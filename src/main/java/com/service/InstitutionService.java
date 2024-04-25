package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.*;

import java.util.List;
import java.util.Map;

public interface InstitutionService extends IService<InstitutionEntity> {

    List<InstitutionEntity> findInstitution(Map<String, String> params);

    List<InstitutionEntity> findCollegeMajor();

    List<YonghuEntity> findYonghuByCounselor();
//
    CounselorUserEntity findCounselorUserEntityByUserId(Map<String, Object> params);

    int addCounselorUser(Map<String, Object> params);

    int addApplyfor(Map<String, Object> params);

    ApplyForEntity findApplyForById(Map<String, Object> params);

    List<InstitutionEntity> findApplyForManage(Map<String, Object> params);

    List<InstitutionEntity> findApplyForManageByCounselor(Map<String, Object> params);

    int updateSchedule(Map<String, Object> params);

    CollectEntity findCollectById(Map<String, Object> params);

    int addCollect(Map<String, Object> params);

    int updateCollect(Map<String, Object> params);

    List<InstitutionEntity> findMyCollection(Map<String, Object> params);
}
