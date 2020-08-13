// class is just a representation of Object :)
class FoodItem{
	// Anything written in the class is Property of Object :)
	String name;
	int quantity;
	int price;
	
	FoodItem(){
		this("NA", 0, 0); // Constructor Chaining -> Executing another constructor from a Constructor
		// this will be used to execute the constructor
	}
	
	FoodItem(String name, int quantity, int price){
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	void showFoodItem() {
		System.out.println("Name: "+name+" Quantity: "+quantity+" Price: "+(quantity*price));
	}
	
	void increment() {
		quantity++;
	}
	
	void decrement() {
		--quantity;
	}
}


public class OOPSQuiz {

	public static void main(String[] args) {
		
		FoodItem item1 = new FoodItem("Veggie Burger", 1, 100);
		FoodItem item2 = new FoodItem("Sandwich", 2, 50);
		FoodItem item3 = item1;
		
		// How many objects will be constructed ? 2
		
		item1.increment();	// i1/i3: 2
		item2.increment();	// i2: 3
		item3.increment();  // i1/i3: 3
		
		item1.increment();  // i1/i3: 4
		item2.decrement();  // i2: 2
		item3.decrement();  // i1/i3: 3
		
		item3.increment();	// i1/i3: 4
		
		item1.showFoodItem();	// Name: Veggie Burger Quantity: 2 Price: ?
		item2.showFoodItem();	// Name: Sandwich Quantity: 2 Price: ?
		item3.showFoodItem();   // Name: Veggie Burger Quantity: 2 Price: ?

		
	}

}
