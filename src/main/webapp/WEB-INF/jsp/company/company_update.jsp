<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Company Profile Update</title>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
</head>
<body>

<div class="header">Company Profile Update</div>
<form action="company/company!update.action" method="post">
    <div>
        <table border=0>
            <tr>
                <th>Company Name:</th>
                <td><input type="text" value="Boyd School"/></td>
            </tr>
            <tr>
                <th>Company Email:</th>
                <td><input type="text" value="contact@bschool.com"/></td>
            </tr>
            <tr>
                <th>Company ID:</th>
                <td><input type="text" disabled=true value="boldschool"/></td>
            </tr>
            <tr>
                <th>Super User ID:</th>
                <td>
                    <select>
                        <option>Existing User1 ID (User1 First Name User1 Last Name)</option>
                        <option>Existing User2 ID (User2 First Name User2 Last Name)</option>
                        <option>Existing User3 ID (User3 First Name User3 Last Name)</option>
                    </select></td>
            </tr>
        </table>
    </div>
    <div>
        <input type="submit" value="SUBMIT">
    </div>
</form>
<div class="footer"><a href="company/company.action">Form Management</a> | <a href="user/user.action">Company
    User Management</a></div>
</body>
</html>
