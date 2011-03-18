package com.form.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTestCase {
    //Spring配置文件路径
    private static String[] configLocations = {"conf/spring/applicationContext*.xml"};
    private static ApplicationContext context;

    //设置配置文件路径
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
