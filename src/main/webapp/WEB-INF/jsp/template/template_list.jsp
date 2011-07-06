<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Form Management</title>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
    <script type="text/javascript">
        function delete_confirm(id) {
            if(confirm("Are you sure delete template?"))
            window.location.href = "<%=basePath%>/template/template!delete.action?template.id="+id;
        }
    </script>
</head>
<body>
<div id="page-wrapper">
    <div id="header-wrapper">
        Form Template
    </div>

    <div id="content-wrapper">
        <div id="sidebar">
            <ul class="menu">
                <li><a href="request_inbox.htm">Request Inbox</li>
                <li><a href="request_outbox.htm">Request Outbox</a></li>
                <li><a class="active-link" href="template/template.action">Form Templates</a></li>
                <li><a href="form_records.htm">Form Records</a></li>
            </ul>
        </div>
        <div id="main-content">
            <table>
                <tr>
                    <th>Template Name</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                <s:iterator value="templates" status="templateStatus">
                    <tr>
                        <td><s:property value="title"/></td>
                        <td>
                            <s:if test="status==1">Active</s:if>
                            <s:else>inActive</s:else>
                        </td>
                        <td><a href="formdata/form-data!list.action?templateId=<s:property value="id"/>">View
                            Records</a>|
                            <a href="template/template!preUpdate.action?template.id=<s:property value="id"/>">Update
                                Template</a> |
                            <a href="javascript:void(0)" onclick="delete_confirm(<s:property value="id"/>);">Delete
                                Template</a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </div>
        <div id="main-content">
            <a href="template/template!preCreate.action">Create New Template</a>
        </div>
    </div>
    <div id="footer-wrapper">
        <a href="companyuser/company-user.action">Company User Management</a> |
        <a href="company/company!preUpdate.action">Company Profile Update</a> |
        <a href="logout.action">Logout System</a>

        <p id="copyright">IDD LLC. &copy; 2011. All rights reserved.</p>
    </div>
</div>
</body>
</html>
