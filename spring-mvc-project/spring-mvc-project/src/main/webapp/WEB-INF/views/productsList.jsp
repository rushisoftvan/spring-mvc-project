<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<html>
<head>
<title>Product List</title>
</head>
<body>
	<div align="center">
		<h2>Product List</h2>
		<div>
		   <a  href="add">Add Product</a><br/>
		</div>
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Category</th>
				<th>Created On</th>
				<th>Updated On</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.category.name}</td>
					<td>${product.createdOn}</td>
					<td>${product.updatedOn}</td>
					<td>${product.activeStatus}</td>
					<td><a href="editPage/${product.id}">Update</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>