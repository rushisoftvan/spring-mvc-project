<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
    <div align="center">
            <h2>Edit Product</h2>
            <form:form action="${pageContext.request.contextPath}/products/update" method="post" modelAttribute="product">

                 <form:hidden path="id" />

                <form:label path="name">Name :</form:label>
                <form:input path="name"/><br/><br/>

                <form:label path="price">Price :</form:label>
                <form:input path="price"/><br/><br/>

                <form:label path="category">Select Category :</form:label>
                <form:select path="category.id">
                 <form:options items="${categories}" itemValue="id" itemLabel="name" />
                </form:select>

                <form:label path="activeStatus">Select Category :</form:label>
                <form:select path="activeStatus">
                <form:options items="${statusList}" />
                </form:select>


                <form:button type="submit">Update</form:button>
            </form:form>
        </div>
</body>
</html>