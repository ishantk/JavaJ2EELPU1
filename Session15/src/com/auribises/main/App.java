package com.auribises.main;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.auribises.dao.DB;
import com.auribises.model.User;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to MongoDB Demo");
		
		//User user = new User("Lee", "lee@example.com", "pass@123");
		//System.out.println(user);
		
		List<Document> documents = new ArrayList<Document>();
		documents.add(new User("Jennie", "jennie@example.com", "jennie123").toDocument());
		documents.add(new User("Jack", "jack@example.com", "jack123").toDocument());
		documents.add(new User("Jim", "jim@example.com", "jim123").toDocument());
		documents.add(new User("Joe", "joe@example.com", "joe123").toDocument());
		documents.add(new User("Kim", "kim@example.com", "kim123").toDocument());
		
		DB db = new DB();
		//db.addUserToCollection(user);
		
		//db.addManyUsers(documents);
		
		//db.fetchAllDocuments();
		
		//db.fetchUser("email", "jim@example.com");
		//db.updateUser("email", "jim@example.com", "jim.watson@example.com");
		db.deleteUser("email", "jim.watson@example.com");
	}
	
}

// Assignment: replicate CMSApp with MongoDB :)
