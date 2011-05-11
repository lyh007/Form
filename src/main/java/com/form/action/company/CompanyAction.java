package com.form.action.company;

import com.form.action.BaseAction;
import com.form.model.Company;
import com.form.model.User;
import com.form.service.CompanyService;
import com.form.service.UserService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/company")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/company/company_welcome.jsp"),
        @Result(name = "registration", location = "/WEB-INF/jsp/management_index.jsp"),
        @Result(name = "create", location = "/WEB-INF/jsp/company/company_registration.jsp"),
        @Result(name = "preUpdate", location = "/WEB-INF/jsp/company/company_update.jsp")
})
public class CompanyAction extends BaseAction {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserService userService;
    private Company company;
    private User user;
    private String rePassword;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    //Sign in
    public String sign() throws Exception {
        return execute();
    }

    //forward to registration page
    public String create() throws Exception {
        return "create";
    }

    //create company and super user
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
            addActionError("please input User Id!");
            return "create";
        }
        if (user.getFirstName() == null || user.getFirstName().length() == 0) {
            addActionError("please input User FirstName!");
            return "create";

        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            addActionError("please input User password!");
            return "create";
        }
        if (rePassword == null || rePassword.length() == 0) {
            addActionError("please input user  rePassword!");
            return "create";
        }
        if (!user.getPassword().equals(rePassword)) {
            addActionError("password not match rePassword!");
            return "create";
        }
        companyService.saveCompany(company);
        user.setCompanyId(company.getId());
        userService.save(user);
        return "registration";
    }

    //prepare update company profile
    public String preUpdate() throws Exception {
        return "preUpdate";
    }

    //update company profile
    public String update() throws Exception {
        return execute();
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
