<%@page import="lti.quiz.bean.OptionBean"%>
<%@page import="lti.quiz.bean.QuizBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz</title>
</head>
<body>
<jsp:include page="banner.jsp" />
<div class="container">
<h3 style="text-align:center">Take this quiz.</h3>
<%	QuizBean quiz = (QuizBean) request.getAttribute("Question"); %>
<form action="quiz.quiz">
<h4><%= quiz.getQuestion() %></h4>
<%	for(OptionBean option : quiz.getOptions()) { %>
	<input type="radio" name="choice" value="<%=option.getScore()%>"><%= option.getOption() %><br>
<%	} %>
<input type="submit" value="Submit Answer" class="btn btn-success">
</form>
</div>

<%@ include file="footer.html" %>
</body>
</html>