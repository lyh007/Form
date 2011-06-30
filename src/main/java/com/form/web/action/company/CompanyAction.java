package com.form.web.action.company;

import com.form.SystemConstants;
import com.form.model.Company;
import com.form.model.CompanyUser;
import com.form.model.Template;
import com.form.service.CompanyService;
import com.form.service.TemplateService;
import com.form.service.CompanyUserService;
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
@Namespace("/company")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/company/company_welcome.jsp"),
        @Result(name = "login", location = "/WEB-INF/jsp/management_index.jsp"),
        @Result(name = "create", location = "/WEB-INF/jsp/company/company_registration.jsp"),
        @Result(name = "preUpdate", location = "/WEB-INF/jsp/company/company_update.jsp")
})
public class CompanyAction extends BaseAction {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyUserService companyUserService;
    @Autowired
    private TemplateService templateService;

    private List<Template> templates = new ArrayList<Template>();
    private Company company = new Company();
    private CompanyUser user = new CompanyUser();
    private String rePassword;
    private String formCreatorId;
    private String userId;
    private String password;
    private List<CompanyUser> users = new ArrayList<CompanyUser>();

    @Override
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        Company sessionCompany = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        CompanyUser user = (CompanyUser) session.getAttribute(SystemConstants.SESSION_USER);
        templates = templateService.getTemplatesByCompanyId(sessionCompany.getId());
        return SUCCESS;
    }

    //Sign in
    public String sign() throws Exception {
        if (formCreatorId == null || formCreatorId.length() == 0) {
            addActionError("please input Form Creator Id!");
            return "login";
        }
        if (userId == null || userId.length() == 0) {
            addActionError("please input CompanyUser Id!");
            return "login";
        }
        if (password == null || password.length() == 0) {
            addActionError("please input CompanyUser Password!");
            return "login";
        }
        company = companyService.getByCompanyId(formCreatorId);
        if (company == null) {
            addActionError(formCreatorId + " company is not exist!");
            return "login";
        }
        CompanyUser param = new CompanyUser();
        param.setCompanyId(company.getId());
        param.setUserId(userId);
        CompanyUser dbUser = companyUserService.getUserByCompanyIdAndUserId(param);
        if (dbUser == null) {
            addActionError(userId + " CompanyUser is not exist!");
            return "login";
        }
        if (!dbUser.getPassword().equalsIgnoreCase(password)) {
            addActionError("password is wrong!");
            return "login";
        }
        if (dbUser.getStatus() == 0) {
            addActionError("CompanyUser is Disabled!");
            return "login";
        }
        templates = templateService.getTemplatesByCompanyId(company.getId());
        HttpSession session = request.getSession();
        session.setAttribute(SystemConstants.SESSION_USER, dbUser);
        session.setAttribute(SystemConstants.SESSION_COMPANY, company);
        session.setAttribute(SystemConstants.SESSION_USER_LOGINID, dbUser.getUserId());
        session.setAttribute(SystemConstants.SESSION_COMPANY_NAME, company.getName());
        return execute();
    }

    //forward to registration page
    public String create() throws Exception {
        return "create";
    }

    //create company and super companyuser
    public String registration() throws Exception {
        //Don't input company base infomation
        if (company == null) {
            addActionError("please input company infomation!");
            return "create";
        }
        if (company.getName() == null || company.getName().length() == 0) {
            addActionError("please input company name!");
            return "create";
        }
        if (company.getEmail() == null || company.getEmail().length() == 0) {
            addActionError("please input company Email!");
            return "create";
        }
        if (company.getCompanyId() == null || company.getCompanyId().length() == 0) {
            addActionError("please input company Id!");
            return "create";
        }
        if (user == null) {
            addActionError("please input company infomation!");
            return "create";
        }
        if (user.getUserId() == null || user.getUserId().length() == 0) {
            addActionError("please input CompanyUser Id!");
            return "create";
        }
        if (user.getFirstName() == null || user.getFirstName().length() == 0) {
            addActionError("please input CompanyUser FirstName!");
            return "create";

        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            addActionError("please input CompanyUser password!");
            return "create";
        }
        if (rePassword == null || rePassword.length() == 0) {
            addActionError("please input companyuser  rePassword!");
            return "create";
        }
        if (!user.getPassword().equals(rePassword)) {
            addActionError("password not match rePassword!");
            return "create";
        }
        Company dbCompany = companyService.getByCompanyId(company.getCompanyId());
        if (dbCompany != null) {
            addActionError("company Id has exist!");
            return "create";
        }
        companyService.saveCompany(company);
        user.setCompanyId(company.getId());
        user.setType(0);     //0:Super CompanyUser 9:Read Only
        user.setStatus(1);   //0:Disabled 1:Enabled
        companyUserService.save(user);

        HttpSession session = request.getSession();
        session.setAttribute(SystemConstants.SESSION_USER, user);
        session.setAttribute(SystemConstants.SESSION_COMPANY, company);
        session.setAttribute(SystemConstants.SESSION_USER_LOGINID, user.getUserId());
        session.setAttribute(SystemConstants.SESSION_COMPANY_NAME, company.getName());
        return "success";
    }

    //prepare update company profile
    public String preUpdate() throws Exception {
        HttpSession session = request.getSession();
        Company sessioncompany = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        user = (CompanyUser) session.getAttribute(SystemConstants.SESSION_USER);
        //update from DB
        company = companyService.getByCompanyId(sessioncompany.getCompanyId());
        users = companyUserService.getSuperUsers(company.getId());
        return "preUpdate";
    }

    //update company profile
    public String update() throws Exception {
        HttpSession session = request.getSession();
        Company sessionCompany = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        if (company == null) {
            addActionError("please input company infomation!");
            Company dbCompany = companyService.getByCompanyId(sessionCompany.getCompanyId());
            users = companyUserService.getSuperUsers(dbCompany.getId());
            return "preUpdate";
        }
        if (company.getName() == null || company.getName().length() == 0) {
            addActionError("please input company name!");
            Company dbCompany = companyService.getByCompanyId(sessionCompany.getCompanyId());
            users = companyUserService.getSuperUsers(dbCompany.getId());
            return "preUpdate";
        }
        if (company.getEmail() == null || company.getEmail().length() == 0) {
            addActionError("please input company Email!");
            Company dbCompany = companyService.getByCompanyId(sessionCompany.getCompanyId());
            users = companyUserService.getSuperUsers(dbCompany.getId());
            return "preUpdate";
        }
        if (company.getCompanyId() == null || company.getCompanyId().length() == 0) {
            addActionError("please input company Id!");
            Company dbCompany = companyService.getByCompanyId(sessionCompany.getCompanyId());
            users = companyUserService.getSuperUsers(dbCompany.getId());
            return "preUpdate";
        }

        //update from db
        Company dbCompany = companyService.getByCompanyId(sessionCompany.getCompanyId());
        dbCompany.setEmail(company.getEmail());
        dbCompany.setName(company.getName());
        companyService.update(dbCompany);
        session.setAttribute(SystemConstants.SESSION_COMPANY, dbCompany);
        session.setAttribute(SystemConstants.SESSION_COMPANY_NAME, dbCompany.getName());
        return execute();
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyUser getUser() {
        return user;
    }

    public void setUser(CompanyUser user) {
        this.user = user;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getFormCreatorId() {
        return formCreatorId;
    }

    public void setFormCreatorId(String formCreatorId) {
        this.formCreatorId = formCreatorId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CompanyUser> getUsers() {
        return users;
    }

    public void setUsers(List<CompanyUser> users) {
        this.users = users;
    }

    public List<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }
}
