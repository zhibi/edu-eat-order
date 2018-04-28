package com.school.support.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by 执笔 on 2017/3/15.
 */
public class WebConfigListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(WebConfigListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.findWebApplicationContext(servletContext);
    }

}
