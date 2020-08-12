import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		
		// MODEL
		int baseFare = 50;
		int kmCharge = 10;
		
		int distanceTravlled = 7;
		
		int olaMicro = 1;
		int olaMini = 2;
		int olaSedan = 3;
		int olaBike = 4;
		int olaShared = 5;

		int amountToPay = 0;
		
		// VIEW
		System.out.println("=========================");
		System.out.println("Select the Type of Cab:");
		System.out.println("1. OLA MICRO");
		System.out.println("2. OLA MINI");
		System.out.println("3. OLA SEDAN");
		System.out.println("4. OLA BIKE");
		System.out.println("5. OLA SHARED");
		System.out.println("=========================");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your Choice:");
		int choice = scanner.nextInt();
		scanner.close();
		
		switch(choice) {
		
			case 1:
				baseFare += 10;
				amountToPay = baseFare + (kmCharge*distanceTravlled);
				System.out.println("OLA MICRO BOOKED. PLEASE PAY: \u20b9"+amountToPay);
				break;
				
			case 2:
				baseFare += 20;
				amountToPay = baseFare + (kmCharge*distanceTravlled);
				System.out.println("OLA MINI BOOKED. PLEASE PAY: \u20b9"+amountToPay);
				break;
			
			case 3:
				baseFare += 50;
				amountToPay = baseFare + (kmCharge*distanceTravlled);
				System.out.println("OLA SEDAN BOOKED. PLEASE PAY: \u20b9"+amountToPay);
				break;
				
			case 4:
				baseFare += 5;
				amountToPay = baseFare + (kmCharge*distanceTravlled);
				System.out.println("OLA BIKE BOOKED. PLEASE PAY: \u20b9"+amountToPay);
				break;
				
			case 5:
				baseFare += 8;
				amountToPay = baseFare + (kmCharge*distanceTravlled);
				System.out.println("OLA SHARED BOOKED. PLEASE PAY: \u20b9"+amountToPay);
				break;
				
			default:
				System.out.println("Please Select Cab to Porceed");
				break;
				
		}
		
	}

	// Assignment: Integrate PromoCoode Coupon Snippet in this program w.r.t. OLA Ride Booking Program :)
	
}
