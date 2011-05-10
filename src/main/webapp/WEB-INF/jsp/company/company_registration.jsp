<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Company Registration</title>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
</head>
<body>
<div class="header">Company Registration</div>
<form action="company/company!registration.action" method="post">
    <div>
        <table border=0>
            <tr>
                <th>Company Name:</th>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <th>Company Email:</th>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <th>Company ID:</th>
                <td><input type="text"/></td>
            </tr>
        </table>
    </div>
    <div>
        <table>
            <tr>
                <th>Super User ID:</th>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <th>Super User First Name:</th>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <th>Super User Last Name:</th>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <th>Super User Password:</th>
                <td><input type="password"/></td>
            </tr>
            <tr>
                <th>Super User Password Re-Type:</th>
                <td><input type="password"/></td>
            </tr>
        </table>
    </div>
    <div>
        <input type="submit" value="submit"/>
    </div>
</form>
</body>
</html>
