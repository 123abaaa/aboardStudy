package com.entity.vo;

import com.entity.YonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

public class YonghuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String mima;

	private String xingming;

	private Integer nianling;

	private String xingbie;

	private String shouji;

	private String touxiang;

	private String sfsh;

	private String shhf;
				
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	public String getMima() {
		return mima;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getXingming() {
		return xingming;
	}

	public void setNianling(Integer nianling) {
		this.nianling = nianling;
	}

	public Integer getNianling() {
		return nianling;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getXingbie() {
		return xingbie;
	}

	public void setShouji(String shouji) {
		this.shouji = shouji;
	}

	public String getShouji() {
		return shouji;
	}

	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}

	public String getTouxiang() {
		return touxiang;
	}

	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}

	public String getSfsh() {
		return sfsh;
	}

	public void setShhf(String shhf) {
		this.shhf = shhf;
	}

	public String getShhf() {
		return shhf;
	}
			
}
