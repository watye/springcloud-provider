package com.talelife.framework.entity;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 3096371004249104171L;
	private String orderBy;
	private Date createTime;
	private Date updateTime;
	private Long createby;
	private String createbyName;
	private Long updateby;
	private String updatebyName;
	public BaseEntity() {
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
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
	public Long getCreateby() {
		return createby;
	}
	public void setCreateby(Long createby) {
		this.createby = createby;
	}
	public String getCreatebyName() {
		return createbyName;
	}
	public void setCreatebyName(String createbyName) {
		this.createbyName = createbyName;
	}
	public Long getUpdateby() {
		return updateby;
	}
	public void setUpdateby(Long updateby) {
		this.updateby = updateby;
	}
	public String getUpdatebyName() {
		return updatebyName;
	}
	public void setUpdatebyName(String updatebyName) {
		this.updatebyName = updatebyName;
	}
}
