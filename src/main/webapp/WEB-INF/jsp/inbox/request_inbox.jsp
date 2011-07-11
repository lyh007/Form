<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Form Management</title>
    <link rel="stylesheet" type="text/css" href="css/general.css"/>
</head>
<body>
<div id="page-wrapper">
  <div id="header-wrapper">
  Request Inbox
  </div>

   <div id="content-wrapper">

      <div id="sidebar">
        <ul class="menu">
          <li><a class="active-link" href=inbox/inbox.action">Request Inbox</li>
          <li><a href="outbox/outbox.action">Request Outbox</a></li>
          <li><a href="template/template.action">Form Templates</a></li>
          <li><a href="formdata/form-data!list.action?templateId=<s:property value="id"/>">Form Records</a></li>
        </ul>

      </div>
  		<div id="main-content">
    		<table>
    				<tr><th>Request Number</th><th>Form Name</th><th>Form Provider</th><th>Date Created</th><th>Decision</th><th>Decision Date</th></tr>
    		</table>
  		</div>

  </div>
  <div id="footer-wrapper">
      <a href="company_user_management.htm">Company User Management</a> | <a href="company_update.htm">Company Profile Update</a>
  		<p id="copyright">IDD LLC. &copy; 2011. All rights reserved.</p>
  </div>

</div>

</body>
</html>
