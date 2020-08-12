
public class ArraySyntaxes {

	public static void main(String[] args) {
		
		// We create the Array along with elements
		
		// Implicit Syntax:
		int[] a1 = {10, 20, 30, 40, 50}; // bracket before	// -> compiler puts new int[] for us in the background
		int a2[] = {10, 20, 30, 40, 50}; // bracket after
		
		System.out.println("a1 is: "+a1); // hash code 1
		System.out.println("a2 is: "+a2); // hash code 2
		
		// Explicit Sytnax
		int[] a3 = new int[]{10, 20, 30, 40, 50}; // bracket before
		int a4[] = new int[]{10, 20, 30, 40, 50}; // bracket after
		
		// new is operator in Java which will create int[] in the Heap area dynamically 
		
		// Array Element Update
		a4[1] = 111;
		a2[2] = 222;
		
		// We can create Arrays without elements by specifying the Size
		int[] a5 = new int[5]; // 5 elements in array, but all of them a re by default 0 initially
		a5[0] = 11;
		//System.out.println(a5[0]);
		//System.out.println(a5[1]);
		for(int element : a5) {
			System.out.print(element+"  ");
		}
		System.out.println();
		
		int a6[], a7[], a8;
		a6 = new int[5];	// a6 is reference to int[]
		a7 = new int[10];	// a7 is reference to int[]
		a8 = 100; // a8 is int
		
		int[] a9, a10; // // a9 and a10 are reference to int[]
		a9 = new int[10];
		a10 = new int[15];
		

	}

}
