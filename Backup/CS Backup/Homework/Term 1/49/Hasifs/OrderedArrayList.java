/********************************
Hasif Ahmed
APCS1 pd2
HW #49: Halving the Halves 
2017-12-08
********************************/

//Other solution for add method by Clara Mohri


/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList()
    {
	_data = new ArrayList<Comparable>();    
    }


    public String toString()
    {
	return _data.toString(); 
    }


    public Comparable remove( int index )
    {	
	return _data.remove(index); 
    }


    public int size()
    { 
	return _data.size();
    }

    
    public Comparable get( int index )
    { 
	return _data.get(index); 
    }


    /***
     * add takes as input any comparable object 
     * (i.e., any object of a class implementing interface Comparable)
     * inserts newVal at the appropriate index
     * maintains ascending order of elements
     * uses a linear search to find appropriate index
     ***/
    public void add( Comparable newVal )
    { 
	
	int ctr = 0;
	while (ctr < _data.size()){
	    if (newVal.compareTo(_data.get(ctr)) < 0)
		break;
	    ctr += 1;
	}
	_data.add(ctr, newVal);
      
    }

    public void addBin( Comparable newVal) {
	boolean guess  = false; //sets a boolean called guess
	int _lo = 0;
	int _high = size() ;
	int _mid = (_lo + _high) / 2 ;

	//for the first input 
	if( _data.size() == 0 ) { //checks if the arraylist is empty
	    _data.add(0,newVal); //adds the newVal as the first element
	}

	//special cases 
	if ( newVal.compareTo( _data.get(0) ) <= 0 ) { //if newVal is smaller than the smallest value then add to the beginning 
 	    _data.add(0,newVal);
	    return;  //get out of function
        }
        else if ( newVal.compareTo( _data.get(size()-1) )  >= 0) { //if newVal is bigger than the biggest value then add it to the end 
	    _data.add(size(),newVal);
	    return; //get out of function
        }

	//for binary adding 
        while (guess == false ) { //uses boolean guess to keep while function going
	    if ( newVal.compareTo( _data.get(_mid) ) <= 0 && //if the new value is less than or equal to the middle and its greater than or equal to the middle than add newVal to the middle
		 newVal.compareTo( _data.get(_mid - 1) ) >= 0 ) {
		_data.add(_mid, newVal);
		guess = true; //change value of guess to get out of while loop 
	    } else if (newVal.compareTo( _data.get(_mid) ) > 0){ //if newVal is bigger than mid 
		_lo = _mid;  // change the value of low
	    } else if ( newVal.compareTo( _data.get(_mid - 1) ) < 0){ //if newVal is smaller than mid
		_high = _mid; //change the value of high
	    }
	    _mid = (_lo + _high) / 2;  //change the value of mid according to the new values of high and low 
        } 
    } 


// main method solely for testing purposes
public static void main( String[] args )
{
    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
	Franz.addBin( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
    for( int i=0; i<Franz.size()-1; i++ ) {
	System.out.println("at i: " + Franz.get(i) );
	if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
	    System.out.println( " *** NOT sorted *** " );
	    break;
	}
    }
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class OrderedArrayList
