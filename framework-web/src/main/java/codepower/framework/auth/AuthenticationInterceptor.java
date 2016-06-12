package codepower.framework.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ifaith.fellowship.service.auth.AuthService;
import com.ifaith.fellowship.entity.auth.CurrentUser;
import com.ifaith.fellowship.entity.user.UserBasicInfo;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	protected AuthService manager;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean isPass = true;

		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			Authentication auth = ((HandlerMethod) handler).getMethodAnnotation(Authentication.class);
			if (auth != null) {
				// here is our Authentication logic.
				String strAuth = request.getHeader("Authorization");
				UserBasicInfo outUser = manager.verifyAccessToken(strAuth);
				if (outUser != null) {
					// set context data.
					
					CurrentUser currentUser = new CurrentUser();
					currentUser.setUserSysNo(outUser.getSysNo());
					currentUser.setUserName(outUser.getName());
					
					//HttpSession session = request.getSession();
					//session.setAttribute("currentUser", currentUser);
					request.setAttribute("currentUser", currentUser);
				} else {
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					isPass = false;
				}
			}
		}
		return isPass;

	}

}
