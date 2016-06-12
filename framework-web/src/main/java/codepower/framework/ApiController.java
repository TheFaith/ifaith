package codepower.framework;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifaith.fellowship.entity.auth.CurrentUser;

public class ApiController {
	@Autowired
	protected HttpServletRequest request;

	protected Map<String, Boolean> map;

	public CurrentUser getCurrentUser() {
		CurrentUser user = null;
		if (this.request != null) {
			user = (CurrentUser) this.request.getAttribute("currentUser");
		}
		return user;
	};

	public boolean hasRight(String key) {
		boolean hasRight = false;
		if (map == null) {
			// TODO load map.
			// map = (Map<String,Boolean>)this.request.getAttribute("rightMap");
			map = new HashMap<String, Boolean>();
		}
		if (map.containsKey(key)) {
			hasRight = map.get(key);
		}
		return hasRight;
	}
}
