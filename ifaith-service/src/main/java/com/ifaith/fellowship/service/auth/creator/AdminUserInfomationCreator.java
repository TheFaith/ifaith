package com.ifaith.fellowship.service.auth.creator;

import org.springframework.beans.factory.annotation.Autowired;


import com.ifaith.fellowship.dataaccess.people.UserRepository;
import com.ifaith.fellowship.entity.auth.CurrentUser;
import com.ifaith.fellowship.entity.user.UserBasicInfo;
import com.ifaith.fellowship.service.auth.AuthUserContext;

public class AdminUserInfomationCreator implements UserInfomationCreator {

	@Autowired
	protected UserRepository userRepo;

	@Override
	public CurrentUser GetUserInfomation(AuthUserContext context) {
		CurrentUser user = null;
		try {
			UserBasicInfo userBasic = userRepo.find(context.getSysNo());
			
			user = new CurrentUser();
			user.setUserSysNo(userBasic.getSysNo());
			user.setUserName(userBasic.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

}
