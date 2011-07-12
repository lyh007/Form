<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>User Registration</title>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
</head>
<body>
<div class="header">User Update</div>
<s:actionerror/>
<form action="user/user!update.action" method="post">
    <input type="hidden" name="user.id" value="${user.id}"/>
    <div>
        <table border=0>
            <tr>
                <th>First Name:</th>
                <td><input type="text" name="user.firstName" value="${user.firstName}"/></td>
            </tr>
            <tr>
                <th>Middle Initial:</th>
                <td><input type="text" name="user.middleInital" value="${user.middleInital}"/></td>
            </tr>
            <tr>
                <th>Last Name:</th>
                <td><input type="text" name="user.lastName" value="${user.lastName}"/></td>
            </tr>
            <tr>
                <th>Email:</th>
                <td><input type="text" name="user.email" value="${user.email}" /></td>
            </tr>
            <tr>
                <th>User Id:</th>
                <td><input type="text" name="user.loginId" value="${user.loginId}" readonly="readonly"/></td>
            </tr>
            <tr>
                <th>Password:</th>
                <td><input type="password" name="user.password" value="${user.password}"/></td>
            </tr>
            <tr>
                <th>Password Re-Type:</th>
                <td><input  type="password" name="confirmPsw" value="${confirmPsw}"/></td>
            </tr>
        </table>
    </div>
    <div>
        <input type="submit" value="submit"/>
    </div>
</form>
</body>
</html>
