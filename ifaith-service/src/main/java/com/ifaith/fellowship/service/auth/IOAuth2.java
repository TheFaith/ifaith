package com.ifaith.fellowship.service.auth;

import com.ifaith.fellowship.entity.auth.AuthenticateModel;
import com.ifaith.fellowship.entity.auth.OAuthRequestModel;

public interface IOAuth2 {
	/**
	 * @return json object entity.
	 * */
	public AuthenticateModel generateAccessToken(OAuthRequestModel model) throws Exception ;
}
