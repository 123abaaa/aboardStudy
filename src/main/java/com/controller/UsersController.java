
package com.controller;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.TokenEntity;
import com.entity.UsersEntity;
import com.service.TokenService;
import com.service.UsersService;
import com.utils.CommonUtil;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.ValidatorUtils;

@RequestMapping("users")
@RestController
public class UsersController{
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private TokenService tokenService;

	@IgnoreAuth
	@PostMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		UsersEntity user = userService.selectOne(new EntityWrapper<UsersEntity>().eq("username", username));
		if(user==null || !user.getPassword().equals(password)) {
			return R.error("Incorrect account or password");
		}
		String token = tokenService.generateToken(user.getId(),username, "users", user.getRole());
		return R.ok().put("token", token);
	}
	
	@IgnoreAuth
	@PostMapping(value = "/register")
	public R register(@RequestBody UsersEntity user){
//    	ValidatorUtils.validateEntity(user);
    	if(userService.selectOne(new EntityWrapper<UsersEntity>().eq("username", user.getUsername())) !=null) {
    		return R.error("User already exists");
    	}
        userService.insert(user);
        return R.ok();
    }

	@GetMapping(value = "logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("Exit successful");
	}
	
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	UsersEntity user = userService.selectOne(new EntityWrapper<UsersEntity>().eq("username", username));
    	if(user==null) {
    		return R.error("Account does not exist");
    	}
    	user.setPassword("123456");
        userService.update(user,null);
        return R.ok("Password has been reset to：123456");
    }
	
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,UsersEntity user){
        EntityWrapper<UsersEntity> ew = new EntityWrapper<UsersEntity>();
    	PageUtils page = userService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, user), params), params));
        return R.ok().put("data", page);
    }

    @RequestMapping("/list")
    public R list( UsersEntity user){
       	EntityWrapper<UsersEntity> ew = new EntityWrapper<UsersEntity>();
      	ew.allEq(MPUtil.allEQMapPre( user, "user")); 
        return R.ok().put("data", userService.selectListView(ew));
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        UsersEntity user = userService.selectById(id);
        return R.ok().put("data", user);
    }
    
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        UsersEntity user = userService.selectById(id);
        return R.ok().put("data", user);
    }

    @PostMapping("/save")
    public R save(@RequestBody UsersEntity user){
//    	ValidatorUtils.validateEntity(user);
    	if(userService.selectOne(new EntityWrapper<UsersEntity>().eq("username", user.getUsername())) !=null) {
    		return R.error("User already exists");
    	}
        userService.insert(user);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody UsersEntity user){
//        ValidatorUtils.validateEntity(user);
    	UsersEntity u = userService.selectOne(new EntityWrapper<UsersEntity>().eq("username", user.getUsername()));
    	if(u!=null && u.getId()!=user.getId() && u.getUsername().equals(user.getUsername())) {
    		return R.error("The username already exists。");
    	}
        userService.updateById(user);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        userService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
