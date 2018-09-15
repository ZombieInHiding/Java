<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<script type="text/javascript" src="bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:indianred;color:azure">
<jsp:include page="banner.jsp" />
<div class="container">
<h1>You resembles to Super Hero</h1>
<% String hero = (String) request.getAttribute("Hero"); %>
<img src="<%= hero %>" height="200" width="250">

<a href="dashboard.jsp" class="btn btn-success">Back to DashBoard </a>


<%@ include file="footer.html" %>
</div>
</body>
</html>