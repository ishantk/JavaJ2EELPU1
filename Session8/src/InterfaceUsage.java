interface Notification{
	void notifyWithMessage(String message);
}

// Subscription for getting some notifications
class User implements Notification{
	
	String name;
	String phone;
	String email;
	
	User(){
		
	}
	
	User(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	void showUserDetails() {
		System.out.println("User Details:");
		System.out.println(name+" | "+phone+" | "+email);		
	}
	
	public void notifyWithMessage(String message) {
		System.out.println("----New Notification Received---");
		System.out.println("Dear, "+name);
		System.out.println("New Message: "+message);
		System.out.println("--------------------------------");
		System.out.println();
	}
}

class Order{
	
	// We may have many more attributes :)
	
	int state = -1; //  0: Order Cancelled, 1: Order Placed, 2: Order Picked Up, 3: Order Delivered
	String[] messages = {"Order Cancelled", "Order Placed", "Order Picked Up", "Order Delivered"};
	
	// reference variable to Notification interface
	// it will point to some Object which implements Notification Interface
	Notification notification;
	
	Order(){
		
	}
	
	void registerUserForNotifications(Notification notification) {
		this.notification = notification;
		notification.notifyWithMessage(messages[1]);
	}
	
	void changeOrderState(int state) {
		notification.notifyWithMessage(messages[state]);
	}
	
}

class DeliveryAgent{
	
	Order order; // Has-An Order
	
}


public class InterfaceUsage {

	public static void main(String[] args) {
		
		//Notification nRef = new User(); // RTP Statement
		
		User user = new User("John", "+91 98765 12345", "john@example.com");
		
		Order order = new Order();

		DeliveryAgent agent = new DeliveryAgent();
		agent.order = order; // Link the Order Object to the Delivery Agent
		
		// We are assuming that user has placed the order :)
		order.registerUserForNotifications(user); // We are managing RTP here
		
		System.out.println();
		System.out.println("Delivery Agent Has Reached the Restaurant and Picked Up The Order");
		System.out.println();
		
		agent.order.changeOrderState(2);
		
		System.out.println();
		System.out.println("Delivery Agent Has Reached the User's Location and Delivered the Food Item");
		System.out.println();
		
		agent.order.changeOrderState(3);
		
		
		
	}

}
