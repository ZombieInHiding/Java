<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="style.css"/>
<script type ="text/javascript" src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<jsp:include page="banner.jsp" />
 <div class="wrapper">
<div class="container">	
	<form action="user.quiz" class="form-signin">
	<%if (request.getParameter("invalid") != null){%>
	<div class="alert-danger"> Invalid Email / Password</div>
	<% } %>
	<h1 class="form-signin-heading">Login Screen</h1>
	<table class="table table-striped " style="width:40%" >
		<tr><td>Email id:</td><td> <input type="email" name="email" required placeholder="someone@somedomain.ext"></td></tr> 
		<tr><td>Password: </td><td><input type="password" name="password" required placeholder="secured password"></td></tr>
		<tr><td colspan = "2"><input type="submit" value="Login" class="btn btn-success"></td></tr>
	</table>		
		<hr> <a href = "forget.jsp">Forgot Password</a>
		<br>Not Registered? <a href = "register.jsp">Register here</a>
	</form>
	</div>
	<%@ include file="footer.html" %>
	</div>
</body>
</html>