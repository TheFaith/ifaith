package com.ifaith.fellowship.entity.auth;

public interface OAuthRequest {
	// getter or setter : consumer key
	public String getConsumerKey();

	public void setConsumerKey(String consumerKey);

	// getter or setter : consumer secret
	public String getConsumerSecret();

	public void setConsumerSecret(String consumerSecret);

	// getter or setter : grant type
	public String getGrantType();

	public void setGrantType(String grantType);
}
