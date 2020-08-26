package com.auribises.webservice;

import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
// ws -> web service
// rs -> restful
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import org.glassfish.jersey.servlet.ServletContainer; -> Configure in web.xml file

/*
 	Restful Web Service Procedure:
 	1. Create a Plain Java Class
 	2. Create Web Methods returning the type of response as required by our solution
 	3. Link Jersey Jars in the Project
 	4. Annotate Java Class and Methods with Jersey Annotations to make it a Web Service
 	5. Configure the API ServletContainer in web.xml file so that we can make Class as a Web Service
 	6. Use Client APIs from jersey jars and execute web methods of the Web Service :)
 	
 */

// Web Service
@Path("/auth")
public class AuthService {
	

	// In Web Service we will create Web Methods
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String registerUserWithPlainResponse() {
		Date date = new Date();
		String resposne = "Hello, We have registered you. Its: "+date;
		return resposne; // we are returning plain text
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String registerUserWithHTMLResponse() {
		Date date = new Date();
		String resposne = "<html><body><center><h4>Hello, We have registered you. Its: "+date+"</h4></center></body></html>";
		return resposne; // we are returning html text
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String registerUserWithXMLResponse() {
		Date date = new Date();
		String resposne = "<?xml version='1.0' encoding='UTF-8'?><message>Hello, We have registered you. Its: "+date+"</message>";
		return resposne; // we are returning xml text
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)  //@Produces("application/json")
	public String registerUserWithJSONResponse() {
		Date date = new Date();
		String resposne = "{ 'message': 'Hello, We have registered you','date': 'Its: "+date+"'}";
		return resposne; // // we are returning JSON text
	}
	
	/*
	@POST
	public String saveUser(User user) {
		
	}*/
	
	// Assignment: Consume this web service through HTML FORM :)
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	public String saveUser(@FormParam("txtName") String name, @FormParam("txtEmail") String email, @FormParam("txtPassword") String password) {
		return "";
	}
	
}
