package com.auribises.model;

// Reference link to understand bson -> https://mongodb.github.io/mongo-java-driver/3.0/bson/
import org.bson.Document;

/*
 	
 	MongoDB Steps:
 	1. Register on mongodb web app -> https://cloud.mongodb.com/
 	2. Create an Oragnization
 	3. Create a Project
 	4. Create Cluster [AWS, GCP, AZURE] -> mumbai as region for india
 	5. In Collections -> you can either load sample data or can create your own database
 	6. In DataBase -> Create Collections and In Collection Create Documents
 					  Collections are analogous to Tables
 					  Documents are analogous to Records
 					  
 					  In MongoDB every data which you wish to save shall be a Document
 					  Document is a HashMap i.e. key value pair :)
 					  
 	MongoDB Connectivity with Java
 	1. In your MongoDB Project go to 
 			Network Access and allow all the ips -> 0.0.0.0/0
 	2. In your MongoDB Project go to
 			Database Access -> and create a user with user name and password
 	3. Download the jar file i.e. library for accessing MongoDB	
 	 	    Link the jar file in your project [mongo-java-driver-3.12.7.jar]
 	 	    https://mvnrepository.com/search?q=mongodb
 	 	    https://mongodb.github.io/mongo-java-driver/
 	4. Copy the Connection Code, from MongoDB Web Console :)
 	5. Write MongoDB CRUD Operation APIs 	    
 	 	    
 	
 */

public class User {

	public String name;
	public String email;
	public String password;
	
	public User() {
		
	}
	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Document toDocument() {
		// Document is a HashMap and is available from library bson
		Document document = new Document();
		
		document.append("name", name);
		document.append("email", email);
		document.append("password", Util.encryptStirng(password));
		
		return document;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}
