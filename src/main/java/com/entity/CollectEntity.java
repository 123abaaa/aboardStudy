package com.entity;

public class CollectEntity {

    private Integer collectId;

    private Integer institutionId;

    private Long userId;

    private Integer collectFlag = 0;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCollectFlag() {
        return collectFlag;
    }

    public void setCollectFlag(Integer collectFlag) {
        this.collectFlag = collectFlag;
    }

    @Override
    public String toString() {
        return "CollectEntity{" +
                "collectId=" + collectId +
                ", institutionId=" + institutionId +
                ", userId=" + userId +
                ", collectFlag=" + collectFlag +
                '}';
    }
}
