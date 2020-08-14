final class AmazonPay{ // final class cannot be extended i.e. no inheritance
	
	final void transact(int pay) { // which cannot be over-rided
		System.out.println("Amount Transacted: \u20b9"+pay);
	}
}

class MyApp{// extends AmazonPay{
	
	/*void transact(int pay) {
		pay += 50;
		System.out.println("Amount Transacted: \u20b9"+pay);
	}*/
	
}



public class FinalKeyword {

	public static void main(String[] args) {

		/*
		int commission = 100;
		commission = 200; // update the data in variable
		*/
		

		// final variables are acting as constants
		final int commission = 100;
		//commission = 200; // updating data in variable is not possible now :)

		//MyApp app = new MyApp();
		//app.transact(500);
		
	}

}
