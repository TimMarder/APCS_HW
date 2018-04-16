/*
Tim Marder
APCS2 pd02
HW33- What a Racket
2018-04-13
*/

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *
 *   1. Add the opening parens, operators, and operands to the first stack.
 *   2. Add the operators, operands, and latest "(" before the ")" into the second stack. Pop them off the first stack.
 *   3. Solve the operation in the second stack and push the solution to the first stack.
 *   4. Ignore the closing paren and continue.
 *   5.	Repeat steps 1-4 until last closing paren is reached.
 *
 * STACK OF CHOICE: LLStack by Mr. Brown-Mykolyk
 * b/c ... We worked on LinkedLists more recently than we did on ArrayList so I feel more comfortable using LinkedLists.
 ******************************************************/

public class Scheme {
  /****************************************************** 
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr ) {
	  
	  String[] arr = expr.split("\\s+");
	  Stack<String> bigger = new LLStack<String>();
	  
	  for (int i = 0 ; i < arr.length ; i++) {
		  if ( !arr[i].equals(")") ) {
			  bigger.push( arr[i] );
		  }
		  else {
			  Stack<String> smaller = new LLStack<String>();
			  
			  while ( !bigger.peek().equals("(") ) {
				  smaller.push( bigger.pop() );
			  }
			  
			  String op = smaller.pop();
			  
			  if (op.equals( "+" ) ) {
				  bigger.pop();
				  bigger.push( unload( 1 , smaller ) );
			  }
			  if (op.equals( "-" ) ) {
				  bigger.pop();
				  bigger.push( unload( 2 , smaller ) );
			  }
			  if (op.equals( "*" ) ) {
				  bigger.pop();
				  bigger.push( unload( 3 , smaller ) );
			  }
		  }
	  }
	  return bigger.pop();
	  
  }//end evaluate()


  /****************************************************** 
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, Stack<String> numbers ) {
	  
	  int result = Integer.parseInt( numbers.pop() );
	  
	  while ( !numbers.isEmpty() ) {
		  if ( op == 1 ) {
			  result = result + Integer.parseInt( numbers.pop() );
		  }
		  if ( op == 2 ) {
			  result = result - Integer.parseInt( numbers.pop() );
		  }
		  if ( op == 3 ) {
			  result = result * Integer.parseInt( numbers.pop() );
		  }
	  }
	  return "" + result;
	  
  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
	}
  catch( NumberFormatException e ) {
  return false;
	}
  }
  */


  //main method for testing
  public static void main( String[] args )
  {

      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
	  /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
