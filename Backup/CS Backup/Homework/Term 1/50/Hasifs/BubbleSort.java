//Hasif Ahmed
//APCS1 pd2
//HW50 -- Dat Bubbly Tho
//2017-12-11
/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/

import java.util.ArrayList;

public class BubbleSort {

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data )
    {
	/* YOUR IMPLEMENTATION HERE */
	int round = data.size() - 1; // uses the bubble sort method where u go thru the list the number of elements minus 1 times 
	while( round > 0 ){ //when round is zero the arraylist is sorted
	    // ArrayList<Comparable> same = data; this doesn't work
	    for(int i = 0; i < data.size() - 1; i++){ //goes through returned 
		if( data.get(i).compareTo(data.get(i+1)) > 0 ){ //compares two adjacent values and if the one to the left is bigger (left to right) switches them
		    Comparable y = data.get(i); //holds the value of left
		    Comparable x = data.get(i+1); //holds the value of right
		    data.set(i,x); //left gets the value of right
		    data.set(i+1,y); //right gets value of left 
		
		}
	    }
	   
	    round -= 1; //reduces a round 
	}
	    
      
      
    }


    // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
    {
	/* YOUR IMPLEMENTATION HERE */
        
	ArrayList<Comparable> returned = new ArrayList<Comparable>(); //filling a new arraylist with the values of input
	for (Comparable i: input) { //for loop going through each element of input
	    returned.add(i); //add element into returned
	}
	int round = returned.size() - 1; // uses the bubble sort method where u go thru the list the number of elements minus 1 times 
	while( round > 0 ){ //when round is zero the arraylist is sorted
	    // ArrayList<Comparable> same = data; this doesn't work
	    for(int i = 0; i < returned.size() - 1; i++){ //goes through returned 
		if( returned.get(i).compareTo(returned.get(i+1)) > 0 ){ //compares two adjacent values and if the one to the left is bigger (left to right) switches them
		    Comparable y = returned.get(i); //holds the value of left
		    Comparable x = returned.get(i+1); //holds the value of right
		    returned.set(i,x); //left gets the value of right
		    returned.set(i+1,y); //right gets value of left 
		
		}
	    }
	   
	    round -= 1; //subtracts a round 
	}
	return returned; //return the sorted version of input 
      
    }


  public static void main( String [] args )
  {

      
      ArrayList glen = new ArrayList<Integer>();
      /*  glen.add(1);
      glen.add(3);
      glen.add(5);
      glen.add(7);
      glen.add(12);
      */
      glen.add(7); 
      glen.add(1); 
      glen.add(5);
      glen.add(12);
      glen.add(3);
      
      System.out.println( "ArrayList glen before sorting:\n" + glen );
     
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      

      /*
       ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
      */

  }//end main

}//end class BubbleSort
