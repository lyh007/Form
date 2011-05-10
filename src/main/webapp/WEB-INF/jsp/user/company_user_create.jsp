<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Company User Create</title>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
</head>
<body>

<div class="header">Company User Create</div>
<form action="user/user!create.action" method="post">
    <div>
        <table border=0>
            <tr>
                <th>First Name:</th>
                <td><input type="text" value=""></td>
            </tr>
            <tr>
                <th>Middle Initial:</th>
                <td><input type="text" value=""/></td>
            </tr>
            <tr>
                <th>Last Name:</th>
                <td><input type="text" value=""/></td>
            </tr>
            <tr>
                <th>Title:</th>
                <td><input type="text" value=""/></td>
            </tr>
            <tr>
                <th>Login ID:</th>
                <td><input type="text" value=""/></td>
            </tr>
            <tr>
                <th>Status:</th>
                <td>
                    <select>
                        <option value="0">Disabled</option>
                        <option value="1" selected>Enabled</option>
                    </select></td>
            </tr>
            <tr>
                <th>Type:</th>
                <td>
                    <select>
                        <option value="0">Super User</option>
                        <option value="9">Read Only</option>
                    </select></td>
            </tr>
            <tr>
                <th>Password:</th>
                <td><input type="password"/></td>
            </tr>
            <tr>
                <th>Password Re-Type:</th>
                <td><input type="password"/></td>
            </tr>
        </table>
    </div>
    <div>
        <input type="submit" value="SUBMIT"/>
    </div>
</form>
<div>
    <a href="user/user.action">Back To User Management</a>
</div>

</body>
</html>
