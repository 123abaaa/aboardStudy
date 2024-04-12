package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.YonghuEntity;
import com.service.TokenService;
import com.service.YonghuService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/guwen")
public class GuWenController {

    @Autowired
    private YonghuService yonghuService;



    @Autowired
    private TokenService tokenService;

    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        YonghuEntity u = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("zhanghao", username));
        if(u==null || !u.getMima().equals(password) || u.getCounselor() == 1) {
            return R.error("Incorrect account or password");
        }

        if(!"yes".equals(u.getSfsh())) return R.error("Account locked，Please contact the administrator for review。");
        String token = tokenService.generateToken(u.getId(), username,"guwen",  "Counselor" );
        return R.ok().put("token", token).put("YonghuEntity", u);
    }

    @RequestMapping("/logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("Exit successful");
    }

    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("userId");
        YonghuEntity u = yonghuService.selectById(id);
        return R.ok().put("data", u);
    }

    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YonghuEntity yonghu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yonghu);
        yonghuService.updateById(yonghu);
        return R.ok();
    }
}
