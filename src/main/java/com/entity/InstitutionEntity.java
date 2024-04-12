package com.entity;

public class InstitutionEntity {

    private Integer institutionId;

    private Integer institutionRanking;

    private String institutionName;

    private String institutionPicture;

    private String institutionUrl;

    private String institutionAddress;

    private String collegeMajor;

    private ApplyForEntity applyForEntity;

    private YonghuEntity yonghuEntity;

    private CollectEntity collectEntity;

    public Integer getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    public Integer getInstitutionRanking() {
        return institutionRanking;
    }

    public void setInstitutionRanking(Integer institutionRanking) {
        this.institutionRanking = institutionRanking;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionPicture() {
        return institutionPicture;
    }

    public void setInstitutionPicture(String institutionPicture) {
        this.institutionPicture = institutionPicture;
    }

    public String getInstitutionUrl() {
        return institutionUrl;
    }

    public void setInstitutionUrl(String institutionUrl) {
        this.institutionUrl = institutionUrl;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public String getCollegeMajor() {
        return collegeMajor;
    }

    public void setCollegeMajor(String collegeMajor) {
        this.collegeMajor = collegeMajor;
    }

    public ApplyForEntity getApplyForEntity() {
        return applyForEntity;
    }

    public void setApplyForEntity(ApplyForEntity applyForEntity) {
        this.applyForEntity = applyForEntity;
    }

    public YonghuEntity getYonghuEntity() {
        return yonghuEntity;
    }

    public void setYonghuEntity(YonghuEntity yonghuEntity) {
        this.yonghuEntity = yonghuEntity;
    }

    public CollectEntity getCollectEntity() {
        return collectEntity;
    }

    public void setCollectEntity(CollectEntity collectEntity) {
        this.collectEntity = collectEntity;
    }

    @Override
    public String toString() {
        return "InstitutionEntity{" +
                "institutionId=" + institutionId +
                ", institutionRanking=" + institutionRanking +
                ", institutionName='" + institutionName + '\'' +
                ", institutionPicture='" + institutionPicture + '\'' +
                ", institutionUrl='" + institutionUrl + '\'' +
                ", institutionAddress='" + institutionAddress + '\'' +
                ", collegeMajor='" + collegeMajor + '\'' +
                ", applyForEntity=" + applyForEntity +
                ", yonghuEntity=" + yonghuEntity +
                ", collectEntity=" + collectEntity +
                '}';
    }
}
