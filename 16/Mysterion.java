/*
Tim Marder
APCS2 pd2
HW#16 -- About Face
2018-03-08
*/


/***********************************
            Pseudocode:
			
function Mysterion(a, b, c, arr)
   v = arr[c]
   swap arr[c], arr[b]
   s = a
   for i in [a ... b-1]
      if arr[i] < v
         swap arr[s], arr[i]
         s += 1
   swap arr[b], arr[s]
   return s
   
  where... a = 0 , b = 4 , c = 2
***********************************/

public class Mysterion {
	
	public static void swap(int a , int b , int[] arr) {
		
		int x = arr[a];
		arr[a] = arr[b];
		arr[b] = x;
		
	}
	
	/*
	I named this function sortMedian because it uses the median, or the midpoint 
	of the array to compare to other elements in the array to create swaps.
	
	int low: this is the lower bound of where the function is looking for swaps.
	int high: this is the higher bound of where the function is looking for swaps.
	int mid: this is the midpoint or median of the array where the element at that
    index with other elements to swap them.
	int[] arr: this is the actual array where all the magic is happening.
	
	The way this method works is that the for loop goes through the elements from
	left to right and compares the current element to the original median element.
	If the median element is larger than the element at which the counter is 
	currently at, then the element that is currently the swapper, which is the 
	variable that is defined in the beginning as the lowest element, swaps with
	the element at the current counter locations. If this happens, the swapper
	counter increase by 1 and the next element would be swapped if the if
	statement were to be true again. In the end, the method returns the total
	amount of swaps since it has been counting with the swapper variable and has
	been increasing by 1 after each swap. This is a semi-sorting method since
	it only swaps elements if the median element is larger than the element
	currently being looked at with the counter but there's no comparisons
	between the median element and elements smaller than it. So if an element
	were to be smaller than the median element, they wouldn't swap, causing
	this to be only a semi-sorting method.
	*/
	
	public static int sortMedian(int low , int high , int mid , int[] arr) {
		
		int med = arr[mid];
		swap(mid , high , arr);
		int swapper = low;
		
		for (int counter = 0 ; counter < high - 1 ; counter++) {
			if (med > arr[counter]) {
				swap(swapper , counter , arr);
				swapper++;
			}
		}
		swap(high , swapper , arr);
		return swapper;
		
	}
	
	public static void printArr(int[] arr) {
		
		String result = "";
		result += "[";
		for (int element : arr) {
			result += element + " , ";
		}
		result = result.substring(0,result.length() - 3);
		result += "]";
		System.out.println(result);
		
	}
	
	public static void main(String[] args) {
		
		int[] arr1 = {15,9,4,3,1};
		int[] arr2 = {8,2,13,7,1};
		int[] arr3 = {2,6,11,4,9};
		
		
		System.out.println("\n");
		
		//arr1
		System.out.println("Printing arr1...");
		printArr(arr1);
		System.out.println("semi-sorting...");
		int s1 = sortMedian(0 , 4 , 2 , arr1);
		printArr(arr1);
		System.out.println("That took " + s1 + " swaps");
		
		
		System.out.println("\n");
		
		//arr2
		System.out.println("Printing arr2...");
		printArr(arr2);
		System.out.println("semi-sorting...");
		int s2 = sortMedian(0 , 4 , 2 , arr2);
		sortMedian(0 , 4 , 2 , arr2);
		printArr(arr2);
		System.out.println("That took " + s2 + " swaps");
		
		
		System.out.println("\n");
		
		//arr3
		System.out.println("Printing arr3...");
		printArr(arr3);
		System.out.println("semi-sorting...");
		int s3 = sortMedian(0 , 4 , 2 , arr3);
		sortMedian(0 , 4 , 2 , arr3);
		printArr(arr3);
		System.out.println("That took " + s3 + " swaps");
		
	}
	
}