// Tim Marder
// APCS1 pd02
// HW #46: Al<B> Sorted!.
// 2017-12-05

import java.util.ArrayList;

public class ALTester {

	public static boolean Sort(ArrayList<Comparable> a) {
		for (int counter = 0 ; counter < a.size() - 1 ; counter++) {
			if (a.get(counter).compareTo(a.get(counter + 1)) > 0) {
				return false;
			}
		}
		return true;
	}



	public static void main(String[] args) {
		ArrayList<Comparable> foo = new ArrayList<Comparable>();
		for (int counter = 0 ; counter < 23 ; counter++) {
			foo.add(counter);
		}
		System.out.println("ArrayList foo:");
		System.out.println(foo);
		System.out.println("ArrayList foo is sorted: " + Sort(foo));
		System.out.println("\n");

		ArrayList<Comparable> goo = new ArrayList<Comparable>();
		for (int counter = 0 ; counter < 22 ; counter++) {
			goo.add(counter);
		}
		goo.add(7);
		System.out.println("ArrayList goo:");
		System.out.println(goo);
		System.out.println("ArrayList goo is sorted: " + Sort(goo));
	}
}