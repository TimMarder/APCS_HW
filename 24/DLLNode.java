/*
Tim Marder
APCS2 pd02
HW#24a -- On the DLL
2018-03-25 
*/

/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode {
	
  private String _cargo;    //cargo may only be of type String
  private DLLNode _nextNode; //pointers to next, prev DLLNodes
  private DLLNode _prevNode;

  
  public DLLNode( String value, DLLNode next, DLLNode prev ) {
	  _cargo = value;
	  _nextNode = next;
	  _prevNode = prev;
  }
  
  
  public String getCargo() {
	  return _cargo;
  }
  
  
  public DLLNode getNext() {
	  return _nextNode;
  }
  
  
  public DLLNode getPrev() {
	  return _prevNode;
  }
  
  
  public String setCargo( String newCargo ) {
	  String temp = getCargo();
	  _cargo = newCargo;
	  return temp;
  }
  
  
  public DLLNode setNext( DLLNode newNext ) {
	  DLLNode temp = getNext();
	  _nextNode = newNext;
	  return temp;
  }
  
  
  public DLLNode setPrev( DLLNode newPrev ) {
	  DLLNode temp = getPrev();
	  _prevNode = newPrev;
	  return temp;
  }
  
  
  public String toString() {
	  return _cargo.toString();
  }
  
  
  public static void main( String[] args ) {
	  
	  DLLNode first = new DLLNode( "dog", null, null);
	  
	  System.out.println( first ); //printing the node
	  
	  first.setPrev( new DLLNode( "pig", null, null )); //settings the previous node
	  
	  first.setNext( new DLLNode( "cat", null, null )); //setting the next node
	  
	  System.out.print( first.getPrev());
	  System.out.print( " --> ");
	  System.out.print( first );
	  System.out.print( " --> " );
	  System.out.print( first.getNext());
  }

}//end class DLLNode
