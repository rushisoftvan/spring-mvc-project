<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add Category</title>
</head>
<body>
	<div align="center">
		<h2>Category List</h2>
		<div>
			<a href="add">Add Category</a><br />
		</div>
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>Name</th>
			</tr>
			<c:forEach var="category" items="${categories}">
				<tr> 
				    
					<td>${category.name}</td>
				</tr>	
			</c:forEach>
			</div>
		</table>
</body>
</html>