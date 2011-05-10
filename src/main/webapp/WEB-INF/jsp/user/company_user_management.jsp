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
        <tr>
            <td>Default One</td>
            <td>Jone Doe</td>
            <td>Enabled</td>
            <td>Super User</td>
            <td><a href="user/user!preUpdate.action">Update</a></td>
        </tr>
        <tr>
            <td>Guest</td>
            <td>Harry Potter</td>
            <td>Enabled</td>
            <td>Read Only</td>
            <td><a href="../">Update|Delete</a></td>
        </tr>
        <tr>
            <td>Guest 2</td>
            <td>Lucas Skywalker</td>
            <td>Disabled</td>
            <td>Read Only</td>
            <td><a href="../">Update|Delete</a></td>
        </tr>
    </table>
</div>

<div class="header"><a href="user/user!preCreate.action">Create A New User</a></div>

<hr/>

<div class="footer"><a href="company/company.action">Form Management</a> | <a href="company/company!preUpdate.action">Company Profile
    Update</a></div>

</body>
</html>