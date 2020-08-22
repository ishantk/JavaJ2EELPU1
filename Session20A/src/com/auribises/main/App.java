package com.auribises.main;

import com.auribises.dao.DB;
import com.auribises.model.Manager;
import com.auribises.model.Restaurant;

public class App {

	public static void main(String[] args) {
		
		Restaurant restaurant = new Restaurant(null, "KFC", "+91 90909 12121", "Mall Road", 4.5, null);
		
		Manager manager = new Manager(null, "Fionna", "+91 98765 11011", "fionna@example.com", null);
		
		// HAS-A Relationship Linking
		restaurant.setManager(manager);
		manager.setRestaurant(restaurant);
		
		DB db = new DB();
		db.saveObject(restaurant); // Saving restaurant will also save manager with RID being same as MID
		db.close();
	}

}
