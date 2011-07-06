package com.form.web.action.outbox;

import com.form.SystemConstants;
import com.form.base.QueryParams;
import com.form.model.*;
import com.form.service.CompleteRequestService;
import com.form.service.TemplateService;
import com.form.service.UserService;
import com.form.web.action.BaseAction;
import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/outbox")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/outbox/request_outbox.jsp")
})
public class OutboxAction extends BaseAction {
    @Autowired
    private TemplateService templateService;
    @Autowired
    private CompleteRequestService completeRequestService;
    @Autowired
    private UserService userService;

    private CompleteRequest completeRequest = new CompleteRequest();
    private List<Template> templates = new ArrayList<Template>(); //ALL Templates List
    private List<CompleteRequest> completeRequests = new ArrayList<CompleteRequest>();

    @Override    //List
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        Company sessionCompany = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        CompanyUser companyUser = (CompanyUser) session.getAttribute(SystemConstants.SESSION_COMPANY_USER);
        templates = templateService.getTemplatesByCompanyId(sessionCompany.getId());

        //if company user login
        QueryParams<CompleteRequest> queryParams = new QueryParams<CompleteRequest>();
        CompleteRequest completeRequestParam = new CompleteRequest();
        completeRequestParam.setCompanyId(sessionCompany.getId());
        completeRequestParam.setCompanyUserId(companyUser.getId());
        queryParams.setEntity(completeRequestParam);
        completeRequests = completeRequestService.queryByPage(queryParams);
        return SUCCESS;
    }

    //Delete Objects
    public String create() throws Exception {
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        CompanyUser companyUser = (CompanyUser) session.getAttribute(SystemConstants.SESSION_COMPANY_USER);
        if (completeRequest == null) {
            addActionError("please input completeRequest infomation!");
            return execute();
        }
        if (StringUtils.isEmpty(completeRequest.getRefNumber())) {
            addActionError("please input completeRequest REF Number!");
            return execute();
        }
        if (StringUtils.isEmpty(completeRequest.getNote())) {
            addActionError("please input completeRequest note!");
            return execute();
        }
        User user = userService.getByREFNumber(completeRequest.getRefNumber());
        if (user == null) {
            addActionError("Consumer User not exists!");
            return execute();
        }
        completeRequest.setCompanyId(company.getId());
        completeRequest.setCompanyUserId(companyUser.getCompanyId());
        completeRequest.setConsumerId(user.getId());
        completeRequest.setRequestDate(new Date());
        completeRequest.setStatus(CompleteRequestStatus.PENDING.getValue());
        completeRequestService.save(completeRequest);
        return execute();
    }

    //Delete Objects
    public String delete() throws Exception {
        return execute();
    }

    public CompleteRequest getCompleteRequest() {
        return completeRequest;
    }

    public void setCompleteRequest(CompleteRequest completeRequest) {
        this.completeRequest = completeRequest;
    }

    public List<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    public List<CompleteRequest> getCompleteRequests() {
        return completeRequests;
    }

    public void setCompleteRequests(List<CompleteRequest> completeRequests) {
        this.completeRequests = completeRequests;
    }
}
