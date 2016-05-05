package com.ifaith.fellowship.entity.auth;

import java.util.Date;

import com.ifaith.fellowship.entity.common.BasicEntity;

public class AuthenticateToken extends BasicEntity {
	protected int tokenId;
	protected int consumerId;
	protected int userId;
	protected int type;
	protected String accessToken;
	protected String refreshToken;
	protected String confusionCode;
	protected Date expirationDate;
	protected double expirationInterval;
	// protected AuthenticateConsumer Consumer { get; set; }

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
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
