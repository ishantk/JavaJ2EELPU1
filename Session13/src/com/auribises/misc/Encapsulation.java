package com.auribises.misc;

class Settings{
	
	private String username = "john.watson"; // Encapsulation -> we are limiting the access of the attribute only to this clas boundary
	int volume;
}

public class Encapsulation {

	public static void main(String[] args) {
		
		Settings settings = new Settings();
		//settings.username = "fionna.flynn";
		settings.volume = 5;

	}

}
