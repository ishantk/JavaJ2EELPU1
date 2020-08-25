package com.auribises.dp;

import java.util.Scanner;

interface FoodItem{
	int getPrice();
	String getDescription();
}

class VeggieBurger implements FoodItem{

	public int getPrice() {
		return 100;
	}

	public String getDescription() {
		return "Veggie Burger with Cheese and Spices";
	}
	
}

abstract class FoodItemDecorator implements FoodItem{
	
	FoodItem item;
	
	FoodItemDecorator(FoodItem item){
		this.item = item;
	}
	
	public int getPrice() {
		return item.getPrice();
	}

	public String getDescription() {
		return item.getDescription();
	}
	
}

class BurgerMeal extends FoodItemDecorator{
	
	BurgerMeal(FoodItem item){
		super(item);
	}
	
	public int getPrice() {
		return item.getPrice() + 80;
	}

	public String getDescription() {
		return item.getDescription()+" [Converted to a Meal with Fries and Coke]";
	}
	
}

public class DecoratorApp {

	public static void main(String[] args) {
		

		VeggieBurger burger = new VeggieBurger();
		System.out.println("********************");
		System.out.println("Burger Details:");
		System.out.println(burger.getDescription());
		System.out.println(burger.getPrice());
		System.out.println("********************");
		
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to convert your burger into a Meal");
		String choice = scanner.nextLine();
		
		if(choice.equals("yes")) {
			BurgerMeal meal = new BurgerMeal(burger); // Object Decoration
			
			System.out.println(meal.getDescription());
			System.out.println(meal.getPrice());
		}
		
		scanner.close();
	}

}
