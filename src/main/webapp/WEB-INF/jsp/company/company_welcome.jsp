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
    Welcome to use Company Boyd School's form management
</div>

<div>
    <table>
        <tr>
            <th>Template Name</th>
            <th>Status</th>
            <th>Form Records</th>
            <th>Operation</th>
        </tr>
        <tr>
            <td>Admission Contract</td>
            <td>Active</td>
            <td>25</td>
            <td><a href="../">View Records</a>|<a href="../">Update Template</a></td>
        </tr>
        <tr>
            <td>Student Survey</td>
            <td>Active</td>
            <td>12</td>
            <td><a href="../">View Records</a>|<a href="../">Update Template</a></td>
        </tr>

    </table>
</div>
<div class="header"><a href="../">Create A New Form</a></div>
<hr/>
<div class="footer"><a href="user/user.action">Company User Management</a> | <a href="company/company!preUpdate.action">Company
    Profile Update</a></div>
</body>
</html>