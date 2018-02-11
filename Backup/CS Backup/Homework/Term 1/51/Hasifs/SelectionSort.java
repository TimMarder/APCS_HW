//Hasif Ahmed
//APCS1 pd2
//HW #51: Selection, Natch
//2017-12-12

/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

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
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	int index = 0; //variable to hold the position of the current index being changed 
	Comparable min; //holds the minimum value of the elements of the array being looked at 
	int location = 0; //location of the minimum value 
	Comparable current; //variable to hold the value of the current index being changed 
	while( index < data.size() - 1 ) { //number of times the while loop will run 
	    
	    min = data.get(index); //sets min to the value at index 
	    current = data.get(index); //sets min to the value at 
	    for( int i = index; i < data.size(); i++ ) { //goes through the elements being looked at to find the minimum 
		if( data.get(i).compareTo(min) < 0){ //if the value at i is smaller than the current minimum 
		    min = data.get(i); //set the value of min to the value at i
		    location = i; //set location to the index of the min ( which is i )
		}
	    }
	    if( data.get(index).compareTo(min) == 0){ //if the value at index is equal to the minimum then no changes were made 
		index += 1; //only thing being done is incrementing index 
	    } else { //else (value at index is not equal to the minimum, changes were made) 
		data.set(index,min); //set the value at index to the minimum
		data.set(location,current); //set the value at location ( which held the minimum ) to the old value held at index 
		// System.out.print(data); //prints the arraylist everytime the while loop is run to see the changes and notice errors 
		index += 1; //increment index
	    }
	}
	    
      
    }//end selectionSortV


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable>
	selectionSort( ArrayList<Comparable> input ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	ArrayList<Comparable> load = new ArrayList<Comparable>(); //create a new arraylist<comparable> to hold the values of input
	for(Comparable x: input){ //goes through input
	    load.add(x); //adds each value of input into load, this way load and input will have the same values without load being an alias 
	}
	selectionSortV(load); //uses the void version of this function to sort the values in load
	
	return load; //returns load, which is the sorted version of input (input has not been altered)
    }//end selectionSort 


    public static void main( String [] args ) 
    { /*
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	selectionSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	
	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	selectionSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
        
      */
        
	ArrayList glen = new ArrayList<Integer>();
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
	System.out.println( coco );
	 

    }//end main

}//end class SelectionSort
