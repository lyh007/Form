package com.form.web.action.companyuser;

import com.form.SystemConstants;
import com.form.base.OceanRuntimeException;
import com.form.model.Company;
import com.form.model.CompanyUser;
import com.form.service.CompanyUserService;
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
import java.util.List;

@Controller
@Scope("prototype")
@ParentPackage(value = "default")
@Namespace("/companyuser")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/companyuser/company_user_management.jsp"),
        @Result(name = "preCreate", location = "/WEB-INF/jsp/companyuser/company_user_create.jsp"),
        @Result(name = "preUpdate", location = "/WEB-INF/jsp/companyuser/company_user_update.jsp"),
        @Result(name = "list", location = "/companyuser/company-user.action",type = "redirect")
})
public class CompanyUserAction extends BaseAction {
    @Autowired
    private CompanyUserService companyUserService;
    private List<CompanyUser> companyUsers = new ArrayList<CompanyUser>();
    private String confirmPsw;
    private CompanyUser companyUser = new CompanyUser();

    @Override //CompanyUser Manager
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        companyUsers = companyUserService.getByUsersByCompanyId(company.getId());
        return SUCCESS;
    }

    //prepare create CompanyUser
    public String preCreate() throws Exception {
        return "preCreate";
    }

    // create company CompanyUser
    public String create() throws Exception {
        if (companyUser == null) {
            addActionError("please input company infomation!");
            return "preCreate";
        }
        if (companyUser.getFirstName() == null || companyUser.getFirstName().length() == 0) {
            addActionError("please input CompanyUser FirstName!");
            return "preCreate";
        }
        if (companyUser.getMiddleInital() == null || companyUser.getMiddleInital().length() == 0) {
            addActionError("please input CompanyUser MiddleInita!");
            return "preCreate";
        }
        if (StringUtils.isEmpty(companyUser.getLastName())) {
            addActionError("please input CompanyUser lastName!");
            return "preCreate";
        }
        if (StringUtils.isEmpty(companyUser.getTitle())) {
            addActionError("please input CompanyUser title!");
            return "preCreate";
        }
        if (companyUser.getLoginId() == null || companyUser.getLoginId().length() == 0) {
            addActionError("please input CompanyUser Login Id!");
            return "preCreate";
        }
        if (companyUser.getPassword() == null || companyUser.getPassword().length() == 0) {
            addActionError("please input CompanyUser password!");
            return "preCreate";
        }
        if (confirmPsw == null || confirmPsw.length() == 0) {
            addActionError("please input companyuser  rePassword!");
            return "preCreate";
        }
        if (!companyUser.getPassword().equals(confirmPsw)) {
            addActionError("password not match Password Re-Type!");
            return "preCreate";
        }
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        CompanyUser param = new CompanyUser();
        param.setCompanyId(company.getId());
        param.setLoginId(companyUser.getLoginId());
        CompanyUser dbUser = companyUserService.getUserByCompanyIdAndUserId(param);
        if (dbUser != null) {
            addActionError("companyuser Id has exist!");
            return "preCreate";
        }

        companyUser.setCompanyId(company.getId());
        companyUserService.save(companyUser);
        return "list";
    }

    //prepare update CompanyUser
    public String preUpdate() throws Exception {
        if (companyUser == null || companyUser.getId() == 0L) {
            throw new OceanRuntimeException("delete companyuser paramter is wrong!");
        }
        companyUser = companyUserService.getById(companyUser.getId());
        if (companyUser == null) {
            throw new OceanRuntimeException("delete companyuser not exists!");
        }
        return "preUpdate";
    }

    //update company CompanyUser
    public String update() throws Exception {
        if (companyUser == null) {
            addActionError("please input company infomation!");
            return "preCreate";
        }
        if (companyUser.getFirstName() == null || companyUser.getFirstName().length() == 0) {
            addActionError("please input CompanyUser FirstName!");
            return "preCreate";
        }
        if (companyUser.getMiddleInital() == null || companyUser.getMiddleInital().length() == 0) {
            addActionError("please input CompanyUser MiddleInita!");
            return "preCreate";
        }
        if (StringUtils.isEmpty(companyUser.getLastName())) {
            addActionError("please input CompanyUser lastName!");
            return "preCreate";
        }
        if (StringUtils.isEmpty(companyUser.getTitle())) {
            addActionError("please input CompanyUser title!");
            return "preCreate";
        }
        if (companyUser.getLoginId() == null || companyUser.getLoginId().length() == 0) {
            addActionError("please input CompanyUser Login Id!");
            return "preCreate";
        }
        if (companyUser.getPassword() == null || companyUser.getPassword().length() == 0) {
            addActionError("please input CompanyUser password!");
            return "preCreate";
        }
        if (confirmPsw == null || confirmPsw.length() == 0) {
            addActionError("please input companyuser  rePassword!");
            return "preCreate";
        }
        if (!companyUser.getPassword().equals(confirmPsw)) {
            addActionError("password not match Password Re-Type!");
            return "preCreate";
        }
        CompanyUser dbUser = companyUserService.getById(companyUser.getId());
        if (dbUser == null) {
            addActionError("modify companyuser not exist!!");
            return "preCreate";
        }
        dbUser.setFirstName(companyUser.getFirstName());
        dbUser.setMiddleInital(companyUser.getMiddleInital());
        dbUser.setLastName(companyUser.getLastName());
        dbUser.setTitle(companyUser.getTitle());
        dbUser.setStatus(companyUser.getStatus());
        dbUser.setType(companyUser.getType());
        dbUser.setTitle(companyUser.getTitle());
        dbUser.setPassword(companyUser.getPassword());
        companyUserService.update(dbUser);
        return "list";
    }

    //delete company CompanyUser
    public String delete() throws Exception {
        if (companyUser == null || companyUser.getId() == 0L) {
            throw new OceanRuntimeException("delete companyuser paramter is wrong!");
        }
        companyUser = companyUserService.getById(companyUser.getId());
        if (companyUser == null) {
            throw new OceanRuntimeException("delete companyuser not exists!");
        }
        companyUserService.delete(companyUser.getId());
        return "list";
    }

    public List<CompanyUser> getCompanyUsers() {
        return companyUsers;
    }

    public void setCompanyUsers(List<CompanyUser> companyUsers) {
        this.companyUsers = companyUsers;
    }

    public String getConfirmPsw() {
        return confirmPsw;
    }

    public void setConfirmPsw(String confirmPsw) {
        this.confirmPsw = confirmPsw;
    }

    public CompanyUser getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(CompanyUser companyUser) {
        this.companyUser = companyUser;
    }
}
