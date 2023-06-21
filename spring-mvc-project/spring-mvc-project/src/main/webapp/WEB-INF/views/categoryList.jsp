<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<html>
<head>
<title>Add Category</title>
</head>
<body>
	<div align="center" class="container">
		<h2>Category List</h2>
		<div>
			<a class="btn btn-info"  href="add">Add Category</a><br />
		</div>
		<table class="table mt-1" border="2" width="70%" cellpadding="2">
			<tr>
				<th class="col">Name</th>
				<th class="col">Status</th>
				<th class="col">Action</th>
			</tr>
			<c:forEach var="category" items="${categories}">
				<tr> 
				    
					<td >${category.name}</td>
					<td>${category.activeStatus}</td>
					<td><a href="editPage/${category.id}">Update</a></td>
				</tr>	
			</c:forEach>
			</div>
		</table>
</body>
</html>