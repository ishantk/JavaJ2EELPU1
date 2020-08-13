
public class StringOperations {

	public static void main(String[] args) {
		
		// Built In String Methods 
		
		//			    012345678......			   27
		String names = "John, Jennie, Jim, Jack, Joe";
		System.out.println("names: "+names);

		int length = names.length();
		System.out.println("Length of names is: "+length); // 28
		
		char ch = names.charAt(length-1);
		System.out.println("ch is: "+ch); // e
		
		//int idx = names.indexOf('o');			 // 1
		int idx = names.lastIndexOf('o');		 // 26
		System.out.println("idx of o is: "+idx); // 26
			
		idx = names.indexOf("Jennie");			// 6. i.e. from where Jennie's J starts
		System.out.println("idx of Jennie is: "+idx);
		
		
		// Strings are IMMUTABLE, i.e. we cannot change them :)
		// Any Manipulation on String will generate a new String in the memory
		String names1 = names.toUpperCase(); // toUpperCase() is a built in function
		System.out.println("names now is: "+names); // remains same
		System.out.println("names1 now is: "+names1); // UPPER CASE
		
		String names2 = names.replace('J', 'K');
		System.out.println("names after replace is: "+names);
		System.out.println("names2 after replace is: "+names2);
		
		//String name = names.substring(6); // return the String from index 6 till end
		String name = names.substring(6, 12); // return the String from index 6 till 11 i.e. < 12
		System.out.println("name is: "+name);
		
		String attendeeName = "john - 11576609";
		String[] data = attendeeName.split("-"); // split takes a delimiter and spilts the string based on it
		System.out.println(data[0].trim());
		System.out.println(data[1].trim());
		
		String email = "johnexample.com";
		if(email.contains("@") && email.contains(".com")) {
			System.out.println("A Valid Email");
		}else {
			System.out.println("Invalid Email");
		}
		
		String password = "";
		if(password.isEmpty()) {
			System.out.println("Please Enter Password First");
		}
		
		String chatMessage = "Hi, My Name is John. Please deliver the product on my address: 2144-B20 Redwood Shores";
		
		if(chatMessage.contains("address")) {
			System.out.println("Address Found in the Message");
			int i = chatMessage.indexOf("address");
			String address = chatMessage.substring(i);
			System.out.println("Delivery Of Product on Below Address");
			System.out.println(address);
		}
		
		String songName = "Hello.docx";
		if(songName.endsWith(".mp3")) {
			System.out.println("AudioPlayer shall play "+songName);
		}else {
			System.out.println("Invalid File for Play Format: "+songName);
		}
		
		System.out.println();
		
		String[] phoneNumbers = {
				"+91 98765 12345",
				"+91 98765 11221",
				"+91 91625 28765",
				"+91 98141 12141",
				"+91 99155 66554",
				"+91 90909 12345",
		};
		
		String toSearch = "12";
		
		for(String phone : phoneNumbers) {
			//if(phone.startsWith(toSearch)) {
			if(phone.contains(toSearch)) {
				System.out.println(phone);
			}
		}
		
	}

}
