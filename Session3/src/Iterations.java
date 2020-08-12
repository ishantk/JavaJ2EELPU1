
public class Iterations {

	public static void main(String[] args) {
		
		// State Wise Data Representation for Active Cases
		int maharashtra = 148553;
		int tamilNadu = 52810;
		int andhraPradesh = 87597;
		int karnataka = 79605;
		int delhi = 10868;
		
		// if we have to represent data for all the states, we need to create many single value containers
		// further, if for states, we need to maintain data for districts, cities etc.. 
		// we will waste a lot of time in creating single value containers i.e. more development time
		
		// any computation will also take more development time 
		int toalActiveCases = maharashtra + tamilNadu + andhraPradesh + karnataka + delhi;
		System.out.println("Total Active Cases: "+toalActiveCases);
		
		// Challenge, if we have to represent data for n-number of states, development time increases :)
		// Solution : Multi Value Container 
		
		// Arrays: Homogeneous
		// Indexing:				  0		 1		2		3	   4
		int[] covid19ActiveCases = {148553, 52810, 87597, 79605, 10868};
		// 0 represent maharashtra, 1 represents tamil nadu so on and so forth....
		
		System.out.println("maharashtra: "+maharashtra);					// single value container
		System.out.println("covid19ActiveCases: "+covid19ActiveCases);		// multi value container
		
		// covid19ActiveCases is not an Array. Its a Reference Variable which is holding the HashCode of the Array
		// Array is created in the Heap Section of RAM
		
		toalActiveCases = 0;
		//toalActiveCases = covid19ActiveCases[0] + covid19ActiveCases[1] + covid19ActiveCases[2] + covid19ActiveCases[3] + covid19ActiveCases[4];
		//System.out.println("Total Active Cases: "+toalActiveCases);
		
		// Arrays are created dynamically i.e. at run time in Java
		// i.e. When program starts, memory allocation happens dynamically
		
		// In Java we have a Program running at JVM end i.e. GarbageCollector
		// GC will look for the unused memory and remove it, but only from Heap :)
		
		// Loops or Iterations:
		int idx = 0;	// starting point
		
		// check condition when we enter the loop
		while(idx < 5) { // go till 4 i.e. less than 5
			toalActiveCases += covid19ActiveCases[idx];
			idx++;
		}
		
		System.out.println("Total Active Cases from While Loop: "+toalActiveCases);
		
		
		toalActiveCases = 0;
		idx = 0;
		
		do {
			toalActiveCases += covid19ActiveCases[idx];
			idx++;
		}while(idx<5); // check condition when we exit the loop
		
		System.out.println("Total Active Cases from do-While Loop: "+toalActiveCases);
		
		toalActiveCases = 0;
		for(int i=0;i<5;i++) {
			toalActiveCases += covid19ActiveCases[i];
		}
		
		System.out.println("Total Active Cases from for Loop: "+toalActiveCases);
		
	}

}
