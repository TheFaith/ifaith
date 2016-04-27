package codepower.framework.web.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean isPass = true;

		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			Authentication auth = ((HandlerMethod) handler).getMethodAnnotation(Authentication.class);
			if (auth != null) {
				// here is our Authentication logic.
				String strAuth = request.getHeader("Authorization");
				if (strAuth == null) {
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					isPass = false;
				}
			}
		}
		return isPass;

	}

}
