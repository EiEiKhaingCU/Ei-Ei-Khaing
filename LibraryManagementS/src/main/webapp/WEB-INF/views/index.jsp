<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/menu.jsp"%>
<h3>${msg}</h3>
<h4>Please type your name!</h4>
<form:form method="post" action="${pageContext.request.contextPath}/postInfo.htm" commandName="student">
Name: <form:input path="name" type="text"/><br>
RollNo: <form:input path="rno" type="text" /><br>
NRC: <form:input path="nrc" type="text" /><br>
Grade: <form:input path="grade" type="text" /><br>
<input type="submit" value="Submit" />
</form:form>

</body>
</html>