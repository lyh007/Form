<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
    <title>Form Management</title>
</head>
<body>
<div id="page-wrapper">
    <div class="header">
        <s:if test="#session.loginType=='COMPANY_USER_LOGIN'">
         Welcome to use Company <s:property value="#session.session_company_name"/>'s form management
        </s:if>
        <s:elseif test="#session.loginType=='COMMON_USER_LOGIN'">
             Hi,common user <s:property value="#session.session_user_loginId"/>,   Welcome to use form management!
        </s:elseif>
    </div>
    <div id="content-wrapper">
        <div id="sidebar">
            <ul class="menu">
                <li class=""><a href="inbox/inbox.action">Request Inbox</a></li>
                <li class=""><a href="outbox/outbox.action">Request Outbox</a></li>
                <s:if test="#session.loginType=='COMPANY_USER_LOGIN'">
                    <li class=""><a href="template/template.action">Form Templates</a></li>
                </s:if>
                <s:elseif test="#session.loginType=='COMMON_USER_LOGIN'">
                    <li class="last"><a href="record/record.action">Form Records</a></li>
                </s:elseif>
            </ul>
        </div>
        <div id="main-content">
            You have 0 new Incomming Form Requests! <br>
            You have 0 new records collected for your form!
        </div>
    </div>
    <div id="footer-wrapper">
         <s:if test="#session.loginType=='COMPANY_USER_LOGIN'">
            <a href="companyuser/company-user.action">Company User Management</a> |
            <a href="company/company!preUpdate.action">Company Profile Update</a> |
        </s:if>
        <s:elseif test="#session.loginType=='COMMON_USER_LOGIN'">
            <a href="user/user!preUpdate.action">User Profile Update</a>  |
        </s:elseif>
        <a href="logout.action">Logout System</a>
         <p id="copyright">IDD LLC. &copy; 2011. All rights reserved.</p>
    </div>
</div>
</body>
</html>