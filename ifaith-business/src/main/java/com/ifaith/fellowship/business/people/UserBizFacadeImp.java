package com.ifaith.fellowship.business.people;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifaith.fellowship.business.BizFacade;
import com.ifaith.fellowship.dataaccess.people.UserRepository;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

@BizFacade
public class UserBizFacadeImp implements UserBizFacade{

	@Autowired
	public UserRepository repoUser;
	
	@Override
	public UserBasicInfo getUserInformation(int sysNo) throws Exception {
		//verify some data here.
		return repoUser.find(sysNo);
	}

}
