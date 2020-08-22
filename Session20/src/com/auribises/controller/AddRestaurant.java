package com.auribises.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auribises.dao.DB;
import com.auribises.model.Restaurant;


@WebServlet({ "/AddRestaurant", "/Add" })
public class AddRestaurant extends HttpServlet {

	DB db;
	
	@Override
	public void init() throws ServletException {
		db = new DB();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Restaurant restaurant = new Restaurant();
		restaurant.name = request.getParameter("txtName");
		restaurant.phone = request.getParameter("txtPhone");
		restaurant.address = request.getParameter("txtAddress");
		restaurant.type = request.getParameter("txtType");
		restaurant.ratings = Double.parseDouble(request.getParameter("txtRatings")); // Convert String to Double
		restaurant.operatingHours = request.getParameter("txtHours");
		
		String message = db.saveObject(restaurant);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String messageToUser = "<html><body><center><h3>"+message+"</h3></center></body></html>";
		
		out.print(messageToUser);
	}

}
