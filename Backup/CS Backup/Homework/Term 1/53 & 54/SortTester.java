/***********************
 * class SortTester -- Tests bubbleSort, selectionSort, and insertionSort.
 ***********************/


// Team Spongebob -- Tim Marder & Brandon Chong
// Tim Marder
// APCS1 pd02
// HW53 -- Solid Comparative Analysis
// 2017-12-14

import java.util.ArrayList;

public class SortTester {

    public static void main(String[] args) {
    	System.out.println("============[BubbleSort]============");
		ArrayList bestCaseBub = new ArrayList<Integer>();
		bestCaseBub.add(1);
		bestCaseBub.add(3);
		bestCaseBub.add(5);
		bestCaseBub.add(7);
		bestCaseBub.add(12);

		/*We believe that the best case scenario for BubbleSort
		is when the array is fully sorted. Using the values from
		our favorite arraylist ([7,1,5,12,3]), we created the
		bestCaseBub arraylist ([1,3,5,7,12]). We believe that
		this arraylist would be the best case scenario for 
		BubbleSort because as it goes through all of the elements
		and compares the neighbor pairs one by one, it wouldn't
		have to make any swaps since all of the elements are
		already arranged in ascending order. This would use up
		the least amount of computer resources since no swaps are
		actually needed*/ 

		System.out.println("\n");
		System.out.println("=~=~=~=~{Best Case}~=~=~=~=");
		System.out.println("BubbleSort best case scenario: " + bestCaseBub);
		MySorts.bubbleSort(bestCaseBub);
		System.out.println("After sorting: " + bestCaseBub);

		ArrayList worstCaseBub = new ArrayList<Integer>();
		worstCaseBub.add(12);
		worstCaseBub.add(7);
		worstCaseBub.add(5);
		worstCaseBub.add(3);
		worstCaseBub.add(1);

		/*The worst case scenario for BubbleSort would be an
		arraylist that is sorted in descending order, or sorted
		backwards. We think that this is the worst case scenario
		because when BubbleSort compares the adjacent elements,
		it would have to make the most amount of swaps possible
		than any other combination of elements*/

		System.out.println("\n");
		System.out.println("=~=~=~=~{Worst Case}~=~=~=~=");
		System.out.println("BubbleSort worst case scenario: " + worstCaseBub);
		MySorts.bubbleSort(worstCaseBub);
		System.out.println("After sorting: " + worstCaseBub);
		System.out.println("\n");

		System.out.println("============[SelectionSort]============");
		ArrayList bestCaseSel = new ArrayList<Integer>();
		bestCaseSel.add(1);
		bestCaseSel.add(3);
		bestCaseSel.add(5);
		bestCaseSel.add(7);
		bestCaseSel.add(12);

		/*We also believed that the best case scenario for SelectionSort
		is an already sorted arraylist. After reviewing Mr. Brown's code
		on SelectionSort, we agreed that there is no distinct best or
		worst case scenario for SelectionSort, but since we have to think
		of 2 scenarios, we just created combinations that made the most
		sense to us. The best case scenario is an already sorted arraylist
		because although SelectionSort will go through every single element
		either way and swap them whether its needed or not, the original
		arraylist is already done, so it would make sense that even though
		the elements are being swapped, it goes back to its original state
		in the end, making it the best case scenario.*/

		System.out.println("\n");
		System.out.println("=~=~=~=~{Best Case}~=~=~=~=");
		System.out.println("SelectonSort best case scenario: " + bestCaseSel);
		MySorts.selectionSort(bestCaseSel);
		System.out.println("After sorting: " + bestCaseSel);

		ArrayList worstCaseSel = new ArrayList<Integer>();
		worstCaseSel.add(3);
		worstCaseSel.add(5);
		worstCaseSel.add(7);
		worstCaseSel.add(12);
		worstCaseSel.add(1);

		/*Like said in the previous comment block, we agreed that there
		isn't really a distinct best or worse case scenarios for 
		SelectionSort, but since we have to choose them, we went with
		what made the most sense to us. So in our opinion, the worst case
		scenario is when all the elements are moved to the left by one
		index and the element that belongs at index 0 moves all the way to
		the last index. This combination is unique because the way SelectionSort
		works, it would have to compare all of the elements until it gets to the
		last element and realizes that the very last element is actually the one
		that belongs in the index that is being compared. So starting from index 0,
		SelectionSort would have to go all the way to the last index and replace it
		with the element at index 0, now placing the element that was at index 0 to
		the last index. Now that element that is at the last index, is actually
		the element the belongs at index 1, and SelectionSort would again, have to
		compare the element at index 1 to all of the other elements till it gets
		to the last index and swap them. This pattern continues until the elements
		in the last 2 indexes are swapped. We believe this is the worst case scenario
		because it has the most inconvinient swaps.*/

		System.out.println("\n");
		System.out.println("=~=~=~=~{Worst Case}~=~=~=~=");
		System.out.println("SelectionSort worst case scenario: " + worstCaseSel);
		MySorts.selectionSort(worstCaseSel);
		System.out.println("After sorting: " + worstCaseSel);
		System.out.println("\n");

		System.out.println("============[InsertionSort]============");
		ArrayList bestCaseIns = new ArrayList<Integer>();
		bestCaseIns.add(1);
		bestCaseIns.add(3);
		bestCaseIns.add(5);
		bestCaseIns.add(7);
		bestCaseIns.add(12);

		/*For InsertionSort, we also decided that the best case scenario is an
		already sorted arraylist. Since InsertionSort looks at one element and
		keeps track of it as it "walks" it by swapping it with adjacent elements
		if it meets the correct criteria. An already sorted arraylist would not require
		any swaps, making the amount of computer resources required less.*/

		System.out.println("\n");
		System.out.println("=~=~=~=~{Best Case}~=~=~=~=");
		System.out.println("InsertionSort best case scenario: " + bestCaseIns);
		MySorts.insertionSort(bestCaseIns);
		System.out.println("After sorting: " + bestCaseIns);

		ArrayList worstCaseIns = new ArrayList<Integer>();
		worstCaseIns.add(12);
		worstCaseIns.add(7);
		worstCaseIns.add(5);
		worstCaseIns.add(3);
		worstCaseIns.add(1);

		/*The worst case scenario for InsertionSort is also a backwards sorted
		arraylist, or an arraylist sorted in descending order, just like BubbleSort.
		This is because when the sorting begins with the first element comparing itself
		to the adjacent element, it would have to walk itself to the very end of the
		arraylist, and after the first pass, the second element will now have to walk
		itself past all the other elements because of the way the pattern works. This
		would cause the arraylist to have the most amount of swaps possible than any
		other combination of elements, causing it to be the worst case scenario.*/

		System.out.println("\n");
		System.out.println("=~=~=~=~{Worst Case}~=~=~=~=");
		System.out.println("InsertionSort worst case scenario: " + worstCaseIns);
		MySorts.insertionSort(worstCaseIns);
		System.out.println("After sorting: " + worstCaseIns);

    }

}
