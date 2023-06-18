<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <div align="center">
            <h2>Product List</h2>
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