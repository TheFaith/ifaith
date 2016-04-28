package com.ifaith.fellowship.business.test;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.ifaith.fellowship.dataaccess.people.UserRepository;
import com.ifaith.fellowship.entity.auth.CurrentUser;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-config.xml")
public class DemoUT extends AbstractJUnit4SpringContextTests {

	@Resource
	protected UserRepository userRepo;

	@Test
	public void test_case() {

		CurrentUser user = null;
		try {
			UserBasicInfo userBasic = userRepo.find(8);

			user = new CurrentUser();
			user.setUserSysNo(userBasic.getSysNo());
			user.setUserName(userBasic.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.isTrue(user.getUserSysNo() == 8);
		//System.out.println(user.getUserSysNo());
		//System.out.println(user.getUserName());
	}
}
