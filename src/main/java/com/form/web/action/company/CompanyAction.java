package com.form.web.action.company;

import com.form.SystemConstants;
import com.form.model.Company;
import com.form.model.User;
import com.form.service.CompanyService;
import com.form.service.UserService;
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
    private UserService userService;
    private Company company = new Company();
    private User user = new User();
    private String rePassword;
    private String formCreatorId;
    private String userId;
    private String password;
    private List<User> users = new ArrayList<User>();

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    //Sign in
    public String sign() throws Exception {
        if (formCreatorId == null || formCreatorId.length() == 0) {
            addActionError("please input Form Creator Id!");
            return "login";
        }
        if (userId == null || userId.length() == 0) {
            addActionError("please input User Id!");
            return "login";
        }
        if (password == null || password.length() == 0) {
            addActionError("please input User Password!");
            return "login";
        }
        Company dbCompany = companyService.getByCompanyId(formCreatorId);
        if (dbCompany == null) {
            addActionError(formCreatorId + " company is not exist!");
            return "login";
        }
        User dbUser = userService.getByUserId(userId);
        if (dbUser == null) {
            addActionError(userId + " User is not exist!");
            return "login";
        }
        if (!dbUser.getPassword().equalsIgnoreCase(password)) {
            addActionError("password is wrong!");
            return "login";
        }
        if (dbUser.getStatus() == 0) {
            addActionError("User is Disabled!");
            return "login";
        }
        HttpSession session = request.getSession();
        session.setAttribute(SystemConstants.SESSION_USER, dbUser);
        session.setAttribute(SystemConstants.SESSION_COMPANY, dbCompany);
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
        Company dbCompany = companyService.getByCompanyId(company.getCompanyId());
        if (dbCompany != null) {
            addActionError("company Id has exist!");
            return "create";
        }
        User dbUser = userService.getByUserId(user.getUserId());
        if (dbUser != null) {
            addActionError("user Id has exist!");
            return "create";
        }
        companyService.saveCompany(company);
        user.setCompanyId(company.getId());
        user.setType(0);     //0:Super User 9:Read Only
        user.setStatus(1);   //0:Disabled 1:Enabled
        userService.save(user);
        return "login";
    }

    //prepare update company profile
    public String preUpdate() throws Exception {
        HttpSession session = request.getSession();
        company = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        user = (User) session.getAttribute(SystemConstants.SESSION_USER);
        users = userService.getByUsersByCompanyId(company.getId());
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
