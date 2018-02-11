// Tim Marder
// APCS1 pd02
// HW#59 -- Make the Matrix Work For You
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

    private Object[][] _matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix()
    {
	_matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) 
    {
	_matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size() 
    {
	return _matrix.length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) 
    {
	return _matrix[r-1][c-1];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) 
    {
	return get(r,c) == null;

    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) 
    {
	Object retVal = _matrix[r-1][c-1];
	_matrix[r-1][c-1] = newVal;
	return retVal;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() 
    {
	String foo = "";
	for( int i =0; i < size(); i++ ) {
	    foo += "| ";
	    for( int j=0; j < size(); j++ ) {
		foo += _matrix[i][j] + " "; //get(i+1,j+1)
	    }
	    foo += "|\n";
	}
	
	return foo;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) 
    {
	boolean foo = false;

	if (this == rightSide) foo = true;  
	// checks for aliases  ex. m1.equals(m1) is true

	else if ( rightSide instanceof Matrix 
		  && size() == ( (Matrix)rightSide).size() ) {
	    Matrix r = (Matrix) rightSide; //for cleaner code later
	    foo = true;
	    outer:
	    for( int i = 0; i < size(); i++ ) {
		for( int j = 0; j < size(); j++ ) {
		    if ( !isEmpty(i,j) && ( !get(i,j).equals(r.get(i,j) ) ) ) {
			foo = false;
			break outer;
		    }
		    else if ( !( isEmpty(i,j) && r.isEmpty(i,j) ) ) {
			foo = false;
			break outer;
		    }
		}
	    }
	}
	return foo;
    }//end equals()



    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) 
    {
	c1 = c1-1;
	c2 = c2-1;
    
	for( int i = 0; i < size(); i++ ) {
	    set( i, c1, set( i, c2, get(i,c1) ) );
	}
    }//O(n) b/c must visit n rows


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) 
    {
	r1 = r1-1;
	r2 = r2-2;
	Object [] temp = _matrix[r1];
	_matrix[r1] = _matrix[r2];
	_matrix[r2] = temp; 
    }//O(1)


    public static void fill(Matrix a) { //a method to quickly fill a matrix for better testing
        int counter = 1; //counter starts at 1 (since rows and columns begin counting with 1 & for easier counting)
        for (int row = 1 ; row < a.size() + 1; row++) { //goes through the rows
            for (int element = 1 ; element < a.size() + 1; element++) { //goes through the elements in the rows
                a.set( row , element , counter ); //sets each element in the matrix with the counter value
                counter += 1; //updates the counter value
            }
        }
    } 


    //            PHASE 2
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //returns copy of row r
    public Object[] getRow( int r ) {
        Object[] result = new Object[this.size()]; //The 1D array that is going to be returned (the row)
        for (int counter = 0 ; counter < this.size() ; counter++) { //goes through the elements
            result[counter] = get( r , counter + 1 ); //gets the element at the specified row and column based on the counter + 1
        }
        return result; //returns the final row
    }//O(1)

    //replaces row r with 1D array newRow
    //returns old row
    public Object[] setRow( int r, Object[] newRow ) {
        Object[] result = new Object[this.size()]; //old row that is later going to be returned
        for (int counter = 0 ; counter < this.size() ; counter++) { //goes through the elements
            Object temp = _matrix[r - 1][counter];
            _matrix[r - 1][counter] = newRow[counter]; //edits the row
            result[counter] = temp; //sets the old row properly
        }
        return result; //returns the old row
    }//O(n)

    public Object[] setCol( int c, Object[] newCol ) {
        Object[] result = new Object[_matrix[0].length]; //old column that is later going to be returned
        for (int counter = 0 ; counter < this.size() ; counter++) {  //goes through the elements
            Object temp = _matrix[counter][c - 1];
            _matrix[counter][c - 1] = newCol[counter]; //edits the column
            result[counter] = temp; //sets the old column properly
        }
        return result; //returns the old column
    }//O(n)

    //M[i,j] -> M[j,i] for all i,j
    public void transpose() {
        for (int row = 0 ; row < this.size() - 1 ; row++) {
            for (int col = 1 ; col < this.size() - 1 ; col++) {
                Object i = _matrix[row][col]; //temporary storage for the old x,y value
                Object j = _matrix[col][row]; //temporary storage for the old y,x value
                _matrix[row][col] = j; //sets the x,y value to the y,x value
                _matrix[col][row] = i; //sets the y,x value to the x,y value
            }
        }
    }//O(n^2)
    
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
   
    
    //main method for testing
    public static void main( String[] args ) {
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

    Object[] newrow = new Object[4];
    newrow[0] = "bro";
    newrow[1] = "now";
    newrow[2] = "lol";
    newrow[3] = "toy";
    System.out.println("Setting row 2 of leo to | bro now lol toy | ...");
    leo.setRow( 2 , newrow );

    System.out.println("Printing new matrix leo...");
    System.out.println(leo);

    Object[] newcol = new Object[4];
    newcol[0] = "A";
    newcol[1] = "B";
    newcol[2] = "C";
    newcol[3] = "D";
    System.out.println("Setting column 1 of leo to:");
    System.out.println("A");
    System.out.println("B");
    System.out.println("C");
    System.out.println("D");
    leo.setCol( 1 , newcol );
    System.out.println("\n");

    System.out.println("Printing new matrix leo...");
    System.out.println(leo);

    System.out.println("Time to transpose matrix leo...");

    System.out.println("Transposing commencing...");
    leo.transpose();
    System.out.println("Transpoing complete!");

    System.out.println("Printing newly transposed matrix leo...");
    System.out.println(leo);

    /****
    System.out.println("The size of a row in array leo is " + leo.size());
    System.out.print("\n");

    System.out.println("The element at row 2, column 4 is " + leo.get(2,4));
    System.out.print("\n");

    System.out.println("Is martix leo empty? " + leo.isEmpty());
    System.out.println("Is matrix neo empty? " + neo.isEmpty());
    System.out.print("\n");
    ****/

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

    System.out.println("Printing row 1 of zeo...");
    System.out.print("| ");
    for (Object a : zeo[0]) {
        System.out.print(a + " ");
    }
    System.out.print("|");


    /****
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
    ****/
    }//end main()

}//end class Matrix
