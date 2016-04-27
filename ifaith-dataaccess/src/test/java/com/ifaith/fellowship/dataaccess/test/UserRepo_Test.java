package com.ifaith.fellowship.dataaccess.test;

import java.util.Calendar;

import org.junit.Test;
import com.ifaith.fellowship.dataaccess.people.UserRepo;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

public class UserRepo_Test {
	@Test
	public void userRepo_insert_test() throws Exception {
		UserRepo userRepo = new UserRepo();
		UserBasicInfo entity = new UserBasicInfo();

		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.set(1986, 9, 17);

		entity.setName("Alan");
		entity.setPassword("123465");
		entity.setDateOfBirth(cal.getTime());
		entity.setTypeID(0);
		entity.setEnabled(true);

		entity.setCreateTime(now.getTime());
		entity.setUpdateTime(now.getTime());
		entity.setCreateUserSysNo(0);
		entity.setUpdateUserSysNo(0);
		entity.setCreateUserName("SystemUser");
		entity.setUpdateUserName("SystemUser");

		userRepo.insert(entity);
		entity.setName("Eric");
		userRepo.update(entity);
		
		userRepo.delete(entity);
		
		System.out.print(entity.getSysNo());
	}
}
