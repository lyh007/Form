package com.form;

public interface SystemConstants {
    /**
     * User key, stored in the HttpSession object reference User
     */
    public final static String SESSION_USER = "session_user";
    /**
     * User Name, stored in the HttpSession
     */
    public final static String SESSION_USER_LOGINID = "session_user_loginId";
    /**
     * Company key, stored in the HttpSession object reference Company
     */
    public final static String SESSION_COMPANY = "session_company";
    /**
     * Company Name, stored in the HttpSession
     */
    public final static String SESSION_COMPANY_NAME = "session_company_name";
    /**
     * Record the address of the last request in order to jump directly to the original login page
     */
    public final static String SESSION_URL = "befor_url";
}
