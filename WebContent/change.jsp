<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
<script type ="text/javascript" src="bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<div class="wrapper">
<div class="container">
	<form action="user.quiz" class="form-signin">
	<h1 class="form-signin-heading">Change Password</h1>
	<table class="table table-striped" style="width:50%">
	    <tr><td>Email id:</td><td> <input type="email" name="email" required></td></tr> 
		<tr><td>New Password: </td><td><input type="password" name="password" required></td></tr>	
		<tr><td colspan = "2"><input type="submit" value="Submit" class="btn btn-success"></td></tr>
		</table>		
	</form>
	</div></div>
</body>
</html>