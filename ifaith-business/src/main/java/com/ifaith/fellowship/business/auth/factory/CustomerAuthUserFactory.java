package com.ifaith.fellowship.business.auth.factory;

import com.ifaith.fellowship.business.auth.ConsumerApp;
import com.ifaith.fellowship.business.auth.creator.CustomerAuthenticationCreator;
import com.ifaith.fellowship.business.auth.creator.CustomerUserInfomationCreator;
import com.ifaith.fellowship.business.auth.creator.NoUserAuthorizationCreator;
import com.ifaith.fellowship.business.auth.creator.UserAuthenticationCreator;
import com.ifaith.fellowship.business.auth.creator.UserAuthorizationCreator;
import com.ifaith.fellowship.business.auth.creator.UserInfomationCreator;

public class CustomerAuthUserFactory extends AuthUserFactory {

	public CustomerAuthUserFactory(ConsumerApp consumer) {
		super(consumer);
	}

	@Override
	protected UserInfomationCreator buildUserInfomationCreator() {
		return new CustomerUserInfomationCreator();
	}

	@Override
	protected UserAuthorizationCreator buildUserAuthorizationCreator() {
		return new NoUserAuthorizationCreator();
	}

	@Override
	protected UserAuthenticationCreator buildUserAuthenticationCreator() {
		return new CustomerAuthenticationCreator();
	}

}
