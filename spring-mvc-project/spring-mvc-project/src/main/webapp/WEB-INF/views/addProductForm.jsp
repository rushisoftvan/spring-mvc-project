<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <div align="center" class="border border-primary w-50 justify-content-center"> 
            <h2>Add Product</h2>
            <form:form action="save" method="post" modelAttribute="product">
                <form:label path="name">Name :</form:label>
                <form:input path="name"/><br/><br/>

                <form:label path="price">Price :</form:label>
                <form:input path="price"/><br/><br/>

                <form:label path="category">Select Category :</form:label>
                <form:select path="category.id">
                 <form:options items="${categories}" itemValue="id" itemLabel="name" />
                </form:select>

                <form:button type="submit">Add</form:button>
            </form:form>
        </div>
</body>
</html>