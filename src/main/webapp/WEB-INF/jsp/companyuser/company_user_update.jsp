<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Company User Update</title>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
</head>
<body>
<div class="header">Company User Update</div>
<s:actionerror/>
<form action="user/user!update.action" method="post">
    <input type="hidden" name="user.id" value="${user.id}">

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
                <th>Title:</th>
                <td><input type="text" name="user.title" value="${user.title}"/></td>
            </tr>
            <tr>
                <th>Login ID:</th>
                <td><input type="text" readonly="readonly" name="user.userId" value="${user.userId}"/></td>
            </tr>
            <s:if test="#session.session_user_loginId==user.userId">
            </s:if>
            <s:else>
                <tr>
                    <th>Status:</th>
                    <td>
                        <select name="user.status">
                            <s:if test="user.status==0">
                                <option value="0" selected="selected">Disabled</option>
                            </s:if>
                            <s:else>
                                <option value="0">Disabled</option>
                            </s:else>
                            <s:if test="user.status==1">
                                <option value="1" selected="selected">Enabled</option>
                            </s:if>
                            <s:else>
                                <option value="1">Enabled</option>
                            </s:else>
                        </select>
                    </td>
                </tr>
            </s:else>
            <s:if test="#session.session_user_loginId==user.userId">
            </s:if>
            <s:else>
                <tr>
                    <th>Type:</th>
                    <td>
                        <select name="user.type">
                            <s:if test="user.type==0">
                                <option value="0" selected="selected">Super User</option>
                            </s:if>
                            <s:else>
                                <option value="0">Super User</option>
                            </s:else>
                            <s:if test="user.type==9">
                                <option value="9" selected="selected">Read Only</option>
                            </s:if>
                            <s:else>
                                <option value="9">Read Only</option>
                            </s:else>
                        </select>
                    </td>
                </tr>
            </s:else>
            <tr>
                <th>Password:</th>
                <td><input type="password" name="user.password" value="${user.password}"/></td>
            </tr>
            <tr>
                <th>Password Re-Type:</th>
                <td><input type="password" name="confirmPsw" value="${user.password}"/></td>
            </tr>
        </table>
    </div>
    <div>
        <input type="submit" value="SUBMIT">
    </div>
</form>
<div>
    <a href="user/user.action">Back To User Management</a>
</div>
</body>
</html>