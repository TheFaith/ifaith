package com.ifaith.fellowship.business.auth;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifaith.fellowship.business.BizFacade;
import com.ifaith.fellowship.business.auth.factory.AuthUserFactory;
import com.ifaith.fellowship.dataaccess.people.AuthenticateTokenRepository;
import com.ifaith.fellowship.dataaccess.people.ConsumerRepository;
import com.ifaith.fellowship.dataaccess.people.UserRepository;
import com.ifaith.fellowship.entity.auth.AuthenticateToken;
import com.ifaith.fellowship.entity.auth.Consumer;
import com.ifaith.fellowship.entity.auth.OAuthRequest;
import com.ifaith.fellowship.entity.auth.ResOwnerPwdCredModel;
import com.ifaith.fellowship.entity.user.SignInModel;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

@BizFacade
public class AuthBizFacadeImp implements AuthBizFacade {
	class OutData {
		public String getTokenType() {
			return tokenType;
		}

		public void setTokenType(String tokenType) {
			this.tokenType = tokenType;
		}

		public String getAccessToken() {
			return accessToken;
		}

		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}

		public String getExpirationDate() {
			return expirationTime;
		}

		public void setExpirationTime(String expirationTime) {
			this.expirationTime = expirationTime;
		}

		public String getRefreshToken() {
			return refreshToken;
		}

		public void setRefreshToken(String refreshToken) {
			this.refreshToken = refreshToken;
		}

		public SignInModel getUser() {
			return user;
		}

		public void setUser(SignInModel user) {
			this.user = user;
		}

		public String tokenType;
		public String accessToken;
		public String expirationTime;
		public String refreshToken;
		public SignInModel user;

	}

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
	@Override
	public Object generateAccessToken(OAuthRequest model) throws Exception {
		if (!(model instanceof ResOwnerPwdCredModel)) {
			// TODO throw new Exception("convert type error!");
			return null;
		}

		ResOwnerPwdCredModel data = (ResOwnerPwdCredModel) model;
		String userName = data.getUserName();
		String password = data.getPassword();
		String key = data.getConsumerKey();
		String secret = data.getConsumerSecret();

		Consumer consumer = repoConsumer.findBy(key, secret);
		if (consumer == null) {
			// TODO throw new Exception("can not find consumer!");
			return null;
		}
		// get user information
		AuthUserFactory factory = AuthUserFactory.CreateAuthUserFactory(consumer.getConsumerApp());
		SignInModel user = factory.AuthenticationUser(userName, password);
		if (user == null) {
			throw new Exception("Error test!");
		}

		// create token.
		AuthenticateToken token = repoToken.findBy(consumer.getSysNo(), user.getUserSysNo());
		if (token == null) {
			// create token
			String strToken = new Date().toString();
			Calendar expirationCalendar = Calendar.getInstance();
			expirationCalendar.setTime(new Date());
			expirationCalendar.add(Calendar.DATE, 1);

			token = new AuthenticateToken();
			token.setAccessToken(strToken + Math.random());
			token.setRefreshToken(strToken + Math.random());
			token.setConfusionCode("");
			token.setExpirationTime(expirationCalendar.getTime());
			token.setExpirationInterval(1);
			token.setAuthConsumerSysNo(consumer.consumerAppID);
			token.setUserSysNo(user.getUserSysNo());
			token.setTypeID(0);
			token.setCreateUserSysNo(0);
			token.setCreateUserName("System User");
			token.setCreateTime(new Date());
			token.setUpdateUserSysNo(0);
			token.setUpdateUserName("System User");
			token.setUpdateTime(new Date());
			repoToken.add(token);
		} else {
			// refresh token
			if (token.getExpirationTime().getTime() < new Date().getTime()) {
				String strToken = new Date().toString();
				Calendar expirationCalendar = Calendar.getInstance();
				expirationCalendar.setTime(new Date());
				expirationCalendar.add(Calendar.DATE, 1);

				token.setAccessToken(strToken + Math.random());
				token.setRefreshToken(strToken + Math.random());
				token.setExpirationTime(expirationCalendar.getTime());
				token.setUpdateUserSysNo(0);
				token.setUpdateUserName("System User");
				token.setUpdateTime(new Date());
				repoToken.save(token);
			}
		}

		// builder output.
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		OutData xOut = new OutData();
		xOut.setTokenType("bearer");
		xOut.setAccessToken(token.getAccessToken());
		xOut.setExpirationTime(df.format(token.getExpirationTime()));
		xOut.setRefreshToken(token.getRefreshToken());
		xOut.setUser(user);
		return xOut;
	}

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

}
