package com.ifaith.fellowship.dataaccess.test;

import java.util.Calendar;
import org.junit.Test;
import com.ifaith.fellowship.dataaccess.people.ConsumerRepoImp;
import com.ifaith.fellowship.entity.auth.Consumer;

public class ConsumerRepo_Test {
	@Test
	public void consumerRepo_insert_test() throws Exception {
		ConsumerRepoImp consumerRepo = new ConsumerRepoImp();
		Consumer entity = new Consumer();

		Calendar now = Calendar.getInstance();

		entity.setConsumerAppID(1000);
		entity.setConsumerName("AdminUI");
		entity.setConsumerKey("AdminUI_Key");
		entity.setConsumerSecret("A2S32F4E35IVK43D53A4S3#J+=");
		entity.setEnabled(true);

		entity.setCreateTime(now.getTime());
		entity.setUpdateTime(now.getTime());
		entity.setCreateUserSysNo(0);
		entity.setUpdateUserSysNo(0);
		entity.setCreateUserName("SystemUser");
		entity.setUpdateUserName("SystemUser");

		consumerRepo.add(entity);
		entity.setConsumerName("Daycare");
		consumerRepo.save(entity);

		consumerRepo.remove(entity);

		System.out.print(entity.getSysNo());
	}
}
