/***********************
 * class MySorts -- implements bubbleSort, selectionSort, and insertionSort.
 ***********************/

// Team Spongebob -- Tim Marder & Brandon Chong
// Tim Marder
// APCS1 pd02
// HW54 -- One File to Bring Them All…
// 2017-12-14

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
}
