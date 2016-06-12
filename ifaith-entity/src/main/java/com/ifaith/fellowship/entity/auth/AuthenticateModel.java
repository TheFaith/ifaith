package com.ifaith.fellowship.entity.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("auth_model")
public class AuthenticateModel {
	public String tokenType;
	public String accessToken;
	public String expirationTime;
	public String refreshToken;
	public AuthenticationUserModel user;

	@JsonProperty("token_type")
	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	@JsonProperty("expiration_time")
	public String getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}
	@JsonProperty("refresh_token")
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	@JsonProperty("user")
	public AuthenticationUserModel getUser() {
		return user;
	}

	public void setUser(AuthenticationUserModel user) {
		this.user = user;
	}

}
