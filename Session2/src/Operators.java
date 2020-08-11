
public class Operators {

	public static void main(String[] args) {
		
		// Controller:
		// 1. Mathematical Computations
		// Operators
		
		// 1. Arithmetic Operators
		//   +, -, *, /, %
		
		int data = 36;
		int buckets = 13;
		
		int hashCode = data % buckets;
		System.out.println("HashCode for data is: "+hashCode);
		
		// 2. Assignement Operators
		// +=, -=, *=, /=, %=
		
		//hashCode = hashCode + 2;
		hashCode += 2;		// 22 and 23 line is same :)
		
		System.out.println("hashCode now is: "+hashCode);
		
		hashCode %= 5;

		System.out.println("hashCode finally is: "+hashCode); // 2
		
		// 3. Increment and Decrement
		// ++, --
		hashCode++; // increment value by 1 | Postfix
		++hashCode; // increment value by 1 | Prefix
		++hashCode;
		
		--hashCode;
		hashCode--;
		
		System.out.println("hasCode after increment and decrement is: "+hashCode); // 3
		
		//int result = hashCode++;
		int result = ++hashCode;
		System.out.println("result is: "+result+" and hashCode is: "+hashCode);
		
		int i = 1;
		int j = i++ + ++i + ++i + i;
		System.out.println("i is: "+i+" and j is: "+j); 
		
		// 4. Conditional Operators
		// >, <, >=, <=, ==, !=
		
		int wallet = 300;
		int cabFare = 500;
		
		System.out.println("Can i Book the Cab? "+(wallet >= cabFare));
		
		// 5. Logical Operators
		// &&, ||, !
		
		int promoCode = 101;
		int cartAmount = 570;
		
		System.out.println("Can i get Promotional Off: "+(promoCode == 101 && cartAmount >= 600));
		System.out.println("Can i get Promotional Off: "+(promoCode == 101 || cartAmount >= 600));
		
		// 6. BitWise Operators
		// &, |, ^
		
		int num1 = 8;				//  1 0 0 0
		int num2 = 12;				//  1 1 0 0
		
		int result1 = num1 & num2;  //  1 0 0 0	// 8
		int result2 = num1 | num2;  //  1 1 0 0 // 12
		int result3 = num1 ^ num2;  //  0 1 0 0 // 4
		
		System.out.println("result1 is: "+result1);
		System.out.println("result2 is: "+result2);
		System.out.println("result3 is: "+result3);
		
		// 7. Shift Operators
		// >>, <<, >>>
		
		int num3 = 8; 				// 1 0 0 0
		int num4 = num3 >> 2;		// _ _ 1 0 -> 0 0 1 0 -> 2 | divide the number by 2 power shift
		System.out.println("num4 is: "+num4);
		
		int num5 = num3 << 2;		// 1 0 0 0 _ _ -> 1 0 0 0 0 0 | multiple number by 2 power shift
		System.out.println("num5 is: "+num5);
		
		// Assignment: Explore shift operators on negative numbers
		// >>> works for positive numbers :)
		
		// Misc Operators : as in when we advance
		
		int tResult = (-10 > 2) ? 1 : 0;
		System.out.println("tResult is "+tResult);
	}

}
