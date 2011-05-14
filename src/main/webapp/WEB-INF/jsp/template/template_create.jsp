<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Template Create</title>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
</head>
<body>

<div class="header">Template Create</div>
<s:actionerror/>
<form action="template/template!create.action" method="post">
    <div>
        <table border=0>
            <tr>
                <th>Title:</th>
                <td><input type="text" name="template.title" value="${template.title}"/></td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <s:textarea name="template.description">
                    </s:textarea>
                </td>
            </tr>
            <tr>
                <th>Status:</th>
                <td>
                    <select name="user.status">
                        <option value="1" selected>Active</option>
                        <option value="0">inActive</option>
                    </select></td>
            </tr>
        </table>
    </div>
    <div>
        <input type="submit" value="SUBMIT"/>
    </div>
</form>
<div>
    <a href="company/company.action">Form Management</a>
</div>

</body>
</html>
