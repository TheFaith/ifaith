package com.ifaith.fellowship.dataaccess.common;

public class DataBuilder {
	/// @function : create Repository Instance
	///
	public static <T extends Repository<?, ?>> T CreateRepository(Class<T> type)
			throws InstantiationException, IllegalAccessException {
		T objInstance = type.newInstance();
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
