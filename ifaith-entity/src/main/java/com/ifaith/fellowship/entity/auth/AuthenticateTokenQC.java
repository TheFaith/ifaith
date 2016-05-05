package com.ifaith.fellowship.entity.auth;

import java.util.Date;
import com.ifaith.fellowship.entity.common.BasiceQueryCondition;

public class AuthenticateTokenQC extends BasiceQueryCondition {

	public Integer userSysNo;
	public Integer consumerSysNo;
	public Integer typeID;
	public String accessToken;
	public String refreshToken;
	public Date expirationTime;

	public Integer getUserSysNo() {
		return userSysNo;
	}

	public void setUserSysNo(Integer userSysNo) {
		this.userSysNo = userSysNo;
	}

	public Integer getConsumerSysNo() {
		return consumerSysNo;
	}

	public void setConsumerSysNo(Integer consumerSysNo) {
		this.consumerSysNo = consumerSysNo;
	}

	public Integer getTypeID() {
		return typeID;
	}

	public void setTypeID(Integer typeID) {
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

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

}
