package com.auribises.java8;

@FunctionalInterface
interface IMessage{
	Message getMessage(String text, String dateTime);
}

class Message{
	Message(String text, String dateTime){
		System.out.println("Message : "+text+" ["+dateTime+"]");
	}
}

public class ConstructorReference {

	public static void main(String[] args) {
		
		//Message mRef = new Message("Thank you So Very Much :)", "18th Aug, 2020, 16:00");
		
		// Constructor Reference
		IMessage iRef = Message :: new;
		iRef.getMessage("Thank you So Very Much :)", "18th Aug, 2020, 16:00");
		
		// Assignment: Write an Implementation to refer a Paramtererized Constructor
	}

}
