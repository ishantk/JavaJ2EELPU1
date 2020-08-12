
public class Overloading {

	// Overloading : Same Method Name with Different i.e. Unique Inputs
	
	/*
	void processBankingPayment(String userName, String password, int amountToPay) {
		System.out.println(">> ONLINE BANKING PAYMENT");
		System.out.println(">> Processing Payment for User: "+userName);
		System.out.println(">> Thank You for making a Payment of: "+amountToPay);
		System.out.println();
	}
	
	void processCardPayment(String cardNumber, int cvv, int amountToPay) {
		System.out.println(">> ONLINE CARD PAYMENT");
		System.out.println(">> Processing Payment for Card: "+cardNumber);
		System.out.println(">> Thank You for making a Payment of: "+amountToPay);
		System.out.println();
	}
	
	void processUPIPayment(String upi, int amountToPay) {
		System.out.println(">> ONLINE UPI PAYMENT");
		System.out.println(">> Processing Payment for UPI: "+upi);
		System.out.println(">> Thank You for making a Payment of: "+amountToPay);
		System.out.println();
	}*/
	
	/*
	 	Overloading is simplifying the usage for us in execution of function
	 	Rules:
	 	1. Method Name must be Same
	 	2. Inputs must be different
	 	3. Return Type has no role to play
	 	
	 	
	 	Polymorphism: Compile Time
	 	// Same method can do different operations for us :)
	 	
	 */

	void processPayment(String userName, String password, int amountToPay) {
		System.out.println(">> ONLINE BANKING PAYMENT");
		System.out.println(">> Processing Payment for User: "+userName);
		System.out.println(">> Thank You for making a Payment of: "+amountToPay);
		System.out.println();
	}
	
	void processPayment(String cardNumber, int cvv, int amountToPay) {
		System.out.println(">> ONLINE CARD PAYMENT");
		System.out.println(">> Processing Payment for Card: "+cardNumber);
		System.out.println(">> Thank You for making a Payment of: "+amountToPay);
		System.out.println();
	}
	
	void processPayment(String upi, int amountToPay) {
		System.out.println(">> ONLINE UPI PAYMENT");
		System.out.println(">> Processing Payment for UPI: "+upi);
		System.out.println(">> Thank You for making a Payment of: "+amountToPay);
		System.out.println();
	}
	
	// JVM wont create the Object of Overloading class to execute the main method
	// JVM uses class name and executes the main method
	public static void main(String[] args) { // static -> it can be accessed with class name
		
		Overloading oRef = new Overloading();
		
		/*oRef.processBankingPayment("john.watson", "john@12345", 1000);
		oRef.processCardPayment("4566 6789 1345 1111", 234, 1500);
		oRef.processUPIPayment("fionna@paytm", 2000);*/
		
		oRef.processPayment("john.watson", "john@12345", 1000);
		oRef.processPayment("4566 6789 1345 1111", 234, 1500);
		oRef.processPayment("fionna@paytm", 2000);

	}

}
