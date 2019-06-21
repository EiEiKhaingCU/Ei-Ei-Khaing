<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
table{
	border-collapse:collapse;
}
table,td,th{
	border:1px solid black;
}
<title>Insert title here</title>
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/menu.jsp"%>
<table >
<h4>Please type book info!</h4>
<form:form method="post" action="${pageContext.request.contextPath}/bookInfo.htm" commandName="book">
<form:hidden path="id"/>
<tr><td>Name:</td><td> <form:input path="name" type="text"/></td></tr>
<tr><td>Author:</td><td> <form:input path="author" type="text"/></td></tr>
<tr><td>Isbn:</td> <td><form:input path="isbn" type="text"/></td></tr>
<tr><td>Category:</td> <td><form:select path="categoryId">    <form:options items="${categoryList}" itemValue="id" itemLabel="name"/>  
</form:select></td></tr>
<tr><td><input type="submit" value="Login" /><td></tr>
</form:form>
</table>
</body>
</html>