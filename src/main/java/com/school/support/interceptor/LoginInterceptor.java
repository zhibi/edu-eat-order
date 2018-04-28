package com.school.support.interceptor;

import com.school.support.annocation.request.LoginInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录拦截器
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private String LOGIN_URL = "join";

    private String loginUrl = LOGIN_URL;
    private String sessionUser = "sessionUser";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object attribute = request.getSession().getAttribute(sessionUser);
        if (handler != null && handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> beanType = handlerMethod.getBeanType();
            LoginInfo requestLogin = null;
            if (beanType.isAnnotationPresent(LoginInfo.class))
                requestLogin = beanType.getAnnotation(LoginInfo.class);
            if (handlerMethod.hasMethodAnnotation(LoginInfo.class))
                requestLogin = handlerMethod.getMethodAnnotation(LoginInfo.class);
            if (requestLogin != null && attribute == null) {//需要登录
                //跳转到登录页面
                response.sendRedirect(loginUrl);
                return false;
            }
        }
        return super.preHandle(request, response, handler);
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(String sessionUser) {
        this.sessionUser = sessionUser;
    }
}
