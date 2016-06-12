package com.ifaith.fellowship.service.auth;

import com.ifaith.fellowship.entity.auth.AuthenticateModel;
import com.ifaith.fellowship.entity.auth.OAuthRequestModel;
import com.ifaith.fellowship.entity.common.GrantType;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

public interface AuthService {
	public AuthenticateModel generateAccessToken(OAuthRequestModel model, GrantType type) throws Exception;

	public UserBasicInfo verifyAccessToken(String strToken) throws Exception;
}

