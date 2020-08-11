// SingleValueContainers are known as PRIMITIVE TYPES
// PRIMITIVE TYPES are the ones which works on VALUES. They Store Values i.e. DATA directly :)
public class SingleValueContainers {

	public static void main(String[] args) {
		
		// Integral
		// 	byte 	8 bits
		//	short	16
		// 	int		32
		// 	long	64
		
		// byte takes 8 bits -> 2 power 8 -> 256 | Range: -128 to 0 to 127 
		
		byte age = 127; 
		//byte age = 128; // error -> number is out of range
		System.out.println("age is: "+age);
		
		// Integral literals can be either 32bit or 64bit
		
		// we can make literals to be of 64 bits by putting l in the end :)
		long salary = 9876543210L;
		
		// Floating Point
		//   float	32bits
		//   double 64 bits
		
		//float pi = 3.14; // error as 3.14 is a literal which will take 64 bit in memory and pi 32 bits
		float pi = 3.14F;  // OK as 3.14f is a literal which will take 32 bit in memory
		double average = 8.3; // OK as 8.3 is 64 bits and so is average
		

		// Logical/Booleans
		// boolean : 8 bits 
		boolean isInternetOn = true;
		isInternetOn = false;
		
		// Characters
		// 16 bits in memory | ASCII (http://www.asciitable.com/) and UNICODES (https://unicode-table.com/en/#0905)
		//char ch = 'A';
		//char ch = 65;
		char ch = '\u0905';
		System.out.println("ch is: "+ch);
		
		// Assignment: Print Your Name in Your Regional Language with unicode table as reference :)
	}

}
