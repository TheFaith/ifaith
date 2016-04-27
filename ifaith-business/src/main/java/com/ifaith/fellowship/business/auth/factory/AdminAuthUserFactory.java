package com.ifaith.fellowship.business.auth.factory;

import com.ifaith.fellowship.business.auth.ConsumerApp;
import com.ifaith.fellowship.business.auth.creator.AdminAuthenticationCreator;
import com.ifaith.fellowship.business.auth.creator.AdminUserInfomationCreator;
import com.ifaith.fellowship.business.auth.creator.NoUserAuthorizationCreator;
import com.ifaith.fellowship.business.auth.creator.UserAuthenticationCreator;
import com.ifaith.fellowship.business.auth.creator.UserAuthorizationCreator;
import com.ifaith.fellowship.business.auth.creator.UserInfomationCreator;

public class AdminAuthUserFactory extends AuthUserFactory {

	public AdminAuthUserFactory(ConsumerApp consumer) {
		super(consumer);
	}

	@Override
	protected UserInfomationCreator buildUserInfomationCreator() {
		return new AdminUserInfomationCreator();
	}

	@Override
	protected UserAuthorizationCreator buildUserAuthorizationCreator() {
		return new NoUserAuthorizationCreator();
	}

	@Override
	protected UserAuthenticationCreator buildUserAuthenticationCreator() {
		return new AdminAuthenticationCreator();
	}

}