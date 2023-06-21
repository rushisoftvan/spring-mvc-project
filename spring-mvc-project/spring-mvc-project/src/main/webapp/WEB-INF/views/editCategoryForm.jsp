<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Category</title>
</head>
<body>
    <div align="center">
    	 <form:form action="${pageContext.request.contextPath}/categories/update" method="post" modelAttribute="category">
    	     <form:hidden path="id" />
    	     
    	     <form:label path="name">Name :</form:label>
             <form:input path="name"/><br/><br/>
              
               <form:label path="activeStatus">Select Category :</form:label>
               <form:select path="activeStatus">
               <form:options items="${statusList}" />
               </form:select>
              
    	  <form:button type="submit">Update</form:button>
           </form:form>
    </div>
</body>
</html>