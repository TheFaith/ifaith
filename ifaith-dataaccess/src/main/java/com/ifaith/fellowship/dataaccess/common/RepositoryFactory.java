package com.ifaith.fellowship.dataaccess.common;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RepositoryFactory {
	/// @function : create Repository Instance
	// TODO We can management the repository create here.
	public static <T extends Repository<?, ?>> T Create(Class<T> type) {
		T objInstance = null;
		//try(ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("spring-ifaith-dataaccess.xml"))
		try(ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("spring-ifaith-business.xml"))
		{
			objInstance = context.getBean(type);	
		}
		return objInstance;
	}

	public static <T> T CreateDataMapper(Class<T> type) {
		// TODO
		return null;
	}

	public static <T> T CreateUnitOfWork(Class<T> type) {
		// TODO
		return null;
	}
}
