package com.auribises.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.auribises.dao.DB;
import com.auribises.model.Restaurant;

/*
 
 	Hibernate Procedure:
 	1. Write Model i.e. Structure of Object which you wish to save in DB
 	2. Link Hibernate jars & DB jars:
 		https://mvnrepository.com/artifact/org.hibernate/hibernate-core
 		Download 5.x version as of now :)
 		Also link MySQL jar
 	3. copy hibernate mapping file in your project's src directory
 		ext -> .hbm.xml file -> where we map java object with database
 	4. copy hibernate.cfg.xml -> hibernate configuration file in your project's src directory
 		here we configure details w.r.t. our database
 	5. in Main Class, Use Hibernate API's to perform CRUD Operations
 
 */

public class AdminApp {

	public static void main(String[] args) {
		

		/*Restaurant restaurant1 = new Restaurant(null, "Hot Breads", "+91 99876 99876", "Sarabha Nagar", "Veg", 4.98, "10:00 to 20:00");
		
		Restaurant restaurant2 = new Restaurant();
		restaurant2.setRid(null);
		restaurant2.setName("Table By Basant");
		restaurant2.setAddress("Feroze Gandhi Market");
		restaurant2.setPhone("+91 98091 12345");
		restaurant2.setType("Veg-NonVeg");
		restaurant2.setRatings(5.0);
		restaurant2.setOperatingHours("10:00 to 24:00");
		
		System.out.println(restaurant1);
		System.out.println(restaurant2);*/
	
		DB db = new DB();
		
		//db.saveObject(restaurant1);
		//db.saveObject(restaurant2);
		
		//db.fetchSingleObject(1);
		//db.fetchAllObjects();
		
		//Restaurant restaurant = new Restaurant(1, "Hot Breads", "+91 99999 33333", "Mall Road", "Veg-NonVeg", 4.2, "10:00 to 22:00");
		//db.updateObject(restaurant);
		
		//Restaurant restaurant = new Restaurant();
		//restaurant.setRid(5);
		
		//db.deleteObject(restaurant);
		
		db.close();
		
	}

}
