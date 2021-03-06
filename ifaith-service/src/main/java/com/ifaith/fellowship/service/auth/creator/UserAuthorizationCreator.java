package com.ifaith.fellowship.service.auth.creator;

import java.util.Map;

import com.ifaith.fellowship.service.auth.AuthUserContext;

// @interface for user authorization creator
public interface UserAuthorizationCreator {
	public Map<String, Boolean> GetUserAuthorization(AuthUserContext context);
}
