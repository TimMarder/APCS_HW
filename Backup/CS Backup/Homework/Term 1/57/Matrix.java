// Tim Marder
// APCS1 pd02
// HW #57 -- How Deep Does the Rabbit Hole Go?
// 2017-12-20

/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
  //constant for default matrix size
  private final static int DEFAULT_SIZE = 2;

  private Object[][] matrix;

  //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
  public Matrix() { // O(1)
  	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
  }


  //constructor intializes an a*a matrix
  public Matrix( int a ) { // O(1)
  	matrix = new Object[a][a];
  }


  //return size of this matrix, where size is 1 dimension
  private int size() { // O(1)
  	return matrix.length;
  }


  //return the item at the specified row & column   
  private Object get( int r, int c ) { // O(1)
  	return matrix[r - 1][c - 1]; //returns the element at r - 1 and c - 1 because matrix rows and columns start at 1, not 0
  }


  //return true if this matrix is empty, false otherwise
  private boolean isEmpty() { // O(n^2)
  	int nulls = 0; //counters for the amount of null elements
  	int total = matrix.length * matrix[0].length; //the total amount of elements
  	for (int row = 0 ; row < matrix.length ; row++) { //goes through the rows
  		for (int element = 0; element < matrix[row].length ; element++) { //goes through the elements in the rows
  			if (matrix[row][element] == null) { //checks to see if each element is null
  				nulls += 1; //if null, updates the nulls variable by +1
  			}
  		}
  	}
  	return nulls == total; //If the amount of nulls is equal to the total amount of elements, then the matrix is empty
  }


  //overwrite item at specified row and column with newVal
  //return old value
  private Object set( int r, int c, Object newVal ) { // O(1)
  	Object oldValue = matrix[r - 1][c - 1]; //sets oldValue variable as the current element at r - 1 and c - 1 (again because matrices start at row 1 and column 1, not 0)
  	matrix[r - 1][c - 1] = newVal; //sets the current location with the new value
  	return oldValue; //returns the old value that is stored in the oldValue variable
  }


  //return String representation of this matrix
  // (make it look like a matrix)
  public String toString() { // O(n^2)
  	String result = ""; //starts off with an empty string
  	for (int row = 0 ; row < matrix.length ; row++) { //goes through the rows
  		result += "| "; //adds the left border for every row
  		for (int element = 0 ; element < matrix[0].length ; element++) { //goes through the elements in each row
  			result += matrix[row][element]; //adds the element
  			result += " "; //adds a space in between elements
  		}
  		result += "|"; //adds the right border for every row
  		result += "\n"; //go to the next line where the next row is going to be
  	}
  	return result; //returns the final matrix
  }


  //override inherited equals method
  //criteria for equality: matrices have identical dimensions,
  // and identical values in each slot
  public boolean equals( Object rightSide ) { // O(n^2)
  	boolean doesEqual = false; //default equal status is false
  	if (rightSide instanceof Matrix) { //checks to see if rightSide is an instance of a Matrix
  		if (rightSide == this) { //if the object is equal to the matrix
  			doesEqual = true; //sets equality status to true
  			return doesEqual; //returns the equality status (true)
  		}
  		if ( ( (Matrix)rightSide ).size() == this.size()) { //Checks to see if the sizes are the same
  			for (int row = 0 ; row < matrix.length ; row++) { //goes through the rows 
  				for (int element = 0 ; element < matrix[row].length ; element++) { //goes through the elements in the rows
  					doesEqual = matrix[row][element].equals( ( (Matrix)rightSide ).get( row , element ) ); //checks for equality for every element
  				}
  			}
  		}
  		return doesEqual; //returns the final equality status value
  	}
  	else {
  		return doesEqual; //if rightSide is not an instance of Matrix, returns the equality status value (false)
  	}
  }


  //swap two columns of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapColumns( int c1, int c2  ) { // O(n^3)
  	Object[] temp = new Object[this.size()]; //temporary storage
  	for (int counter1 = 0 ; counter1 < temp.length ; counter1++) {
  		temp[counter1] = this.get( counter1 + 1 , c1 ); //edits the temporary storage for later use
  	}
  	for (int counter2 = 0 ; counter2 < this.size() ; counter2++) {
  		this.set( counter2 + 1 , c1 , this.get( counter2 + 1 , c2 )); //swaps the first column
  	}
  	for (int counter3 = 0 ; counter3 < this.size() ; counter3++) {
  		this.set( counter3 + 1 , c2 , temp[counter3] ); //swaps the second column (uses temporary storage)
  	}
  }


  //swap two rows of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapRows( int r1, int r2  ) { // O(n^3)
  	Object[] temp = new Object[matrix[0].length]; //temporary storage
  	for (int counter1 = 0 ; counter1 < temp.length ; counter1++) {
  		temp[counter1] = this.get( r1 , counter1 + 1 ); //edits the temporary storage for later use
  	}
  	for (int counter2 = 0 ; counter2 < matrix[0].length ; counter2++) {
  		this.set( r1 , counter2 + 1 , this.get( r2 , counter2 + 1 )); //swaps the first row
  	}
  	for (int counter3 = 0 ; counter3 < matrix[0].length ; counter3++) {
  		this.set( r2 , counter3 + 1 , temp[counter3] ); //swaps the second row (uses temporary storage)
  	}
  }


  public static void fill(Matrix a) { //a method to quickly fill a matrix for better testing
  	int counter = 1; //counter starts at 1 (since rows and columns begin counting with 1 & for easier counting)
  	for (int row = 1 ; row < a.size() + 1; row++) { //goes through the rows
  		for (int element = 1 ; element < a.size() + 1; element++) { //goes through the elements in the rows
  			a.set( row , element , counter ); //sets each element in the matrix with the counter value
  			counter += 1; //updates the counter value
  		}
  	}
  }


  //main method for testing
  public static void main( String[] args ) { // O(n^3)
  	System.out.println("Creating default sized matrix neo...");
  	System.out.print("\n");

  	Matrix neo = new Matrix(); //FYI neo is the main character in the movie "The Matrix" :)

  	System.out.println("Printing matrix neo...");
  	System.out.print("\n");

  	System.out.println(neo);

  	System.out.println("Creating 4x4 sized matrix leo...");
  	System.out.print("\n");

  	Matrix leo = new Matrix(4);

  	System.out.println("Printing matrix leo...");
  	System.out.println("\n");

  	System.out.println(leo);

  	System.out.println("Filling matrix leo...");

  	fill(leo);

  	System.out.println("Printing filled matrix leo...");

  	System.out.println(leo);

  	System.out.println("The size of a row in array leo is " + leo.size());
  	System.out.print("\n");

  	System.out.println("The element at row 2, column 4 is " + leo.get(2,4));
  	System.out.print("\n");

  	System.out.println("Is martix leo empty? " + leo.isEmpty());
  	System.out.println("Is matrix neo empty? " + neo.isEmpty());
  	System.out.print("\n");

  	System.out.println("Editing matrix neo...");
  	System.out.println("Setting row 1, column 1 --> yes");
  	neo.set(1,1,"yes");
  	System.out.println("Setting row 1, column 2 --> tim");
  	neo.set(1,2,"tim");
  	System.out.println("Setting row 2, column 1 --> dog");
  	neo.set(2,1,"dog");
  	System.out.println("Setting row 2, column 2 --> cat");
  	neo.set(2,2,"cat");
  	System.out.print("\n");

  	System.out.println("Printing new array neo...");
  	System.out.println(neo);

  	System.out.println("Creating 2D array zeo with default size...");
  	Object[][] zeo = new Object[2][2];

  	System.out.println("Editing 2D array zeo to be identical to matrix neo");
  	System.out.println("Setting row 1, column 1 --> yes");
  	zeo[0][0] = "yes";
  	System.out.println("Setting row 1, column 2 --> tim");
  	zeo[0][1] = "tim";
  	System.out.println("Setting row 2, column 1 --> dog");
  	zeo[1][0] = "dog";
  	System.out.println("Setting row 2, column 2 --> cat");
  	zeo[1][1] = "cat";
  	System.out.print("\n");

  	System.out.println("Printing 2D array zeo...");
  	System.out.print("\n");
  	System.out.println("| " + zeo[0][0] + " " + zeo[0][1]+ " |");
  	System.out.println("| " + zeo[1][0] + " " + zeo[1][1]+ " |");
  	System.out.print("\n");

  	System.out.println("Does matrix neo equal to 2D array zeo? " + neo.equals(zeo));
  	System.out.print("\n");

	System.out.println("Swapping columns 1 and 3 of Matrix leo...");
	leo.swapColumns(1,3);
	System.out.print("\n");

	System.out.println("Printing Matrix leo...");
	System.out.println(leo);

	System.out.println("Now swapping rows 1 and 2 of Matrix leo...");
	leo.swapRows(1,2);
	System.out.print("\n");

	System.out.println("Printing Matrix leo...");
	System.out.println(leo);
  }

}//end class Matrix
