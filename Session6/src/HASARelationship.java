// 1. Think of an Object
//    Restaurant: name, phone, address, description, ratings, operatingHours
//    Menu      : title, numOfDishes
//    Dish		: name, ratings, price

//    Write Relationship between the objects
//	  Restaurant HAS-A Menu | 1 to 1
//    Menu HAS Dishes       | 1 to many

// 2. Code Objects i.e. Write class
class Restaurant{
	
	// Attributes: non static and hence, property of object
	String name;
	String phone;
	String address;
	String description;
	double ratings;
	String operatingHours;
	
	// Has-A Relationship | 1 to 1
	Menu menu; // Reference to the Menu Object
	
	Restaurant(){
		// code nothing here means, default data as nulls and 0s for attributes ..
	}
	
	Restaurant(String name, String phone, String address, String description, double ratings, String operatingHours,
			Menu menu) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.description = description;
		this.ratings = ratings;
		this.operatingHours = operatingHours;
		this.menu = menu;
	}
	
	void showRestaurant() {
		System.out.println("**************************");
		System.out.println(name);
		System.out.println(address+" | "+phone);
		System.out.println(description);
		System.out.println(ratings+" | "+operatingHours);
		
		menu.showMenu();
		
		System.out.println("*************************");
	}
	
}

class Menu{
	
	String title;
	int numOfDishes;
	
	// HAS-A Relationship | 1 to many
	Dish[] dishes;		// Reference to Array of Dish Objects
	
	Menu() {
		
	}

	Menu(String title, int numOfDishes, Dish[] dishes) {
		this.title = title;
		this.numOfDishes = numOfDishes;
		this.dishes = dishes;
	}
	
	void showMenu() {
		System.out.println("^^^^^^^^^^^^^^^^");
		System.out.println("MENU DETAILS:");
		System.out.println(title+"["+numOfDishes+"]");
		
		System.out.println("DISHES IN MENU:");
		
		for(Dish dish : dishes) { // Enhanced For Loop
			dish.showDish();
		}
		
		System.out.println("^^^^^^^^^^^^^^^^");
	}
	
}

class Dish{
	
	String name;
	double ratings;
	double price;
	
	Dish(){
		
	}

	Dish(String name, double ratings, double price) {
		this.name = name;
		this.ratings = ratings;
		this.price = price;
	}
	
	void showDish() {
		System.out.println("------------------");
		System.out.println("Name: "+name);
		System.out.println("\u20b9"+price+" | "+ratings);
		System.out.println("------------------");
	}
	
}

public class HASARelationship {

	public static void main(String[] args) {
		
		Dish dish1 = new Dish("Red Valvet Cake", 4.5, 500.22);
		Dish dish2 = new Dish("Black Forest Cake", 5.0, 400.45);
		Dish dish3 = new Dish("Veg Tahli", 4.2, 200.0);
		
		// Array of Dishes
		Dish[] dishes = {dish1, dish2, dish3};
		
		Menu menu = new Menu("Gopal's Veg Menu", dishes.length, dishes);
		//menu.showMenu();
		
		Restaurant restaurant = new Restaurant("Gopal Sweets", "+91 99999 11111", "Sarabha Nagar", "Mithai, Snacks, Indian, Chinese", 4.5, "10:00 to 20:00", menu);
		
		restaurant.showRestaurant();
	}

}
