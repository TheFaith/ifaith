package com.ifaith.fellowship.dataaccess.common;

public interface Repository<T> {

	public void Insert(T entity);

	public void Update(T entity);

	public void Delete(T entity);
}
