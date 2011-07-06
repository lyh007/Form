package com.form.web.action.inbox;

import com.form.web.action.BaseAction;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/inbox")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/company/company_welcome.jsp")
})
public class InboxAction extends BaseAction {
     @Override    //List
    public String execute() throws Exception {
        return SUCCESS;
    }

    //Delete Objects
    public String delete() throws Exception {
        return execute();
    }
}
