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
    			<tr><th>Index</th><th>Request Number</th><th>Form Name</th><th>Form Provider</th><th>Date Created</th><th>Decision</th><th>Decision Date</th></tr>
                 <s:iterator value="completeRequests" status="completeRequestStatus">
                    <tr>
                        <td>${completeRequestStatus.index+1}</td>
                        <td><s:property value="refNumber"/></td>
                        <td><s:property value="template.title"/></td>
                        <td><s:property value="companyUser.loginId"/></td>
                        <td><s:date name="requestDate" format="yyyy-MM-dd"/></td>
                        <td>
                             <s:if test="status==1">
                               <a href="inbox/inbox!reject.action?completeRequest.id=<s:property value="id"/>">Reject</a> |
                               <a href="inbox/inbox!accept.action?completeRequest.id=<s:property value="id"/>">Accept</a>
                            </s:if>
                            <s:elseif test="status==2">
                                ACCEPT
                            </s:elseif>
                            <s:elseif test="status==3">
                                REJECTED
                            </s:elseif>
                        </td>
                        <td><s:date name="decisionDate" format="yyyy-MM-dd"/></td>
                    </tr>
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
            <a href="user/user!preUpdate.action">User Profile Update</a>   |
        </s:elseif>
        <a href="logout.action">Logout System</a>
  		<p id="copyright">IDD LLC. &copy; 2011. All rights reserved.</p>
  </div>

</div>

</body>
</html>
