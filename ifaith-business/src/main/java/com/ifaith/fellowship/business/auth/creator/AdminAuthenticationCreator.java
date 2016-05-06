package com.ifaith.fellowship.business.auth.creator;

import com.ifaith.fellowship.entity.user.AdminUserModel;
import com.ifaith.fellowship.entity.user.SignInModel;

public class AdminAuthenticationCreator implements UserAuthenticationCreator {

	@Override
	public SignInModel authenticationUser(int userId, int churchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignInModel authenticationUser(String userName, String password, String churchCode) {
		// TODO Auto-generated method stub
		AdminUserModel model = null;
		if(userName.equals("alan.luo") && password.equals("Active@000"))
		{
			model =  new AdminUserModel();
			model.setUserSysNo(100);
			model.setChurchSysNo(8601);
			model.setUserName("alan.luo");
		}
		return model;
	}

}
