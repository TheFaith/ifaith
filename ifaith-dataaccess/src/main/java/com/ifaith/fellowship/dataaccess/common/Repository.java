package com.ifaith.fellowship.dataaccess.common;

import java.util.List;

public interface Repository<T, Q> {

	public int insert(T entity) throws Exception;

	public int update(T entity) throws Exception;

	public int delete(T entity) throws Exception;

	public T find(int sysNo);

	public List<T> query(QueryCondition<Q> query);
}
