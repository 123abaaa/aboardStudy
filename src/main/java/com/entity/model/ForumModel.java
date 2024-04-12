package com.entity.model;

import com.entity.ForumEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

public class ForumModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String content;

	private Long parentid;

	private Long userid;

	private String username;

	private String avatarurl;

	private String isdone;

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setAvatarurl(String avatarurl) {
		this.avatarurl = avatarurl;
	}

	public String getAvatarurl() {
		return avatarurl;
	}

	public void setIsdone(String isdone) {
		this.isdone = isdone;
	}

	public String getIsdone() {
		return isdone;
	}
			
}
