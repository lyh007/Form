<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@include file="/common/taglibs.jsp" %>

<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="generator" content="CoffeeCup HTML Editor (www.coffeecup.com)">
    <meta name="created" content="Sun, 30 Jan 2011 03:24:42 GMT">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <title>The Boyd School</title>
    <link href="<%=basePath%>css/boyd.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="header">
    Welcome to use Template <s:property value="template.title"/>'s formData
</div>
<div>
    <table>
        <tr>
            <td>ID</td>
            <td>Full Name</td>
            <td>age</td>
            <td>Date of Birth</td>
            <td>Nickname</td>
        </tr>
        <s:iterator value="formDataList">
            <tr>
                <td><a href="formdata/form-data!view.action?formData.id=<s:property value="id"/>"> <s:property
                        value="id"/></a></td>
                <td><s:property value="text_20_18"/></td>
                <td><s:property value="text_20_19"/></td>
                <td><s:property value="text_20_20"/></td>
                <td><s:property value="text_50_1"/></td>
            </tr>
        </s:iterator>
    </table>
</div>
<div class="header">
    <a href="formdata/form-data!step1.action?templateId=${template.id}">Fill a new Form</a>

</div>
<hr/>
<div class="footer">
    <a href="company/company.action">Form Management</a> |
    <a href="companyuser/company-user.action">Company User Management</a> |
    <a href="company/company!preUpdate.action">Company Profile Update</a> |
    <a href="logout.action">Logout System</a>
</div>
</body>
</html>