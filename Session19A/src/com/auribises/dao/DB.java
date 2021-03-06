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
		
		// Obtain Transaction from the Session
		transaction = session.getTransaction();
		
	}

	public void saveObject(Object object) {
	
		transaction.begin();
		session.save(object);
		transaction.commit();
		
		System.out.println("Object Saved");
		
	}
	
	public void fetchSingleObject(Integer id) {
		Restaurant restaurant = session.get(Restaurant.class, id);
		System.out.println(restaurant);
		restaurant.showRestaurant();
	}
	
	public void fetchAllObjects() {
		//String hql = "From Restaurant";
		//String hql = "From Restaurant where ratings > 4.8";
		
		//List<Restaurant> restaurants = session.createQuery(hql).list();
		
		// Explore new API against createCriteria here :)
		Criteria criteria = session.createCriteria(Restaurant.class);
		criteria.add(Restrictions.gt("ratings", 4.8));
		
		List<Restaurant> restaurants = criteria.list();
		
		// Iterate in List of Restaurants
		restaurants.forEach((restaurant) -> restaurant.showRestaurant());
		
	}
	
	public void updateObject(Restaurant object) {
		transaction.begin();
		session.update(object);
		transaction.commit();
		System.out.println("Object Updated in DataBase");
	}
	
	public void deleteObject(Restaurant object) {
		transaction.begin();
		session.delete(object);
		transaction.commit();
		System.out.println("Object Deleted From DataBase");
	}
	
	public void close() {
		session.close();
		sessionFactory.close();
		System.out.println("Session Closed :)");
	}
	
}
