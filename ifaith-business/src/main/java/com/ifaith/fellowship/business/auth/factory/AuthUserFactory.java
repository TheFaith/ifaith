package com.ifaith.fellowship.business.auth.factory;

import com.ifaith.fellowship.business.auth.creator.UserAuthenticationCreator;
import com.ifaith.fellowship.business.auth.creator.UserAuthorizationCreator;
import com.ifaith.fellowship.business.auth.creator.UserInfomationCreator;
import com.ifaith.fellowship.entity.auth.ConsumerApp;
import com.ifaith.fellowship.entity.user.SignInModel;

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

		this._userInfoCreator = buildUserInformationCreator();
		this._authorizationCreator = buildUserAuthorizationCreator();
		this._authenticationCreator = buildUserAuthenticationCreator();
	}

	/// get consumer information
	public ConsumerApp getConsumer() {
		return this._consumer;
	}

	/* # Action to client. */
	public SignInModel AuthenticationUser(String userName, String password){
		return _authenticationCreator.authenticationUser(userName, password, "");
	}
	/* # Static create factory. */

	/* # Abstract method for different application. */
	/**
	 * @Description build user information creator
	 * @return creator for user authorization.
	 * @author alan.luo
	 */
	protected abstract UserInfomationCreator buildUserInformationCreator();

	/**
	 * @Description build user authorization creator
	 * @return creator for user authorization.
	 * @author alan.luo
	 */
	protected abstract UserAuthorizationCreator buildUserAuthorizationCreator();

	/**
	 * @Description build user authentication creator
	 * @return creator for user authentication.
	 * @author alan.luo
	 */
	protected abstract UserAuthenticationCreator buildUserAuthenticationCreator();

	/**
	 * @param consumer
	 *            consumer for information
	 * @return entity for AuthUserFactory
	 * @author alan.luo
	 */
	public static AuthUserFactory CreateAuthUserFactory(ConsumerApp consumer) {
		AuthUserFactory factory = null;
		switch (consumer) {
		case Daycare:
			factory = new DaycareAuthUserFactory(consumer);
			break;
		case AdminUI:
			factory = new AdminAuthUserFactory(consumer);
			break;
		case CustomerUI:
			factory = new CustomerAuthUserFactory(consumer);
			break;
		case Unknow:
		default:
			break;
		}
		return factory;
	}
}
