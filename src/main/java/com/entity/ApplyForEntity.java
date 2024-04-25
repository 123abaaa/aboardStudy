package com.entity;

public class ApplyForEntity {

    private Integer applyforid;

    private Long userId;
//
    private Integer InstitutionId;

    private Integer schedule;

    public Integer getApplyforid() {
        return applyforid;
    }

    public void setApplyforid(Integer applyforid) {
        this.applyforid = applyforid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getInstitutionId() {
        return InstitutionId;
    }

    public void setInstitutionId(Integer institutionId) {
        InstitutionId = institutionId;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }
}
