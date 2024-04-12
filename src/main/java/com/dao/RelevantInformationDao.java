package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.entity.RelevantInformationEntity;

import java.util.List;
import java.util.Map;

public interface RelevantInformationDao extends BaseMapper<RelevantInformationEntity> {

    List<RelevantInformationEntity> findRelevantInformation(Map<String, Object> params);

    int addDetails(Map<String, Object> params);

    int updateDetails(Map<String, Object> params);

    int deleteDetails(Map<String, Object> params);
}
