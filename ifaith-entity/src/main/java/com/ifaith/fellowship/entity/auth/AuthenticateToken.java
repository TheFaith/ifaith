package com.ifaith.fellowship.entity.auth;

import java.util.Date;

import com.ifaith.fellowship.entity.common.BasicEntity;

public class AuthenticateToken extends BasicEntity {

	protected int sysNo;
	protected int authConsumerSysNo;
	protected int userSysNo;
	protected int typeID;
	protected String accessToken;
	protected String refreshToken;
	protected String confusionCode;
	protected Date expirationTime;
	protected double expirationInterval;

	// protected AuthenticateConsumer Consumer { get; set; }
	public int getSysNo() {
		return sysNo;
	}

	public void setSysNo(int sysNo) {
		this.sysNo = sysNo;
	}

	public int getAuthConsumerSysNo() {
		return authConsumerSysNo;
	}

	public void setAuthConsumerSysNo(int authConsumerSysNo) {
		this.authConsumerSysNo = authConsumerSysNo;
	}

	public int getUserSysNo() {
		return userSysNo;
	}

	public void setUserSysNo(int userSysNo) {
		this.userSysNo = userSysNo;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getConfusionCode() {
		return confusionCode;
	}

	public void setConfusionCode(String confusionCode) {
		this.confusionCode = confusionCode;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public double getExpirationInterval() {
		return expirationInterval;
	}

	public void setExpirationInterval(double expirationInterval) {
		this.expirationInterval = expirationInterval;
	}

	/**
	 * @description AuthenticateTokenID
	 */
}
