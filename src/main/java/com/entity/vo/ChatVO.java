package com.entity.vo;

import com.entity.ChatEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

public class ChatVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long adminid;

	private String ask;

	private String reply;

	private Integer isreply;
				
	public void setAdminid(Long adminid) {
		this.adminid = adminid;
	}
	
	public Long getAdminid() {
		return adminid;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getAsk() {
		return ask;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getReply() {
		return reply;
	}

	public void setIsreply(Integer isreply) {
		this.isreply = isreply;
	}

	public Integer getIsreply() {
		return isreply;
	}
			
}
