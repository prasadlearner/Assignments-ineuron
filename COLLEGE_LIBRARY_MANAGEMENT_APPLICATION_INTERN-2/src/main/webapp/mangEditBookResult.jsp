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
<br/>
<br/>
<br/>

<form action="controller/mangUpdatebook" method="post">
<center>
<table>
<c:choose> 
<c:when test="${book ne null || !empty book}">

<tr>
<th>BOOK ID</th>
<td><input type="text"  name='bid' value="${book.bid}" readonly/></td>
</tr>
<tr>
<th>BOOK TITLE</th>
<td><input type="text" name="btitle" value="${book.btitle}"/></td>
</tr>
<tr>
<th>BOOK AUTHOR</th>
<td><input type="text" name='bauthor' value="${book.bauthor}"/></td>
</tr>
<tr>
<th>BOOK CATEGORY</th>
<td><input type="text" name="bcategory" value="${book.bcategory}"/></td>
</tr>
<tr>
<th></th>
<td><input type="submit" value="UPDATE"/></td>
</tr>

</c:when>

<c:otherwise>
<h1 style="color:rd; text-align:center">BOOK NOT AVAILABLE</h1>

</c:otherwise>
</c:choose>
</table>
 <a href='../mangEditBook.jsp'>|Back|</a>
</center>
</form>
</body>
</html>