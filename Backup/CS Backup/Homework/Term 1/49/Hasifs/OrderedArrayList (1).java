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
    for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
        //newVal < oal[p]
        _data.add( p, newVal );
        return; //Q:why not break?
	    }
    }
    _data.add( newVal ); //newVal > every item in oal, so add to end 
  }

    
  public int addBin( Comparable newVal)
  {
      int _hi, _lo, compared;
      _lo = 0;
      _hi = _data.size() - 1;
      System.out.println("inserting " + newVal);
        if (newVal.compareTo(_data.get( _lo)) < 0){
	    _data.add( _lo, newVal );
	    return _lo;
        }
        if (newVal.compareTo(_data.get( _hi)) > 0){
	    _data.add( _hi + 1, newVal );
	    return _hi + 1;
        }

      while (true) {
	  compared = (int) ( (_hi + _lo) / 2 );
	  if( this.get(compared) ==  newVal ||
	      (this.get(compared).compareTo( newVal ) < 0) && (this.get(compared + 1).compareTo(newVal) > 0)) {
	    _data.add( compared + 1, newVal );
	    return compared + 1;
	  }
	  else if( this.get(compared).compareTo(newVal) > 0 ) {
	      _hi = compared - 1;
	  }
	  else {
	      _lo = compared + 1;
	      
	  }	  
      }
  }
    
    
  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.add( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    int i = 0;
    while (i < 10) {
	int random = (int) (Math.random() * 100);
	System.out.println(Franz.addBin(random));
	System.out.println( Franz );
	System.out.println("/==========================");
	i++;
    }    
	    
    //check for sorted-ness
    //if msg does not appear, list was sorted
    /*
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at i: " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }
    */
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class OrderedArrayList
