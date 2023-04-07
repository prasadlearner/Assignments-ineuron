<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BOOK SEARCH PAGE</title>
</head>
<body bgcolor="lightblue">
	<h1 style='coclor: red; text-align: center'>Book Search Info</h1>
	<center>
		<form action="./controller/bookSearch" method="post" >
			<table>
				<tr>
					<th>Enter Author Name</th>
					<td><input type='text' name='bauthor' /></td>
				</tr>

				<tr>
					<th>Enter Book Title</th>
					<td><input type='text' name='btitle' /></td>
				</tr>

				<tr>
					<th>Enter Book Category</th>
					<td><input type='text' name='bcategory' /></td>
				</tr>

				<tr>
				<th></th>
					<td><input type='submit' value='Search' /></td>
					
				</tr>

			</table>
		</form>
		</center>
</body>
</html>