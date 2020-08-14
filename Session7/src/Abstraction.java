/*
class PaytmPaymentGateway{

	PaytmPaymentGateway(){
		System.out.println("PaytmPaymentGateway Object Constructed");
	}
	
	String tokens = "token1, token2, token3";

	double transactionCharge = 0.02; // This will be a commission to Paytm for any transaction on their portal
	
	void pay(int amount, String accessToken) {
		if(tokens.contains(accessToken)) {
			System.out.println("Payment Transaction Done: \u20b9"+amount);
			double commision = amount * transactionCharge;
			onSuccess(commision, amount-commision);
		}else {
			System.out.println("Payment Transaction Not Done");
			onFailure(101); // 101 means invalid access token
		}
	}
	
	// For Paytm, to implement these functions is no sense :)
	void onSuccess(double commission, double finalAmount) {
		System.out.println("Transaction Was Success");
		System.out.println("We will Charge: \u20b9"+commission+" for transaction ");
		System.out.println("You will be Given a Final Amount of: \u20b9"+finalAmount);
	}
	
	void onFailure(int errorCode) {
		System.out.println("Transaction Was Failed");
	}
	
}*/

/*
abstract class PaytmPaymentGateway{

	PaytmPaymentGateway(){
		System.out.println("PaytmPaymentGateway Object Constructed");
	}
	
	String tokens = "token1, token2, token3";

	double transactionCharge = 0.02; // This will be a commission to Paytm for any transaction on their portal
	
	// children wont be able to re-define it :)
	final void pay(int amount, String accessToken) {
		if(tokens.contains(accessToken)) {
			System.out.println("Payment Transaction Done: \u20b9"+amount);
			double commision = amount * transactionCharge;
			onSuccess(commision, amount-commision);
		}else {
			System.out.println("Payment Transaction Not Done");
			onFailure(101); // 101 means invalid access token
		}
	}
	
	// For Paytm, to implement these functions is no sense :)
	// we can mark the functions as abstract -> they will have no definition
	// They are kind of rules, made by Paytm Payement gateway that children must define these rules :)
	abstract void onSuccess(double commission, double finalAmount);
	abstract void onFailure(int errorCode);
	
}
*/

// interface -> will have no object, neither we not JVM can create its object in memory :)
// 	         -> they are not extended, they are implemented
//				i.e. interfaces are not for inheritance they are for implementation and refining the concept of RTP
//           -> they can be implemented in a multiple fashion 
//				i.e. multiple implementation is supported and its not multiple inheritance
interface PaytmPaymentGateway{

	// error: interfaces cannot have constructors -> as they cannot have objects
	/*PaytmPaymentGateway(){
		System.out.println("PaytmPaymentGateway Object Constructed");
	}
	*/
	
	// variables created here are final and are static
	String tokens = "token1, token2, token3";

	// variables created here are final and are static
	double transactionCharge = 0.02; // This will be a commission to Paytm for any transaction on their portal
	
	// functions must be marked as default, if we wish to define them
	// otherwise functions cannot have definitions
	default void pay(int amount, String accessToken) {
		if(tokens.contains(accessToken)) {
			System.out.println("Payment Transaction Done: \u20b9"+amount);
			double commision = amount * transactionCharge;
			onSuccess(commision, amount-commision);
		}else {
			System.out.println("Payment Transaction Not Done");
			onFailure(101); // 101 means invalid access token
		}
	}
	
	// Functions by default will be public abstract
	void onSuccess(double commission, double finalAmount);
	void onFailure(int errorCode);
	
}

// Rules: abstract class -> cannot have direct objects. i.e. we cannot create objects, BUT JVM will follow rule of inheritance and will create the object
//        abstract function -> can be only created in abstract class
//							   they will have no definition and children must define them

class ZomatoPaymentsPage implements PaytmPaymentGateway{//extends PaytmPaymentGateway{
	
	ZomatoPaymentsPage(){
		System.out.println("ZomatoPaymentsPage Object Constructed");
	}
	
	public void onSuccess(double commission, double finalAmount) {
		System.out.println("Transaction Was Success");
		System.out.println("Thank You for Paying \u20b9"+(commission+finalAmount));
		System.out.println("Your food is on the Way !!");
	}
	
	public void onFailure(int errorCode) {
		System.out.println("Sorry !! Your Payment wasnt a Success");
		System.out.println("Your Order is Confirmed. Please retry your Payment");
	}
}

class SwiggyPaymentsPage implements PaytmPaymentGateway{//extends PaytmPaymentGateway{
	
	SwiggyPaymentsPage(){
		System.out.println("SwiggyPaymentsPage Object Constructed");
	}
	

	public void onSuccess(double commission, double finalAmount) {
		System.out.println("Transaction Was Success");
		System.out.println("Thank You for Paying \u20b9"+(commission+finalAmount));
		System.out.println("We are Sending you Your hunger Bite !!");
	}
	
	public void onFailure(int errorCode) {
		System.out.println("Sorry !! Your Payment wasnt a Success");
		System.out.println("We will book your order on cash. Please confirm in case !!");
	}
}

class OlaPaymentsPage implements PaytmPaymentGateway{//extends PaytmPaymentGateway{
	OlaPaymentsPage(){
		System.out.println("OlaPaymentsPage Object Constructed");
	}
	

	public void onSuccess(double commission, double finalAmount) {
		System.out.println("Transaction Was Success");
		System.out.println("Thank You for Paying \u20b9"+(commission+finalAmount));
		System.out.println("Your CAB is on the Way !!");
	}
	
	public void onFailure(int errorCode) {
		System.out.println("Sorry !! Your Payment wasnt a Success");
		System.out.println("We cant Book a Cab for you. Please Book it on Cash");
	}
}


public class Abstraction {

	public static void main(String[] args) {
		
		// RTP:
		// Ref var of Parent can point to Child Object
		// Ref Var of Interface can point to the Object which implements it
		PaytmPaymentGateway gateway;
		
		gateway = new ZomatoPaymentsPage();
		gateway.pay(1200, "token1");
		
		System.out.println();
		
		gateway = new SwiggyPaymentsPage();
		gateway.pay(400, "token12");
		
		System.out.println();
		
		gateway = new OlaPaymentsPage();
		gateway.pay(200, "token23");
		
		// abstract class cannot have direct objects :)
		//gateway = new PaytmPaymentGateway(); // Direct Object Construction is not a good options
		
		// Interfaces are needed to perform RTP as here we have no much specific requirements for Parent Object
	}

}
