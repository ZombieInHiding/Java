<%@page import="lti.quiz.bean.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
<script type ="text/javascript" src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<!--  Create a object of user session -->
<% RegisterBean user = (RegisterBean) session.getAttribute("USER"); %>
<!-- Control space after RegisterBean imports the package automatically-->
<body style="background-color: teal; color:white">
<jsp:include page="banner.jsp" />
<div class="container">
<h1> My Dashboard</h1>
<h4>Email id: <%= user.getEmail() %></h4>
<img src= "<%= user.getProfile() %>" height="100" width="150">
<hr>
<h2> Ever wondered which Super Hero are you?</h2>
<a href="quiz.quiz" class="btn btn-success">Take a Quiz to discover</a>
<%@ include file="footer.html" %>
</div>
</body>
</html>

