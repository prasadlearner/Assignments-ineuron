<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor='lightblue'>
	<br />
	<br />
	<c:choose>
		<c:when test="${status eq 'success' }">
			<h1 style="color: green; text-align: center">
			BOOK UPDATED SUCCESSFULLY</h1>
		</c:when>
		
		<c:when test="${status eq 'notfound' }">
			<h1 style="color: green; text-align: center">
			BOOK NOT AVAILABLE FOR UPDATION</h1>
		</c:when>
		
		<c:otherwise>
			<h1 style="color: red; text-align: center">BOOK UPDATION FAILED
			</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>