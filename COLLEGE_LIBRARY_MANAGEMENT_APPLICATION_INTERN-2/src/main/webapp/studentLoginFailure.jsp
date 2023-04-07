<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Login Error Page</title>
</head>
<body bgcolor="lightblue">
<br/>
<br/>
	<c:choose>
	
		<c:when test="${status eq 'Failure' }">
			<h1 style="color:red; text-align:center">
				STUDENT LOGIN FAILED
			</h1>
		</c:when>
	</c:choose>
<div style="text-align:center"><a href="../studentLogin.jsp">|Login Page|</a></div>
</body>
</html>