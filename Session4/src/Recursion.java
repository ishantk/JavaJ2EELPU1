// Recursion and Method Execution Stack
// PS: either static or non static, method execution stack remains same :)

public class Recursion {

	// function executing itself again to solve some problem -> Recursion
	// dynamic programming -> almost all of the problems are solved with recursion
	static int getMaxNumber(int[] numbers, int length) {
		System.out.println("getMaxNumber executed with length: "+length);
		int num = 0;
		
		if(length == 1) { // it means we have only element in the array | Base Case
			return numbers[0]; // as this will be the only element and hence the max
		}else {
			num = getMaxNumber(numbers, length-1);
		}
		
		if(num > numbers[length-1]) {
			return num;
		}else {
			return numbers[length-1];
		}
	}
	
	public static void main(String[] args) {

		int[] data = {10, 20, 30};	// 30 is the max number
		int max = Recursion.getMaxNumber(data, data.length);
		System.out.println(">> max is: "+max);
	}
	
	// Assignment: Implement Recursive Function to Code binary representation of a number
	//			   Also draw its memory execution stack :)

}
