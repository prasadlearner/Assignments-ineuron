<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update Form</title>
</head>
<br/>
<br/>
<br/>
<body bgcolor='lightblue'>
	<center>
		<c:choose>
			<c:when test="${student ne null || !empty student }">
				<form method="post" action="./controller/update">
					<table>
						<tr>
							<th>SID</th>
							<td><input type='text' name=sid value="${student.id }"readonly /></td>
						</tr>

						<tr>
							<th>SNAME</th>
							<td><input type='text' name=sname value="${student.name }" /></td>
						</tr>

						<tr>
							<th>SAGE</th>
							<td><input type='text' name=sage value="${student.age }" /></td>
						</tr>

						<tr>
							<th>SADDR</th>
							<td><input type='text' name=saddr value="${student.address}" /></td>
						</tr>

						<tr>
							<th></th>
							<td><input type='submit' value="update" /></td>
						</tr>
					</table>
				</form>

			</c:when>

			<c:otherwise>
				<h1 style="color: red; text-align: center">No Record To Display</h1>

			</c:otherwise>

		</c:choose>

	</center>
</body>
</html>