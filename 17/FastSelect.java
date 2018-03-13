// Tim Marder
// APCS2 pd02
// HW#17 -- So So Fast
// 2018-03-12

/*******************[PSEUDOCODE]********************

fxn partition( arr, left, right, pvtPos )
    pvtVal = arr[pvtPos]
    swap arr[pvtPos], arr[right] // move pivot to end
    storPos = left

    for i in [left..right-1]
        if arr[i] < pvtVal
       swap arr[storPos], arr[i]
       storPos += 1

    //move pivot back to previous location
    swap arr[right], arr[storPos]

    return storPos
	
***************************************************/

/*
Algorithm:

My algorithm finds the yth smallest element of an array by using
the partition algorithm. After multiple traces, I realized that
the pos value that first starts out as the starting index always
ends up being 1 less than the y value. I think it works this way
because it accounts for the amount of elements in the array - 1.
For example, if we are looking for the smallest element, the y
value would be 1, so there would be 0 elements lesser than it,
therefore making the pos value 0. If y = 2, then pos = 1, etc. So
knowing this, I created a simple if function call that checks if
the pos value + 1 equals to y, and if it does, it would return
the element, which would be the yth smallest value.

The best case scenario is when the first element of the array is
the yth smallest element [ O(n) ].

The worse case scenario is when the last element of the array is
the yth smallest element [ O(n^2) ].

*/

public class FastSelect{
	
	public static int split(int start, int finish, int index, int[] arr) {
		
		int iElement = arr[index];
		int pos = start;
		
		for (int i = start ; i <= finish ; i++) {
			if (iElement > arr[i]) {
				pos += 1;
			}
		}
		return pos;
		
	}
	
	public static int findYsmallest(int y, int[] arr) {
		
		for (int i = 0 ; i < arr.length ; i++) {
			if (split(0, arr.length - 1, i, arr) + 1 == y) {
				return arr[i];
			}
		}
		return -1;
	}
	
	public static void printArr(int[] arr) {
		
		String result = "";
		result += "[";
		for (int element : arr) {
			result += element + " , ";
		}
		result = result.substring(0, result.length() - 3);
		result += "]";
		System.out.println(result);
		
	}
	
	public static void Yelements(int[] arr) {
		
		for (int counter = 1 ; counter < arr.length ; counter++) {
			if (counter == 1) {
				System.out.println("1st smallest element: " + findYsmallest(1, arr));
			}
			else if (counter == 2) {
				System.out.println("2nd smallest element: " + findYsmallest(2, arr));
			}
			else {
				System.out.println(counter + "th smallest element: " + findYsmallest(counter, arr));
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] arr0 = {7,1,5,12,3};
		int[] arr1 = {12,82,56,31,98,13,76,55,46};
		int[] arr2 = {7,1,8,2,3,9,4};
		
		System.out.println("\n");
		
		//arr0
		System.out.println("Printing arr0...");
		printArr(arr0);
		System.out.println("Finding yth smallest elements...");
		Yelements(arr0);
		
		System.out.println("\n");
		
		//arr1
		System.out.println("Printing arr1...");
		printArr(arr1);
		System.out.println("Finding yth smallest elements...");
		Yelements(arr1);
		
		System.out.println("\n");
		
		//arr2
		System.out.println("Printing arr2...");
		printArr(arr2);
		System.out.println("Finding yth smallest elements...");
		Yelements(arr2);
	
	}
	
}
	