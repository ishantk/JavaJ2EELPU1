
public class MutableStrings {

	public static void main(String[] args) {
		
		// Strings are IMMUTABLE
		String str = new String("Hello");
		String newStr = str.concat(" World");
		
		System.out.println("str is: "+str);			// Hello
		System.out.println("newStr is: "+newStr);	// Hello World
		
		// MUTABLE Strings
		// StringBuffer | StringBuilder | They can be used only in Object Way
		
		// we can make modifications in the same string itself :)
		// THREAD-SAFE i.e. SYNCHRONIZED
		StringBuffer buffer = new StringBuffer("Hello");
		buffer.append(" World");
		
		System.out.println("buffer is: "+buffer);	// Hello World
		
		
		// NOT THREAD-SAFE
		StringBuilder builder = new StringBuilder("Hello");
		builder.append(" World");
		
		System.out.println("builder is: "+builder);	// Hello World
		
		//builder.ensureCapacity(20); // We can ensure capacity of StringBuilder but this will grow dynamically if needed
		
	}

}
