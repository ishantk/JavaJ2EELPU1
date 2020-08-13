import java.awt.geom.CubicCurve2D;

// 1. Think of an Object
// Order: date, time, customerName, customerEmail, dishes, totalPrice


// 2. Code the Object i.e. Write its Class

class Order{
	
	// Attributes: Property of Object
	// non static attributes:  goes in the object container
	String date;
	String time;
	String customerName;
	String customerEmail;
	String dishes;
	double totalPrice;
	
	// every object will have its own counter attribute :)
	//int counter = 0; // it is within the object
	
	// static will not go in the object i.e. it is not an attribute of object, not a property of object
	// static is Property of class | goes in the class container
	static int counter = 0;
	
	// Default Constructor
	Order(){
		this("NA", "NA", "NA", "NA", "NA", 0);
		counter++;
	}

	// Parameterized Constructor
	Order(String date, String time, String customerName, String customerEmail, String dishes, double totalPrice) {
		counter++; // property of class can be accessed in property of object
		this.date = date;
		this.time = time;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.dishes = dishes;
		this.totalPrice = totalPrice;
	}
	
	// non static method
	// which is property of object
	void showOrderDetails() {
		System.out.println("Order Details:");
		System.out.println("~~~~~~~~~~~~~~");
		System.out.println("Date: "+date+" Time: "+time);
		System.out.println("Name"+customerName+" Email: "+customerEmail);
		System.out.println("Dishes: "+dishes);
		System.out.println("Total Price: \u20b9"+totalPrice);
		System.out.println();
	}
	
	// static method:
	// which is property of class
	static int getOrderObjectCount() {
		// property of class cannot access property of object
		//System.out.println("customer name is: "+customerName); // error
		return counter;
	}
	
}

// static can be accessed from non static but vice versa not possible

public class StaticKeyword {

	public static void main(String[] args) {
		
		// We have created, 3 order objects
		Order o1 = new Order("12th Aug, 2020", "10:00", "John", "john@example.com", "Noodles, Manchurian, Coke", 575.66);
		Order o2 = new Order("12th Aug, 2020", "11:00", "Fionna", "fionna@example.com", "Noodles, Coke", 475.66);
		Order o3 = new Order("12th Aug, 2020", "14:00", "Dave", "dave@example.com", "Burger, Manchurian, Coke", 375.66);
		
		System.out.println("Total Order Objects: "+o1.counter); // this shows the counter value available in class Order
		System.out.println("Total Order Objects: "+o2.counter); // this shows the counter value available in class Order
		System.out.println("Total Order Objects: "+o3.counter); // this shows the counter value available in class Order
		
		System.out.println("Total Order Objects: "+Order.counter);// Right Way to Access
		
		System.out.println("Orders: "+o1.getOrderObjectCount());
		System.out.println("Orders: "+Order.getOrderObjectCount());

	}

}
