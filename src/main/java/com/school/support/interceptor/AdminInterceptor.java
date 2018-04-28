package com.school.support.interceptor;

import com.school.support.context.Constant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 执笔 on 2017/3/21.
 */
public class AdminInterceptor extends HandlerInterceptorAdapter implements Constant{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object = request.getSession().getAttribute(SESSION_ADMIN);
        String uri = request.getRequestURI();
        if(null == object && uri.startsWith("/admin") && !uri.startsWith("/admin/login") &&!uri.contentEquals("/admin/customer/login")){
            response.sendRedirect("/admin/login");
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
