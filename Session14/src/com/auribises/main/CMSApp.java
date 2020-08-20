package com.auribises.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.auribises.dao.DB;
import com.auribises.model.Customer;


public class CMSApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		DB db = new DB();
		db.createConnection();
		
		while(true) {
			
			System.out.println("-----------------------------------------");
			System.out.println("Welcome to CMS App");
			System.out.println("1. Add Customer");
			System.out.println("2. Show All Customers");
			System.out.println("3. Mark Exit for Customer");
			System.out.println("4. Show Customer by Phone");
			System.out.println("5. Delete Customer by ID");
			System.out.println("5. Delete Customer by Phone");
			System.out.println("6. See Customers with time spent > 30 mins");
			System.out.println("7. Execute Batch");
			System.out.println("0. Exit the App");
			System.out.println("-----------------------------------------");
			
			System.out.println();
			
			System.out.println("Enter Your Choice: ");
			int choice = scanner.nextInt();
			
			if(choice == 0) {
				System.out.println("Thank You For Using CMS APP :)");
				break;
			}
			
			scanner.nextLine();
			
			switch (choice) {
				case 1:
					Customer cRef = new Customer();
					
					System.out.println("Enter Customer Name: ");
					cRef.name = scanner.nextLine();
					
					System.out.println("Enter Customer Phone: ");
					cRef.phone = scanner.nextLine();
					
					System.out.println("Enter Customer Email: ");
					cRef.email = scanner.nextLine();
					
					System.out.println("Enter Customer Temperature: ");
					cRef.temperature = scanner.nextDouble();
					
					Date date = new Date(); 
					cRef.entryDateTime = date.toString();
					cRef.exitDateTime = "NA";
					
					System.out.println("customer is:");
					System.out.println(cRef); 
					
					scanner.nextLine();
					
					System.out.println("Would You Like to Add Customer "+cRef.name+" ? (yes/no)");
					String save = scanner.nextLine();
					if(save.equals("yes")) {
						//String message = db.addCustomer(cRef);
						//System.out.println(message);
						db.executeProcedureInDB(cRef);
					}else {
						System.out.println("Thank You For Using CMS App :)");
					}
					
					break;
					
				case 2:
					ArrayList<Customer> customers = db.fetchAllCustomers();
					customers.forEach((customer)->System.out.println(customer));
					break;
					
				case 3:
				
					String exitDateTime = new Date().toString();
					
					System.out.println("Enter Customer ID: ");
					int customerId = scanner.nextInt();
					String message = db.markExit(exitDateTime, customerId);
					System.out.println(message);
					
					break;
					
				case 4:
					System.out.println("Enter Customer Phone: ");
					String phone = scanner.nextLine();
					db.fetchCustomerWithPhone(phone);
					break;
					
				case 5:
					System.out.println("Enter Customer ID: ");
					customerId = scanner.nextInt();
					
					message = db.deleteCustomer(customerId);
					System.out.println(message);
					
					break;
					
					
				case 6:
						
					break;
					
				case 7:
					db.executeBatchTransaction();
					break;	
									
				default:
					System.out.println("Invalid Choice");
					break;
			}
			
		}
		
		db.closeConnection();
		scanner.close();

	}

}

// Assignment: Finish the remaining parts of our App
//			   Try Implementing more functionalities :)
//			   Statistics of how many customers came on a particular day :)
//			   How many customers available in some date time range ?
//			   Explore MetaData in JDBC :)
