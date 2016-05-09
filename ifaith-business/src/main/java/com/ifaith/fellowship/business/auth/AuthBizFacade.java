package com.ifaith.fellowship.business.auth;

import com.ifaith.fellowship.entity.auth.OAuthRequest;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

public interface AuthBizFacade {
	public Object generateAccessToken(OAuthRequest model) throws Exception;

	public UserBasicInfo verifyAccessToken(String strToken) throws Exception;
}
