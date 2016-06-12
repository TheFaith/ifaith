package codepower.framework.web;

import java.util.Map;

public class MapJsonResponse<K, V> implements Response {
	protected Map<K, V> datas;

	public MapJsonResponse(Map<K, V> datas) {
		this.datas = datas;
	}
}
