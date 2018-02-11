// Tim Marder
// APCS2 pd02
// HW#05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
// 2018-02-07

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  The original array is cut in half and then the new arrays are cut in half and the
  process continues until the smaller arrays are cut into the smallest possible
  array size (1). Since the arrays have one element, that means that they are sorted,
  so then the arrays are ready to be merged to together. Since the arrays are sorted,
  the merge method works properly by comparing the elements at the front of the arrays
  and placing them in the appropriate order in the new array. This process continues
  until there are finally two arrays again which are then merged into the final array
  which should be completely sorted.
  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b ) {
  	int[] finalArray = new int[a.length + b.length]; //length of final array is the sum of the two being merged
  	int indexA = 0; //placeholder for index of first array currently at
  	int indexB = 0; //placeholder for index of second array currently at

  	for (int counter = 0 ; counter < finalArray.length ; counter++) { //while there are still elements to merge
  		if (a.length > indexA && b.length > indexB) { //if there are still elements in both arrays left to merge
  			if (a[indexA] < b[indexB]) { //if element at current index of the first array is smaller than the element at the current index of the second array
  				finalArray[counter] = a[indexA]; //set the current index of the final array to the element at the current index of the first array
  				indexA++; //increase index of first array by 1
  			}
  			else { //if element at current index of the second array is smaller than the element at the current index of the first array
  				finalArray[counter] = b[indexB]; //set the current index of the final array to the element at the current index of the second array
  				indexB++; //increase index of first array by 1
  			}
  		}
  		else { //if one of the arrays runs out of elements to merge
  			if (a.length == indexA) { //if the first array runs out of elements to merge
  				finalArray[counter] = b[indexB]; //set the current index of the final array to the element at the current index of the second array
  				indexB++; //increase index of second array by 1
  			}
  			else { //if the second array runs out of elements to merge
  				finalArray[counter] = a[indexA]; //set the current index of the final array to the element at the current index of the first array
  				indexA++; //increase index of first array by 1
  			}
  		}
  	}
  	return finalArray; //returns final array
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr ) {
  	int[] half1 = new int[arr.length / 2]; //takes the first half of the array to sort
  	int[] half2 = new int[arr.length - half1.length]; //takes the second half of the array to sort

  	if (arr.length == 1) { //if the length of the array is 1, that means that it is already sorted
  		return arr; //since the array is sorted, it can be returned
  	}
  	else { //if the length of the array is greater than 1
  		for (int counter = 0 ; counter < half1.length ; counter++) { //for every element in the first half of the array being sorted
  			half1[counter] = arr[counter]; //set the current index of the first half of the array to the current index of the original array
  		}
  		for (int counter = 0 ; counter < half2.length ; counter++) { //for every element in the second half of the array being sorted
  			half2[counter] = arr[half1.length + counter]; //set the current index of the second half of the array to the current index of the
  		}                     //original array + the length of the first half since it is now looking at the second half of the original array
  	}
  	int[] sorted1 = sort(half1); //sorts the first half of the array
  	int[] sorted2 = sort(half2); //sorts the second half of the array
  	return merge( sorted1 , sorted2 ); //merges the two sorted arrays and returns the final array
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    String array = "";
    array += "[";
    for( int i : a )
      array += i + ",";
    array = array.substring( 0 , array.length() - 1 );
    array += "]";
    System.out.println(array);
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {
      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};
      int[] arr8 = {5,10,15,20,25,30,35,40}; //added test case for better testing merge
      int[] arr9 = {3,6,9,12,15,18,21,24,27}; //added test case for better testing merge

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr8 );
      mess(arr3);
      printArray( arr9 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr8 and arr9: ");
      printArray( merge(arr8,arr9) );

      System.out.println("\narr4-7 unsorted:");
      printArray( arr4 );
      printArray( arr5 );
      printArray( arr6 );
      printArray( arr7 );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
     /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
