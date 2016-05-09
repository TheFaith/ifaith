package com.ifaith.fellowship.api.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifaith.fellowship.entity.auth.CurrentUser;
import com.ifaith.fellowship.entity.user.*;

import codepower.framework.web.auth.Authentication;

@Controller
public class UserController {
	@Authentication
	@ResponseBody
	@RequestMapping(value = "/user/{sysno}", method = RequestMethod.GET)
	public UserBasicInfo getUserBasicInformation(HttpServletRequest request,@PathVariable("sysno") int sysNo) {
		CurrentUser user = (CurrentUser)request.getAttribute("currentUser");
		//CurrentUser user = (CurrentUser)request.getSession().getAttribute("currentUser");
		
		UserBasicInfo userBasicInfo = new UserBasicInfo(100, "Alan", new Date());
		if (sysNo != 0) {
			userBasicInfo = new UserBasicInfo(101, "Other", new Date());
		}
		return userBasicInfo;
	}
}
