package com.auribises.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/FrontController", "/Front", "/App" })
public class FrontController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("txtType");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String message = "Welcome to LMS APP";
		
		
		if(type.equals("login")) {
			//RequestDispatcher dispatcher = request.getRequestDispatcher("Login"); //Login -> url pattern of LoginServlet
			RequestDispatcher dispatcher = request.getRequestDispatcher("Awesome"); //Login -> url pattern of LoginServlet
			  dispatcher.forward(request, response);	
			//dispatcher.include(request, response);
		}else if (type.equals("register")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("Register"); //Login -> url pattern of LoginServlet
			dispatcher.forward(request, response);	
		}else {
			message = "Invalid Request";
		}
		
		
		String htmlResponse = "<html><body><center>Response: "+message+"</center></body></html>";
		out.print(htmlResponse);
		
	}

}
