<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete page</title>
</head>
<body>
<br/>
<br/>
<br/>
	<c:choose>
		<c:when test="${status eq 'Success'}">
			<h1 style='color: green; text-align: center'>Record deleted
				Successfully</h1>
		</c:when>
		<c:when test="${status eq 'failed' } ">
			<h1 style='color: red; text-align: center'>Record deletion
				failed</h1>
		</c:when>

		<c:otherwise>
			<h1 style='color: red; text-align: center'>Record not found</h1>
		</c:otherwise>

	</c:choose>
</body>
</html>