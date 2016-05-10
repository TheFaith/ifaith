package com.ifaith.fellowship.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ifaith.fellowship.business.people.UserBizFacade;
import com.ifaith.fellowship.entity.auth.CurrentUser;

import codepower.framework.web.ApiController;
import codepower.framework.web.auth.Authentication;

@RestController
public class UserController extends ApiController {
	class OutPut {
		public int current_user_sysno;
		public int input_user_sysno;
		public String message;
		public String current_user_name;

		public OutPut(int cSysNo, int iSysNo, String msg, String name) {
			current_user_sysno = cSysNo;
			input_user_sysno = iSysNo;
			message = msg;
			current_user_name = name;
		}
	}

	@Autowired
	protected UserBizFacade manager;

	@Authentication
	@ResponseBody
	@RequestMapping(value = "/user/{sysno}", method = RequestMethod.GET)
	public OutPut testUserContext(@PathVariable("sysno") int sysNo) throws Exception {
		String message = null;
		CurrentUser user = this.getCurrentUser();
		if (user.getUserSysNo() == sysNo) {
			message = "same user.";
		} else {
			message = "other user.";
		}
		String name = manager.getUserInformation(user.getUserSysNo()).getName();
		OutPut xOutPut = new OutPut(user.getUserSysNo(), sysNo, message, name);
		return xOutPut;
	}
}
