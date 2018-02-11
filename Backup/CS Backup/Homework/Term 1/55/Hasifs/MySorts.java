//Hasif Ahmed Kyle Tau 
//APCS1 pd2
//HW55 -- Never Fear, Big Oh is here!
//2017-12-14
import java.util.ArrayList;
public class MySorts
{
    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    
    // Makes n-1 passes acorss the collection, and constants are insignificant, so if we ignore the -1, the number of passes is just n.
    // Best Case: O(n)
    // Makes n-1 passes without any swaps
    // Worst Case: O(n^2)
    // Makes n-1 passes with the swaps.Passes through n times for EACH element, so n^2.
    public static void bubbleSortV( ArrayList<Comparable> data )
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
    }
  
    
    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order

    //Best Case: O(n^2)
    //Looks at each element (n elements) for n-1 passes (n*n-1)
    //Worst Case: O(n^2)
    //Looks at each element (n elements) for n-1 passes (n*n-1)
    public static void selectionSortV( ArrayList<Comparable> data ) 
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
    }//end selectionSortV



    
    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order

    //Best Case: O(n)
    //Already sorted, each pass only takes a look at the n elements (n operations)
    //Worst Case: O(n^2)
    //n-1 passes, each time doing add(), which is O(n), so n-1*n is O(n^2)
    public static void insertionSortV( ArrayList<Comparable> data )
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
    }//end insertionSortV

    /* 
       Method add()
       Search Type: Linear f(n) = n
       The best case scenario would be if the value being added belonged at the first index looked at. This is because this linear search traverses through the list from left 
       to right. So, if  the element belonged at index 0, it would be compared to the current value at index 0 and then added to that position, and wouldn't have to go through the rest
       of the list. Best Case: O(1)
       The worst case scenario for linear searches would mean going through the entire data set. This would
       mean that the element belonged at the end of the data set, and so in this case, would be greater than all the current elements in the set. Worst Case: O(n)
       
       Method: addBin()
       Search Type: Logarithmic h(n) = log(n) (log base 2)
       It's useful to know that h(n) is Big Oh of f(n), which means that the number of comparisons for this method will always be less than for the add() method. The best case scenario 
       for this method would be if the value belonged at the middle of the collection. This way it would only take one comparison to add the value. Best Case: O(1)
       Another way to say this is O(1). The worst case scenario for this method would be if the value belonged one away from the ends or the middle. This would mean that the method will 
       use its max number of comparisons, which is represented by log(n) (log base 2). Worst Case: O(log(n) (log base 2))

      
    */

    
  
    public static void main(String[] args){
    }

}
