package com.form.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTestCase {
    //Spring config file path
    private static String[] configLocations = {"conf/spring/applicationContext*.xml"};
    private static ApplicationContext context;

    //set config path
    protected static void setConfigLocations(String[] locations) {
        configLocations = locations;
    }

    protected static ApplicationContext getApplicationContext() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext(configLocations);
        }

        return context;
    }
}
