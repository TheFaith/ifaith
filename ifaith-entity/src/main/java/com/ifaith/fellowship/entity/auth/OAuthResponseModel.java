package com.ifaith.fellowship.entity.auth;


public class OAuthResponseModel implements OAuthResponse {
	public OAuthResponseModel(String accessToken, String tokenType, String expiresDate, String refreshToken) {
		super();
		this.accessToken = accessToken;
		this.tokenType = tokenType;
		this.expiresDate = expiresDate;
		this.refreshToken = refreshToken;
	}

	protected String accessToken;
	protected String tokenType;
	protected String expiresDate;
	protected String refreshToken;
	protected Object user;

	@Override
	public String getAccessToken() {
		return accessToken;
	}

	@Override
	public String getTokenType() {
		return tokenType;
	}

	@Override
	public String getExpiresDate() {
		return expiresDate;
	}

	@Override
	public String getRefreshToken() {
		return refreshToken;
	}

	@Override
	public Object getUser() {
		return user;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public void setExpiresDate(String expiresDate) {
		this.expiresDate = expiresDate;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public void setUser(Object user) {
		this.user = user;
	}
}
