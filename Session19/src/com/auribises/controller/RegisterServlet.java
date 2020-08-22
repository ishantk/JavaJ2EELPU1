package com.auribises.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auribises.dao.DB;
import com.auribises.model.User;


@WebServlet({ "/RegisterServlet", "/Register" })
public class RegisterServlet extends HttpServlet {
	
	DB db;
	
	// When object of RegisterServlet will be created by Web Server, init will be executed
	// it is executed only once
	public void init(ServletConfig config) throws ServletException {
		db = new DB();
	}

	// service is executed for any request coming from the client
	// if, object is already existing, this same function will be executed again
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		
		// 1. Capture the Data from the Client which is available in HttpServletRequest
		user.name = request.getParameter("txtName");
		user.email = request.getParameter("txtEmail");
		user.password = request.getParameter("txtPassword");
		System.out.println(user);
		// Till Here we have a temporary User Object in the RAM on Server Space :)
				
		// 2. Save the User in Database Permanently
		String message = db.addUserToCollection(user);
		
		// 3. Send Back some HTML Response to Client
		response.setContentType("text/html");
		String htmlResponse = "<html><body><center>Response: "+message+"</center></body></html>";
		
		PrintWriter out = response.getWriter();
		out.print(htmlResponse); // This will be sent back to Client :)
	}
}