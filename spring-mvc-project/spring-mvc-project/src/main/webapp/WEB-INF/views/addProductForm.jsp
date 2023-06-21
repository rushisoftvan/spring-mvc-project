<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<script>
     function validation(){
    	 console.log("rushikesh");
    	 var letters =/^[A-Za-z]+$/;
    	 var name=$("#name").val().trim();
    	 var price=$("#price").val().trim();
    	 
    	 if(name=="" || !letters.test(name) ){
    		 $("#nameValidation").show();
    		 $("#ageValidation").hide();
    		 return false;
    	 }
    	 else if(price =="" || isNaN(price))
    	 {
    		  
    		 $("#ageValidation").show();
    		 $("#nameValidation").hide();
    		return false; 
    	 }
    	 
    	 return true;
     }
</script>
<body>
    <div align="center" > 
            <h2>Add Product</h2>
            <form:form action="save" method="post" modelAttribute="product" onsubmit="return validation();">
                <form:label path="name">Name :</form:label>
                <form:input path="name" id="name" /><br/><br/>
                 
                 <div class="alert alert-danger" role="alert" id="nameValidation" style="display:none;">
		  Please Enter vaild name
		</div>
                 
                <form:label path="price">Price :</form:label>
                <form:input path="price" id="price"/><br/><br/>
                   
                   <div class="alert alert-danger" role="alert" id="ageValidation" style="display:none;">
		             Please Enter vaild price
		           </div>
                   
                   
                <form:label path="category">Select Category :</form:label>
                <form:select path="category.id">
                 <form:options items="${categories}" itemValue="id" itemLabel="name" />
                </form:select><br/><br>

                <form:button type="submit">Add</form:button>
            </form:form>
        </div>
</body>
</html>