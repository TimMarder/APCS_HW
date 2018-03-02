/*
Tim Marder
APCS2 pd02
HW#10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
2018-02-28  
*/

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
  private int[][] _board;
    
  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }

  
  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
  public boolean solve() {
    if (solveH(0)) {
		printSolution();
		return true;
	}
	return false;
  }

  
  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) {
	  if (col == _board[0].length) {
		  return true;
	  }
	  else {
		for (int row = 0 ; row < _board.length ; row++) {
			if (addQueen( row , col )) {
				if (solveH (col + 1)) {
					return true;
				}
				else {
					removeQueen( row , col );
				}
			}
		}
	  }
	  return false;
  }


  public void printSolution() {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
	String result = "";
	for (int row = 0 ; row < _board.length ; row ++) {
		for (int col = 0 ; col < _board.length ; col++) {
			if (_board[row][col] <= 0) {
				result += "_";
				result += "\t";
			}
			else {
				result += "Q";
				result += "\t";
			}
		}
		result += "\n";
	}
	System.out.println(result);
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * Method used for representing the queen that is added to the board and is shown
   as a 1. All of the other spaces in the same row as the queen will be decreased by
   1 and should be represented by negative numbers after several queens have been
   placed on the board (will be -1 after just the first queen). The same process
   happens to the diagonals of the same queen. The spaces are decreased by 1 to
   represent unavailable spaces for another queen to be placed because they would
   kill each other.
   * precondition: row and column inputted are within the correct range of the board.
   * postcondition: places a 1 at current location to represent the queens.
					decreases spaces in the same row as the queen by 1.
					decreases spaces in the diagonals that would be killed by the queen by 1.
					returns false if something other than an available space is at the current location.
					return true if the location is available for a queen to be placed.
   */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
	    return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
        _board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * Method used for removing a queen at the current location by looking to see if the
   current space has a 1 to represent a queen. If there is indeed a 1 at the location,
   it is set to a 0 to resemble a new available space and all of the spaces that would
   have been killed by the now removed queen are increased by 1. So if the spaces were -1,
   they become 0 and are now newly available spaces. A similar method is used as the addQueen
   method to increase all the spaces in the same row as the removed queen as well as the
   diagonals that would have been unavailable spaces when the queen was there.
   * precondition: row and column inputed are within the correct range of the board.
   * postcondition: changes a 1 to a 0 to signify a queen being removed.
					increases spaces in the same row as the removed queen by 1.
					increases spaces in the diagonals that included the removed queen by 1.
					returns false if the current location has no queen.
					return true if the current location had a queen and was successful removed.
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
	    return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * toString method used for representing the chess board by returning
   the spaces of the board in a grid-like view. This works by using a
   double for loop to go through the rows and column of the chess board
   and add them to the final string in the correct order. After each row
   of spaces have been added, a line break is added to represent a new
   row.
   * precondition: the amount of rows and column on the board is correct.
   * postcondition: Returns a string that represents the spaces on the 
   chess board in a form of a grid.
   */
  public String toString() 
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
	
	//===========================
	
	System.out.println("\n");
	
	//4x4
	System.out.println("Testing 4x4...");
	QueenBoard a = new QueenBoard(4);
	System.out.println(a);
	System.out.println("Solving 4x4...");
	a.solve();
	System.out.println("\n");
	
	//5x5
	System.out.println("Testing 5x5...");
	QueenBoard c = new QueenBoard(5);
	System.out.println(c);
	
	c.solve();
	System.out.println("\n");
	
	//6x6
	System.out.println("Testing 6x6...");
	QueenBoard d = new QueenBoard(6);
	System.out.println(d);
	d.solve();
	System.out.println("\n");
	
	//8x8
	System.out.println("Testing 8x8...");
	QueenBoard e = new QueenBoard(8);
	System.out.println(e);
	e.solve();
	System.out.println("\n");
	
	//10x10
	System.out.println("Testing 10x10...");
	QueenBoard f = new QueenBoard(10);
	System.out.println(f);
	f.solve();
  }
    
}//end class
