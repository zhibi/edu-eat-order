package com.school.support.exception;

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

        ex.printStackTrace();

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Map<String, String> model = new HashMap<>();
        model.put("errorMsg", ex.getMessage());
        if (ex instanceof TipException) {
            model.put("tipMsg", ex.getMessage());
            return new ModelAndView("admin/msg", model);

        }
        return new ModelAndView("msg", model);
    }
}