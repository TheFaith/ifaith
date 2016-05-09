package com.ifaith.fellowship.dataaccess.common;

import java.util.List;

import com.ifaith.fellowship.entity.common.BasiceQueryCondition;

public interface Repository<T, Q extends BasiceQueryCondition> {

	public int add(T entity) throws Exception;

	public int save(T entity) throws Exception;

	public int remove(int sysNo) throws Exception;

	public T find(int sysNo)throws Exception;

	public List<T> findsBy(Q query)throws Exception;
}
