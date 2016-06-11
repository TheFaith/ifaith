package com.ifaith.fellowship.service.auth.factory;

import com.ifaith.fellowship.service.auth.creator.CustomerAuthenticationCreator;
import com.ifaith.fellowship.service.auth.creator.CustomerUserInfomationCreator;
import com.ifaith.fellowship.service.auth.creator.NoUserAuthorizationCreator;
import com.ifaith.fellowship.service.auth.creator.UserAuthenticationCreator;
import com.ifaith.fellowship.service.auth.creator.UserAuthorizationCreator;
import com.ifaith.fellowship.service.auth.creator.UserInfomationCreator;
import com.ifaith.fellowship.entity.auth.ConsumerApp;

public class CustomerAuthUserFactory extends AuthUserFactory {

	public CustomerAuthUserFactory(ConsumerApp consumer) {
		super(consumer);
	}

	@Override
	protected UserInfomationCreator buildUserInformationCreator() {
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
