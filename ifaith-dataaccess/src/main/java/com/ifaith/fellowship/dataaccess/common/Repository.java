package com.ifaith.fellowship.dataaccess.common;

import java.io.IOException;
import java.util.List;

public interface Repository<T, Q> {

	public int add(T entity) throws Exception;

	public int save(T entity) throws Exception;

	public int remove(T entity) throws Exception;

	public T find(int sysNo)throws IOException;

	public List<T> findBy(QueryCondition<Q> query);
}
