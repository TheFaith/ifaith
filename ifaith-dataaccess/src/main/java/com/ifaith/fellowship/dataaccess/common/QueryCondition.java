package com.ifaith.fellowship.dataaccess.common;

import com.ifaith.fellowship.entity.common.BasiceQueryCondition;

public class QueryCondition<T extends BasiceQueryCondition> {
	protected int pageIndex;
	protected int pageSize;
	protected T condition;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public T getCondition() {
		return condition;
	}

	public void setCondition(T condition) {
		this.condition = condition;
	}
}
