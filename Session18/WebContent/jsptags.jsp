<%@page import="com.auribises.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>  
<%@ page errorPage="errorPage.jsp" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Tags</title>
</head>
<body>
	
	<center>
	
	<h4>Scriptlet Tags:</h4>
	
	
	<%-- error -> as a is declared later. a is: <%= a %> --%>
	
	<h4>Area of Circle with radius 4.7 is: <%= area(4.7) %></h4>
	<h4>PI is: <%= PI %></h4>
	
	<%
		int a = 10;
		int b = 20;
		int sum = a+b;
		
		
		// out is an object of PrintWriter class which will send back the repsonse to client
		// we say out is an implicit object :)
		out.print("Sum is: "+sum);
	%>
	
	<br/>
	
	<!-- Expression Tag -->
	a is: <%= a %>
	
	<!-- Declarative Tag -->
	<%!
		double PI = 3.14;
		double area(double radius){
			return PI * radius * radius;
		}
	%>
	
	<h4>Area of Circle with radius 2.2 is: <%= area(2.2) %></h4>
	
	<%
		int[] numbers = {10, 20, 30, 40, 50};
	
		out.print(numbers[1]);
	
	%>
	
	<%= numbers[1] %>
	
	<br/>
	
	<!-- JSP Action Tags -->
	<jsp:include page="header.jsp"/>
	
	<%
		User user = new User();
		user.setName("John");
		user.setEmail("john@example.com");
		user.setPassword("pass123");
		
	%>
	
	Name: <%= user.getName() %> Email: <%= user.getEmail() %> Password: <%= user.getPassword() %>
	
	<br/>
	
	<jsp:useBean id="uRef" class="com.auribises.model.User"/>
	<jsp:setProperty property="name" name="uRef" value="Sia"/>
	<jsp:setProperty property="email" name="uRef" value="sia@example.com"/>
	<jsp:setProperty property="password" name="uRef" value="sia@123"/>
	
	Name: <jsp:getProperty property="name" name="uRef"/>
	Email: <jsp:getProperty property="email" name="uRef"/>
	Password: <jsp:getProperty property="password" name="uRef"/>
	
	<br/>
	<h3>JSTL DEMO :)</h3>
	
	<c:forEach var="i" begin="1" end="10">
		<c:out value="${i}"></c:out> <br/>
	</c:forEach>
	
	</center>

</body>
</html>