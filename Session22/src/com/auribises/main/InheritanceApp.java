package com.auribises.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.auribises.beans.FoodItem;
import com.auribises.beans.Pizza;

public class InheritanceApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("inheritance.xml");
		
		//FoodItem item = context.getBean("item", FoodItem.class);
		//System.out.println(item);
		
		Pizza pizza = context.getBean("pizza", Pizza.class);
		System.out.println(pizza);

	}

}
