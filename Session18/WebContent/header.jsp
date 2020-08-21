<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LMS</title>
</head>
<body>

	<%!
		Date date = new Date();
		String today = date.toString();
	%>

	<center>
		<br/>
		------------------------------------
		<h3>Welcome to LMS</h3>
		Work hard, Get Luckier
		<br/>
		<%= today %>
		<br/>
		------------------------------------
		<br/>
	</center>

</body>
</html>