<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student record</title>
</head>
<br/>
<br/>
<br/>
<br/>
<body bgcolor='lightblue'>
	<c:choose>

		<c:when test="${student ne null || !empty student }">
			<table border="1" align="center">
			<caption>Student Record</caption>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Age</th>
					<th>Address</th>
				</tr>
				<tr>
					<td>${student.id }</td>
					<td>${student.name }</td>
					<td>${student.age }</td>
					<td>${student.address }</td>
				</tr>
			</table>
		</c:when>
		
	<c:otherwise>	<h1 style='color:red; text-align:center'>No data to display</h1></c:otherwise>

	</c:choose>
</body>
</html>