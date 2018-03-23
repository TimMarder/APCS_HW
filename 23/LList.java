/*****************************************************
Team Febreeze - Tim Marder, Ricky Lin
Tim Marder
APCS2 pd02
HW #23: Give and Take
2018-03-22 F


 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    public boolean add( String newVal )
    {
	LLNode tmp = new LLNode( newVal, _head );
	_head = tmp;
	_size++;
	return true;
    }

    public void add( int i, String newVal )
    {
      if ( i < 0 || i > size() )
    	    throw new IndexOutOfBoundsException();  //prevent picking of index out of range but allows for null to be picked
      LLNode first = _head;  //set temp to start at the head
      if (i == 0) {
          _head = new LLNode(newVal, first);  //if adding to beginning, change head to new node with newVal as cargo and point to the old _head
          _size++;  //increment size
      }
      else {
        for (int x = 1; x < i; x++) {  //interate through array excluding 0th index and stopping at index before i
          first = first.getNext();  //set first to the next node
        }
        first.setNext(new LLNode(newVal,first.getNext())); //set the pointer of first to a new node that has newVal as cargo and points to the node originally after first
        _size++;  //increment size
      }
    }

    public String remove (int i) {
      if ( i < 0 || i >= size() )
    	    throw new IndexOutOfBoundsException();  //limits range; can't remove null
      LLNode first = _head;  //set temp to start at _head
      if (i == 0) {  //if removing 1st one
        String old = first.getCargo();  //saved the removed cargo
        _head = first.getNext();  //change the head to the next node, losing the reference to the original _head
        _size--;  //decrement _size
        return old;  //return old cargo
      }
      else {
        for (int x = 1; x < i; x++) {  //iterate through array excluding 0th and stopping at index before i
          first = first.getNext();  //move first to next node
        }
        String old = first.getNext().getCargo();  //save the removed node's cargo
        first.setNext(first.getNext().getNext()); //set the reference of the node before removed node to the node after removed node
        _size--;  //decrement size
        return old;  //return old cargo
      }
    }

    public String get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public String set( int index, String newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() { return _size; }

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );

  james.add(1,"fred");
  System.out.println("fred should be at index 1 now");
  System.out.println( james );
  james.add(0,"hat");
  System.out.println("hat should be at index 0 now");
  System.out.println( james );
  james.add(6,"dog");
  System.out.println("dog should be at last index now");
  System.out.println( james );
  //james.add(100,"free"); testing IndexOutOfBoundsException
  System.out.println(james.remove(6));
  System.out.println( james );
  System.out.println(james.remove(0));
  System.out.println( james );
  System.out.println(james.remove(1));
  System.out.println( james );
    }

}//end class LList
