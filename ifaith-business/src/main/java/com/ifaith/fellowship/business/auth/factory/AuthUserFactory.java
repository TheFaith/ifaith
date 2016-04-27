package com.ifaith.fellowship.business.auth.factory;

import com.ifaith.fellowship.business.auth.ConsumerApp;
import com.ifaith.fellowship.business.auth.creator.UserAuthenticationCreator;
import com.ifaith.fellowship.business.auth.creator.UserAuthorizationCreator;
import com.ifaith.fellowship.business.auth.creator.UserInfomationCreator;

public abstract class AuthUserFactory {

	/// consumer information
	protected ConsumerApp _consumer;
	/// user information creator.
	protected UserInfomationCreator _userInfoCreator;
	/// user authorization creator.
	protected UserAuthorizationCreator _authorizationCreator;
	/// user authentication creator.
	protected UserAuthenticationCreator _authenticationCreator;

	public AuthUserFactory(ConsumerApp consumer) {
		this._consumer = consumer;

		this._userInfoCreator = buildUserInfomationCreator();
		this._authorizationCreator = buildUserAuthorizationCreator();
		this._authenticationCreator = buildUserAuthenticationCreator();
	}

	/// get consumer information
	public ConsumerApp getConsumer() {
		return this._consumer;
	}

	/* # Action to client. */

	/* # Static create factory. */

	/* # Abstract method for different application. */
	/// <summary>
	/// create user information creator.
	/// </summary>
	/// <returns>creator</returns>
	protected abstract UserInfomationCreator buildUserInfomationCreator();

	/// <summary>
	/// create user authorization creator.
	/// </summary>
	/// <returns>creator</returns>
	protected abstract UserAuthorizationCreator buildUserAuthorizationCreator();

	/// <summary>
	/// create user authentication creator.
	/// </summary>
	/// <returns>creator</returns>
	protected abstract UserAuthenticationCreator buildUserAuthenticationCreator();

}
