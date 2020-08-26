<%@page import="javax.ws.rs.core.MediaType"%>
<%@page import="javax.ws.rs.client.WebTarget"%>
<%@page import="javax.ws.rs.core.UriBuilder"%>
<%@ page import="javax.ws.rs.client.Client"%>
<%@ page import="javax.ws.rs.client.ClientBuilder"%>
<%@ page import="org.glassfish.jersey.client.ClientConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESTful Client</title>
</head>
<body>

	<center>
		
		<h3>Welcome to RESTful Client - Consume the Web Service</h3>
		
		<%
			
			// APIs from Jersey to access the web service
			ClientConfig clientConfig = new ClientConfig();
			Client client = ClientBuilder.newClient(clientConfig);
			
			// WebTarget can access the web methods in the web service hosted at http://localhost:8080/Session26
			WebTarget webTarget = client.target(UriBuilder.fromUri("http://localhost:8080/Session26").build());
			
			//              		/rest/auth
			String plainResponse = webTarget.path("rest").path("auth").request().accept(MediaType.TEXT_PLAIN).get(String.class);
			String htmlResponse = webTarget.path("rest").path("auth").request().accept(MediaType.TEXT_HTML).get(String.class);
			String xmlResponse = webTarget.path("rest").path("auth").request().accept(MediaType.TEXT_XML).get(String.class);
			String jsonResponse = webTarget.path("rest").path("auth").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		%>
		
		Plain Response from the Web Service: <br/>
		<%= plainResponse %> <br/><br/>
		
		HTML Response from the Web Service: <br/>
		<%= htmlResponse %> <br/><br/>
		
		XML Response from the Web Service: <br/>
		<%= xmlResponse %> <br/><br/>
		
		JSON Response from the Web Service: <br/>
		<%= jsonResponse %> <br/><br/>
		
	</center>

</body>
</html>