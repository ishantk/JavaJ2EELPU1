package com.auribises.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.auribises.model.User;
import com.auribises.model.Util;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

public class DB {
	
	MongoDatabase database;
	MongoCollection<Document> collection;
	
	public DB() {
	
		MongoClientURI uri = new MongoClientURI(Util.URI);
		
		MongoClient mongoClient = new MongoClient(uri);
		database = mongoClient.getDatabase(Util.DB_NAME);
		
		database.listCollectionNames().cursor().forEachRemaining((String name) -> System.out.println(name));
		
		// Reference to Users Collection
		collection = database.getCollection(Util.COLLECTION_USERS);
	}
	
	public void addUserToCollection(User user) {
		collection.insertOne(user.toDocument());
		System.out.println(user.name+" Added in DataBase");
	}
	
	public void addManyUsers(List<Document> documents) {
		collection.insertMany(documents);
		System.out.println(documents.size()+" Documents Inserted");
	}
	
	public void fetchAllDocuments() {
		System.out.println(collection.count()); // to get the count of documents in collection if we dont want to to fetch all
		collection.find().cursor().forEachRemaining((Document doc)->System.out.println(doc.toJson()));
	}
	
	public void fetchUser(String where, String what) {
		System.out.println(collection.find(eq(where, what)).first().toJson());
	}
	
	public void updateUser(String where, String what, String newWhat) {
		collection.updateOne(eq(where, what), new Document("$set", new Document(where, newWhat)));
		System.out.println("User Updated");
	}

	public void deleteUser(String where, String what) {
		collection.deleteOne((eq(where, what)));
		System.out.println("Document Deleted");
	}
	
}
