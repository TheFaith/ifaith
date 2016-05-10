package com.ifaith.fellowship.business.people;

import com.ifaith.fellowship.entity.user.UserBasicInfo;

public interface UserBizFacade {
	
	public UserBasicInfo getUserInformation(int sysNo) throws Exception;
}
