package com.ifaith.fellowship.business.auth.factory;

import com.ifaith.fellowship.business.auth.creator.AdminAuthenticationCreator;
import com.ifaith.fellowship.business.auth.creator.AdminUserInfomationCreator;
import com.ifaith.fellowship.business.auth.creator.NoUserAuthorizationCreator;
import com.ifaith.fellowship.business.auth.creator.UserAuthenticationCreator;
import com.ifaith.fellowship.business.auth.creator.UserAuthorizationCreator;
import com.ifaith.fellowship.business.auth.creator.UserInfomationCreator;
import com.ifaith.fellowship.entity.auth.ConsumerApp;

public class DaycareAuthUserFactory extends AuthUserFactory {

	public DaycareAuthUserFactory(ConsumerApp consumer) {
		super(consumer);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected UserInfomationCreator buildUserInformationCreator() {
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
