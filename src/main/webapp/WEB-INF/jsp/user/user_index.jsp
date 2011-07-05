<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>User Login</title>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
    <script type="text/javascript">
        function onLoad() {
            document.getElementById('loginId').focus();
        }
    </script>
</head>
<body onload="onLoad()">

<div class="header">
    Sign in as user
</div>
<s:actionerror/>
<form action="user/user!sign.action" method="post">
    <div>
        <table border=0>
            <tr>
                <td>User Id</td>
                <td><input type="text" name="user.loginId" value="${user.loginId}" id="loginId"/></td>
            </tr>

            <tr>
                <td>Password</td>
                <td><input type="password" name="user.password" value="${user.password}"/></td>
            </tr>
        </table>
    </div>
    <div>
        <input type="submit" value="SUBMIT"> &nbsp; <input type="reset" value="Reset">
    </div>
    <div class="footer"><a href="user/user!preRegistration.action">New User Sign Up</a></div>
    <div class="footer"><a href="user/user!companyUserLogin.action">Not a stand alone user, switch to company login
        page</a></div>
</form>
</body>
</html>
