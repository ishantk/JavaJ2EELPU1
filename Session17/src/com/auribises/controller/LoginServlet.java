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
		db.createConnection();
	}

	
	public void destroy() {
		db.closeConnection();
	}
	
	// doPost can handle only post request from the client
	/*protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}*/
	
	// any http request
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		
		// 1. Capture the Data from the Client which is available in HttpServletRequest
		user.email = request.getParameter("txtEmail");
		user.password = request.getParameter("txtPassword");
		System.out.println(user);
		// Till Here we have a temporary User Object in the RAM on Server Space :)
				
		// 2. Save the User in Database Permanently
		boolean status = db.loginUser(user);
		
		String message = "";
		
		// Navigation from ServletOne to ServletTwo :)
		String url = "'Welcome'";
		
		if(status) {
			// 1. Session Tracking - URL Writing -> Write the Data in URL [Query String]
			//url = "'Welcome?name="+user.name+"&email="+user.email+"'";
			//String linkToHome = "<br/><a href="+url+">Click to Enter Home</a><br/>";
			// message = user.name+" Login Success"+linkToHome;
			
			// 2. Session Tracking - Hidden Form Field
			/*String form = "<form action='Welcome' method='post'>"
					+ "<input type='hidden' name='name' value='"+user.name+"'/>"
					+ "<input type='hidden' name='email' value='"+user.email+"'/>"
					+ "<input type='submit' value='Click to Enter Home'/>"
					+ "</form>";
			
			message = user.name+" Login Success <br/>"+form;*/
			
			// 3. Cookies -> Stores the Data as HashMap on the Browser
			// PS: in Cookies, we need to save the data always as Strings :)
			// For Special Symbols and characters, cookie will throw error 
			// We must encode them -> URLEncoder | Explore it
			//Cookie cookie1 = new Cookie("keyName", "john");
			//Cookie cookie2 = new Cookie("keyEmail", "john123");
			
//			cookie1.setMaxAge(60);
			
			//response.addCookie(cookie1);
			//response.addCookie(cookie2);
			
			// 4. Session Tracking - HttpSession API
			HttpSession session = request.getSession();
			session.setAttribute("keyUser", user);
			
			String linkToHome = "<br/><a href="+url+">Click to Enter Home</a><br/>";
			message = user.name+" Login Success"+linkToHome;
			
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
// Logout Functionality in this Web App with Cookies/HttpSession Technique
// Explore ServletConfig API :)
