package com.ifaith.fellowship.controller.auth;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ifaith.fellowship.service.auth.AuthService;

import codepower.framework.web.SimpleJsonResponse;

import com.ifaith.fellowship.entity.auth.AuthenticateModel;
import com.ifaith.fellowship.entity.auth.OAuthRequestModel;
import com.ifaith.fellowship.entity.auth.OAuthResponse;
import com.ifaith.fellowship.entity.auth.OAuthResponseModel;
import com.ifaith.fellowship.entity.common.GrantType;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	protected AuthService manager;
	@Autowired
	protected AuthService authService;

	@RequestMapping(value = "token", method = RequestMethod.POST)
	public SimpleJsonResponse<AuthenticateModel> token(@RequestBody OAuthRequestModel model) throws Exception {
		// #01.action
		GrantType grantType = GrantType.Convert(model.getGrantType());
		AuthenticateModel returnData = authService.generateAccessToken(model, grantType);

		// #02.format response.
		SimpleJsonResponse<AuthenticateModel> response = new SimpleJsonResponse<>(returnData);
		return response;
	}

	/**
	 * ----------------------------------------
	 * ----------------------------------------
	 * ----------------------------------------
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/user/{sysno}", method = RequestMethod.GET)
	public UserBasicInfo getUserBasicInformation(@PathVariable("sysno") int sysNo) {

		UserBasicInfo userBasicInfo = new UserBasicInfo(100, "Alan", new Date());
		if (sysNo != 0) {
			userBasicInfo = new UserBasicInfo(101, "Other Test", new Date());
		}
		return userBasicInfo;
	}

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public OAuthResponse createAccessToken(OAuthRequestModel model) {
		// AuthUserFactory

		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return new OAuthResponseModel("access_token", "token_type", dateFormat.format(currentDate), "refresh_token");
	}

	@ResponseBody
	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	public OAuthResponse refreshAccessToken(OAuthRequestModel model) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return new OAuthResponseModel("access_token", "token_type", dateFormat.format(currentDate), "refresh_token");
	}

}
