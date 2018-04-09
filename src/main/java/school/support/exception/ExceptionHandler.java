package school.support.exception;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Map<String, String> model = new HashMap<>();
		model.put("errorMsg", ex.getMessage());
		ex.printStackTrace();
		return new ModelAndView("error", model);
	}
}