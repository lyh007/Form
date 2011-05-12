package com.form.web;

import com.form.util.LogUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * save Spring Application Contex
 */
public final class ServerBeanFactory {
    private static Logger logger = LogUtil.getLogger(LogUtil.FORM_LOG);
    private static ApplicationContext ctx = null;
    private static ServletContext scx = null;

    private ServerBeanFactory() {
    }

    public static void setAppContext(ApplicationContext appCtx) {
        ctx = appCtx;
    }

    public static ApplicationContext getAppContext() {
        return ctx;
    }

    public static void setServletContext(ServletContext servletContext) {
        scx = servletContext;
    }

    public static ServletContext getServletContext() {
        return scx;
    }

    public static Object getBean(String beanName) {
        return ctx.getBean(beanName);
    }

    /**
     * Initialization of each module, respectively, if there is a single module failed to initialize the other modules not affect the system
     */
    public static void initModules() {
        logger.info("execute init Modules......");
    }
}
