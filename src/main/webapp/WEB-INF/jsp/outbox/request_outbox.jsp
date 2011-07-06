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
        Request Outbox
    </div>

    <div id="content-wrapper">
        <div id="sidebar">
            <ul class="menu">
                <li><a href="request_inbox.htm">Request Inbox</a></li>
                <li><a class="active-link" href="outbox/outbox.action">Request Outbox</a></li>
                <li><a href="form_template.htm">Form Templates</a></li>
                <li><a href="form_records">Form Records</a></li>
            </ul>
        </div>
        <div id="main-content">
            <table>
                <tr>
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
                        <td><s:property value="refNumber"/></td>
                        <td><s:property value="formId"/></td>
                        <td><s:property value="consumerId"/></td>
                        <td>
                            <s:date name="requestDate" format="yyyy-MM-dd HH:mm:ss"/>
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
                        <td></td>
                        <td><s:property value="note"/></td>
                        <td><a href="###">Del</a> | <a href="###">Resend</a></td>
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
        <a href="companyuser/company-user.action">Company User Management</a> |
        <a href="company/company!preUpdate.action">Company Profile Update</a> |
        <a href="logout.action">Logout System</a>

        <p id="copyright">IDD LLC. &copy; 2011. All rights reserved.</p>
    </div>
</div>
</body>
</html>
