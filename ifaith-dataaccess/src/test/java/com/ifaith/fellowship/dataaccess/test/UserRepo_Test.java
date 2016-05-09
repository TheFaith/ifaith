package com.ifaith.fellowship.dataaccess.test;

import java.util.Calendar;

import org.junit.Test;

import com.ifaith.fellowship.dataaccess.common.RepositoryFactory;
import com.ifaith.fellowship.dataaccess.people.UserRepoImp;
import com.ifaith.fellowship.dataaccess.people.UserRepository;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

public class UserRepo_Test {
	@Test
	public void userRepo_insert_test() throws Exception {
		UserRepoImp userRepo = new UserRepoImp();
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

		int no = userRepo.add(entity);
		entity.setName("Eric");
		userRepo.save(entity);
		
		userRepo.remove(no);
		
		System.out.print(entity.getSysNo());
	}
	@Test
	public void repositoryFactory_insert_test() throws Exception {
		UserRepository repo =  RepositoryFactory.Create(UserRepository.class);
		UserBasicInfo user = repo.find(8);
		
		System.out.println(user.getSysNo());
		System.out.println(user.getName());
	}
	
	
	
}
