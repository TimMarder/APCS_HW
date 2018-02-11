//Hasif Ahmed
//APCS1 pd2
//HW #59: Make the Matrix Work For You
//2017-12-21
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
    // O(1)
    public Matrix( )
    {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE]; //creates a 2D array with the default size
    }


    //constructor intializes an a*a matrix
    // O(1)
    public Matrix( int a )
    {
	matrix = new Object[a][a]; //creates a 2D array with the input (square, equal length and width)
    }


    //return size of this matrix, where size is 1 dimension
    // O(1)
    private int size() 
    {
	return matrix.length; //returns the horizontal length of the array (number of columns)
    }


    //return the item at the specified row & column
    // O(1)
    private Object get( int r, int c ) 
    {
	return matrix[r - 1][c - 1]; //returns the value at index [r][c], its - 1 from both because the values inputted are based off 1 being the starting index and not 0
    }


    //return true if this matrix is empty, false otherwise
    // O(n^2)
    private boolean isEmpty( int r, int c ) 
    {
	return get(r,c) == null;

    }

    //overwrite item at specified row and column with newVal
    //return old value
    // O(1)
    private Object set( int r, int c, Object newVal ) 
    {
	Object ret = matrix[r - 1][c - 1]; //initializes a variable to hold the value at the index given, its - 1 from both because the values inputted are based off 1 being the starting index and not 0
        matrix[r - 1][c - 1] = newVal; //sets the value at that index to the new value given 
	return ret; //returns the old value 
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    // O(n^2)
    public String toString() 
    {
	String returned = ""; //creates a string to be added on to 
	//String returned = "-"; //coded regions here are attempts to include the -    - as shown in the example 
	/* for( int i = 0; i < matrix.length; i++ ){
	    returned += "\t";
	}
	returned += "-\n";
	*/
	for(int x = 0; x < matrix[0].length; x++){ //through each row 
	    returned += "| "; //begginnig 
	    for(int j = 0; j < matrix.length; j++){ //through each value in the row
		returned += matrix[x][j] + " "; //add that value to the string 
	    }
	    returned += "|\n"; //end 
	}
	/*
	returned += "-";
	for(int l = 0; l < matrix.length; l++){
	    returned += "\t";
	}
	returned += "-";
	*/
	returned = returned.substring(0,returned.length()-1);
	return returned; //return the string 
    }
	    


    
    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    // O(n^2)
    public boolean  equals( Object rightSide )
    {
        if(!(rightSide instanceof Matrix))return false; //checks if the object given is a Matrix or not
	
	//return hold.get(1,1).equals((Object) 23);
     	if(((Matrix)rightSide).size() != this.size()) return false; //checks if the two matrices have the same horizontal length 
	for(int x = 1; x < matrix[0].length+1; x++){ //through the row of the first 
	    for(int j = 1; j < this.size()+1; j++){ //through each element of the first 
		if(this.get(x,j) == null){ //if that element is empty 
		    if(!( ((Matrix)rightSide).get(x,j) == null)){ //if the same element in rightSide is not empty
			return false; //the matrices are not equal
		    }
		}else if(!((this.get(x,j).equals(((Matrix)rightSide).get(x,j))))) //if the elements at the index for each Matrix are not equal 
		    return false; //the matrices are not equal 
	    }
	}
		   
	return true; //passed every test so every element in both matrices are the same 
    }

    
	//swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    //O(n^3)
    public void swapColumns( int c1, int c2  ) 
    {
	Object[] holder = new Object[this.size()]; //intializes a 1D array to hold the values of column 1 
	for(int i = 0; i < holder.length; i++) //places the values of column 1 into holder
	    holder[i] = this.get(i + 1,c1);
	for(int j = 0; j < this.size(); j++) // places the values of column 2 into column 1 
	    this.set(j + 1,c1,this.get(j+1,c2));
	for(int p = 0;p < this.size(); p++) //places the values of holder (initial values of column 1) into column 2 
	    this.set(p + 1,c2,holder[p]);
	
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    // O(n^3)
    public void swapRows( int r1, int r2  )
    {
	Object[] row1 = new Object[matrix[0].length]; //initializes a 1D array to hold the values of row 1 
	for(int i = 0; i < row1.length; i++) //places the values of row 1 into row1
	    row1[i] = this.get(r1,i+1);
	for(int j = 0; j < matrix[0].length; j++) //places the values of row 2 into row 1 
	    this.set(r1,j+1,this.get(r2,j+1));
	for(int p = 0; p < matrix[0].length; p++) //places the values of row1 (initial values of row 1) into row 2
	    this.set(r2,p+1,row1[p]);
	    
    }

    //helper method that returns copy of column c
    public Object[] getCol( int c ) {
        Object[] x = new Object[this.size()]; //creates a 1D array, same size as the size() of matrix
	for(int i = 0; i < this.size(); i++){ //goes through the column c
	    x[i] = get(i+1,c); //copies values of column c from the matrix into the 1D array
	}
	return x; //returns the 1D array 
	
    }//O(1)

    //returns copy of row r

    public Object[] getRow( int r ) {
        Object[] x = new Object[this.size()]; //creates a 1D array, same size as the size() of matrix 
	for(int i = 0; i < this.size(); i++){ //goes through the row r
	    x[i] = get(r,i+1); //copies values of row r from the matrix into the 1D array
	}
	return x; //returns the 1D array 
	
    }//O(1)


    //replaces row r with 1D array newRow

    //returns old row

    public Object[] setRow( int r, Object[] newRow ) {
	Object[] x = new Object[this.size()]; //creates a 1D array, same size as the size() of matrix
	for(int i = 0;i < this.size();i++){ //goes through the row r
	    x[i] = matrix[r-1][i]; //copies values of row r from the matrix into the 1D array 
	    matrix[r-1][i] = newRow[i]; //sets values of row r from the matrix to the values from the newRow
	}
	return x; //returns the 1D array holding the old values 

    }//O(n)


    public Object[] setCol( int c, Object[] newCol ) {
	Object[] x = new Object[matrix[0].length]; //creates a 1D array, same size as the size() of matrix 
	for(int i = 0; i < this.size(); i++){ //goes through the column c
	    x[i] = matrix[i][c - 1]; //copies values of column c from the matrix to the values from the newCol
	    matrix[i][c - 1] = newCol[i]; //sets values of column c from the matrix to the values from the newCol
	}
	return x; //returns the 1D array holding the old values 

    }//O(n)


    public void transpose() {
	Object j; //initializes an Object variable to hold a value from the matrix
	for(int i = 0; i < this.size() -1; i++){ //used to go by rows, i represents row number (1st row is i = 0)
	    for(int x = 1; x < this.size() - i; x++){ //used to go through the columns of row i (x starts as 1 and x is less than the size() - i to ignore the diagnol slots)
	        j = matrix[i][x]; //j is used to hold the value as [i][x]
		matrix[i][x] = matrix[x][i]; //value at [i][x] is set to value at [x][i]
		matrix[x][i] = j; //value at [x][i] is set to old value of [i][x] using j
	    }
	}
    }//O()
	
    //simplify the use of System.out.println()
    public static void SOP(Object x){
	System.out.println(x);
    }

    //simplify the use of System.out.print()
    public static void S(Object x){
	System.out.print(x);
    }

    

    //main method for testing
    public static void main( String[] args ) 
    {
	SOP("Hasif Ahmed Period 2");
	SOP("Testing for HW 57");
	SOP("Creating an empty matrix of 5 x 5");
	Matrix pop = new Matrix(5);
	SOP(pop + "\n");

	SOP("Creating a matrix named 'ok' of default sizes and will include the values:\nrow 1- 10,yes \nrow 2- no,0");
	Matrix ok = new Matrix();
        SOP("The size is " + ok.size());
	ok.set(1,1,10);
	ok.set(1,2,"yes");
	ok.set(2,1,"no");
	ok.set(2,2,0);
	SOP(ok);
	SOP("The value at position(1,1) is " + ok.get(1,1));
     	SOP("The matrix is empty:\n" + ok.isEmpty(1,1));
	
	Object[][] test = new Object[2][2];
	test[0][0] = 23;
	test[0][1] = 28;
	test[1][0] = "cool";
	test[1][1] = 90;
	SOP("Comparing 'ok' with a 2D array that is not a matrix:\n" + ok.equals(test) + "\n");

	SOP("Creating a matrix named 'test2' of default sizes and will include the values:\nrow 1- 10,yes \nrow 2- no,0");
	Matrix test2 = new Matrix();
       	SOP("The size is " + test2.size());
	test2.set(1,1,10);
	test2.set(1,2,"yes");
	test2.set(2,1,"no");
	test2.set(2,2,0);
	SOP(test2);
	
	SOP("Comparing 'ok' with 'test2':\n" + ok.equals(test2) + "\n");

	SOP("Time to switch things up in 'ok'...");
	SOP("Initial state of 'ok':\n" + ok);
	ok.swapColumns(1,2);
	SOP("After swapping columns 1 and 2:\n" + ok);
	ok.swapRows(1,2);
	SOP("After swapping rows 1 and 2 of modified 'ok':\n" + ok);

	Object[] test3 = new Object[2];
	test3 = ok.getRow(1);
	SOP("\nTime to test for HW59...\nRow 1 of ok is- ");
	S("[ ");
	for(Object p: test3){
	    S(p + " ");
	}
	S("]");

	SOP("\nInitial state of 'ok':\n" + ok);
	ok.setRow(2,test3);
	SOP("After setting row 2 to same values as row 1:\n" + ok);

	SOP("");
	SOP("Resetting 'ok':");
	ok.set(1,1,10);
	ok.set(1,2,"yes");
	ok.set(2,1,"no");
	ok.set(2,2,0);
	SOP(ok);

	Object[] test4 = new Object[2];
	test4 = ok.getCol(1);
	SOP("Column 1 of 'ok' is- ");
	S("[ ");
	for(Object h: test4){
	    S(h + " ");
	}
	S("]");

	SOP("\nInitial state of 'ok':\n" + ok);
	ok.setCol(2,test4);
	SOP("After setting column 2 to same values as column 1:\n" + ok);

	SOP("");
	SOP("Resetting 'ok':");
	ok.set(1,1,10);
	ok.set(1,2,"yes");
	ok.set(2,1,"no");
	ok.set(2,2,0);
	SOP(ok);
        SOP("");

	SOP("Initial state of 'ok':\n" + ok);
	ok.transpose();
        SOP("After transposing matrix 'ok':\n" + ok);

	
	

	
	
    }

}//end class Matrix
