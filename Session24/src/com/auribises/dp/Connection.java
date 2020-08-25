package com.auribises.dp;

/*public class Connection {
	
	public Connection() {
		System.out.println("Connection Constructed: "+hashCode());
	}

}*/

public class Connection {
	
	// Create the Object in class itself
	// con is property of class and Connection Object will be constructed dynamically in the Heap
	private static Connection con = new Connection();
	
	// Now objects of this class are not permitted outside
	private Connection() {
		System.out.println("Connection Constructed: "+hashCode());
	}
	
	public static Connection getConnection() {
		return con;
	}

}
