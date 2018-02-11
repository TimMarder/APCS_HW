/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

// Tim Marder
// APCS1 pd02
// HW #51 - Selection
// 2017-12-12

import java.util.ArrayList;

public class SelectionSort 
{
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
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data ) {
  	int index = 0; //The index of the current element
  	int minIndex = 0; //The index of the element with the smallest value in the array
  	Comparable current; //Holds the value of the current index
  	Comparable min; //Holds the value of the minimum index
  	for (int pass = data.size() - 1 ; pass > 0; pass--) { //Tells how many times the sorting algorithm is ran through the elements (passes)
  		current = data.get(index); //Sets "current" as the value at "index"
  		min = data.get(index); //Sets "min" as the value at "index"
  		for (int counter = index ; counter < data.size() ; counter++) { //Goes through the elements of the array
  			if (min.compareTo(data.get(counter)) > 0) { //if min > value at index "counter"
  				minIndex = counter; //Set "minIndex" to the "counter" value
  				min = data.get(counter); //Set "min" to the value at index "counter"
  			}
  		}
  		if (min.compareTo(data.get(index)) != 0) { //If min is not equal to the value at index "index"
  			data.set( minIndex , current ); //Set "minIndex" to the "current" value
  			data.set( index , min ); //set "index" to the "min" index
  		}
  		index++; //Goes on to the next index to compare to the other indexes
  	}
  }

  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    selectionSort( ArrayList<Comparable> input ) {
    	ArrayList<Comparable> result = new ArrayList<Comparable>(); //Defines the arraylist that is going to be returned
    	for (Comparable index : input) { //Foreach loop to copy the elements from arraylist comparable input to arraylist comparable result 
    		result.add(index); //adds the element from arraylist comparable input to arraylist comparable result
    	}
    	selectionSortV(result); //sorts the arraylist comparable result using the void selection sort method
    	return result; //returns the final arraylist
    }//end selectionSort 


  public static void main( String[] args ) 
  {
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    /*===============for VOID methods=============
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      selectionSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      ============================================*/

    /*==========for AL-returning methods==========*/
      //ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = selectionSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = selectionSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      //System.out.println( coco );
      /*============================================*/

  }//end main

}//end class SelectionSort
