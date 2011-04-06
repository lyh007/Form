<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@include file="/common/taglibs.jsp" %>

<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />    
    <meta name="generator" content="CoffeeCup HTML Editor (www.coffeecup.com)">
    <meta name="created" content="Sun, 30 Jan 2011 03:24:42 GMT">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <title>The Boyd School</title>
    <link href="<%=basePath%>css/boyd.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="outline">
    <center>
        <h3>form data list</h3><br>
        <h4><a href="<%=request.getContextPath()%>/formdata/form-data!step1.action">Fill a new Form</a></h4>
        <table width="100%">
            <tr>
                <td>ID</td>
                <td>Full Name</td>
                <td>age</td>
                <td>Date of Birth</td>
                <td>Nickname</td>
            </tr>
            <s:iterator value="formDataList">
                <tr>
                    <td><a href="formdata/form-data!view.action?formData.id=<s:property value="id"/>"> <s:property value="id"/></a></td>
                    <td><s:property value="text_20_18"/></td>
                    <td><s:property value="text_20_19"/></td>
                    <td><s:property value="text_20_20"/></td>
                    <td><s:property value="text_50_1"/></td>
                </tr>
            </s:iterator>
        </table>
    </center>
</div>
</body>
</html>