package codepower.framework.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.ifaith.fellowship.dataaccess.common.Repository;

public class AppContextHelper implements ApplicationContextAware {

	protected static ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		appContext = context;
	}

	public static <T extends Repository<?, ?>> T getRepository(Class<T> interfaceType) {
		T entity = appContext.getBean(interfaceType);
		return entity;
	}
	
	public static <T> T getBean(Class<T> interfaceType) {
		T entity = appContext.getBean(interfaceType);
		return entity;
	}
}