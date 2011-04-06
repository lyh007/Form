<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Form application</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Form</h2>--%>
<%--<a href="<%=request.getContextPath()%>/formdata/form-data!list.action">Form Result List</a>--%>
<%--<a href="<%=request.getContextPath()%>/formdata/form-data!step1.action">Fill a new Form</a>--%>
<%--</body>--%>
<%--</html>--%>
<%
    response.sendRedirect(request.getContextPath()+"/formdata/form-data!list.action");
%>
