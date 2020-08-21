<%@page import="com.auribises.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>	

	<center>
		<h3>Welcome Home</h3>
		<%
			/* String name = request.getParameter("name");
			String email = request.getParameter("email"); */
			
			User user = (User)session.getAttribute("keyUser");
		%>
		<h4>User Details</h4>
		<h4>Name: <%= user.name %></h4>
		<h4>Email: <%= user.email %></h4>
		
	</center>

</body>
</html>