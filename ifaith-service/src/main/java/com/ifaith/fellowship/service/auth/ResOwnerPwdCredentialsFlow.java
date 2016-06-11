package com.ifaith.fellowship.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import com.ifaith.fellowship.dataaccess.people.ConsumerRepository;

public class ResOwnerPwdCredentialsFlow implements IOAuth2{
	
	@Autowired
	protected ConsumerRepository consumerRepo;
	@Override
	public Object GenerateAccessToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
