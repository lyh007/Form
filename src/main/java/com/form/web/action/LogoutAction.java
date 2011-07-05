package com.form.web.action;

import com.form.SystemConstants;
import com.form.model.CompanyUser;
import com.form.model.User;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/")
@Results({
        @Result(name = "success", location = "/index.action", type = "redirect"),
        @Result(name = "userLogin", location = "/user/user!userLogin.action", type = "redirect")
})
public class LogoutAction extends BaseAction {
    @Override      //foward to login page
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        if (session != null) {
            SystemConstants.LoginType loginType = SystemConstants.LoginType.getValueOf((String) session.getAttribute(SystemConstants.LOGIN_TYPE));
            if (loginType == SystemConstants.LoginType.COMPANY_USER_LOGIN) {
                //delete Session company user
                CompanyUser user = (CompanyUser) session.getAttribute(SystemConstants.SESSION_COMPANY_USER);
                if (user != null) {
                    //ss.logout(admin.getName()); TODO:not set user offline
                    session.removeAttribute(SystemConstants.SESSION_COMPANY_USER);
                }
                session.removeAttribute(SystemConstants.SESSION_COMPANY_USER_LOGINID);
                session.removeAttribute(SystemConstants.SESSION_COMPANY);
                session.removeAttribute(SystemConstants.SESSION_COMPANY_NAME);
                session.removeAttribute(SystemConstants.LOGIN_TYPE);
                session.invalidate();
            } else if (loginType == SystemConstants.LoginType.COMMON_USER_LOGIN) {
                User user = (User) session.getAttribute(SystemConstants.SESSION_USER);
                if (user != null) {
                    //ss.logout(admin.getName()); TODO:not set user offline
                    session.removeAttribute(SystemConstants.SESSION_USER);
                }
                session.removeAttribute(SystemConstants.SESSION_USER_LOGINID);
                session.removeAttribute(SystemConstants.LOGIN_TYPE);
                session.invalidate();
                return "userLogin";
            } else {
                //not implements
            }
        }
        return SUCCESS;
    }
}
