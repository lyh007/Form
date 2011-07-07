package com.form.web.action.inbox;

import com.form.SystemConstants;
import com.form.base.QueryParams;
import com.form.model.Company;
import com.form.model.CompanyUser;
import com.form.model.CompleteRequest;
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
@ParentPackage(value = "struts-default")
@Namespace("/inbox")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/company/company_welcome.jsp")
})
public class InboxAction extends BaseAction {
      @Autowired
    private CompleteRequestService completeRequestService;
     private List<CompleteRequest> completeRequests = new ArrayList<CompleteRequest>();
    @Override    //List
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        SystemConstants.LoginType loginType = SystemConstants.LoginType.getValueOf((String) session.getAttribute(SystemConstants.LOGIN_TYPE));
        //if company user login
        if (loginType == SystemConstants.LoginType.COMPANY_USER_LOGIN) {
            Company sessionCompany = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
            CompanyUser companyUser = (CompanyUser) session.getAttribute(SystemConstants.SESSION_COMPANY_USER);

            QueryParams<CompleteRequest> queryParams = new QueryParams<CompleteRequest>();
            CompleteRequest completeRequestParam = new CompleteRequest();
            completeRequestParam.setCompanyId(sessionCompany.getId());
            completeRequestParam.setCompanyUserId(companyUser.getId());
            queryParams.setEntity(completeRequestParam);
            completeRequests = completeRequestService.queryByPage(queryParams);
        } else if (loginType == SystemConstants.LoginType.COMMON_USER_LOGIN) {   //common user login

        }
        return SUCCESS;
    }

    //Delete Objects
    public String delete() throws Exception {
        return execute();
    }

    public List<CompleteRequest> getCompleteRequests() {
        return completeRequests;
    }

    public void setCompleteRequests(List<CompleteRequest> completeRequests) {
        this.completeRequests = completeRequests;
    }
}
