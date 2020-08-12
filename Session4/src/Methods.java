
public class Methods {

	// Functions or Methods
	// Methods -> Created inside the class
	
	// which will contain some piece of code, which we need to execute again and again
	// void is return type i.e. data type which method must return in the end
	// void means nothing should be returned
	// printMaxNumber: name of method -> can be any name of your choice
	// () -> input list => contains an reference to array of int[] as input
	
	// non static method -> for which we need to create an object
	void printMaxNumber1(int[] array) { // defining/creating a method
		
		int max = array[0];
		
		for(int i=1;i<array.length;i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		System.out.println("Maximum is: "+max);
	}
	
	// static is a method which can be executed without the Object
	static void printMaxNumber2(int[] array) { // defining/creating a method
		
		int max = array[0];
		
		for(int i=1;i<array.length;i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		System.out.println("Maximum is: "+max);
	}
	
	// here we have return type mentioned as int
	int getMaxNumber1(int[] array) { // defining/creating a method
		
		int max = array[0];
		
		for(int i=1;i<array.length;i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		return max; // return the same type of data in the end as specified in return type
	}
	
	// static is a method which can be executed without the Object
	static int getMaxNumber2(int[] array) { // defining/creating a method
		
		int max = array[0];
		
		for(int i=1;i<array.length;i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		int[] covid19IndiaCases9Aug = {135076, 134513, 23521, 412341, 4567};
		int[] covid19IndiaCases10Aug = {235076, 234513, 33521, 22341, 515567};
		int[] covid19IndiaCases11Aug = {335076, 334513, 1243521, 32341, 6567};
		
		int[] iplData = {135, 175, 441, 189, 567};
		
		/*
		int max9Aug = covid19IndiaCases9Aug[0];
		
		for(int i=1;i<covid19IndiaCases9Aug.length;i++) {
			if(covid19IndiaCases9Aug[i] > max9Aug) {
				max9Aug = covid19IndiaCases9Aug[i];
			}
		}
		
		System.out.println("Max cases on 9th Aug: "+max9Aug);
		
		int max10Aug = covid19IndiaCases10Aug[0];
		
		for(int i=1;i<covid19IndiaCases10Aug.length;i++) {
			if(covid19IndiaCases10Aug[i] > max10Aug) {
				max10Aug = covid19IndiaCases10Aug[i];
			}
		}
		
		System.out.println("Max cases on 10th Aug: "+max10Aug);
		
		int maxPoints = iplData[0];
		
		for(int i=1;i<iplData.length;i++) {
			if(iplData[i] > maxPoints) {
				maxPoints = iplData[i];
			}
		}
		
		System.out.println("Max Points from IPL Data: "+maxPoints);
		
		// Why Methods or Functions
		// As per above snippets, we are writing the same code again and again to solve the similar problem
		*/
		
		// non static methods -> executed with objects :)
		
		// In the Main, we will execute the method which we have created
		// Create an Object of the class to execute the method
		// Object Construction Statement
		Methods mRef = new Methods();
		
		mRef.printMaxNumber1(covid19IndiaCases9Aug);
		mRef.printMaxNumber1(covid19IndiaCases10Aug);
		mRef.printMaxNumber1(covid19IndiaCases11Aug);
		mRef.printMaxNumber1(iplData);
		
		System.out.println();
		
		// static methods -> executed with class name :)
		
		Methods.printMaxNumber2(covid19IndiaCases9Aug);
		Methods.printMaxNumber2(covid19IndiaCases10Aug);
		Methods.printMaxNumber2(covid19IndiaCases11Aug);
		Methods.printMaxNumber2(iplData);
		
		System.out.println();
		
		int result1 = mRef.getMaxNumber1(covid19IndiaCases10Aug);
		int result2 = Methods.getMaxNumber2(covid19IndiaCases10Aug);
		
		System.out.println("result1: "+result1);
		System.out.println("result2: "+result2);
		
		System.out.println("Max in IPL Data: "+Methods.getMaxNumber2(iplData));
		
	}

	// Assignment: Write insertionSort method to sort the elements of array :)
	
}
