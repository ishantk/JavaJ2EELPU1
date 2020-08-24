package com.auribises.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

import com.auribises.model.Restaurant;

// Hibernate APIs
/*
 	SessionFactory 	-> it maintains Session Objects
 		to create SessionFactory Instance StandardServiceRegistry and MedataSources API
 		
 		 
 	Session 		-> Session is connection with the database through Hibernate
 	Transaction 	-> Any CUD Operation in Hibernate is a Transaction
 */

public class DB {
	
	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	
	public DB() {
	
		try {
			
			// Reading hibernate.cfg.xml file and managing the operations in the background
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
			
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
		
		// Obtain Connection to the DataBase
		session = sessionFactory.openSession();
		
		// If we wish to have multiple connections to the database :)
		//session1 = sessionFactory.openSession();
		//session2 = sessionFactory.openSession();
		
		// Obtain Transaction from the Session
		transaction = session.getTransaction();
		
	}

	public void saveObject(Object object) {
	
		transaction.begin();
		session.save(object);
		transaction.commit();
		
		System.out.println("Object Saved");
		
	}
	
	public Restaurant getRestaurant(Integer rid) {
								// get function will execute SQL Statement to fetch Record form DataBase
		Restaurant restaurant = session.get(Restaurant.class, rid);
		return restaurant;
	}
	
	
	public void close() {
		session.close();
		sessionFactory.close();
		System.out.println("Session Closed :)");
	}
	
}
