package com.form;

public interface SystemConstants {
    /**
     * CompanyUser key, stored in the HttpSession object reference CompanyUser
     */
    public final static String SESSION_COMPANY_USER = "session_company_user";
    /**
     * CompanyUser Login Id, stored in the HttpSession
     */
    public final static String SESSION_COMPANY_USER_LOGINID = "session_company_user_loginId";
    /**
     * Company key, stored in the HttpSession object reference Company
     */
    public final static String SESSION_COMPANY = "session_company";
    /**
     * Company Name, stored in the HttpSession
     */
    public final static String SESSION_COMPANY_NAME = "session_company_name";
    /**
     * User key, stored in the HttpSession object reference CompanyUser
     */
    public final static String SESSION_USER = "session_user";
    /**
     * User Login Id, stored in the HttpSession
     */
    public final static String SESSION_USER_LOGINID = "session_user_loginId";
    /**
     * Login Type: commonUser| companyUser
     */
    public final static String LOGIN_TYPE = "loginType";

    /**
     * Record the address of the last request in order to jump directly to the original login page
     */
    public final static String SESSION_URL = "befor_url";

    /**
     * Login Type Enum
     */
    public enum LoginType {
        COMMON_USER_LOGIN, //COMMON USER Login
        COMPANY_USER_LOGIN; //COMPANY USER Login

        public static LoginType getValueOf(String loginTypeStr) {
            if (loginTypeStr == null) return null;
            for (LoginType loginType : values()) {
                if (loginType.toString().equalsIgnoreCase(loginTypeStr)) {
                    return loginType;
                }
            }
            return null;
        }
    }
}
