package com.auribises.io;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/*
 	
 	Stream -> Flow of Data
 	OutputStream -> Data flows from Program into File
 	InputStream -> Data flows from File into Program
 	
 	Java IO Package APIs
 	1. File
 		point to the File in our system
 	2. FileInputStream
 		reads the data as binary
 	3. FileOutputStream
 		writes the data as binary
 	4. FileReader
 		reads the data as text
 	5. FileWriter
 		writes the data as text
 		
 	Binary Files -> Where information is stored as binary -> eg: pptx, pdf, mp3, mp4 etc
 	Text File    -> Where information is stores as text   -> eg: .html, .java, .c, .csv, .txt etc	
 	
 */

// Serializable is known as MarkerInterfcae
// Its a Marker which tells JVM that Objects of Customer can be saved in file
class Customer implements Serializable{// extends Object{ Every class in Java is by default Child of a built in class i.e. Object :)
	
	// Attributes
	String name;
	String phone;
	String email;
	double temperature;
	
	transient String entryDateTime;
	transient String exitDateTime;
	
	Customer(){
		
	}
	
	Customer(String name, String phone, String email, double temperature, String entryDateTime, String exitDateTime) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.temperature = temperature;
		this.entryDateTime = entryDateTime;
		this.exitDateTime = exitDateTime;
	}
	
	// Override toString function of the Parent Class Object here
	public String toString() {
//		String customerDetails = name+","+phone+","+email+","+temperature+","+entryDateTime+","+exitDateTime+"\n";
//		return customerDetails;
		return name+","+phone+","+email+","+temperature+","+entryDateTime+","+exitDateTime+"\n";
	}
}

class FileIOOperations{
	
	void saveDataInFile(String data) {
		try {
			
			File file = new File("/users/ishantkumar/Downloads/customers-17-aug-2020.csv");
			//if(file.exists())
			
			// Performs File IO Operations by writing data as bytes :)
			//FileOutputStream stream = new FileOutputStream(file); // it will over-write the data in the file
			FileOutputStream stream = new FileOutputStream(file, true); // appends the data in the file
			stream.write(data.getBytes());
			System.out.println("Data Saved in File "+file.getName());
			stream.close();
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
			e.printStackTrace(); // this function will give us the line number as well where exception came in
		}
	}
	
	void saveDataInFileAgaian(String data) {
		try {
			
			File file = new File("/users/ishantkumar/Downloads/customers-18-aug-2020.csv");
			//if(file.exists())
			
			// Performs File IO Operations by writing data as text :)
			//FileWriter writer = new FileWriter(file); // it will over-write the data in the file
			FileWriter writer = new FileWriter(file, true); // appends the data in the file
			writer.write(data);
			System.out.println("Data Saved in File "+file.getName());
			writer.close();
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
			e.printStackTrace(); // this function will give us the line number as well where exception came in
		}
	}
	
	void readDataFromFile() {
		try {
			
			File file = new File("/users/ishantkumar/Downloads/customers-17-aug-2020.csv");
			
			// reads the data as bytes
			FileInputStream stream = new FileInputStream(file);
			
			int data = 0;
			
			while((data = stream.read()) != -1) {
				System.out.print((char)data);
			}
			
			stream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void readDataFromFileAgain() {
		try {
			
			File file = new File("/users/ishantkumar/Downloads/customers-18-aug-2020.csv");
			FileReader reader = new FileReader(file);			// char by char
			BufferedReader buffer = new BufferedReader(reader); // line by line
			
			String line = "";
			
			while((line = buffer.readLine()) != null) {
				System.out.println(line);
			}
			
			buffer.close();
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// serialization is to save object in a file
	void serialization(Customer customer) {
		try {
			
			File file = new File("/users/ishantkumar/Downloads/"+customer.phone+".txt");
			
			FileOutputStream stream = new FileOutputStream(file);
			
			ObjectOutputStream objectStream = new ObjectOutputStream(stream);
			objectStream.writeObject(customer);
			
			System.out.println("Object Saved in "+file.getName());
			
			objectStream.close();
			stream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// deserialization is to read object from a file into java program as object
	void deserialization(String phone) {
		try {
			
			File file = new File("/users/ishantkumar/Downloads/"+phone+".txt");
			
			FileInputStream stream = new FileInputStream(file);
			
			ObjectInputStream objectStream = new ObjectInputStream(stream);
			
			Customer customer = (Customer)objectStream.readObject();
			System.out.println(customer);
			
			objectStream.close();
			stream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

public class CMSApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		FileIOOperations io = new FileIOOperations();
		
		while(true) {
			
			System.out.println("-----------------------------------------");
			System.out.println("Welcome to CMS App");
			System.out.println("1. Add Customer");
			System.out.println("2. Show All Customers");
			System.out.println("3. Mark Exit for Customer");
			System.out.println("4. Show Customer by Phone");
			System.out.println("5. See Customers with time spent > 30 mins");
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
					
					Date date = new Date(); // Date Object which is the time-stamp of our system
					cRef.entryDateTime = date.toString();
					cRef.exitDateTime = "NA";
					
					System.out.println("customer is:");
					System.out.println(cRef); // whenever we print reference variable toString method from Object class is executed automatically
					//System.out.println(cRef.toString()); // we have no toString in Customer class and we are executing it ? as it is thr in the Parent Class Object
					
					scanner.nextLine();
					
					System.out.println("Would You Like to Add Customer "+cRef.name+" ? (yes/no)");
					String save = scanner.nextLine();
					if(save.equals("yes")) {
						
						// Persistence -> Save the State of an Object
						// 1. Files
						// 2. DataBase -> Local/Cloud :)
						
						String data = cRef.toString();
						//io.saveDataInFile(data);
						//io.saveDataInFileAgaian(data);
						
						io.serialization(cRef);
						
						System.out.println("Customer Saved in File");
						
					}else {
						System.out.println("Thank You For Using CMS App :)");
					}
					
					break;
					
				case 2:
					//io.readDataFromFile();
					io.readDataFromFileAgain();
					break;
					
				case 3:
					
					break;
					
				case 4:
					System.out.println("Enter Customer Phone: ");
					String customerPhone = scanner.nextLine();
					io.deserialization(customerPhone);
					break;
					
				case 5:
					
					break;
									
				default:
					System.out.println("Invalid Choice");
					break;
			}
			
		}
		
		scanner.close();
		
	}

}

// Assignment: Implement Point# 3, 4, and 5 :)
