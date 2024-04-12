package com.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.InstitutionDao;
import com.entity.*;
import com.service.InstitutionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InstitutionServiceImpl extends ServiceImpl<InstitutionDao, InstitutionEntity> implements InstitutionService {

    @Override
    public List<InstitutionEntity> findInstitution(Map<String, String> params) {
        return baseMapper.findInstitution(params);
    }

    @Override
    public List<InstitutionEntity> findCollegeMajor() {
        return baseMapper.findCollegeMajor();
    }

    @Override
    public List<YonghuEntity> findYonghuByCounselor() {
        return baseMapper.findYonghuByCounselor();
    }

    @Override
    public CounselorUserEntity findCounselorUserEntityByUserId(Map<String, Object> params) {
        return baseMapper.findCounselorUserEntityByUserId(params);
    }

    @Override
    public int addCounselorUser(Map<String, Object> params) {
        return baseMapper.addCounselorUser(params);
    }

    @Override
    public int addApplyfor(Map<String, Object> params) {
        return baseMapper.addApplyfor(params);
    }

    @Override
    public ApplyForEntity findApplyForById(Map<String, Object> params) {
        return baseMapper.findApplyForById(params);
    }

    @Override
    public List<InstitutionEntity> findApplyForManage(Map<String, Object> params) {
        return baseMapper.findApplyForManage(params);
    }

    @Override
    public List<InstitutionEntity> findApplyForManageByCounselor(Map<String, Object> params) {
        return baseMapper.findApplyForManageByCounselor(params);
    }

    @Override
    public int updateSchedule(Map<String, Object> params) {
        return baseMapper.updateSchedule(params);
    }

    @Override
    public CollectEntity findCollectById(Map<String, Object> params) {
        return baseMapper.findCollectById(params);
    }

    @Override
    public int addCollect(Map<String, Object> params) {
        return baseMapper.addCollect(params);
    }

    @Override
    public int updateCollect(Map<String, Object> params) {
        return baseMapper.updateCollect(params);
    }

    @Override
    public List<InstitutionEntity> findMyCollection(Map<String, Object> params) {
        return baseMapper.findMyCollection(params);
    }
}
