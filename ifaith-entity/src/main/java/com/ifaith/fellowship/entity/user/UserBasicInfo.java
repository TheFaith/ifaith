package com.ifaith.fellowship.entity.user;

import java.util.Calendar;
import java.util.Date;

import com.ifaith.fellowship.entity.common.BasicEntity;

public class UserBasicInfo extends BasicEntity{
	protected int sysNo;
	protected String name;
	protected String password;
	protected Date dateOfBirth;
	protected int age;
	protected int typeID;
	protected boolean isEnabled;

	public UserBasicInfo() {
	}

	public UserBasicInfo(int sysNo, String name, Date dateOfBirth) {
		this.sysNo = sysNo;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	// get SysNo
	public int getSysNo() {
		return sysNo;
	}

	// set SysNo
	public void setSysNo(int sysNo) {
		this.sysNo = sysNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public int getAge() {
		Calendar now = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		dob.setTime(this.dateOfBirth);
		return now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
	}
}
