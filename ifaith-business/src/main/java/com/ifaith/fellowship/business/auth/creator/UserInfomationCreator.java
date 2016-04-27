package com.ifaith.fellowship.business.auth.creator;

import com.ifaith.fellowship.business.auth.AuthUserContext;
import com.ifaith.fellowship.entity.auth.CurrentUser;

// @interface for user information creator
public interface UserInfomationCreator {
	public CurrentUser GetUserInfomation(AuthUserContext context);
}
