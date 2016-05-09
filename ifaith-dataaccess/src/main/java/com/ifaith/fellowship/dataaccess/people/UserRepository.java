package com.ifaith.fellowship.dataaccess.people;

import com.ifaith.fellowship.dataaccess.common.Repository;
import com.ifaith.fellowship.entity.user.UserBasicInfo;
import com.ifaith.fellowship.entity.user.UserQC;

public interface UserRepository extends Repository<UserBasicInfo, UserQC> {
	public UserBasicInfo findsBy(String name) throws Exception;
}
