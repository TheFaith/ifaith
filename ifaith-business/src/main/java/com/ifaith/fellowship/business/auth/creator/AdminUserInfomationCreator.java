package com.ifaith.fellowship.business.auth.creator;

import com.ifaith.fellowship.business.auth.AuthUserContext;
import com.ifaith.fellowship.dataaccess.common.DataBuilder;
import com.ifaith.fellowship.dataaccess.people.UserRepo;
import com.ifaith.fellowship.entity.auth.CurrentUser;

public class AdminUserInfomationCreator implements UserInfomationCreator{

	@Override
	public CurrentUser GetUserInfomation(AuthUserContext context) {
		// TODO Auto-generated method stub
		try {
			DataBuilder.<UserRepo>CreateRepository(UserRepo.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
