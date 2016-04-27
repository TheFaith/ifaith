package com.ifaith.fellowship.business.auth.creator;

import com.ifaith.fellowship.entity.user.SignInModel;

public interface UserAuthenticationCreator {
	
	public SignInModel authenticationUser(int userId, int churchId);

	public SignInModel authenticationUser(String userName, String password, String churchCode);
}
