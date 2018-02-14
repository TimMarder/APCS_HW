// Team Da_Wae -- Tim Marder & Simon Tsui
// Tim Marder
// APCS2 pd02
// HW#07 -- A Man, A Plan, A Canal: Panama!
// 2018-02-13


public class Resrever {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	
	
    public static String makeString(int length) {
		String str = "";

		for (int i = 0 ; i < length ; i++) {
			int randLetter = (int) (Math.random() * 26);
			str = str + ALPHABET.substring(randLetter , randLetter + 1);
		}
		return str;
    }
	
	
	
	public static String reverse(String s){ //method to reverse string and runs in linear time [ O(n) ]
		String retstr = ""; //The final reversed string that is going to be returned
		for(int i = s.length() - 1; i >= 0; i--){ //for loop to go through the letters in the String starting from the back
			retstr += s.substring(i); //adds the current letter that the for loop is at to the final string
			s = s.substring(0, i); //removes the last letter which has already been added to the final string
		}
		return retstr; //returns the final string
    }
	
	
	/*
	There is no possible logarithmic method for returning a string backwards.
	
	While a linear method for turning a string backwards is possible,
	there is no possible method that runs it in O(log n) speed. This is
	because merge runs in linear time, adding the string in 1 character
	at a time is an O(n) method. As long as writing the reversed string
	takes O(n) time, an O(log n) runtime will not be possible.
    */
	
	
	public static void sop(String a) { //helper method to save time
		System.out.println(a);
	}
	
	
	public static void newLine() { //another helper method
		System.out.println("\n");
	}
	
	
	public static void main(String[] args) {
		String string1 = makeString(5);
		String string2 = makeString(8);
		String string3 = makeString(10);
		String string4 = makeString(15);
		String string5 = "BrownMykolyk";
		String string6 = "racecar";
		
		sop("Printing string1...");
		sop(string1);
		newLine();
		
		sop("Printing string2...");
		sop(string2);
		newLine();
		
		sop("Printing string3...");
		sop(string3);
		newLine();
		
		sop("Printing string4...");
		sop(string4);
		newLine();
		
		sop("Printing string5...");
		sop(string5);
		newLine();
		
		sop("Printing string6...");
		sop(string6);
		newLine();
		
		sop("Reversing string1...");
		sop("result :" + reverse(string1));
		newLine();
		
		sop("Reversing string2...");
		sop("result :" + reverse(string2));
		newLine();
		
		sop("Reversing string3...");
		sop("result :" + reverse(string3));
		newLine();
		
		sop("Reversing string4...");
		sop("result :" + reverse(string4));
		newLine();
		
		sop("Reversing string5...");
		sop("result :" + reverse(string5));
		newLine();
		
		sop("Reversing string6...");
		sop("result :" + reverse(string6));
		newLine();
	}
}
