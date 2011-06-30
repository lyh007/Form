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
@ParentPackage(value = "struts-default")
@Namespace("/companyuser")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/companyuser/company_user_management.jsp"),
        @Result(name = "preCreate", location = "/WEB-INF/jsp/companyuser/company_user_create.jsp"),
        @Result(name = "preUpdate", location = "/WEB-INF/jsp/companyuser/company_user_update.jsp")
})
public class CompanyUserAction extends BaseAction {
    @Autowired
    private CompanyUserService companyUserService;
    private List<CompanyUser> users = new ArrayList<CompanyUser>();
    private String confirmPsw;
    private CompanyUser user = new CompanyUser();

    @Override //CompanyUser Manager
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        users = companyUserService.getByUsersByCompanyId(company.getId());
        return SUCCESS;
    }

    //prepare create CompanyUser
    public String preCreate() throws Exception {
        return "preCreate";
    }

    // create company CompanyUser
    public String create() throws Exception {
        if (user == null) {
            addActionError("please input company infomation!");
            return "preCreate";
        }
        if (user.getFirstName() == null || user.getFirstName().length() == 0) {
            addActionError("please input CompanyUser FirstName!");
            return "preCreate";
        }
        if (user.getMiddleInital() == null || user.getMiddleInital().length() == 0) {
            addActionError("please input CompanyUser MiddleInita!");
            return "preCreate";
        }
        if (StringUtils.isEmpty(user.getLastName())) {
            addActionError("please input CompanyUser lastName!");
            return "preCreate";
        }
        if (StringUtils.isEmpty(user.getTitle())) {
            addActionError("please input CompanyUser title!");
            return "preCreate";
        }
        if (user.getUserId() == null || user.getUserId().length() == 0) {
            addActionError("please input CompanyUser Login Id!");
            return "preCreate";
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            addActionError("please input CompanyUser password!");
            return "preCreate";
        }
        if (confirmPsw == null || confirmPsw.length() == 0) {
            addActionError("please input companyuser  rePassword!");
            return "preCreate";
        }
        if (!user.getPassword().equals(confirmPsw)) {
            addActionError("password not match Password Re-Type!");
            return "preCreate";
        }
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        CompanyUser param = new CompanyUser();
        param.setCompanyId(company.getId());
        param.setUserId(user.getUserId());
        CompanyUser dbUser = companyUserService.getUserByCompanyIdAndUserId(param);
        if (dbUser != null) {
            addActionError("companyuser Id has exist!");
            return "preCreate";
        }

        user.setCompanyId(company.getId());
        companyUserService.save(user);
        return execute();
    }

    //prepare update CompanyUser
    public String preUpdate() throws Exception {
        if (user == null || user.getId() == 0L) {
            throw new OceanRuntimeException("delete companyuser paramter is wrong!");
        }
        user = companyUserService.getById(user.getId());
        if (user == null) {
            throw new OceanRuntimeException("delete companyuser not exists!");
        }
        return "preUpdate";
    }

    //update company CompanyUser
    public String update() throws Exception {
        if (user == null) {
            addActionError("please input company infomation!");
            return "preCreate";
        }
        if (user.getFirstName() == null || user.getFirstName().length() == 0) {
            addActionError("please input CompanyUser FirstName!");
            return "preCreate";
        }
        if (user.getMiddleInital() == null || user.getMiddleInital().length() == 0) {
            addActionError("please input CompanyUser MiddleInita!");
            return "preCreate";
        }
        if (StringUtils.isEmpty(user.getLastName())) {
            addActionError("please input CompanyUser lastName!");
            return "preCreate";
        }
        if (StringUtils.isEmpty(user.getTitle())) {
            addActionError("please input CompanyUser title!");
            return "preCreate";
        }
        if (user.getUserId() == null || user.getUserId().length() == 0) {
            addActionError("please input CompanyUser Login Id!");
            return "preCreate";
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            addActionError("please input CompanyUser password!");
            return "preCreate";
        }
        if (confirmPsw == null || confirmPsw.length() == 0) {
            addActionError("please input companyuser  rePassword!");
            return "preCreate";
        }
        if (!user.getPassword().equals(confirmPsw)) {
            addActionError("password not match Password Re-Type!");
            return "preCreate";
        }
        CompanyUser dbUser = companyUserService.getById(user.getId());
        if (dbUser == null) {
            addActionError("modify companyuser not exist!!");
            return "preCreate";
        }
        dbUser.setFirstName(user.getFirstName());
        dbUser.setMiddleInital(user.getMiddleInital());
        dbUser.setLastName(user.getLastName());
        dbUser.setTitle(user.getTitle());
        dbUser.setStatus(user.getStatus());
        dbUser.setType(user.getType());
        dbUser.setTitle(user.getTitle());
        dbUser.setPassword(user.getPassword());
        companyUserService.update(dbUser);
        return execute();
    }

    //delete company CompanyUser
    public String delete() throws Exception {
        if (user == null || user.getId() == 0L) {
            throw new OceanRuntimeException("delete companyuser paramter is wrong!");
        }
        user = companyUserService.getById(user.getId());
        if (user == null) {
            throw new OceanRuntimeException("delete companyuser not exists!");
        }
        companyUserService.delete(user.getId());
        return execute();
    }

    public List<CompanyUser> getUsers() {
        return users;
    }

    public void setUsers(List<CompanyUser> users) {
        this.users = users;
    }

    public String getConfirmPsw() {
        return confirmPsw;
    }

    public void setConfirmPsw(String confirmPsw) {
        this.confirmPsw = confirmPsw;
    }

    public CompanyUser getUser() {
        return user;
    }

    public void setUser(CompanyUser user) {
        this.user = user;
    }
}
