package com.ifaith.fellowship.entity.user;

public class AdminUserModel implements SignInModel {

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int userSysNo;
	public String userName;
	public int churchSysNo;

	@Override
	public int getUserSysNo() {
		return userSysNo;
	}

	@Override
	public int getChurchSysNo() {
		return churchSysNo;
	}

	public void setUserSysNo(int userSysNo) {
		this.userSysNo = userSysNo;
	}

	public void setChurchSysNo(int churchSysNo) {
		this.churchSysNo = churchSysNo;
	}

}
