package com.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.RelevantInformationDao;
import com.entity.RelevantInformationEntity;
import com.service.RelevantInformationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RelevantInformationServiceImpl extends ServiceImpl<RelevantInformationDao, RelevantInformationEntity> implements RelevantInformationService {

    @Override
    public List<RelevantInformationEntity> findRelevantInformation(Map<String, Object> params) {
        return baseMapper.findRelevantInformation(params);
    }

    @Override
    public int addDetails(Map<String, Object> params) {
        return baseMapper.addDetails(params);
    }

    @Override
    public int updateDetails(Map<String, Object> params) {
        return baseMapper.updateDetails(params);
    }

    @Override
    public int deleteDetails(Map<String, Object> params) {
        return baseMapper.deleteDetails(params);
    }
}
