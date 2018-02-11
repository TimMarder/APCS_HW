//Hasif Ahmed
//APCS1 pd2
//HW52 -- Poker Face
//2017-12-13
/***************************************
 *  class InsertionSort -- implements InsertionSort algorithm
 ***************************************/

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
    public static void insertionSortV( ArrayList<Comparable> data )
    {
	/* YOUR IMPLEMENTATION HERE */
	int count = -1; //will be used to hold the new index being analyzed
	Comparable p; //will be used to hold the value of the removed 
	int x = data.size(); //holds the size of data
	int something; //instantiated variable that will be used to hold the index of the new element of the array being scrutinized 
        for(int k = 0; k < x; k++){ //for loop to go traverse through the list (passes) 
	    count += 1; //initially sets count to 0, so its not a negative index and will be used as a pass counter and as a index of the new element being scrutinized 
	    something = count; //sets a variable to count, so the index of the new element can be modified without messing with count 
	    for(int i = count ; i >= 0; i-- ) { //after a new element is identified, this loop will check this element with all the previous ones (adjacently) to find its position
		//System.out.println(i); //was used to check the i number (error counter)
		//System.out.println( "old " + data); //used to check the data set after this (error counter)
		
		if(data.get(something).compareTo(data.get(i)) < 0){ //compares the new one to the one previous to it
		    
		    p = data.remove(something); //if the new one is smaller, set the p variable to the value of the new element, remove it 
		    data.add(i,p); //add the new one to the correct position
		    //System.out.println(data); // (error counter)
		    something -= 1; //reduced the value of something, something essentially holds the index of the new element as it is moved throughout the list
		}
	    }
	}
    }
			
		        
					
	
	



    // ArrayList-returning insertionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable>
	insertionSort( ArrayList<Comparable> input )
    {
	/* YOUR IMPLEMENTATION HERE*/
	ArrayList<Comparable> op = new ArrayList<Comparable>(); //instantiates new arraylist<comparable> to hold the elements of input
	for(Comparable x: input){ //goes through input
	    op.add(x); //adds each element of input to op
	}
	insertionSortV(op); //uses the previous void sort method on op
	return op; //returns op ( the sorted version of input ) 
    }//end insertionSort
    

    public static void main( String[] args )
    {
	/*
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
	*/
        
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
	  System.out.println( coco );
        

    }//end main

}//end class InsertionSort
