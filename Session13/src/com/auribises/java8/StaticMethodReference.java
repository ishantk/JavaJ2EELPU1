package com.auribises.java8;

interface ClickListener{
	
	void onPressed(int state); // 0 means sigle time press, 1 means long press, 2 means double press
}

// Button here is not implementing any interface
class Button{
	
	public static void onPressed(int state) {
		if(state == 0) {
			System.out.println("Single Press Detected");
		}else if(state == 1) {
			System.out.println("Long Press Detected");
		}else if(state == 2) {
			System.out.println("Double Press Detected");
		}
	}
	
}

public class StaticMethodReference {

	public static void main(String[] args) {
		
		// Static Method Reference
		// We have a method which is static in some other class
		// We need not to define it again, and can simply have a reference to it
		// Here we use Class Name to pass the Method Reference
		ClickListener listener = Button::onPressed;
		listener.onPressed(2);
		
	}

}
