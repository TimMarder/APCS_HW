public interface List {

	//Append (adds) the argument to the end of this list.
	boolean add(java.lang.Object x);

	//Returns the element at the specified position in this list.
	java.lang.Object get(int index);

	//Replaces the element at the specific position in this list with
	//the specific object.
	java.lang.Object set(int index, java.lang.Object o);

	int size();
	
}//end interface List
