package com.auribises.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.auribises.dao.DB;
import com.auribises.model.User;


@WebServlet({ "/LoginServlet", "/Login" })
public class LoginServlet extends HttpServlet {
	
	DB db;
	
	public void init(ServletConfig config) throws ServletException {
		db = new DB();
	}
	
	// any http request
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		
		// 1. Capture the Data from the Client which is available in HttpServletRequest
		user.email = request.getParameter("txtEmail");
		user.password = request.getParameter("txtPassword");
		System.out.println(user);
		// Till Here we have a temporary User Object in the RAM on Server Space :)
				
		// 2. Fetch the User in from DataBase
		boolean status = false; // db.fetchUserFromCollection(where, what);
		
		String message = "";
		
		if(status) {
			
			
		}else {
			message = "Invalid Credentials";
		}
		
		// 3. Send Back some HTML Response to Client
		response.setContentType("text/html");
		String htmlResponse = "<html><body><center>Response: "+message+"</center></body></html>";
		
		PrintWriter out = response.getWriter();
		out.print(htmlResponse); // This will be sent back to Client :)
	}

}

// Assignment:
// 1. Implement Login Flow
// 2. Implement User Profile -> Edit his/her data
//							 -> Block his Account => maintain a separate attribute for status	
