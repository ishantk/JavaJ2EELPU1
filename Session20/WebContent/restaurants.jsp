<%@page import="com.auribises.model.Restaurant"%>
<%@page import="java.util.List"%>
<%@page import="com.auribises.dao.DB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Web Admin backend</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<!-- Reference Link for UI -->
<!-- https://www.w3schools.com/bootstrap -->

<div class="jumbotron text-center">
  <h2>Food Delivery App - Admin Panel</h2>
  <p>We Deliver in No Time :)</p>
</div>

<div class="container">
  <h2>All Restaurants:</h2>
  
  <ul class="list-group">

  <%
  	DB db = new DB();
  	List<Restaurant> restaurants = db.fetchAllObjects();
  	
  	for(Restaurant restaurant : restaurants){
  %>
  	<li class="list-group-item list-group-item-success"><%= restaurant.name %> | <%= restaurant.address %> <span class="badge"><%= restaurant.ratings %></span></li>
  <%  		
  	}
  %>
  
  </ul>
  
</div>  

</body>
</html>