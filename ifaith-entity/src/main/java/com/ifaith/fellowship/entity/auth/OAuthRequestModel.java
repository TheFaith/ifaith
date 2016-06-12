package com.ifaith.fellowship.entity.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("oauth_model")
public class OAuthRequestModel {

	// @NotEmpty(message = "consumer_key is required!")
	protected String consumerKey;

	// @NotEmpty(message = "consumer_secret is required!")
	protected String consumerSecret;

	// @NotEmpty(message = "grant_type is required!")
	protected String grantType;

	// @NotEmpty(message = "user_name is required!")
	protected String userName;

	// @NotEmpty(message = "password is required!")
	protected String password;

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

	@JsonProperty("consumer_key")
	public String getConsumerKey() {
		return consumerKey;
	}

	@JsonProperty("consumer_key")
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	@JsonProperty("consumer_secret")
	public String getConsumerSecret() {
		return consumerSecret;
	}

	@JsonProperty("consumer_secret")
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	@JsonProperty("grant_type")
	public String getGrantType() {
		return grantType;
	}

	@JsonProperty("grant_type")
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
}
