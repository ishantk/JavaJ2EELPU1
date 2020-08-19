package com.auribises.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Outer{
	
	void show() {
		System.out.println("This is show of Outer");
	}
	
	// Nested Class
	// Class within the Class
	// > Increase the level of encapsulation
	// > May be used as a Helper Class
	class Inner{ // Inner class can be of any access type
		void show() {
			System.out.println("This is show of Inner");
		}
	}
}

// Outer class will be for displaying the users
// Outer class methods can access Inner Class and can fetch the data from DB 
// Making the Code more Maintainable
class DisplayUsersOnPage{
	
	class FetchUsersFromDB{
		
	}
	
}


/*class Arrays{
	
	class ArrayList{
		
	}
}*/

class ArrayToList{
	
	static ArrayList<String> toList(String...names){
		ArrayList<String> list = new ArrayList<String>();
		for(String name : names) {
			list.add(name);
		}
		
		return list;
	}
}

public class NestedClass {

	public static void main(String[] args) {
		
		Outer oRef = new Outer();
		oRef.show();
		
		Outer.Inner iRef = oRef.new Inner();
		iRef.show();
		
		//List<String> names = Arrays.asList("John", "Jennie", "Jim");
		//System.out.println(names.getClass());
		
		//  Arrays.asList returns a nested ArrayList class Object, which is fixed in Size
		// Hence, we can only set i.e. update the data or get the data, we cannot remove or add data :(
		
		List<String> names = ArrayToList.toList("John", "Jennie", "Jim");
		System.out.println(names.getClass());
		
		names.add("Sia");
		System.out.println(names);
		
	}

}
