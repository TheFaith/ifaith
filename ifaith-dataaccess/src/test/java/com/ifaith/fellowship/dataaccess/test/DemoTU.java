package com.ifaith.fellowship.dataaccess.test;

import java.io.IOException;

import org.junit.Test;

import com.ifaith.fellowship.dataaccess.demo.DemoDao;
public class DemoTU {
	@Test
	public void Test_DemoDao() throws IOException{
		DemoDao dao = new DemoDao();
		dao.createSqlSession();
	}
}
