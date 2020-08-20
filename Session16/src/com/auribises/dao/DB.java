package com.auribises.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.auribises.model.User;

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
	
	// 3. Write and Execute SQL Statement
	public String registerUser(User user) {
		
		String message = "NA";
		
		try {
			String sql = "insert into User values(null, ?, ?, ?)";
			
			prepStmt = connection.prepareStatement(sql);
			prepStmt.setString(1, user.name);
			prepStmt.setString(2, user.email);
			prepStmt.setString(3, user.password);
			
			int i = prepStmt.executeUpdate(); // executeUpdate -> will perform SQL insert, update and delete commands
			
			if(i>0) {
				message = "4. "+user.name+" Registered  :)";
			}else {
				message = "4. "+user.name+" NOT Registered :(";
			}
			
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
		
		return message;
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
