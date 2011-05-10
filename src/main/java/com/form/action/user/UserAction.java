package com.form.action.user;

import com.form.action.BaseAction;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/user")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/user/company_user_management.jsp"),
        @Result(name = "preCreate", location = "/WEB-INF/jsp/user/company_user_create.jsp"),
        @Result(name = "preUpdate", location = "/WEB-INF/jsp/user/company_user_update.jsp")
})
public class UserAction extends BaseAction {
    @Override //User Manager
    public String execute() throws Exception {
        return SUCCESS;
    }

    //prepare create User
    public String preCreate() throws Exception {
        return "preCreate";
    }

    // create company User
    public String create() throws Exception {
        return execute();
    }

    //prepare update User
    public String preUpdate() throws Exception {
        return "preUpdate";
    }

    //update company User
    public String update() throws Exception {
        return execute();
    }

    //delete company User
    public String delete() throws Exception {
        return execute();
    }
}
