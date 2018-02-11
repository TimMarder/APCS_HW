// Hasif Ahmed
// APCS1 pd2
// HW45 -- In America, the Driver Sits on the Left
// 2017-12-04


public class SuperArray extends java.lang.Object implements List
{

    private Object[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new Object[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
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
  private void expand()
  {
      Object[] temp = new Object[ size() * 2 ];
    for( int i = 0; i < size(); i++ )
      temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return value at specified index
    public java.lang.Object get( int index )
    {
	if( index < 0 || index >= size() ){
	    throw new java.lang.IndexOutOfBoundsException("Index out of bounds.");
	}
	return _data[index];
    }


  //mutator -- set value at index to newVal,
  //           return old value at index
    public java.lang.Object set( int index, java.lang.Object o )
    {
	if( index < 0 || index >= size() ){
	    throw new java.lang.IndexOutOfBoundsException("Index out of bounds.");
	}
	Object temp = _data[index];
	_data[index] = o;
	return temp;
    }


  //adds an item after the last item
  public boolean add( java.lang.Object o )
  {
    add( _size, o );
    return true;
  }


  //inserts an item at index
    public void add( int index, java.lang.Object o )
    {
	if( index < 0 || index >= size()){
	    throw new java.lang.IndexOutOfBoundsException("Index is out of bounds.");
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
    public java.lang.Object remove( int index )
    {
	if( index < 0 || index >= size() ){
	    throw new java.lang.IndexOutOfBoundsException("Index out of bounds.");
	}
	Object oldVal = _data[index];
        for( int i = index; i < _size - 1; i++ ) {
	    _data[i] = _data[i+1];
	}
	_size--;
        
	return oldVal;
    }


  //return number of meaningful items in _data
  public int size()
  {
    return _data.length;
  }



  //main method for testing
   //main method for testing
    public static void main( String[] args )
    {
    
	List mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add("duh");
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(true);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);
	

	System.out.println("Printing object at index 0...");
	System.out.println(mayfield.get(0));
	System.out.println("Printing object at index 1...");
	System.out.println(mayfield.get(1));
	System.out.println("Printing object at index 4...");
	System.out.println(mayfield.get(4));

	System.out.println("Setting element at index 5... ");
	System.out.println(mayfield.set(5, 27));
	System.out.println(mayfield);
	System.out.println("Setting element at index 0... ");
	System.out.println(mayfield.set(0, 91));
	System.out.println(mayfield);
	System.out.println("Setting element at index 9...");
	System.out.println(mayfield.set(9, "duh"));
	System.out.println(mayfield);

	SuperArray notInterface = new SuperArray();
	System.out.println("Printing empty SuperArray notInterface...");
	System.out.println(notInterface);

	notInterface.add(0,"never");
	notInterface.add(1,"hello");
	notInterface.add(0,12);
	System.out.println("Printing populated SuperArray notInterface...");
	System.out.println(notInterface);

	notInterface.remove(0);
	notInterface.remove(1);
	System.out.println("Printing current SuperArray notInterface...");
	System.out.println(notInterface);
	
    }//end main()


}//end class


