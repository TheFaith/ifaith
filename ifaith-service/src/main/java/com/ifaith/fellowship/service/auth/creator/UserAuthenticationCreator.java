package com.ifaith.fellowship.service.auth.creator;

import com.ifaith.fellowship.entity.auth.AuthenticationUserModel;

public interface UserAuthenticationCreator {
	
	public AuthenticationUserModel authenticationUser(int userId, int churchId);

	public AuthenticationUserModel authenticationUser(String userName, String password, String churchCode)  throws Exception;
}
