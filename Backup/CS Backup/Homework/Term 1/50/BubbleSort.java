/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/

// Tim Marder
// APCS1 pd02
// HW #50 - Dat Bubbly Tho
// 2017-12-11

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
  public static void bubbleSortV( ArrayList<Comparable> data ) {
  	for (int pass = data.size() - 1 ; pass > 0 ; pass--) { //for loop for going through the passes (or phases) of bubble sorting
  		for (int counter = 1 ; counter < data.size() ; counter++) { //for loop for going through the elements of data
  			if (data.get(data.size() - (counter + 1)).compareTo(data.get(data.size() - counter)) > 0) { //Compares the last 2 elements, swaps them if the one
  				Comparable temp = data.get(data.size() - (counter + 1));								//to the left is larger than the one on the right.
  				data.set(data.size() - (counter + 1), data.get(data.size() - counter));
  				data.set(data.size() - counter, temp);
  			}
  		}
  	}
  }

  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) {
  	ArrayList<Comparable> result = new ArrayList<Comparable>(); //Defines the ArrayList that is going to be returned
  	for (Comparable index : input) { //Foreach loop for copying the elements from input into the new ArrayList
  		result.add(index);
  	}
  	for (int pass = result.size() - 1 ; pass > 0 ; pass--) { //for loop for going through the passes (or phases) of bubble sorting
  		for (int counter = 1 ; counter < result.size() ; counter++) { //for loop for going through the elements of the new ArrayList
  			if (result.get(result.size() - (counter + 1)).compareTo(result.get(result.size() - counter)) > 0) { //Compares the last 2 elements, swaps them if the one
  				Comparable temp = result.get(result.size() - (counter + 1));									//to the left is larger than the one on the right.
  				result.set(result.size() - (counter + 1), result.get(result.size() - counter));
  				result.set(result.size() - counter, temp);
  			}
  		}
  	}
  	return result;
  }


  public static void main( String [] args )
  {

    //===============for VOID methods=============
      /*ArrayList glen = new ArrayList<Integer>();
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
      System.out.println( "ArrayList coco after sorting:\n" + coco );*/
      //============================================

    /*==========for AL-returning methods==========*/
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
      //System.out.println( coco ); I commented this out because coco was being printed twice
      /*============================================*/

  }//end main

}//end class BubbleSort
