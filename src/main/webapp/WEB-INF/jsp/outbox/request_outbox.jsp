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
           function delete_confirm(id) {
            if(confirm("Are you sure delete this request?"))
            window.location.href = "<%=basePath%>/outbox/outbox!delete.action?completeRequest.id="+id;
        }
    </script>
</head>
<body>
<div id="page-wrapper">
    <div id="header-wrapper">
        Request Outbox
    </div>

    <div id="content-wrapper">
        <div id="sidebar">
            <ul class="menu">
                <li><a href="inbox/inbox.action">Request Inbox</a></li>
                <li><a class="active-link" href="outbox/outbox.action">Request Outbox</a></li>
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
                    <th>REF Number</th>
                    <th>Form Name</th>
                    <th>Form Consumer</th>
                    <th>Date Sent</th>
                    <th>Status</th>
                    <th>Decision Date</th>
                    <th>Comment</th>
                    <th>Action</th>
                </tr>
                <s:iterator value="completeRequests" status="completeRequestStatus">
                    <tr>
                        <td>${completeRequestStatus.index+1}</td>
                        <td><s:property value="refNumber"/></td>
                        <td><s:property value="template.title"/></td>
                        <td><s:property value="consumer.loginId"/></td>
                        <td>
                            <s:date name="requestDate" format="yyyy-MM-dd"/>
                        </td>
                        <td>
                            <s:if test="status==1">
                                PENDING
                            </s:if>
                            <s:elseif test="status==2">
                                ACCEPT
                            </s:elseif>
                            <s:elseif test="status==3">
                                REJECTED
                            </s:elseif>
                        </td>
                        <td> <s:date name="decisionDate" format="yyyy-MM-dd"/></td>
                        <td><s:property value="note"/></td>
                        <td><a href="javascript:void(0);" onclick="delete_confirm(<s:property value="id"/>);">Del</a> | <a href="javascript:void(0);" onclick="alert('not implement!');">Resend</a></td>
                    </tr>
                </s:iterator>
            </table>
        </div>
        <div id="main-content">
            <a href="javascript:void(0);" id="create_new_request">Create New Request</a>
            <s:actionerror/>
            <form id="new_request_form" method="POST" action="outbox/outbox!create.action">
                <div id="new_request_fields">
                    <div><label>Form Name</label>: <br/>
                        <select name="completeRequest.formId">
                            <s:iterator value="templates" status="templateStatus">
                                <option value="<s:property value="id"/> "><s:property value="title"/></option>
                            </s:iterator>
                        </select>
                    </div>
                    <div><label>Consumer Ref Number</label>: <br/>
                        <input type=textfield name="completeRequest.refNumber" value="${completeRequest.refNumber}"/>
                    </div>
                    <div><label>Description</label>: <br/>
                        <textarea name="completeRequest.note">${completeRequest.note}</textarea></div>
                    <div><input type="submit" value="Submit" id="submit_new_request"/>
                        <input type="reset" value="Cancel" id="cancel_new_request"/>
                    </div>
                </div>
            </form>

        </div>
    </div>
    <div id="footer-wrapper">
         <s:if test="#session.loginType=='COMPANY_USER_LOGIN'">
            <a href="companyuser/company-user.action">Company User Management</a> |
            <a href="company/company!preUpdate.action">Company Profile Update</a> |
        </s:if>
        <s:elseif test="#session.loginType=='COMMON_USER_LOGIN'">
            <a href="user/user!preUpdate.action">User Profile Update</a> |
        </s:elseif>
        <a href="logout.action">Logout System</a>

        <p id="copyright">IDD LLC. &copy; 2011. All rights reserved.</p>
    </div>
</div>
</body>
</html>
