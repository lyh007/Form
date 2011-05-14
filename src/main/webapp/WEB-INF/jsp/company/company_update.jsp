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
<s:actionerror/>
<form action="company/company!update.action" method="post">
    <div>
        <table border=0>
            <tr>
                <th>Company Name:</th>
                <td><input type="text" name="company.name" value="<s:property value="company.name"/>"/></td>
            </tr>
            <tr>
                <th>Company Email:</th>
                <td><input type="text" name="company.email" value="${company.email}"/></td>
            </tr>
            <tr>
                <th>Company ID:</th>
                <td><input type="text" readonly="readonly" name="company.companyId" value="${company.companyId}"/></td>
            </tr>
            <tr>
                <th>Super User ID:</th>
                <td>
                    <select>
                        <s:iterator value="users" status="userStatus">
                            <s:if test="userId==user.userId">
                                <option selected="selected" value="<s:property value="userId"/>"><s:property
                                        value="userId"/>(<s:property value="firstName"/>&nbsp;<s:property
                                        value="lastName"/>)
                                </option>
                            </s:if>
                            <s:else>
                                <option value="<s:property value="userId"/>"><s:property value="userId"/>(<s:property
                                        value="firstName"/>&nbsp;<s:property value="lastName"/>)
                                </option>
                            </s:else>
                        </s:iterator>
                    </select>
                </td>
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
