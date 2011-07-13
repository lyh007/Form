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
                <td><s:property value="text_20_13"/></td>
                <td><s:property value="text_20_14"/></td>
                <td><s:property value="text_20_15"/></td>
                <td><s:property value="text_20_16"/></td>
            </tr>
        </s:iterator>
    </table>
</div>
<div class="header">
    <a href="formdata/form-data!step1.action?templateId=${template.id}">Fill a new Form</a>

</div>
<hr/>
<div class="footer">
    <s:if test="#session.loginType=='COMPANY_USER_LOGIN'">
        <a href="company/company.action">Form Management</a> |
        <a href="companyuser/company-user.action">Company User Management</a> |
        <a href="company/company!preUpdate.action">Company Profile Update</a> |
     </s:if>
     <s:elseif test="#session.loginType=='COMMON_USER_LOGIN'">
        <a href="user/user.action">Main Page</a>   |
        <a href="user/user!preUpdate.action">User Profile Update</a>   |
    </s:elseif>
    <a href="logout.action">Logout System</a>
</div>
</body>
</html>