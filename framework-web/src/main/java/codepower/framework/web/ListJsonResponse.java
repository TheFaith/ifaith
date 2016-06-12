package codepower.framework.web;

import java.util.List;

public class ListJsonResponse<T> implements Response {
	protected List<T> datas;

	public ListJsonResponse(List<T> datas) {
		this.datas = datas;
	}
}
