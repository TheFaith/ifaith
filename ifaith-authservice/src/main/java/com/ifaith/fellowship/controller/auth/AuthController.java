package com.ifaith.fellowship.controller.auth;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifaith.fellowship.entity.auth.OAuthResponse;
import com.ifaith.fellowship.entity.auth.OAuthResponseModel;
import com.ifaith.fellowship.entity.auth.ResOwnerPwdCredModel;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

@Controller
@RequestMapping("/token")
public class AuthController {
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
	public OAuthResponse createAccessToken(ResOwnerPwdCredModel model) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return new OAuthResponseModel("access_token", "token_type", dateFormat.format(currentDate), "refresh_token");
	}
	
	@ResponseBody
	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	public OAuthResponse refreshAccessToken(ResOwnerPwdCredModel model) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return new OAuthResponseModel("access_token", "token_type", dateFormat.format(currentDate), "refresh_token");
	}
}
