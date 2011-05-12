package com.form.web.action.user;

import com.form.SystemConstants;
import com.form.model.Company;
import com.form.model.User;
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
import java.util.List;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/user")
@Results({
        @Result(name = "success", location = "/WEB-INF/jsp/user/company_user_management.jsp"),
        @Result(name = "preCreate", location = "/WEB-INF/jsp/user/company_user_create.jsp"),
        @Result(name = "preUpdate", location = "/WEB-INF/jsp/user/company_user_update.jsp")
})
public class UserAction extends BaseAction {
    @Autowired
    private UserService userService;
    private List<User> users = new ArrayList<User>();
    private String confirmPsw;
    private User user = new User();

    @Override //User Manager
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        users = userService.getByUsersByCompanyId(company.getId());
        return SUCCESS;
    }

    //prepare create User
    public String preCreate() throws Exception {
        return "preCreate";
    }

    // create company User
    public String create() throws Exception {
        if (user == null) {
            addActionError("please input company infomation!");
            return "preCreate";
        }
        if (user.getFirstName() == null || user.getFirstName().length() == 0) {
            addActionError("please input User FirstName!");
            return "preCreate";

        }
        if (user.getMiddleInital() == null || user.getMiddleInital().length() == 0) {
            addActionError("please input User MiddleInita!");
            return "preCreate";
        }
        if (StringUtils.isEmpty(user.getLastName())) {
            addActionError("please input User lastName!");
            return "preCreate";
        }
        if (StringUtils.isEmpty(user.getTitle())) {
            addActionError("please input User title!");
            return "preCreate";
        }
        if (user.getUserId() == null || user.getUserId().length() == 0) {
            addActionError("please input User Login Id!");
            return "preCreate";
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            addActionError("please input User password!");
            return "preCreate";
        }
        if (confirmPsw == null || confirmPsw.length() == 0) {
            addActionError("please input user  rePassword!");
            return "preCreate";
        }
        if (!user.getPassword().equals(confirmPsw)) {
            addActionError("password not match Password Re-Type!");
            return "preCreate";
        }
        User dbUser = userService.getByUserId(user.getUserId());
        if (dbUser != null) {
            addActionError("user Id has exist!");
            return "preCreate";
        }
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute(SystemConstants.SESSION_COMPANY);
        user.setCompanyId(company.getId());
        userService.save(user);
        return execute();
    }

    //prepare update User
    public String preUpdate() throws Exception {
        return "preUpdate";
    }

    //update company User
    public String update() throws Exception {
        return execute();
    }

    //delete company User
    public String delete() throws Exception {
        return execute();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getConfirmPsw() {
        return confirmPsw;
    }

    public void setConfirmPsw(String confirmPsw) {
        this.confirmPsw = confirmPsw;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
