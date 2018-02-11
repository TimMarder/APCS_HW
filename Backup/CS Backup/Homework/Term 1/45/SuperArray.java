// Tim Marder
// APCS1 pd02
// HW45 -- In America, the Driver Sits on the Left
// 2017-12-04 M

/***************************
 * class SuperArray version 3.0
 * ( SKELETON )
 * Wrapper class for array. Facilitates resizing,
 * resizing
 * expansion
 * read/write capability on elementse
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 *
 * ...and now SuperArray complies with the specifications of the
 * ListInt interface. (ListInt.java must be in same dir as this file)
 ***************************/

public class SuperArray extends java.lang.Object implements List {
	private Object[] _data;  //underlying container
	private int _size;    //number of elements in this SuperArray


	//default constructor – initializes 10-item array
	public SuperArray() {
		_data = new Object[10];
		_size = 0;
	}


	//output SuperArray in [a,b,c] format
	public String toString() {
		String foo = "[";
		for( int i = 0; i < _size; i++ ) {
			foo += _data[i] + ",";
		}
		if ( foo.length() > 1 )
			//shave off trailing comma
			foo = foo.substring( 0, foo.length()-1 );
		foo += "]";
		return foo;
	}


	//double capacity of SuperArray
	private void expand() {
		Object[] temp = new Object[ _data.length * 2 ];
		for( int i = 0; i < _data.length; i++ )
			temp[i] = _data[i];
		_data = temp;
	}


	//accessor -- return value at specified index
	public java.lang.Object get( int index ) {
		if (index < 0 || index >= size()) {
			throw new java.lang.IndexOutOfBoundsException("Index Out Of Bounds");
		}
		return _data[index];
	}


	//mutator -- set value at index to newVal,
	//           return old value at index
	public java.lang.Object set( int index, java.lang.Object o ) {
		if (index < 0 || index >= size()) {
			throw new java.lang.IndexOutOfBoundsException("Index Out Of Bounds");
		}
		Object temp = _data[index];
		_data[index] = o;
		return temp;
	}


	//adds an item after the last item
	public boolean add( java.lang.Object o ) {
		add( _size, o );
		return true;
	}


	//inserts an item at index
	public void add( int index, java.lang.Object o ) {
		if (index < 0 || index >= size()) {
			throw new java.lang.IndexOutOfBoundsException("Index out of bounds");
		}
		//first expand if necessary
		if ( _size >= _data.length )
			expand();
		for( int i = _size; i > index; i-- ) {
			_data[i] = _data[i-1]; //each slot gets value of left neighbor
		}
		_data[index] = o;
		_size++;
	}


	//removes the item at index
	//shifts elements left to fill in newly-empted slot
	public java.lang.Object remove( int index ) {
		if (index < 0 || index >= size()) {
			throw new java.lang.IndexOutOfBoundsException("Index Out Of Bounds");
		}
		Object temp = _data[index];
		for( int i = index; i < _size - 1; i++ ) {
			_data[i] = _data[i+1];
		}
		_size--;
		return temp;
	}


	//return number of meaningful items in _data
	public int size() {
		return _data.length;
	}



	//main method for testing
	public static void main( String[] args ) {
		List mayfield = new SuperArray();
		System.out.println("Printing empty SuperArray mayfield...");
		System.out.println(mayfield);
		System.out.println("\n");

		System.out.println("Adding elements...");
		System.out.println("\n");
		mayfield.add(true);
		mayfield.add(false);
		mayfield.add("hello");
		mayfield.add(2.0);
		mayfield.add(1);

		System.out.println("Printing populated SuperArray mayfield...");
		System.out.println(mayfield);

		System.out.println("\n");

		System.out.println("The element at Index 1 is " + mayfield.get(1));
		System.out.println("The element at Index 3 is " + mayfield.get(3));
		System.out.println("The element at Index 4 is " + mayfield.get(4));

		System.out.println("\n");

		System.out.println("Setting Index 0 to 'Greetings'...");
		mayfield.set( 0 , "Greetings" );
		System.out.println("Setting Index 3 to false...");
		mayfield.set( 3 , false );
		System.out.println("Setting Index 4 to 'Farewell'...");
		mayfield.set( 4 , "Farewell" );

		System.out.println("\n");

		System.out.println("Printing new SuperArray mayfield...");
		System.out.println(mayfield);

		System.out.println("\n");

		SuperArray nayfield = new SuperArray();

		System.out.println("Printing empty SuperArray nayfield...");
		System.out.println(nayfield);

		System.out.println("\n");

		System.out.println("Adding elements...");
		System.out.println("\n");
		nayfield.add("Batman");
		nayfield.add(5);
		nayfield.add("is");
		nayfield.add(71.0);
		nayfield.add("very");
		nayfield.add(false);
		nayfield.add("awesome");

		System.out.println("Printing populated SuperArray nayfield...");
		System.out.println(nayfield);

		System.out.println("\n");

		System.out.println("Removing element at index 1...");
		nayfield.remove(1);
		System.out.println("Removing element at index 3...");
		nayfield.remove(2); //2 because now index 3 is actually index 2
		System.out.println("Removing element at index 5...");
		nayfield.remove(3); //3 because now index 5 is actually index 3

		System.out.println("\n");

		System.out.println("Printing new SuperArray nayfield...");
		System.out.println(nayfield);
	}//end main()


}//end class


/***
             ,,########################################,,
          .*##############################################*
        ,*####*:::*########***::::::::**######:::*###########,
      .*####:    *#####*.                 :*###,.#######*,####*.
     *####:    *#####*                      .###########*  ,####*
  .*####:    ,#######,                        ##########*    :####*
  *####.    :#########*,                       ,,,,,,,,.      ,####:
    ####*  ,##############****************:,,               .####*
     :####*#####################################**,        *####.
       *############################################*,   :####:
        .#############################################*,####*
          :#####:*****#####################################.
            *####:                  .,,,:*****###########,
             .*####,                            *######*
               .####* :*#######*               ,#####*
                 *###############*,,,,,,,,::**######,
                   *##############################:
                     *####*****##########**#####*
                      .####*.            :####*
                        :####*         .#####,
                          *####:      *####:
                           .*####,  *####*
                             :####*####*
                               *######
                                 *##

         -Miranda Chaiken '16

         ***/
