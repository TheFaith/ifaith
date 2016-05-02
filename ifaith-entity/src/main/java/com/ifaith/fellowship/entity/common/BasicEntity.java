package com.ifaith.fellowship.entity.common;

import java.util.Date;

public class BasicEntity {
	protected int sysNo;
	protected Date createTime;
	protected int createUserSysNo;
	protected String createUserName;
	protected Date updateTime;
	protected int updateUserSysNo;
	protected String updateUserName;

	public int getSysNo() {
		return sysNo;
	}

	public void setSysNo(int sysNo) {
		this.sysNo = sysNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCreateUserSysNo() {
		return createUserSysNo;
	}

	public void setCreateUserSysNo(int createUserSysNo) {
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

	public int getUpdateUserSysNo() {
		return updateUserSysNo;
	}

	public void setUpdateUserSysNo(int updateUserSysNo) {
		this.updateUserSysNo = updateUserSysNo;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
}
