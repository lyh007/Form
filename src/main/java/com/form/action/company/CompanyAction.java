package com.form.action.company;

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
@Namespace("/company")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/company/company_welcome.jsp"),
        @Result(name = "registration", location = "/WEB-INF/jsp/management_index.jsp"),
        @Result(name = "create", location = "/WEB-INF/jsp/company/company_registration.jsp"),
        @Result(name = "preUpdate", location = "/WEB-INF/jsp/company/company_update.jsp")
})
public class CompanyAction extends BaseAction {
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    //Sign in
    public String sign() throws Exception {
        return execute();
    }

    //forward to registration page
    public String create() throws Exception {
        return "create";
    }

    //create company and super user
    public String registration() throws Exception {
        return "registration";
    }

    //prepare update company profile
    public String preUpdate() throws Exception {
        return "preUpdate";
    }

    //update company profile
    public String update() throws Exception {
        return execute();
    }
}
