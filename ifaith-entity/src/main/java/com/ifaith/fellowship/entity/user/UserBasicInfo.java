package com.ifaith.fellowship.entity.user;

public class UserBasicInfo {
	private long sysNo;
	private String name;
	private int age;

	public UserBasicInfo() {
	}

	public UserBasicInfo(long sysNo, String name, int age) {
		this.sysNo = sysNo;
		this.name = name;
		this.age = age;
	}
	//get SysNo
	public long getSysNo() {
		return sysNo;
	}
	//set SysNo
	public void setSysNo(long sysNo) {
		this.sysNo = sysNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
