package com.ifaith.fellowship.entity.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResOwnerPwdCredModel implements OAuthRequest {

	protected String userName;
	protected String password;
	protected String consumerKey;
	protected String consumerSecret;
	protected String grantType;

	@JsonProperty("user_name")
	public String getUserName() {
		return userName;
	}

	@JsonProperty("user_name")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	@JsonProperty("consumer_key")
	public String getConsumerKey() {
		return consumerKey;
	}

	@Override
	@JsonProperty("consumer_key")
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	@Override
	@JsonProperty("consumer_secret")
	public String getConsumerSecret() {
		return consumerSecret;
	}

	@Override
	@JsonProperty("consumer_secret")
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	@Override
	@JsonProperty("grant_type")
	public String getGrantType() {
		return grantType;
	}

	@Override
	@JsonProperty("grant_type")
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
}
