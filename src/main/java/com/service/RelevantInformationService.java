package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.RelevantInformationEntity;

import java.util.List;
import java.util.Map;

public interface RelevantInformationService extends IService<RelevantInformationEntity> {

    List<RelevantInformationEntity> findRelevantInformation(Map<String, Object> params);

    int addDetails(Map<String, Object> params);

    int updateDetails(Map<String, Object> params);

    int deleteDetails(Map<String, Object> params);
}
