package com.form.web.action.inbox;

import com.form.SystemConstants;
import com.form.base.OceanRuntimeException;
import com.form.base.Page;
import com.form.base.QueryParams;
import com.form.model.CompleteRequest;
import com.form.model.CompleteRequestStatus;
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
import java.util.Date;
import java.util.List;

@Controller
@Scope("prototype")
@ParentPackage(value = "default")
@Namespace("/inbox")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/inbox/request_inbox.jsp")
})
public class InboxAction extends BaseAction {
    @Autowired
    private CompleteRequestService completeRequestService;
    private List<CompleteRequest> completeRequests = new ArrayList<CompleteRequest>();
    private CompleteRequest completeRequest = new CompleteRequest();

    @Override    //List
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        QueryParams<CompleteRequest> queryParams = new QueryParams<CompleteRequest>();
        CompleteRequest completeRequestParam = new CompleteRequest();
        Page paging = new Page();
        paging.setPageSize(100); //每页显示10条
        paging.setCurrentPage(1);
        SystemConstants.LoginType loginType = SystemConstants.LoginType.getValueOf((String) session.getAttribute(SystemConstants.LOGIN_TYPE));
        //if company user login
        if (loginType == SystemConstants.LoginType.COMPANY_USER_LOGIN) {

        } else if (loginType == SystemConstants.LoginType.COMMON_USER_LOGIN) {   //common user login
            User commonUser = (User) session.getAttribute(SystemConstants.SESSION_USER);
            completeRequestParam.setConsumerId(commonUser.getId());
        }
        queryParams.setPaging(paging);
        queryParams.setEntity(completeRequestParam);
        completeRequests = completeRequestService.queryByPage(queryParams);
        return SUCCESS;
    }

    //Reject
    public String reject() throws Exception {
        if (completeRequest == null && completeRequest.getId() == 0L) {
            throw new OceanRuntimeException("request id not set!");
        }
        completeRequest = completeRequestService.getById(completeRequest.getId());
        if (completeRequest == null) {
            throw new OceanRuntimeException("request not found!");
        }
        completeRequest.setDecisionDate(new Date());
        completeRequest.setStatus(CompleteRequestStatus.REJECTED.getValue());
        completeRequestService.changeStatus(completeRequest);
        return execute();
    }

    //accept
    public String accept() throws Exception {
        if (completeRequest == null && completeRequest.getId() == 0L) {
            throw new OceanRuntimeException("request id not set!");
        }
        completeRequest = completeRequestService.getById(completeRequest.getId());
        if (completeRequest == null) {
            throw new OceanRuntimeException("request not found!");
        }
        completeRequest.setDecisionDate(new Date());
        completeRequest.setStatus(CompleteRequestStatus.ACCEPT.getValue());
        completeRequestService.changeStatus(completeRequest);
        return execute();
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

    public CompleteRequest getCompleteRequest() {
        return completeRequest;
    }

    public void setCompleteRequest(CompleteRequest completeRequest) {
        this.completeRequest = completeRequest;
    }
}
