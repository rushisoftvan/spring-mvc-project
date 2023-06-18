<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
    <div align="center">
            <h2>Add Category</h2>
            <form:form action="save" method="post" modelAttribute="category">
                <form:label path="name">Name :</form:label>
                <form:input path="name"/><br/><br/>

                <form:button>Add</form:button>
            </form:form>
        </div>
</body>
</html>