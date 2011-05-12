package com.form.web.listener;

import com.form.Version;
import com.form.web.ServerBeanFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Form System Listner
 */
public class FormStartupListener implements ServletContextListener {
    private static Logger logger = LogManager.getLogger("FORM");

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        ServerBeanFactory.setAppContext(ctx);
        ServerBeanFactory.setServletContext(servletContextEvent.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("FORM Server [" + Version.getInstance().getSvnTag() + ".GA (build: SVNTag="
                + Version.getInstance().getSvnTag() + " date=" + Version.getInstance().getBuildDate() + ")] has stopped...");
    }
}
