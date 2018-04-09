package school.support.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Ghost
 *
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object object = request.getSession().getAttribute("sessionAdmin");
		String uri = request.getRequestURI();
		if (null == object) {
			response.sendRedirect("/admin/login");
			return false;
		}
		return super.preHandle(request, response, handler);
	}
}
