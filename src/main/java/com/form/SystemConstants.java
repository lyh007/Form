package com.form;

public interface SystemConstants {
    /**
     * User key, stored in the HttpSession object reference User
     */
    public final static String SESSION_USER = "com.form.model.user";
    /**
     * Record the address of the last request in order to jump directly to the original login page
     */
    public final static String SESSION_URL = "befor_url";
}
