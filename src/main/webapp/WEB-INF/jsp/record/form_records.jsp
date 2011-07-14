<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Form Management</title>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
    <script src="libs/jquery.js" type="text/javascript"></script>
    <script src="libs/jquery.query.js" type="text/javascript"></script>
    <script src="libs/jquery-ui.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#new_request_fields").hide();

            $("#create_new_request").click(function() {
                $("#new_request_fields").show();
            });

            $("#cancel_new_request").click(function() {
                $(':input', '#new_request_form').not(':button, :submit, :reset, :hidden').val('').removeAttr('checked').removeAttr('selected');

                $("#new_request_fields").hide();
            });
        });
    </script>
</head>
<body>
<div id="page-wrapper">
    <div id="header-wrapper">
        Form Records
    </div>
    <div id="content-wrapper">
        <div id="sidebar">
            <ul class="menu">
               <li><a class="active-link" href="inbox/inbox.action">Request Inbox</a></li>
               <li><a href="outbox/outbox.action">Request Outbox</a></li>
                <s:if test="#session.loginType=='COMPANY_USER_LOGIN'">
                     <li><a href="template/template.action">Form Templates</a></li>
                </s:if>
                <s:elseif test="#session.loginType=='COMMON_USER_LOGIN'">
                    <li class="last"><a href="record/record.action">Form Records</a></li>
                </s:elseif>
            </ul>
        </div>
        <div id="main-content">

            <table>
                <tr>
                    <th>Index</th>
                    <th>Form Template</th>
                    <th>Provider</th>
                    <th>Status</th>
                    <th>Date Received</th>
                    <th>Date Accepted</th>
                    <th>Action</th>
                </tr>
                <s:iterator value="templates" status="templateStatus">
                    <td>${templateStatus.index+1}</td>
                    <td><s:property value="title"/></td>
                    <td><s:property value="company.name"/></td>
                    <td>
                        <s:if test="status==1">Active</s:if>
                        <s:else>inActive</s:else>
                    </td>
                    <td></td>
                    <td><s:date name="decisionDate" format="yyyy-MM-dd"/> </td>
                    <td>
                        <a href="formdata/form-data!list.action?templateId=<s:property value="id"/>">Edit Data</a>|
                        <a href="javascript:void(0);" onclick="alert('not implements!');">Delete</a>
                    </td>
                </s:iterator>
            </table>
        </div>
    </div>
    <div id="footer-wrapper">
        <s:if test="#session.loginType=='COMPANY_USER_LOGIN'">
            <a href="companyuser/company-user.action">Company User Management</a> |
            <a href="company/company!preUpdate.action">Company Profile Update</a> |
        </s:if>
        <s:elseif test="#session.loginType=='COMMON_USER_LOGIN'">
            <a href="user/user.action">Main Page</a>   |
            <a href="user/user!preUpdate.action">User Profile Update</a> |
        </s:elseif>
        <a href="logout.action">Logout System</a>

        <p id="copyright">IDD LLC. &copy; 2011. All rights reserved.</p>
    </div>
</div>
</body>
</html>
