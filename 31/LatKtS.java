/*
Tim Marder
APCS2 pd02
HW#31 -- Stack: What Is It Good For?
2018-04-11
*/

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS {

  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s ) {

	Latkes stack = new Latkes( s.length() );
	
	for (int i = 0 ; i < s.length() ; i++) {
		stack.push( s.substring( i , i + 1 ) );
	}
	
	String rtrn = "";
	
	for (int i = 0 ; i < s.length() ; i++) {
		rtrn += stack.pop();
	}
	
	return rtrn;
  
  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
  public static boolean allMatched( String s ) {

	Latkes stack = new Latkes( s.length() );
	
	for (int i = 0 ; i < s.length() ; i++) {
		String pancake = s.substring( i , i + 1 );
		if (pancake.equals("(") ||
			pancake.equals("[") ||
			pancake.equals("{")) {
				stack.push( pancake );
			}
		else if ( !stack.isEmpty() ) {
			String first = stack.pop();
			if (!(first.equals("(") && pancake.equals(")") ||
				  first.equals("[") && pancake.equals("]") ||
				  first.equals("{") && pancake.equals("}"))) {
					  return false;
				  }
		}
		else {
			return false;
		}
	}
		
	return stack.isEmpty();
  
  }//end allMatched()


  //main method to test
  public static void main( String[] args ) {
	  
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	  
  }

}//end class LatKtS
