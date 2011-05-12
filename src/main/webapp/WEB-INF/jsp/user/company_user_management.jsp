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

<div class="header">

    Boyd School User Management
</div>

<div>
    <table>
        <tr>
            <th>User ID</th>
            <th>User Name (First Name Last Name)</th>
            <th>Status</th>
            <th>Role</th>
            <th>Operation</th>
        </tr>
        <s:iterator value="users" status="userStatus">
            <tr>
                <td><s:property value="userId"/></td>
                <td>
                    <s:property value="firstName"/>&nbsp;<s:property value="lastName"/>
                </td>
                <td>
                    <s:if test="status==0">Disabled</s:if><s:else>Enabled</s:else>
                </td>
                <td>
                    <s:if test="type==0">Super User</s:if><s:else>Read Only</s:else>
                </td>
                <td>
                    <s:if test="type==0"><a href="user/user!preUpdate.action?user.id=${id}">Update</a></s:if>
                    <s:else>
                        <a href="user/user!preUpdate.action?user.id=${id}">Update</a>|<a href="user/user!delete.action?user.id=${id}">Delete</a>
                    </s:else>
                </td>
            </tr>
        </s:iterator>
    </table>
</div>

<div class="header"><a href="user/user!preCreate.action">Create A New User</a></div>

<hr/>

<div class="footer"><a href="company/company.action">Form Management</a> | <a href="company/company!preUpdate.action">Company
    Profile
    Update</a></div>

</body>
</html>