
public class ArrayTypes {

	public static void main(String[] args) {
		
		// Data for 5 states for 3 days..
		// Array: 1-D Array
		int[] covid19IndiaCases9Aug = {135076, 134513, 23521, 12341, 4567};
		int[] covid19IndiaCases10Aug = {235076, 234513, 33521, 22341, 5567};
		int[] covid19IndiaCases11Aug = {335076, 334513, 43521, 32341, 6567};
		
		
		// Challenge: For n-number of days we need to write n-numbers of Arrays
		// Solution: Array of Arrays
		// 2-D Array
		
		int[][] covid19IndiaCasesAug = {
				// 0        1      2      3     4
				{135076, 134513, 23521, 12341, 4567},	// 0 
				{235076, 234513, 33521, 22341, 5567},	// 1
				{335076, 334513, 43521, 32341, 6567},	// 2
				{335076, 334513, 43521}					// 3
		};
		
		System.out.println("covid19IndiaCases9Aug: "+covid19IndiaCases9Aug);				// HashCode
		System.out.println("covid19IndiaCases9Aug length: "+covid19IndiaCases9Aug.length);	// 5
		
		System.out.println();
		
		System.out.println("covid19IndiaCasesAug: "+covid19IndiaCasesAug);					// HashCode
		System.out.println("covid19IndiaCasesAug length: "+covid19IndiaCasesAug.length);	// 4
		
		for(int i=0;i<covid19IndiaCasesAug.length;i++) {
			System.out.println("covid19IndiaCasesAug["+i+"] is: "+covid19IndiaCasesAug[i]);
		}
		
		System.out.println("covid19IndiaCasesAug[0][1]: "+covid19IndiaCasesAug[0][1]);	// 134513
		
		System.out.println("covid19IndiaCasesAug data:");
		for(int i=0;i<covid19IndiaCasesAug.length;i++) { // i: 0, 1, 2 and 3
			
			// when i is 0:, j-> 0, 1, 2, 3, 4 | covid19IndiaCasesAug[0].length -> 5
			// when i is 1:, j-> 0, 1, 2, 3, 4 | covid19IndiaCasesAug[1].length -> 5
			// when i is 2:, j-> 0, 1, 2, 3, 4 | covid19IndiaCasesAug[2].length -> 5
			// when i is 3:, j-> 0, 1, 2	   | covid19IndiaCasesAug[2].length -> 3
			for(int j=0;j<covid19IndiaCasesAug[i].length;j++) {	// Nested For Loop: Loop Within a Loop
				System.out.print(covid19IndiaCasesAug[i][j]+"  ");
			}
			System.out.println();
		}
		
		// Array of Array of Arrays: 3-D Array
		int[][][] yearlyCases = {
				{									// jan month
					{335076, 334513, 43521},		// day 1 of jan
					{335076, 334513, 43521},
					{335076, 334513, 43521},
					
				},
				{									// feb month
					{335076, 334513, 43521},		// day 1 of feb
					{335076, 334513, 43521},
					{335076, 334513, 43521},
				},
				{									// march month
					{335076, 334513, 43521},		// day 1 of march
					{335076, 334513, 43521},
					{335076, 334513, 43521},
					{335076, 334513, 43521},
					{335076, 334513, 43521},
					{335076, 334513, 43521},
					
				}
		};
		
		System.out.println("yearlyCases is: "+yearlyCases);					  // HashCodes
		System.out.println("yearlyCases[0] is: "+yearlyCases[0]);			  // HashCodes
		System.out.println("yearlyCases[0][0] is: "+yearlyCases[0][0]);		  // HashCodes
		System.out.println("yearlyCases[0][0][0] is: "+yearlyCases[0][0][0]); // 335076
		
		// Represent the above 3-d array in memory :)
 
	}

}
