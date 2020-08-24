package com.auribises.main;

import com.auribises.dao.DB;
import com.auribises.model.Burger;
import com.auribises.model.FoodItem;
import com.auribises.model.VeggieBurger;

/*
 	All the classes in the hierachy mapped to a SINGLE TABLE with DISCRIMINATOR
 */

public class InheritanceApp {

	public static void main(String[] args) {
		
		FoodItem item = new FoodItem(null, "Pizza", 300);
		
		Burger burger = new Burger("Spicey Aaloo Tikki", "Tomato and Mayo");
		
		// Parent Object -> FoodItem
		burger.setName("Mc Burger");
		burger.setPrice(50);
		burger.setItemCode(null);
		
		VeggieBurger veggieBurger = new VeggieBurger("Oreganos", 3);
		
		// Parent Object -> Burger
		veggieBurger.setBurgerName("Spicey Paneer Patty");
		veggieBurger.setDressing("Tomato, Mint and Mayo");
		
		// GranParent Object -> FoodItem
		veggieBurger.setName("Mc Paneer");
		veggieBurger.setPrice(200);
		veggieBurger.setItemCode(null);
		
		System.out.println(item);
		System.out.println(burger);
		System.out.println(veggieBurger);
		
		DB db = new DB();
		
		db.saveObject(item);
		db.saveObject(burger);
		db.saveObject(veggieBurger);
		
		db.close();
		
	}

}
