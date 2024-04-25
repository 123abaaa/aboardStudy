package com.entity;

public class CounselorUserEntity {

    private Integer counseloruserid;

    private Long counselorid;

    private Long userid;
//
    public Integer getCounseloruserid() {
        return counseloruserid;
    }
//
    public void setCounseloruserid(Integer counseloruserid) {
        this.counseloruserid = counseloruserid;
    }
//
    public Long getCounselorid() {
        return counselorid;
    }

    public void setCounselorid(Long counselorid) {
        this.counselorid = counselorid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
