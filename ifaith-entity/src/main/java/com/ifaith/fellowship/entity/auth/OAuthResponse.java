package com.ifaith.fellowship.entity.auth;

public interface OAuthResponse {
	public String getAccessToken();

	public String getTokenType();

	public String getExpiresDate();

	public String getRefreshToken();

	public Object getUser();
}
