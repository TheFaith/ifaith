package com.ifaith.fellowship.service.auth;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import com.ifaith.fellowship.dataaccess.people.AuthenticateTokenRepository;
import com.ifaith.fellowship.dataaccess.people.ConsumerRepository;
import com.ifaith.fellowship.entity.auth.AuthenticateModel;
import com.ifaith.fellowship.entity.auth.AuthenticateToken;
import com.ifaith.fellowship.entity.auth.AuthenticationUserModel;
import com.ifaith.fellowship.entity.auth.Consumer;
import com.ifaith.fellowship.entity.auth.OAuthRequestModel;
import com.ifaith.fellowship.service.auth.factory.AuthUserFactory;

import codepower.framework.core.AppContextHelper;

public class ResOwnerPwdCredentialsFlow implements IOAuth2 {
	public ResOwnerPwdCredentialsFlow() {
		this.repoConsumer = AppContextHelper.getRepository(ConsumerRepository.class);
		this.repoToken = AppContextHelper.getRepository(AuthenticateTokenRepository.class);
	}

	// @Autowired
	protected ConsumerRepository repoConsumer;
	// @Autowired
	protected AuthenticateTokenRepository repoToken;

	@Override
	public AuthenticateModel generateAccessToken(OAuthRequestModel model) throws Exception {

		String userName = model.getUserName();
		String password = model.getPassword();
		String key = model.getConsumerKey();
		String secret = model.getConsumerSecret();

		Consumer consumer = repoConsumer.findBy(key, secret);
		if (consumer == null) {
			// APIExceptionHelper.throwException_UnAuthorized("consumer
			// information is wrong!", ErrorCode.AUTH_TOKEN);
		}
		// get user information
		AuthUserFactory factory = AuthUserFactory.CreateAuthUserFactory(consumer.getConsumerApp());
		AuthenticationUserModel user = factory.AuthenticationUser(userName, password);
		if (user == null) {
			// APIExceptionHelper.throwException_UnAuthorized("user does not
			// exist", ErrorCode.AUTH_TOKEN);
		}

		// create token.
		AuthenticateToken token = repoToken.findBy(consumer.getSysNo(), user.getUserSysNo());
		if (token == null) {
			// create token
			createToken(consumer.getId(), user.getUserSysNo());
		} else {
			// refresh token
			if (token.getExpirationTime().getTime() < new Date().getTime()) {
				refreshToken(token);
			}
		}

		// builder output.
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		AuthenticateModel outData = new AuthenticateModel();
		outData.setTokenType("bearer");
		outData.setAccessToken(token.getAccessToken());
		outData.setExpirationTime(df.format(token.getExpirationTime()));
		outData.setRefreshToken(token.getRefreshToken());
		outData.setUser(user);
		return outData;
	}

	protected void createToken(int consumerId, int userId) throws Exception {
		Calendar expirationCalendar = Calendar.getInstance();
		expirationCalendar.setTime(expirationCalendar.getTime());
		expirationCalendar.add(Calendar.DATE, 1);

		AuthenticateToken token = new AuthenticateToken();
		token.setAccessToken(generateToken("access_Token"));
		token.setRefreshToken(generateToken("refresh_Token"));
		token.setConfusionCode("");
		token.setExpirationTime(expirationCalendar.getTime());
		token.setExpirationInterval(1);
		token.setAuthConsumerSysNo(consumerId);
		token.setUserSysNo(userId);
		token.setCreateUserName("System");
		token.setCreateTime(new Date());
		token.setUpdateUserName("System");
		token.setUpdateTime(new Date());
		repoToken.add(token);
	}

	protected void refreshToken(AuthenticateToken token) throws Exception {
		Calendar expirationCalendar = Calendar.getInstance();
		expirationCalendar.setTime(new Date());
		expirationCalendar.add(Calendar.DATE, 1);
		token.setAccessToken(generateToken("access_Token"));
		token.setRefreshToken(generateToken("refresh_Token"));
		token.setExpirationTime(expirationCalendar.getTime());
		token.setUpdateTime(new Date());
		repoToken.save(token);
	}

	protected String generateToken(String secret) {
		// Encryption encryption = new Encryption(secret);
		// int num = (int) Math.random() * 1000;
		// return encryption.encryptString(LocalDateTime.now().toString() +
		// num);
		return secret + (int) Math.random() * 1000;
	}

}