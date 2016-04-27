package com.ifaith.fellowship.dataaccess.demo;

import com.ifaith.fellowship.entity.user.UserBasicInfo;

public interface UserMapper {
	// selectUser
	UserBasicInfo selectUser(int id);
}
