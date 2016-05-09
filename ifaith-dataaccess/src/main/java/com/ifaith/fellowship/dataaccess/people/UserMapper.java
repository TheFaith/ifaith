package com.ifaith.fellowship.dataaccess.people;

import java.util.List;

import com.ifaith.fellowship.entity.user.UserBasicInfo;
import com.ifaith.fellowship.entity.user.UserQC;

public interface UserMapper {
	public UserBasicInfo getUser(int sysNo);

	public List<UserBasicInfo> queryUsers(UserQC query);

	public int insertUser(UserBasicInfo user);

	public int updateUser(UserBasicInfo user);

	public int deleteUser(int sysNo);
}
