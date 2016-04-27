package com.ifaith.fellowship.dataaccess.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSourceManager {
	private final static String CST_RESOURCE = "db-conf.xml";

	public static SqlSessionFactory createSessionFactory() throws IOException {
		// @ control data SessionFactory.
		// try {
		// InputStream iStream =
		// Resources.getResourceAsStream(DataSourceManager.CST_RESOURCE);
		// } catch (IOException ex) {
		// // log error.
		// }
		InputStream iStream = Resources.getResourceAsStream(DataSourceManager.CST_RESOURCE);
		return new SqlSessionFactoryBuilder().build(iStream);
	}
}
