package com.ifaith.fellowship.business.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ifaith.fellowship.business.auth.factory.AuthUserFactory;
import com.ifaith.fellowship.dataaccess.people.AuthenticateTokenRepository;
import com.ifaith.fellowship.dataaccess.people.ConsumerRepository;
import com.ifaith.fellowship.entity.auth.AuthenticateToken;
import com.ifaith.fellowship.entity.auth.Consumer;
import com.ifaith.fellowship.entity.auth.OAuthRequest;
import com.ifaith.fellowship.entity.auth.ResOwnerPwdCredModel;
import com.ifaith.fellowship.entity.user.SignInModel;

@Component
public class AuthBizFacadeImp implements AuthBizFacade {
	class OutData {
	}

	@Autowired
	protected ConsumerRepository repoConsumer;
	@Autowired
	protected AuthenticateTokenRepository repoToken;

	/**
	 * @author alan.luo
	 * @throws Exception
	 * @display
	 */
	@Override
	public Object generateAccessToken(OAuthRequest model) throws Exception {
		// TODO : generateAccessToken
		if (!(model instanceof ResOwnerPwdCredModel)) {
			// throw new Exception("convert type error!");
			return null;
		}

		ResOwnerPwdCredModel data = (ResOwnerPwdCredModel) model;
		String userName = data.getUserName();
		String password = data.getPassword();
		String key = data.getConsumerKey();
		String secret = data.getConsumerSecret();

		Consumer consumer = repoConsumer.findBy(key, secret);
		if (consumer == null) {
			// throw new Exception("can not find consumer!");
			return null;
		}
		// get user information
		AuthUserFactory factory = AuthUserFactory.CreateAuthUserFactory(consumer.getConsumerApp());
		SignInModel user = factory.AuthenticationUser(userName, password);

		// create token.
		AuthenticateToken token = repoToken.findBy(consumer.getSysNo(), user.getUserSysNo());

		@SuppressWarnings("unused")
		OutData xOut = new OutData() {
			public String getTokenType() {
				return "bearer";
			}

			public String getAccessToken() {
				return key;
			}

			public String getExpirationDate() {
				return key;
			}

			public String getRefreshToken() {
				return key;
			}

			public SignInModel getUser() {
				return user;
			}
		};
		return xOut;
	}

	public void refreshAccessToken() {

	}

}
