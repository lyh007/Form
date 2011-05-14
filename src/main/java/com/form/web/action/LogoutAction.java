package com.form.web.action;

import com.form.SystemConstants;
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
        @Result(name = "success", location = "/index.action", type = "redirect")
})
public class LogoutAction extends BaseAction {
    @Override      //foward to login page
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        if (session != null) {
            //删除Session中的用户信息
            User user = (User) session.getAttribute(SystemConstants.SESSION_USER);
            if (user != null) {
                //ss.logout(admin.getName()); TODO:这里暂不需要设置用户的在线状态
                session.removeAttribute(SystemConstants.SESSION_USER);
            }
            session.removeAttribute(SystemConstants.SESSION_USER_LOGINID);
            session.removeAttribute(SystemConstants.SESSION_COMPANY);
            session.removeAttribute(SystemConstants.SESSION_COMPANY_NAME);
            session.invalidate();
        }
        return SUCCESS;
    }
}
