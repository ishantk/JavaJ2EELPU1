package com.auribises.dao;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.auribises.model.User;
import com.auribises.model.Util;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DB {
	
	MongoDatabase database;
	MongoCollection<Document> collection;
	
	public DB() {
	
		MongoClientURI uri = new MongoClientURI(Util.URI);
		
		MongoClient mongoClient = new MongoClient(uri);
		database = mongoClient.getDatabase(Util.DB_NAME);
		
		// Reference to Users Collection
		collection = database.getCollection(Util.COLLECTION_USERS);
	}
	
	public String addUserToCollection(User user) {
		collection.insertOne(user.toDocument());
		return "Dear, "+user.name+" You are registered Successfully on "+user.registeredOn;
	}
	
	public void fetchUserFromCollection(String where, String what) {
		System.out.println(collection.find(eq(where, what)).first().toJson());
	}
	
}
