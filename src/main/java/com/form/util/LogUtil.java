package com.form.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * System Log Util
 */
public final class LogUtil {
    //CA platform log ID
    public static final String FORM_LOG = "FORM";

    public static Logger getLogger(String name) {
        return LogManager.getLogger(name);
    }
}
