<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Submit Book Status Page</title>
</head>
<body bgcolor="lightblue">
<br/>
<br/>
	<c:choose>
		<c:when test="${status eq 'success' }">
			<h1 style="color:green; text-align:center">
				STUDENT BOOK SUBMITTED SUCCESSFULLY
			</h1>
		</c:when>
		<c:when test="${status eq 'fineAmtPending' }">
			<h1 style="color:green; text-align:center">
				 FINE AMOUNT IS PENDING COLLECT BEFORE BOOK SUBMITION
			</h1>
		</c:when>
		<c:when test="${status eq 'notIssued' }">
			<h1 style="color:green; text-align:center">
				 THIS BOOK IS NOT ISSUED FOR THIS STUDENT :: ${param.sid}
			</h1>
		</c:when>
		<c:otherwise>
			<h1 style="color:red; text-align:center">
				STUDENT SUBMITION FAILED
			</h1>
		</c:otherwise>
	</c:choose>
	<div style="text-align:center"><a href='../mangSubmitBook.jsp'>|Back|</a></div>
</body>
</html>