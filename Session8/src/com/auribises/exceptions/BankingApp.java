package com.auribises.exceptions;

import java.io.IOException; // CHECKED EXCEPTION

// User Defined UnChecked Exception
class MyBankingException extends RuntimeException{
	MyBankingException(String message){
		super(message);
	}
}

//User Defined Checked Exception
class YourBankingException extends Exception{
	YourBankingException(String message){
		super(message);
	}
}

class BankAccount{
	
	int balance;
	int minBalance;
	
	int attempts=0;
	
	BankAccount(){
		balance = 10000;
		minBalance = 2000;
		
		System.out.println("------------------------");
		System.out.println("Welcome to Banking");
		System.out.println("Your Current Balance is: \u20b9"+balance);
		System.out.println("Please Maintain a Min Balance of \u20b9"+minBalance);
		System.out.println("------------------------");
		System.out.println();
	}
	
	void withdraw(int amount) throws IOException, YourBankingException {
		System.out.println("~~~~~~~Withrawl Initiated~~~~~~");
		balance -= amount; // amount will be deducted from balance
		
		if(balance <= minBalance) {
			balance += amount;
			System.out.println("Withdrawl Failed. Balance is Low: \u20b9"+balance);
			
			attempts++;
			
		}else {
			System.out.println("Withdrawl Successful. New Balance is: \u20b9"+balance);
		}
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		
		if(attempts == 3) {
			
			// ArithmeticException is Child of RuntimeException
			// Hence, we are throwing a UNCHEKCED EXCEPTION
			//ArithmeticException aRef = new ArithmeticException("Illegal Attempts: "+attempts);
			//throw aRef; // Throwing an Exception oursleves
			
			// IOException is not Child of RuntimeException but is child of Exception
			// Hence, we are throwing a CHEKCED EXCEPTION
			//IOException iRef = new IOException("Illegal Attempts: "+attempts);
			//throw iRef; // Throwing an Exception oursleves
			
			//MyBankingException mRef = new MyBankingException("Illegal Attempts: "+attempts);
			//throw mRef;
			
			YourBankingException yRef = new YourBankingException("Illegal Attempts: "+attempts);
			throw yRef;
		}
	}
	
}

public class BankingApp {

	public static void main(String[] args) {
		
		System.out.println("Banking App Started");
		
		BankAccount johnsAccount = new BankAccount();
		
		// Transacting for 500 times makes no sense and john is trying to waste Bank's resources
		try {
			for(int i=1;i<=500;i++) {
				johnsAccount.withdraw(3000);
			}
		}catch(Exception e) {
			System.out.println("Some Banking Exception: "+e);
		}
		
		System.out.println("Banking App Finished");
	}

}
