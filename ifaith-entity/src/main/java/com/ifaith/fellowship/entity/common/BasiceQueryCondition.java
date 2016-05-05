package com.ifaith.fellowship.entity.common;

import java.util.Date;

public class BasiceQueryCondition {
	protected Date createTime;
	protected Integer createUserSysNo;
	protected String createUserName;
	protected Date updateTime;
	protected Integer updateUserSysNo;
	protected String updateUserName;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUserSysNo() {
		return createUserSysNo;
	}

	public void setCreateUserSysNo(Integer createUserSysNo) {
		this.createUserSysNo = createUserSysNo;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateUserSysNo() {
		return updateUserSysNo;
	}

	public void setUpdateUserSysNo(Integer updateUserSysNo) {
		this.updateUserSysNo = updateUserSysNo;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
}
