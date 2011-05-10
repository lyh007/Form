package com.form.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/management_index.jsp")
})
public class IndexAction extends BaseAction {
    @Override      //foward to login page
    public String execute() throws Exception {
        return SUCCESS;
    }
}
