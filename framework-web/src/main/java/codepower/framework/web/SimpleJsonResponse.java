package codepower.framework.web;

public class SimpleJsonResponse<T> implements Response {
	protected T data;

	public SimpleJsonResponse(T data) {
		this.data = data;
	}
}
