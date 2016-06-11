package com.ifaith.fellowship.service.auth.creator;

import java.util.HashMap;
import java.util.Map;

import com.ifaith.fellowship.service.auth.AuthUserContext;

public class NoUserAuthorizationCreator implements UserAuthorizationCreator {

	@Override
	public Map<String, Boolean> GetUserAuthorization(AuthUserContext context) {
		return new HashMap<String, Boolean>();
	}

}
