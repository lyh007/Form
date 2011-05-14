<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
    <title>Form Management</title>
    <script type="text/javascript">
        function delete_confirm(id) {
            alert(id);
            window.location.href = "<%=request.getContextPath()%>/template/template!delete.action?template.id="+id;
        }
    </script>
</head>
<body>
<div class="header">
    Welcome to use Company <s:property value="#session.session_company_name"/>'s form management
</div>

<div>
    <table>
        <tr>
            <th>Template Name</th>
            <th>Status</th>
            <th>Form Records</th>
            <th>Operation</th>
        </tr>
        <s:iterator value="templates" status="templateStatus">
            <tr>
                <td><s:property value="title"/></td>
                <td>
                    <s:if test="status==1">Active</s:if>
                    <s:else>inActive</s:else>
                </td>
                <td>0</td>
                <td><a href="../">View Records</a>|
                    <a href="template/template!preUpdate.action?template.id=<s:property value="id"/>">Update
                        Template</a> |
                    <a href="template/template!delete.action?template.id=<s:property value="id"/>">Delete Template</a>
                </td>
            </tr>
        </s:iterator>
    </table>
</div>
<div class="header">
    <a href="../">Create A New Form</a>|
    <a href="template/template!preCreate.action">Create a New Form Template</a>
</div>
<hr/>
<div class="footer"><a href="user/user.action">Company User Management</a> |
    <a href="company/company!preUpdate.action">Company Profile Update</a> |
    <a href="logout.action">Logout System</a>
</div>
</body>
</html>