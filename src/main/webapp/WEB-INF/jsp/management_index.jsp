<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
    <title>Form Management</title>
    <script type="text/javascript">
        function onLoad() {
            document.getElementById('formCreatorId').focus();
        }
    </script>
</head>
<body onload="onLoad()">
<div class="header">
    Sign in as form creator
</div>
<form action="company/company!sign.action" method="post">
    <div>
        <s:actionerror/>
        <table border=0>
            <tr>
                <td>Form Creator Id</td>
                <td><input type="text" name="formCreatorId" value="${formCreatorId}" id="formCreatorId"/></td>
            </tr>
            <tr>
                <td>User Id</td>
                <td><input type="text" name="userId" value="${userId}"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" value="${password}"/></td>
            </tr>
        </table>
    </div>
    <div>
        <input type="hidden" name="wonderUrl" value="<%=request.getParameter("wonderUrl") %>"/>
        <input type="submit" value="SUBMIT"> &nbsp; <input type="reset" value="Reset">
    </div>
</form>
<div class="footer"><a href="company/company!create.action">Create a New Form Creator</a></div>
</body>
</html>