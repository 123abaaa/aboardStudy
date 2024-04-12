package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("yonghu")
public class YonghuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YonghuEntity() {
		
	}
	
	public YonghuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@TableId
	private Long id;
			
	private String zhanghao;
			
	private String mima;
			
	private String xingming;
			
	private Integer nianling;
			
	private String xingbie;
			
	private String shouji;
			
	private String touxiang;

	private String email;

	private String undergraduateinstitution;

	private Integer divideequally;

	private Integer ieltsscore;
			
	private String sfsh;
				
	private String shhf;

	private Integer counselor;

	private String counselorinstitution;

	private Integer workingyears;
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}

	public String getZhanghao() {
		return zhanghao;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUndergraduateinstitution() {
		return undergraduateinstitution;
	}

	public void setUndergraduateinstitution(String undergraduateinstitution) {
		this.undergraduateinstitution = undergraduateinstitution;
	}

	public Integer getDivideequally() {
		return divideequally;
	}

	public void setDivideequally(Integer divideequally) {
		this.divideequally = divideequally;
	}

	public Integer getIeltsscore() {
		return ieltsscore;
	}

	public void setIeltsscore(Integer ieltsscore) {
		this.ieltsscore = ieltsscore;
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

	public Integer getCounselor() {
		return counselor;
	}

	public void setCounselor(Integer counselor) {
		this.counselor = counselor;
	}

	public String getCounselorinstitution() {
		return counselorinstitution;
	}

	public void setCounselorinstitution(String counselorinstitution) {
		this.counselorinstitution = counselorinstitution;
	}

	public Integer getWorkingyears() {
		return workingyears;
	}

	public void setWorkingyears(Integer workingyears) {
		this.workingyears = workingyears;
	}
}
