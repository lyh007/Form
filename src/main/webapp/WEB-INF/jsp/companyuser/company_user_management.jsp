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
           if(confirm("Are your sure delete user?")){
                 location.href = "<%=basePath%>/companyuser/company-user!delete.action?companyUser.id="+id;
           }
        }
    </script>
</head>
<body>

<div class="header">
    <s:property value="#session.session_company_name"/> User Management
</div>

<div>
    <table>
        <tr>
            <th>User ID</th>
            <th>User Name (First Name Last Name)</th>
            <th>Status</th>
            <th>Role</th>
            <th>Operation</th>
        </tr>
        <s:iterator value="companyUsers" status="companyUserStatus">
            <tr>
                <td><s:property value="loginId"/></td>
                <td>
                    <s:property value="firstName"/>&nbsp;<s:property value="lastName"/>
                </td>
                <td>
                    <s:if test="status==0">Disabled</s:if><s:else>Enabled</s:else>
                </td>
                <td>
                    <s:if test="type==0">Super User</s:if><s:else>Read Only</s:else>
                </td>
                <td>
                    <s:if test="type==0"><a href="companyuser/company-user!preUpdate.action?companyUser.id=${id}">Update</a></s:if>
                    <s:else>
                        <a href="companyuser/company-user!preUpdate.action?companyUser.id=${id}">Update</a>|<a href="javascript:void(0);" onclick="delete_confirm(${id});">Delete</a>
                    </s:else>
                </td>
            </tr>
        </s:iterator>
    </table>
</div>

<div class="header"><a href="companyuser/company-user!preCreate.action">Create A New User</a></div>

<hr/>

<div class="footer"><a href="company/company.action">Form Management</a> |
    <a href="company/company!preUpdate.action">Company Profile Update</a> |
    <a href="logout.action">Logout System</a></div>

</body>
</html>