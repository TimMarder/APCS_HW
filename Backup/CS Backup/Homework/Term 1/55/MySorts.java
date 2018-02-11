/***********************
 * class MySorts -- implements bubbleSort, selectionSort, and insertionSort.
 ***********************/

// Team Spongebob -- Tim Marder & Brandon Chong
// Tim Marder
// APCS1 pd02
// HW55 -- Never Fear, Big Oh Is Here!
// 2017-12-15

import java.util.ArrayList;

public class MySorts {
    //=================== HELPER METHODS ===================
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi )
    {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }
    
    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al )
    {
	int randomIndex;
	//setup for traversal fr right to left
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }

    //=================== SORT METHODS ===================
    
    public static void bubbleSort( ArrayList<Comparable> data )
    {
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    System.out.println( "commencing pass #" + passCtr + "..." );
	    
	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
		//if element at i > element at i+1, swap
		if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) 
		    data.set( i, data.set(i+1,data.get(i)) );	
		//System.out.println(data); //diag: show current state of list
	    }
	}
    } //end bubbleSort

    /*Best case senario for bubbleSort would lead to a time of O(n^2) It must go trough the 
      ArrayList the same ammount as the worst case senario.
      Worse case scenario for bubbleSort would lead to a time of O(n^2). The time becomes 
      (n-1) + (n-2) + ... 2 + 1. You can rewrite this as ((n-1)+1)* (n-1)/2. This becomes (n^2 + n)/2.
      Since the leading coefficient is the only important thing, run time is O(n^2).
    */

    public static void selectionSort( ArrayList<Comparable> data ) 
    {
    	//note: this version places greatest value at rightmost end,

    	//maxPos will point to position of SELECTION (greatest value)
    	int maxPos;

	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
		System.out.println( "maxPos: " + maxPos );//diag
		System.out.println( data );//diag
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
		    maxPos = i;
	    }
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	    System.out.println( "after swap: " +  data );//diag
    	}
    }//end selectionSort

    /*Best case senario for selectionSort would lead to a time of O(n^2) Same reason as bubble sort..
      Worse case senario for selectionSort would lead to a time of O(n^2) For selectionSort it still 
      has to make the same number of swaps whether or not they are in order or not, so worse case senario
      is same time as best case.
    */
    
    public static void insertionSort( ArrayList<Comparable> data )
    {
	for( int partition = 1; partition < data.size(); partition++ ) {
	    //partition marks first item in unsorted region
	    
	    //diag:
	    System.out.println( "\npartition: " + partition + "\tdataset:");
	    System.out.println( data ); 
	    
	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- ) {
		
		// "walk" the current item to where it belongs
		// by swapping adjacent items
		if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
		    //diag:
		    System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
		    data.set( i, data.set( i-1, data.get(i) ) ); 
		}
		else 
		    break; 
	    }
	}
    }//end insertionSort

    /*Best case senario for insertionSort would lead to a time of O(n). The number of comparisons of
    this would be n-1. This is because for each time the partition increases, there is only one
    comparison that follows since the "sorted region" is already in order. The partition increases n-1
    times. Since the -1 is irrelevant, the run time is O(n). 
    Worse case senario for insertionSort would lead to a time of O(n^2). For this it would be the
    same reasoning as for bubble sort.
    */

    /*
    ===[add(); Method]===
    Category: Linear
    Base Case Scenario: O( 1 ) 
    If the value being added would belong at the first index, since linear search goes through the
    elements 1 by 1 in order from left to right. It would add the value at the first index and wouldn't
    have to traverse through the rest of the arraylist.

    Worst Case Scenario: O( n )
    If the value being added would belong at the very last index, since linear search goes through the
    elements 1 by 1 in order from left to right. Since the value would have to go in the very end of
    the arraylist, it would have to traverse through the entire arraylist until it gets to the end
    and finally adds the value.
    */

    /*
    ===[addBin(); Method]===
    Category: Logarithmic
    Base Case Scenario: O( 1 )
    Just like the add() method, the best case scenario would be O(1) because the logarithmic formula
    ( log base 2 * n ) is the big Oh of the linear formula ( n ), which means that you can find out
    how many guesses it will take to guess a number from 1-n by doing log base 2 * n. The base case
    scenario would be the very middle number of the arraylist because that is where logarithmic
    search would start guessing.

    Worst Case Scenario: O( log base 2 * n )
    There are a few worst case scenarios for logarithmic search. Values that are located at index 0
    and index n, as well as values located at the indexes +1 and -1 away from the very middle value
    are the worst case scenarios because the way logarithmic search works is it guesses by making
    halves of the arraylist to finally shorten itself to the final value, and since these elements
    are at the very ends of the array or right near the middle value, it would take addBin the
    longest amount of time to add the value at the correct position.
    */

}
