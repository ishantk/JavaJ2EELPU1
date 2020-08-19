package com.auribises.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.auribises.model.Customer;

// Object of DB class will access the DataBase
public class DB {
	
	// Connection is an Interface whose reference we have declared
	Connection connection;
	Statement statement;
	PreparedStatement prepStmt;
	
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
	public String addCustomer(Customer customer) {
		
		String message = "NA";
		
		/*
		try {
			String sql = "insert into Customer values(null, '"+customer.name+"', '"+customer.phone+"', '"+customer.email+"', "+customer.temperature+", '"+customer.entryDateTime+"', '"+customer.exitDateTime+"')";
			System.out.println("SQL: "+sql);
			
			statement = connection.createStatement();
			int i = statement.executeUpdate(sql); // executeUpdate -> will perform SQL insert, update and delete commands
			
			if(i>0) {
				message = "4. "+customer.name+" Added in DataBase :)";
			}else {
				message = "4. "+customer.name+" NOT Added in DataBase :(";
			}
			
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}*/
		
		try {
			String sql = "insert into Customer values(null, ?, ?, ?, ?, ?, ?)";
			
			prepStmt = connection.prepareStatement(sql);
			prepStmt.setString(1, customer.name);
			prepStmt.setString(2, customer.phone);
			prepStmt.setString(3, customer.email);
			prepStmt.setFloat(4, (float) customer.temperature);
			prepStmt.setString(5, customer.entryDateTime);
			prepStmt.setString(6, customer.exitDateTime);
			
			int i = prepStmt.executeUpdate(); // executeUpdate -> will perform SQL insert, update and delete commands
			
			if(i>0) {
				message = "4. "+customer.name+" Added in DataBase :)";
			}else {
				message = "4. "+customer.name+" NOT Added in DataBase :(";
			}
			
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
		
		return message;
	}
	
	public String markExit(String exitDateTime, int customerId) {
		
		String message = "NA";
		
		try {
			
			String sql = "update Customer set exitDateTime = ? where id = ?";
			prepStmt = connection.prepareStatement(sql);
			prepStmt.setString(1, exitDateTime);
			prepStmt.setInt(2, customerId);
			
			int i = prepStmt.executeUpdate(); // executeUpdate -> will perform SQL insert, update and delete commands
			
			if(i>0) {
				message = "4. "+customerId+" Exit Time Updated in DataBase :)";
			}else {
				message = "4. "+customerId+" Exit Time NOT Updated in DataBase :(";
			}
			
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
		
		return message;
	}
	
	public String deleteCustomer(int customerId) {
		
		String message = "NA";
		
		try {
			
			String sql = "delete from Customer where id = ?";
			prepStmt = connection.prepareStatement(sql);
			prepStmt.setInt(1, customerId);
			
			int i = prepStmt.executeUpdate(); // executeUpdate -> will perform SQL insert, update and delete commands
			
			if(i>0) {
				message = "4. "+customerId+" Deleted from DataBase :)";
			}else {
				message = "4. "+customerId+" NOT Deleted from DataBase :(";
			}
			
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
		
		return message;
	}
	
	public void fetchCustomerWithPhone(String phone) {
		try {
			
			String sql = "select * from Customer where phone = ?";
			prepStmt = connection.prepareStatement(sql);
			prepStmt.setString(1, phone);
			
			ResultSet resultSet = prepStmt.executeQuery(); // executeQuery() -> to fetch the data from the DataBase :) 
			
			if(resultSet.next()) {
				
				System.out.println("Customer Found");
				
				Customer customer = new Customer();
				customer.id = resultSet.getInt(1);
				customer.name = resultSet.getString(2);
				customer.phone = resultSet.getString(3);
				customer.email = resultSet.getString(4);
				customer.temperature = resultSet.getFloat(5);
				customer.entryDateTime = resultSet.getString(6);
				customer.exitDateTime = resultSet.getString(7);
				
				System.out.println(customer);
				
			}else {
				System.out.println("Customer Not Found");
			}
			
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
	}
	
	public ArrayList<Customer> fetchAllCustomers() {
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		try {
			
			String sql = "select * from Customer";
			prepStmt = connection.prepareStatement(sql);
			
			ResultSet resultSet = prepStmt.executeQuery(); // executeQuery() -> to fetch the data from the DataBase :) 
			
			while(resultSet.next()) {				
				Customer customer = new Customer();
				customer.id = resultSet.getInt(1);
				customer.name = resultSet.getString(2);
				customer.phone = resultSet.getString(3);
				customer.email = resultSet.getString(4);
				customer.temperature = resultSet.getFloat(5);
				customer.entryDateTime = resultSet.getString(6);
				customer.exitDateTime = resultSet.getString(7);
				
				//System.out.println(customer);
				customers.add(customer);
			}
			
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
		
		return customers;
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
