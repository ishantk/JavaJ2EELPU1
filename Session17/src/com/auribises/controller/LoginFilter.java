package com.auribises.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");

		if(email.isEmpty() && password.isEmpty()) {
			response.setContentType("text/html");
			String htmlResponse = "<html><body><center>Filter: Invalid Data Sent :(</center></body></html>";
			
			PrintWriter out = response.getWriter();
			out.print(htmlResponse); // This will be sent back to Client :)
		}else {
			// pass the request along the filter chain -> attached Servlet will be executed
			chain.doFilter(request, response);
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
