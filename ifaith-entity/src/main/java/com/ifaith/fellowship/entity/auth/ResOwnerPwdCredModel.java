package com.ifaith.fellowship.entity.auth;

public class ResOwnerPwdCredModel implements OAuthRequest {

	protected String userName = null;
	protected String password = null;
	protected String consumerKey = null;
	protected String consumerSecret = null;
	protected String grantType = null;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getConsumerKey() {
		return consumerKey;
	}

	@Override
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	@Override
	public String getConsumerSecret() {
		return consumerSecret;
	}

	@Override
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	@Override
	public String getGrantType() {
		return grantType;
	}

	@Override
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
}
