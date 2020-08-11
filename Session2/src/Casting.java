
public class Casting {

	public static void main(String[] args) {
		
		int iVar1 = 50;
		
		// Erroneous:
		//byte bVar1 = iVar1; // as we are copying data from 32 bits of container into 8 bits of container
		
		// OK:
		// we will now just copy the 8 bits of data from iVar1 from LSB
		// CASTING (byte)
		byte bVar1 = (byte)iVar1; // DOWN-CASTING
		System.out.println("bVar1 is: "+bVar1);
		
		int iVar2 = bVar1; 		  // UP-CASTING (Taken Care by Compiler for Us)
		System.out.println("iVar2 is: "+iVar2);
		
		// Here, size is not the concern, type is concern
		int iVar3 = 97;
		char ch = (char)iVar3;	  // TYPE-CASTING
		
		System.out.println("ch is: "+ch);

	}

}
