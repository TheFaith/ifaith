package com.ifaith.fellowship.service.auth;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifaith.fellowship.dataaccess.people.AuthenticateTokenRepository;
import com.ifaith.fellowship.dataaccess.people.ConsumerRepository;
import com.ifaith.fellowship.dataaccess.people.UserRepository;
import com.ifaith.fellowship.entity.auth.AuthenticateModel;
import com.ifaith.fellowship.entity.auth.AuthenticateToken;
import com.ifaith.fellowship.entity.auth.OAuthRequestModel;
import com.ifaith.fellowship.entity.common.GrantType;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

@Service
public class AuthServiceImp implements AuthService {

	@Autowired
	protected ConsumerRepository repoConsumer;
	@Autowired
	protected AuthenticateTokenRepository repoToken;
	@Autowired
	protected UserRepository repoUser;

	/**
	 * @author alan.luo
	 * @throws Exception
	 * @display
	 */

	public void refreshAccessToken() {

	}

	@Override
	public UserBasicInfo verifyAccessToken(String strToken) throws Exception {
		UserBasicInfo outUser = null;
		AuthenticateToken token = repoToken.findBy(strToken);
		Date now = new Date();
		if (token != null && now.before(token.getExpirationTime())) {
			outUser = repoUser.find(token.getUserSysNo());
		}
		return outUser;
	}

	@Override
	public AuthenticateModel generateAccessToken(OAuthRequestModel model, GrantType type) throws Exception {
		IOAuth2 oAuth2 = null;
		switch (type) {
		case ResOwnerPwdCredentials:
			oAuth2 = new ResOwnerPwdCredentialsFlow();
			break;
		case AuthorizationCode:
		case ClientCredentials:
		case Implicit:
		case RefreshToken:
		case Unknow:
		default:
			// APIExceptionHelper.throwException_UnAuthorized("grant type is
			// wrong!", ErrorCode.AUTH_TOKEN);
		}

		return oAuth2.generateAccessToken(model);
	}

}
