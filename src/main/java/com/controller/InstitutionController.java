package com.controller;

import com.entity.*;
import com.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/institution")
public class InstitutionController {

    @Autowired
    private InstitutionService institutionService;

    @ResponseBody
    @RequestMapping("/findInstitution")
    public Map<String, Object> findInstitution(@RequestParam Map<String, String> params, InstitutionEntity institutionEntity) {
        Map<String, Object> map = new HashMap<>();

        List<InstitutionEntity> institutionEntityList = institutionService.findInstitution(params);

        List<InstitutionEntity> collegeMajorList = institutionService.findCollegeMajor();

        map.put("institutionEntityList", institutionEntityList);
        map.put("collegeMajorList", collegeMajorList);

        return map;
    }

    @ResponseBody
    @RequestMapping("/applyFor")
    public Map<String, Object> applyFor(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();

        List<YonghuEntity> yonghuEntityList = institutionService.findYonghuByCounselor();

        if (yonghuEntityList.size() == 0) {
            map.put("code", 400);
            map.put("message", "There are currently no study abroad consultants available，Please try again later!");
            return map;
        } else {
            CounselorUserEntity counselorUserEntity = institutionService.findCounselorUserEntityByUserId(params);

            if (counselorUserEntity == null) {
                int num = (int)(Math.random() * (yonghuEntityList.size()));

                params.put("counselorid", yonghuEntityList.get(num).getId());
                int addCounselorUserRow = institutionService.addCounselorUser(params);

                if (addCounselorUserRow > 0) {
                    params.put("schedule", 1);

                    int addInstitutionRow = institutionService.addApplyfor(params);

                    if (addInstitutionRow > 0) {
                        map.put("code", 200);
                        map.put("message", "Application successful!");
                        return map;
                    } else {
                        map.put("code", 400);
                        map.put("message", "Application failed!");
                        return map;
                    }
                } else {
                    map.put("code", 400);
                    map.put("message", "Application failed!");
                    return map;
                }

            } else {

                ApplyForEntity applyForEntity = institutionService.findApplyForById(params);

                if (applyForEntity == null) {
                    params.put("schedule", 1);

                    int addInstitutionRow = institutionService.addApplyfor(params);

                    if (addInstitutionRow > 0) {
                        map.put("code", 200);
                        map.put("message", "Application successful!");
                        return map;
                    } else {
                        map.put("code", 400);
                        map.put("message", "Application failed!");
                        return map;
                    }
                } else {
                    map.put("code", 400);
                    map.put("message", "The school has applied，Please select a new institution!");
                    return map;
                }
            }
        }
    }

    @ResponseBody
    @RequestMapping("/findApplyForManage")
    public Map<String, Object> findApplyForManage(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();

        List<InstitutionEntity> institutionEntityList = institutionService.findApplyForManage(params);

        map.put("institutionEntityList", institutionEntityList);

        return map;
    }

    @ResponseBody
    @RequestMapping("/findApplyForManageByCounselor")
    public Map<String, Object> findApplyForManageByCounselor(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();

        List<InstitutionEntity> institutionEntityList = institutionService.findApplyForManageByCounselor(params);

        map.put("institutionEntityList", institutionEntityList);

        return map;
    }

    @ResponseBody
    @RequestMapping("/updateSchedule")
    public Map<String, Object> updateSchedule(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();

        int row = institutionService.updateSchedule(params);

        if (row > 0) {
            map.put("code", 200);
            map.put("message", "Successful modification of college application progress!");
        } else {
            map.put("code", 400);
            map.put("message", "School application progress modification failed!");
        }

        return map;
    }

    @ResponseBody
    @RequestMapping("/updateCollect")
    public Map<String, Object> updateCollect(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();

        CollectEntity collectEntity = institutionService.findCollectById(params);

        if (collectEntity == null) {
            int addCollectRow = institutionService.addCollect(params);

            if (addCollectRow > 0) {
                if (Integer.parseInt(String.valueOf(params.get("collectFlag"))) == 0) {
                    map.put("code", 200);
                    map.put("message", "Cancel collection successful!");
                    return map;
                } else if (Integer.parseInt(String.valueOf(params.get("collectFlag"))) == 1) {
                    map.put("code", 200);
                    map.put("message", "Collection successful!");
                    return map;
                }
            } else {
                map.put("code", 400);
                map.put("message", "operation failed!");
                return map;
            }
        } else {
            int updateCollectRow = institutionService.updateCollect(params);

            if (updateCollectRow > 0) {
                if (Integer.parseInt(String.valueOf(params.get("collectFlag"))) == 0) {
                    map.put("code", 200);
                    map.put("message", "Cancel collection successful!");
                    return map;
                } else if (Integer.parseInt(String.valueOf(params.get("collectFlag"))) == 1) {
                    map.put("code", 200);
                    map.put("message", "Collection successful!");
                    return map;
                }
            } else {
                map.put("code", 400);
                map.put("message", "operation failed!");
                return map;
            }
        }

        return map;
    }

    @ResponseBody
    @RequestMapping("/findMyCollection")
    public Map<String, Object> findMyCollection(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();

        List<InstitutionEntity> institutionEntityList = institutionService.findMyCollection(params);

        map.put("institutionEntityList", institutionEntityList);

        return map;
    }
}
