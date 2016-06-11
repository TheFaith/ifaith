package com.ifaith.fellowship.service.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifaith.fellowship.dataaccess.people.UserRepository;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

@Service
public class UserBizFacadeImp implements UserBizFacade{

	@Autowired
	public UserRepository repoUser;
	
	@Override
	public UserBasicInfo getUserInformation(int sysNo) throws Exception {
		//verify some data here.
		return repoUser.find(sysNo);
	}

}
