<%@page import="com.auribises.model.Restaurant"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.auribises.dao.DB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String name = request.getParameter("name");
	
	DB db = new DB();
	db.createConnection();
	ArrayList<Restaurant> restaurants = db.getRestaurants(name);
	
	for(Restaurant restaurant : restaurants){
		out.print(restaurant.toString()+"<br/>"); // response back to index page :)
	}

	db.closeConnection();
%>