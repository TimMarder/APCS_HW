/********************************
Hasif Ahmed
APCS1 pd2
HW #47:_ascending
2017-12-06
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
	// *** YOUR IMPLEMENTATION HERE ***
	_data = new ArrayList<Comparable>();
    }


    public String toString()
    {
	// *** YOUR IMPLEMENTATION HERE ***
	String foo = "[";
	for( int i = 0; i < size(); i++ ) {
	    foo += get(i) + ",";
	}
	if ( foo.length() > 1 )
	    //shave off trailing comma
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    public Comparable remove( int index )
    {
	Comparable x = get(index);
      
	// *** YOUR IMPLEMENTATION HERE ***
        _data.remove(index);
	return x; //placeholder 
    }


  public int size()
  { 
    // *** YOUR IMPLEMENTATION HERE ***
      return _data.size(); //placeholder 
  }

    
  public Comparable get( int index )
  { 
    // *** YOUR IMPLEMENTATION HERE ***
      
      return _data.get(index); //placeholder  
  }


    public void add(Comparable newVal)
    { 
	// *** YOUR IMPLEMENTATION HERE ***
        for(int i = 0; i < size(); i++){
	    if(get(i).compareTo(newVal) >= 0){
		_data.add(i,newVal);
		return;
	    }
	}
	_data.add(newVal);
    }



  // main method solely for testing purposes
  public static void main( String[] args )
  {
    
    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.add( (int)( 50 * Math.random() ) );
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
       
  }//end main()

}//end class OrderedArrayList
