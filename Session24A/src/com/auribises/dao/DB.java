package com.auribises.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.auribises.model.Restaurant;

public class DB {
	
	// Connection is an Interface whose reference we have declared
	Connection connection;
	PreparedStatement prepStmt; // to execute SQL Command in MySQL DB
	
	
	// 1. Load the Driver
	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Driver Loaded :) ");
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
	}
	
	// 2. Create the Connection
	public void createConnection() {
		try {
			
			String url = "jdbc:mysql://localhost/auridb";
			
			String user = "root";
			String password = "";
			
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("2. Connection Created :) ");
			
			
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
	}
	
	public ArrayList<Restaurant> getRestaurants(String name){
		
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		
		try {
			
			String sql = "select * from Restaurant where name like '"+name+"%'";
			prepStmt = connection.prepareStatement(sql);
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()) {
				
				Restaurant restaurant = new Restaurant();
				
				restaurant.rid = rs.getInt(1);
				restaurant.name = rs.getString(2);
				restaurant.phone = rs.getString(3);
				restaurant.address = rs.getString(4);
				restaurant.type = rs.getString(5);
				restaurant.ratings = rs.getDouble(6);
				restaurant.operatingHours = rs.getString(7);
				
				restaurants.add(restaurant);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return restaurants;
	}
	

	// 4. Close Connection with DataBase
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("4. Connection Closed");
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
	}
}
