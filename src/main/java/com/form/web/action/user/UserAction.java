package com.form.web.action.user;

import com.form.SystemConstants;
import com.form.model.User;
import com.form.model.UserStatus;
import com.form.service.CompleteRequestService;
import com.form.service.UserService;
import com.form.util.REFNumberUtil;
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
@Namespace("/user")
@Results({
        @Result(name = "companyUserLogin", location = "/WEB-INF/jsp/management_index.jsp"),
        @Result(name = "userLogin", location = "/WEB-INF/jsp/user/user_index.jsp"),
        @Result(name = "preRegistration", location = "/WEB-INF/jsp/user/user_registration.jsp"),
        @Result(name = "loginMainPage", location = "/WEB-INF/jsp/company/company_welcome.jsp"),
        @Result(name = "update", location = "/WEB-INF/jsp/user/user_update.jsp")
})
public class UserAction extends BaseAction {
    @Autowired
    private UserService userService;
    @Autowired
    private CompleteRequestService completeRequestService;
    private User user;
    private List<User> users = new ArrayList<User>();
    private String confirmPsw;

    private long incomingCount;
    private long recordCount;

    @Override
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        SystemConstants.LoginType loginType = SystemConstants.LoginType.getValueOf((String) session.getAttribute(SystemConstants.LOGIN_TYPE));
        if (loginType == SystemConstants.LoginType.COMMON_USER_LOGIN) {
            User commonUser = (User) session.getAttribute(SystemConstants.SESSION_USER);
            incomingCount = completeRequestService.getCommonUserIncommingCount(commonUser.getId());
            recordCount = completeRequestService.getCommonUserRecordCount(commonUser.getId());
        }
        return "loginMainPage";
    }

    //Company User Login page
    public String companyUserLogin() {
        return "companyUserLogin";
    }

    //User Login Page
    public String userLogin() {
        return "userLogin";
    }

    //prepare create User
    public String preRegistration() throws Exception {
        return "preRegistration";
    }

    // create company User
    public String create() throws Exception {
        if (user == null) {
            addActionError("please input company infomation!");
            return "preRegistration";
        }
        if (user.getFirstName() == null || user.getFirstName().length() == 0) {
            addActionError("please input user FirstName!");
            return "preRegistration";
        }
        if (user.getMiddleInital() == null || user.getMiddleInital().length() == 0) {
            addActionError("please input user MiddleInita!");
            return "preRegistration";
        }
        if (StringUtils.isEmpty(user.getLastName())) {
            addActionError("please input user lastName!");
            return "preRegistration";
        }
        if (user.getEmail() == null || user.getEmail().length() == 0) {
            addActionError("please input E-Mail Address!");
            return "preRegistration";
        }
        if (user.getLoginId() == null || user.getLoginId().length() == 0) {
            addActionError("please input user Login Id!");
            return "preRegistration";
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            addActionError("please input user password!");
            return "preRegistration";
        }
        if (confirmPsw == null || confirmPsw.length() == 0) {
            addActionError("please input user  rePassword!");
            return "preRegistration";
        }
        if (!user.getPassword().equals(confirmPsw)) {
            addActionError("password not match Password Re-Type!");
            return "preRegistration";
        }

        String loginId = user.getLoginId();
        User dbUser = userService.getByLoginId(loginId);
        if (dbUser != null) {
            addActionError("user LoginId has exist!");
            return "preRegistration";
        }
        user.setRefNumber(REFNumberUtil.GenerateREFNumber());
        user.setStatus(UserStatus.ENABLED.ordinal());
        userService.save(user);
        //Save User information to Session For Login Main Page
        HttpSession session = request.getSession();
        session.setAttribute(SystemConstants.LOGIN_TYPE, SystemConstants.LoginType.COMMON_USER_LOGIN.toString());
        session.setAttribute(SystemConstants.SESSION_USER, user);
        session.setAttribute(SystemConstants.SESSION_USER_LOGINID, user.getLoginId());
        return loginMainPage();
    }

    public String loginMainPage() {
        HttpSession session = request.getSession();
        SystemConstants.LoginType loginType = SystemConstants.LoginType.getValueOf((String) session.getAttribute(SystemConstants.LOGIN_TYPE));
        if (loginType == SystemConstants.LoginType.COMMON_USER_LOGIN) {
            User commonUser = (User) session.getAttribute(SystemConstants.SESSION_USER);
            incomingCount = completeRequestService.getCommonUserIncommingCount(commonUser.getId());
            recordCount = completeRequestService.getCommonUserRecordCount(commonUser.getId());
        }
        return "loginMainPage";
    }

    //Sign in
    public String sign() throws Exception {
        if (user == null) {
            addActionError("please input user Login information!");
            return "userLogin";
        }
        if (user.getLoginId() == null || user.getLoginId().length() == 0) {
            addActionError("please input user login Id!");
            return "userLogin";
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            addActionError("please input user login Password!");
            return "userLogin";
        }
        User dbUser = userService.getByLoginId(user.getLoginId());
        if (dbUser == null) {
            addActionError("user is not exist!");
            return "userLogin";
        }
        if (!dbUser.getPassword().equalsIgnoreCase(user.getPassword())) {
            addActionError("password is wrong!");
            return "userLogin";
        }
        if (dbUser.getStatus() == UserStatus.DISABLED.ordinal()) {
            addActionError("user is Disabled!");
            return "userLogin";
        }
        HttpSession session = request.getSession();
        session.setAttribute(SystemConstants.LOGIN_TYPE, SystemConstants.LoginType.COMMON_USER_LOGIN.toString());
        session.setAttribute(SystemConstants.SESSION_USER, dbUser);
        session.setAttribute(SystemConstants.SESSION_USER_LOGINID, dbUser.getLoginId());
        return loginMainPage();
    }

    //load user info for update
    public String preUpdate() {
        HttpSession session = request.getSession();
        SystemConstants.LoginType loginType = SystemConstants.LoginType.getValueOf((String) session.getAttribute(SystemConstants.LOGIN_TYPE));
        if (loginType == SystemConstants.LoginType.COMMON_USER_LOGIN) {
            User sessionUser = (User) session.getAttribute(SystemConstants.SESSION_USER);
            if (sessionUser != null) {
                //update information from db
                user = userService.getById(sessionUser.getId());
            }
        }
        return "update";
    }

    //update user info
    public String update() throws Exception {
        if (user == null) {
            addActionError("please input user infomation!");
            return "update";
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            addActionError("please input user login Password!");
            return "update";
        }
        if (confirmPsw == null || confirmPsw.length() == 0) {
            addActionError("please input user rePassword!");
            return "update";
        }
        User dbUser = userService.getByLoginId(user.getLoginId());
        if (dbUser == null) {
            addActionError("user is not exist!");
            return "update";
        }
        if (!dbUser.getPassword().equalsIgnoreCase(user.getPassword())) {
            addActionError("password is wrong!");
            return "update";
        }
        dbUser.setFirstName(user.getFirstName());
        dbUser.setMiddleInital(user.getMiddleInital());
        dbUser.setLastName(user.getLastName());
        dbUser.setPassword(user.getPassword());
        userService.update(dbUser);
        return execute();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public long getIncomingCount() {
        return incomingCount;
    }

    public void setIncomingCount(long incomingCount) {
        this.incomingCount = incomingCount;
    }

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }
}
