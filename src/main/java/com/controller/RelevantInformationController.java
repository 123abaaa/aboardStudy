package com.controller;

import com.entity.RelevantInformationEntity;
import com.service.RelevantInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/RelevantInformation")
public class RelevantInformationController {

    @Autowired
    private RelevantInformationService relevantInformationService;

    @ResponseBody
    @RequestMapping("/findRelevantInformation")
    public Map<String, Object> findRelevantInformation(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();

        List<RelevantInformationEntity> relevantInformationEntityList = relevantInformationService.findRelevantInformation(params);

        map.put("relevantInformationEntityList", relevantInformationEntityList);

        return map;
    }


    @ResponseBody
    @RequestMapping("/addDetails")
    public Map<String, Object> addDetails(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();

        int row = relevantInformationService.addDetails(params);

        if (row > 0) {
            map.put("code", 200);
            map.put("message", "Successfully added relevant information!");
        } else {
            map.put("code", 400);
            map.put("message", "Failed to add relevant information!");
        }

        return map;
    }

    @ResponseBody
    @RequestMapping("/updateDetails")
    public Map<String, Object> updateDetails(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();

        int row = relevantInformationService.updateDetails(params);

        if (row > 0) {
            map.put("code", 200);
            map.put("message", "Successfully modified relevant information!");
        } else {
            map.put("code", 400);
            map.put("message", "Related information modification failed!");
        }

        return map;
    }

    @ResponseBody
    @RequestMapping("/deleteDetails")
    public Map<String, Object> deleteDetails(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();

        int row = relevantInformationService.deleteDetails(params);

        if (row > 0) {
            map.put("code", 200);
            map.put("message", "Relevant information deleted successfully!");
        } else {
            map.put("code", 400);
            map.put("message", "Failed to delete relevant information!");
        }

        return map;
    }
}
