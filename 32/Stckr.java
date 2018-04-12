/*
Tim Marder
APCS2 pd02
HW#32 -- Leon Leonwood Stack
2018-04-11
*/

/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr {
    
    public static void main( String[] args ) {
	
	/*****************************************
	NOTE: Sorry about lots of line breaks. :(
	Its to make the output be more organized.
	*****************************************/
	
	//Stack cakes = new ALStack()...
	Stack cakes = new LLStack<String>();
	
	System.out.println("Is stack cakes empty? " + cakes.isEmpty()); //true
	
	System.out.println("\n");
	
	System.out.println("Pushing fee...");
	cakes.push("fee");
	System.out.println("Pushing fye...");
	cakes.push("fye");
	System.out.println("Pushing foe...");
	cakes.push("foe");
	System.out.println("Pushing fum...");
	cakes.push("fum");
	
	System.out.println("\n");
	
	System.out.println("Peeking top pancake...");
	System.out.println(cakes.peek() + " has been peeked!"); //fum
	
	System.out.println("\n");
	
	System.out.println("Popping top pancake...");
	System.out.println(cakes.pop() + " has been popped!"); //fum
	
	System.out.println("\n");
	
	System.out.println("Is stack cakes empty? " + cakes.isEmpty()); //false
	
	System.out.println("\n");
	
	System.out.println("Popping top pancake...");
	System.out.println(cakes.pop() + " has been popped!"); //foe
	System.out.println("Popping top pancake...");
	System.out.println(cakes.pop() + " has been popped!"); //fye
	System.out.println("Popping top pancake...");
	System.out.println(cakes.pop() + " has been popped!"); //fee
	
	System.out.println("\n");
	
	System.out.println("Is stack cakes empty? " + cakes.isEmpty()); // true
    }

}//end class

