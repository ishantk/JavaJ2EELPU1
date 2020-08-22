<%@page import="com.auribises.dao.DB"%>
<%@page import="com.auribises.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

	<%
			
		User user = new User();
		user.name = request.getParameter("txtName");
		user.email = request.getParameter("txtEmail");
		user.password = request.getParameter("txtPassword");
		
		DB db = new DB();
		
		String message = db.addUserToCollection(user);
		
	%>

	<center>
		<h3>
			Registration Completed
		</h3>
		<h4> <%= message %></h4>
	</center>
</body>
</html>