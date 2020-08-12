
public class EnhancedLoop {

	public static void main(String[] args) {
		
		int[] covid19ActiveCases = {148553, 52810, 87597, 79605, 10868, 435613, 13545, 3456};
		
		
		System.out.println("Regular For Loop");
		
		for(int idx=0; idx<covid19ActiveCases.length; idx++) {
			System.out.println(covid19ActiveCases[idx]);
		}
		
		System.out.println();
		
		System.out.println("Enhanced For Loop");
		
		// Enhanced For Loop : do not worry about indexing :)
		// read the data and give it to us and will run from 0th index till the last automatically
		//int i = 0; if we wish to maintain indexing in enhanced for loop
		for(int anyName : covid19ActiveCases) {
			System.out.println(anyName);
			// i++; // if we wish to maintain indexing in enhanced for loop
		}

	}

}
