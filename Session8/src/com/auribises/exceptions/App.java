package com.auribises.exceptions;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Welcome to our App");
		
		int[] cashBacks = {100, 50, 70, 80, 90, 150, 99, 10, 8, 12};
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your Lucky Number to Win a CashBack: ");
		int luckyNumber = scanner.nextInt();
		scanner.close();
		
		int additionalCashBack = 0;
		
		try {
			System.out.println("You have Won a CashBack of \u20b9"+cashBacks[luckyNumber]);
			additionalCashBack = cashBacks[luckyNumber]/luckyNumber;
			System.out.println("We have an additional CashBack for You: \u20b9"+additionalCashBack);
		}/*catch(ArrayIndexOutOfBoundsException aRef) {
			System.out.println("Some Array Index Exception: "+aRef);
		}catch(ArithmeticException aRef) {
			System.out.println("Sorry! No Additional Cashback for You");
			System.out.println("Some Arithmetic Exception: "+aRef);
		}*/
		catch(Exception e) { // RTP: e can point to an Exception Child Object
			System.out.println("Some Exception: "+e);
		}finally { // either exception is handled or not :)
			System.out.println("This is suppose to be executed at any cost. finally :)");
		}
		
		
		System.out.println("Thank You for using our App");

	}

}

// Graceful Termination of App: our main method will execute all the statements without any error at run time
// Abnoraml Termination of App: our main method will crash, i.e. some error will occur and program will terminate from that line number itself
//								Unfortunately, Application has stopped Working
//								Error at Runtime -> Exception :)
// try, catch and finally
/*
 	try{
 	
 	} // error
 	
 	
 	try{
 	
 	}catch(){
 	
 	}
 	
 	try{
 	
 	}finally(){
 	
 	}
 	
 	try{
 	
 	}catch(){
 	
 	}finally{
 	
 	}
 	
 	try{
 		try{
 	
	 	}catch(){
	 	
	 	}finally{
	 	
	 	}
 	}catch(){
 	 	try{
 	
	 	}catch(){
	 	
	 	}finally{
	 	
	 	}
 	}finally{
 	 	try{
 	
	 	}catch(){
	 	
	 	}finally{
	 	
	 	}
 	}
 	
 */

/*
 	
 	Java Exception Hierarchy
 	
 	Throwable
 		> Exception
 			linked with some errors at runtime in our code and can be handled with try, catch, finally
 			> RuntimeException						
 				> ArithmeticException
 				> ArrayIndexOutOfBoundsException
 				> NullPointerException
 				.
 				...
 			> IOException
 				> FileNotFoundException
 				.
 				...
 			> SQLException
 				.
 				..
 				....
 			.
 			..
 			...
 		> Error
 			linked with memory and JVM
 			we cannot handle this error
 	
 	
 		UNCHECKED EXCEPTIONS: Which are not checked by compiler
 		RuntimeException Class and its Children are known as UNCHECKED EXCEPTIONS
 		
 		CHECKED EXCEPTIONS: Which are checked by compiler
 		Other than RuntimeException Class and its Children everyone is CHECKED EXCEPTION
 		
 		Exception is Parent to All the Exceptions and hence as per RTP
 		Ref var of Parent Exception can point to any Child Object
 	
 */










