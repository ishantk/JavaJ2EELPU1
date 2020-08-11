// Java Program means a Java Class
// public or non public as of now no concern :)

/*
 
 Amazon eCommerce Grand Sale
	SBI : 10% Discount -> Card Usage
		  1. HomeAndKitchen
		  2. MobileDevice

	Problem Statement:
	where SBI should advertise in an offline manner	to sell credit cards more by putting up a stall :)
		   
	HomeAndKitchen	 		discount   
	day1Sales -> 223451		10%
	day2Sales -> 323452		10%
	day3Sales -> 423459	 	10% 
	
	MobileDevice			discount   
	day1Sales -> 1223451	10%
	day2Sales -> 2323452	10%
	day3Sales -> 3423459	10%  
 
 Problems are Mathematical Always
 
 	MODEL
 		Data Storage Containers -> Focus on Storing Data which we will process to solve the problem
 			1. Single Value Containers
 				instagram user id
 			2. Multi Value Containers
 				Homo	: Same type of data			| album of images on instagram
 				Hetro   : different type of data    | album of images & videos on instagram
 				
 			ShoppingCart on Amazon is a Storage Container
 			
 			Storage Containers -> 1. Fixed Size i.e. in memory they will take a particular amount of memory which is pre-defined
 									 This cannot be altered
 									 static storage containers whose sizes cannot be altered
 								  2. Variable Size i.e. memory can increase or decrease as per our requirements
 								  	 dynamic storage containers whose size cannot be altered
 	VIEW
 		User Interface i.e. where user can give data as input or we process data and show the output
 		Web, Mobile, Desktop, CommandLine
 	CONTROLLER
 		Logical Processing on Data
 		1. Computation		 -> Mathematical Operations
 		2. Conditional Flows -> Taking the decision
 		3. Iterations        -> Doing something again and again
 
 */

public class SBIAmazonProblem {

	// main is a function
	// but in OOPS terminology, main is method :)
	// main will be executed and whatever we write in main will be executed
	public static void main(String[] args) {
		
		// MODEL: Data Storage Container
		
		// 1. Data Storage Container Creation
		// int day1SalesHK is variable or storage container name
		// 223451 is literal or constant
		int day1SalesHK = 223451;
		int day2SalesHK = 323452;
		int day3SalesHK = 423459;
		
		// int -> is a storage container which shall take 32 bits of size in memory
		
		int day1SalesMD = 1223451;
		int day2SalesMD = 2323452;
		int day3SalesMD = 3423459;
		
		// 2. Update Container Data
		day3SalesHK = 516789;
		
		// VIEW: UI -> Textual UI i.e. Command/Console Based UI
		// 3. Read the data from Storage Container
		System.out.println("Home and Kitchen 3 Day Sale:");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("day1SalesHK: "+day1SalesHK);
		System.out.println("day2SalesHK: "+day2SalesHK);
		System.out.println("day3SalesHK: "+day3SalesHK);
		
		System.out.println();
		
		System.out.println("Mobile Device 3 Day Sale:");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("day1SalesMD: "+day1SalesMD);
		System.out.println("day2SalesMD: "+day2SalesMD);
		System.out.println("day3SalesMD: "+day3SalesMD);
		
		// PS: Model cannot be deleted from memory by Us. It will be deleted automatically when program i.e main will finish :)
		
		// CONTROLLER: Logical Processing on Data -> Mathematical Computations
		int totalSalesHK = day1SalesHK + day2SalesHK + day3SalesHK;
		int totalSalesMD = day1SalesMD + day2SalesMD + day3SalesMD;
		
		System.out.println();
		
		// Display Sales
		System.out.println("Home and Kitchen 3 Day TOTAL Sale: "+totalSalesHK);
		System.out.println("Mobile Device 3 Day TOTAL Sale: "+totalSalesMD);
		
		// Compute Discounts
		double totalDiscountHK = 0.10 * totalSalesHK;
		double totalDiscountMD = 0.10 * totalSalesMD;
		
		// Display Discounts
		System.out.println("Home and Kitchen 3 Day TOTAL Discounts by SBI : "+totalDiscountHK);
		System.out.println("Mobile Device 3 Day TOTAL Discounts by SBI : "+totalDiscountMD);
		
		System.out.println();
		
		System.out.println("Final OutCome: ");
		
		if(totalSalesHK > totalSalesMD) {
			System.out.println("SBI must put Stall in Home and Kitchen Applicance Shops");
		}else {
			System.out.println("SBI must put Stall in Mobile Shops");
		}
		
		if(totalDiscountHK > totalDiscountMD) {
			System.out.println("SBI Gave More Discount for Home and Kitchen Sales by "+(totalDiscountHK - totalDiscountMD));
		}else {
			System.out.println("SBI Gave More Discount for Mobile Devices Sales by "+(totalDiscountMD - totalDiscountHK));
		}
		

	}

}
