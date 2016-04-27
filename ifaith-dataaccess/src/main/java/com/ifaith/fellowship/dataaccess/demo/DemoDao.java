package com.ifaith.fellowship.dataaccess.demo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

public class DemoDao {
	public void createSqlSession() throws IOException {
		String strResource = "db-conf.xml";
		InputStream iStream = Resources.getResourceAsStream(strResource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(iStream);
		SqlSession session = sessionFactory.openSession();

		String statement = "com.ifaith.fellowship.userMapper.getUser";

		UserBasicInfo userBasicInfo = session.selectOne(statement, 2);

		System.out.println(userBasicInfo.getSysNo());
		System.out.println(userBasicInfo.getAge());
		System.out.println(userBasicInfo.getName());
	}
}
