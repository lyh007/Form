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
<form action="companyuser/company-user!update.action" method="post">
    <input type="hidden" name="companyUser.id" value="${companyUser.id}">

    <div>
        <table border=0>
            <tr>
                <th>First Name:</th>
                <td><input type="text" name="companyUser.firstName" value="${companyUser.firstName}"/></td>
            </tr>
            <tr>
                <th>Middle Initial:</th>
                <td><input type="text" name="companyUser.middleInital" value="${companyUser.middleInital}"/></td>
            </tr>
            <tr>
                <th>Last Name:</th>
                <td><input type="text" name="companyUser.lastName" value="${companyUser.lastName}"/></td>
            </tr>
            <tr>
                <th>Title:</th>
                <td><input type="text" name="companyUser.title" value="${companyUser.title}"/></td>
            </tr>
            <tr>
                <th>Login ID:</th>
                <td><input type="text" readonly="readonly" name="companyUser.loginId" value="${companyUser.loginId}"/></td>
            </tr>
            <s:if test="#session.session_user_loginId==companyUser.companyUserId">
            </s:if>
            <s:else>
                <tr>
                    <th>Status:</th>
                    <td>
                        <select name="companyUser.status">
                            <s:if test="companyUser.status==0">
                                <option value="0" selected="selected">Disabled</option>
                            </s:if>
                            <s:else>
                                <option value="0">Disabled</option>
                            </s:else>
                            <s:if test="companyUser.status==1">
                                <option value="1" selected="selected">Enabled</option>
                            </s:if>
                            <s:else>
                                <option value="1">Enabled</option>
                            </s:else>
                        </select>
                    </td>
                </tr>
            </s:else>
            <s:if test="#session.session_user_loginId==companyUser.companyUserId">
            </s:if>
            <s:else>
                <tr>
                    <th>Type:</th>
                    <td>
                        <select name="companyUser.type">
                            <s:if test="companyUser.type==0">
                                <option value="0" selected="selected">Super User</option>
                            </s:if>
                            <s:else>
                                <option value="0">Super User</option>
                            </s:else>
                            <s:if test="companyUser.type==9">
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
                <td><input type="password" name="companyUser.password" value="${companyUser.password}"/></td>
            </tr>
            <tr>
                <th>Password Re-Type:</th>
                <td><input type="password" name="confirmPsw" value="${companyUser.password}"/></td>
            </tr>
        </table>
    </div>
    <div>
        <input type="submit" value="SUBMIT">
    </div>
</form>
<div>
    <a href="companyuser/company-user.action">Back To User Management</a>
</div>
</body>
</html>