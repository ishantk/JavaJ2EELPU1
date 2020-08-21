package com.auribises.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.auribises.model.User;


@WebServlet({ "/HomeServlet", "/Welcome" })
public class HomeServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		// Read the Data from URL/Form
		//String name = request.getParameter("name");
		//String email = request.getParameter("email");
		
		/*
		String name = "", email = "";
		
		// Read All the Cookies from the Browser available for your app
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("keyName")) {
					name = cookie.getValue();
				}
				
				if(cookie.getName().equals("keyEmail")) {
					email = cookie.getValue();
				}
			}
		}*/
		
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("keyUser");
		
		String htmlResponse = "<html><body><center>Welcome to Home Page :)<br/>"+
		"<h3>"+user.name+"</h3>"+
		"<h4>"+user.email+"</h4>"+
		"</center></body></html>";
		
		PrintWriter out = response.getWriter();
		out.print(htmlResponse); 
	}

}
