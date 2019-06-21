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
Student Information is<br>
<table>
	<thead>
		<tr>
		<th>No</th>
		<th>Name</th>
		<th>RollNo</th>
		<th>NRC</th>
		<th>Grade</th>
		<th>DELETE</th>
		<th>Update</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="emp" items="${student}" varStatus="index">
		<tr>
		<td>${index.count }</td>
		<td>${emp.name }</td>
		<td>${emp.rno }</td>
		<td>${emp.nrc }</td>
		<td>${emp.grade }</td>	
		<td><a href="<c:url value='/deleteStudent/${emp.id}'/>">Delete</a></td>	
		<td><a href="<c:url value='/updateStudent/${emp.id}'/>">Update</a> </td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>