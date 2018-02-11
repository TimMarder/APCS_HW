/********************************
 Tim Marder
 APCS1 pd02
 HW#47 -- ascending
 2017-12-06   
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList {
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList() {
    _data = new ArrayList<Comparable>();
  }


  public String toString() {
    String result = "";
    result = result + "[";
    for (int counter = 0 ; counter < size() ; counter++) {
      result = result + get(counter);
      if (counter + 1 < size()) {
        result = result + ",";
      }
    }
    result = result + "]";
    return result;
  }


  public Comparable remove( int index ) {
    Comparable result = get(index);
    _data.remove(index);
    return result;
  }


  public int size() { 
    return _data.size(); 
  }

    
  public Comparable get( int index ) { 
    return _data.get(index);
  }


  public void add(Comparable newVal) {
    for (int counter = 0 ; counter < size() ; counter++) {
      if (get(counter).compareTo(newVal) >= 0) {
        _data.add( counter , newVal );
        return;
      }
    }
    _data.add(newVal);
  }



  // main method solely for testing purposes
  public static void main( String[] args ) {
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
      /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class OrderedArrayList
