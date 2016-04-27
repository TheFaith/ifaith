package com.ifaith.fellowship.entity.auth;

public class CurrentUser {
	protected int userSysNo;
	protected int churchSysNo;
	protected String userName;
	protected String churchCode;
	
	public int getUserSysNo() {
		return userSysNo;
	}
	public void setUserSysNo(int userSysNo) {
		this.userSysNo = userSysNo;
	}
	public int getChurchSysNo() {
		return churchSysNo;
	}
	public void setChurchSysNo(int churchSysNo) {
		this.churchSysNo = churchSysNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getChurchCode() {
		return churchCode;
	}
	public void setChurchCode(String churchCode) {
		this.churchCode = churchCode;
	}
	
}
