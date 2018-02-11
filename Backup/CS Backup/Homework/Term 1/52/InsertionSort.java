/***************************************
 *  class InsertionSort -- implements InsertionSort algorithm
 ***************************************/

// Tim Marder
// APCS1 pd02
// HW #52 - Poker Face
// 2017-12-13

import java.util.ArrayList;

public class InsertionSort
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


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSortV( ArrayList<Comparable> data ) {
    int partition = 1; //Starts with partition size 1
    for (int pass = data.size() - 1 ; pass > 0; pass--) { //Tells how many times the sorting algorithm is ran through the elements (passes)
      for (int counter = partition ; counter > 0 ; counter--) { //Goes through the elements
        if (data.get(counter - 1).compareTo(data.get(counter)) > 0) { //Checks if the previous element is larger then the next element
          data.set(counter, (data.set(counter - 1, data.get(counter)))); //swaps the elements
        }
      }
      partition++; //increases the partition size by 1
    }
  }//end insertionSortV


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    insertionSort( ArrayList<Comparable> input ) {
      ArrayList<Comparable> result = new ArrayList<Comparable>(); //Defines the arraylist that is going to be returned
      for (Comparable index : input) { //Foreach loop to copy the elements from arraylist comparable input to arraylist comparable result
        result.add(index); //adds the element from arraylist comparable input to arraylist comparable result
      }
      insertionSortV(result); //sorts the arraylist comparable result using the void selection sort method
      return result; //returns the final arraylist
  }//end insertionSort


  public static void main( String [] args )
  {
    /*===============for VOID methods=============
      System.out.println("\n*** Testing sort-in-place (void) version... *** ");
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      insertionSortV(glen);
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      insertionSortV(coco);
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      ============================================*/

    /*==========for AL-returning methods==========*/
      System.out.println( "*** Testing non-void version... *** " );
    	ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = insertionSort( glen );
      System.out.println( "\nsorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = insertionSort( coco );
      System.out.println( "\nsorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      //System.out.println( coco );
      /*============================================*/

  }//end main

}//end class InsertionSort