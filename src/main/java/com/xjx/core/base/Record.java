package com.xjx.core.base;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public abstract class Record implements Data{

	private static final long serialVersionUID = 373594492678592363L;
	
	private Integer incrementId;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	private String createUserId;
	private String updateUserId;
	public Integer getIncrementId() {
		return incrementId;
	}
	public void setIncrementId(Integer incrementId) {
		this.incrementId = incrementId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	

}
