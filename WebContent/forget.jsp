<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="style.css"/>
<script type ="text/javascript" src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
<div class="wrapper">
<div class="container">
	
	<form action="user.quiz" class="form-signin">
	<%if (request.getParameter("invalid") != null){%>
	<div class="alert-danger"> Invalid Email / Password</div>
	<% } %>
	<h1 class="form-signin-heading">Forgot Password</h1>
	<table class="table" style="width:50%">
	    <tr><td>Email ID: </td><td><input type="email" name="email" required></td></tr>
		<tr><td>Favorite Superhero: </td><td><input name="hero" required></td></tr> 		
		<tr><td colspan="2"><input type="submit" value="Submit" class="btn btn-success"></td></tr>
	</table>		
	</form>
	</div></div>
</body>
</html>