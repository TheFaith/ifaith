package com.ifaith.fellowship.dataaccess.people;

import com.ifaith.fellowship.entity.user.UserBasicInfo;

public interface UserMapper {
	public UserBasicInfo getUser(int sysNo);

	public int insertUser(UserBasicInfo user);

	public int updateUser(UserBasicInfo user);

	public int deleteUser(int sysNo);
}
