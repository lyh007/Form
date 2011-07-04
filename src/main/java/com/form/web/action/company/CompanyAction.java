package com.form.web.action.company;

import com.form.SystemConstants;
import com.form.model.Company;
import com.form.model.CompanyUser;
import com.form.model.Template;
import com.form.service.CompanyService;
import com.form.service.CompanyUserService;
import com.form.service.TemplateService;
import com.form.util.REFNumberUtil;
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
    private CompanyUser companyUser = new CompanyUser();
    private String rePassword;
    private String formCreatorId;
    private String companyUserLoginId;
    private String password;
    private List<CompanyUser> companyUsers = new ArrayList<CompanyUser>();

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
        if (companyUserLoginId == null || companyUserLoginId.length() == 0) {
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
        param.setLoginId(companyUserLoginId);
        CompanyUser dbUser = companyUserService.getUserByCompanyIdAndUserId(param);
        if (dbUser == null) {
            addActionError(companyUserLoginId + " CompanyUser is not exist!");
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
        session.setAttribute(SystemConstants.SESSION_USER_LOGINID, dbUser.getLoginId());
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
        if (companyUser == null) {
            addActionError("please input company infomation!");
            return "create";
        }
        if (companyUser.getLoginId() == null || companyUser.getLoginId().length() == 0) {
            addActionError("please input CompanyUser Id!");
            return "create";
        }
        if (companyUser.getFirstName() == null || companyUser.getFirstName().length() == 0) {
            addActionError("please input CompanyUser FirstName!");
            return "create";

        }
        if (companyUser.getPassword() == null || companyUser.getPassword().length() == 0) {
            addActionError("please input CompanyUser password!");
            return "create";
        }
        if (rePassword == null || rePassword.length() == 0) {
            addActionError("please input companyuser  rePassword!");
            return "create";
        }
        if (!companyUser.getPassword().equals(rePassword)) {
            addActionError("password not match rePassword!");
            return "create";
        }
        Company dbCompany = companyService.getByCompanyId(company.getCompanyId());
        if (dbCompany != null) {
            addActionError("company Id has exist!");
            return "create";
        }
        company.setRefNumber(REFNumberUtil.GenerateREFNumber());
        companyService.saveCompany(company);
        companyUser.setCompanyId(company.getId());
        companyUser.setType(0);     //0:Super CompanyUser 9:Read Only
        companyUser.setStatus(1);   //0:Disabled 1:Enabled
        companyUserService.save(companyUser);

        HttpSession session = request.getSession();
        session.setAttribute(SystemConstants.SESSION_USER, companyUser);
        session.setAttribute(SystemConstants.SESSION_COMPANY, company);
        session.setAttribute(SystemConstants.SESSION_USER_LOGINID, companyUser.getLoginId());
        session.setAttribute(SystemConstants.SESSION_COMPANY_NAME, company.getName());
        return "success";
    }

    //prepare update company profile
    public String preUpdate() throws Exception {
        HttpSession session = request.getSession();
        Company sessioncompany = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        companyUser = (CompanyUser) session.getAttribute(SystemConstants.SESSION_USER);
        //update from DB
        company = companyService.getByCompanyId(sessioncompany.getCompanyId());
        companyUsers = companyUserService.getSuperUsers(company.getId());
        return "preUpdate";
    }

    //update company profile
    public String update() throws Exception {
        HttpSession session = request.getSession();
        Company sessionCompany = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        if (company == null) {
            addActionError("please input company infomation!");
            Company dbCompany = companyService.getByCompanyId(sessionCompany.getCompanyId());
            companyUsers = companyUserService.getSuperUsers(dbCompany.getId());
            return "preUpdate";
        }
        if (company.getName() == null || company.getName().length() == 0) {
            addActionError("please input company name!");
            Company dbCompany = companyService.getByCompanyId(sessionCompany.getCompanyId());
            companyUsers = companyUserService.getSuperUsers(dbCompany.getId());
            return "preUpdate";
        }
        if (company.getEmail() == null || company.getEmail().length() == 0) {
            addActionError("please input company Email!");
            Company dbCompany = companyService.getByCompanyId(sessionCompany.getCompanyId());
            companyUsers = companyUserService.getSuperUsers(dbCompany.getId());
            return "preUpdate";
        }
        if (company.getCompanyId() == null || company.getCompanyId().length() == 0) {
            addActionError("please input company Id!");
            Company dbCompany = companyService.getByCompanyId(sessionCompany.getCompanyId());
            companyUsers = companyUserService.getSuperUsers(dbCompany.getId());
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

    public CompanyUser getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(CompanyUser companyUser) {
        this.companyUser = companyUser;
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

    public String getCompanyUserLoginId() {
        return companyUserLoginId;
    }

    public void setCompanyUserLoginId(String companyUserLoginId) {
        this.companyUserLoginId = companyUserLoginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CompanyUser> getCompanyUsers() {
        return companyUsers;
    }

    public void setCompanyUsers(List<CompanyUser> companyUsers) {
        this.companyUsers = companyUsers;
    }

    public List<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }
}
