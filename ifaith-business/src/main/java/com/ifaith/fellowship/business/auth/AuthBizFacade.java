package com.ifaith.fellowship.business.auth;

import com.ifaith.fellowship.entity.auth.OAuthRequest;

public interface AuthBizFacade {
	public Object generateAccessToken(OAuthRequest model) throws Exception;
}
