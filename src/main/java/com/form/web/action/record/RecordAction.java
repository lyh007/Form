package com.form.web.action.record;

import com.form.SystemConstants;
import com.form.model.Template;
import com.form.model.User;
import com.form.service.CompleteRequestService;
import com.form.web.action.BaseAction;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
@ParentPackage(value = "default")
@Namespace("/record")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/record/form_records.jsp")
})
public class RecordAction extends BaseAction {
    @Autowired
    private CompleteRequestService completeRequestService;
    private List<Template> templates = new ArrayList<Template>(); //ALL Templates List

    @Override    //List
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        SystemConstants.LoginType loginType = SystemConstants.LoginType.getValueOf((String) session.getAttribute(SystemConstants.LOGIN_TYPE));
        //if company user login
        if (loginType == SystemConstants.LoginType.COMPANY_USER_LOGIN) {

        } else if (loginType == SystemConstants.LoginType.COMMON_USER_LOGIN) {   //common user login
            User commonUser = (User) session.getAttribute(SystemConstants.SESSION_USER);
            templates = completeRequestService.queryCommonUserTemplates(commonUser.getId());
        }
        return SUCCESS;
    }

    //Delete Objects
    public String delete() throws Exception {
        return execute();
    }

    public List<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }
}
