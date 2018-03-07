/*
Team MisterClean -- Tim Marder, Max Millar, William Lu
Tim Marder
APCS2 pd2
HW15 -- Thinkers of the Corn
2018-03-07 W
*/

/***
 * SKEELTON for class 
 * MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 * 
 * USAGE: 
 * $ java Maze [mazefile]
 * (mazefile is ASCII representation of maze, using symbols below)
 * 
 * ALGORITHM for finding exit from starting position:
 *  Starting on one spot, if the spot is the exit, change solved to true.
    If the spot is not on the maze, on the wall, or on a visited path, it backtracks.
    Else it moves onto one of the next 4 possible spots on the maze, and repeats the action.
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver 
{
  private char[][] maze;
  private int h, w; //height, width of maze
  private boolean solved;

  //initialize constants for map component symbols
  final private char HERO =         '@';
  final private char PATH =         '#';
  final private char WALL =         ' ';
  final private char EXIT =         '$';
  final private char VISITED_PATH = '.';


  public MazeSolver( String inputFile ) {
    // init 2D array to represent maze 
    // (80x25 is default terminal window size)
    maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
	    Scanner sc = new Scanner( new File(inputFile) );

	    System.out.println( "reading in file..." );

	    int row = 0;

	    while( sc.hasNext() ) {

            String line = sc.nextLine();

            if ( w < line.length() ) 
                w = line.length();

            for( int i=0; i<line.length(); i++ )
                maze[i][row] = line.charAt( i );

            h++;
            row++;
	    } 

	    for( int i=0; i<w; i++ )
            maze[i][row] = WALL;
        
	    h++;
	    row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    solved = false;
  }//end constructor


  public String toString() {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = ""; //"[0;0H";  
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i<h; i++ ) {
	    for( j=0; j<w; j++ )
        retStr = retStr + maze[j][i] + " ";
	    retStr = retStr + "\n";
    }
    System.out.println(h + " " + w);
    return retStr;
  }


  //helper method to keep try/catch clutter out of main flow
  private void delay( int n ) {
    try {
	    Thread.sleep(n);
    } catch( InterruptedException e ) {
	    System.exit(0);
    }
  }


  /*********************************************
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   *********************************************/
    public void solve( int x, int y ) {

        delay(100); //slow it down enough to be followable
        
        if ( solved ) {
            System.out.println("solved!");
            System.exit(0);
        }

        //primary base case
        if ( x < 0 || x > w - 2 ||
             y < 0 || y > h - 2 ) {
            return;
        }
        //other base case(s)...
        else if ( maze[x][y] == EXIT ) {
            solved = true;
            return;
        } 
        else if ( maze[x][y] == VISITED_PATH ) {
            return;
        }
        else if ( maze[x][y] == WALL ) {
            return;
        }
        //recursive reduction
        else {
            maze[x][y] = VISITED_PATH;
            
            System.out.println(this);
            
            int[] nextX = {x-1, x, x, x+1};
            int[] nextY = {y, y+1, y-1, y};
            
            for(int i = 0; i < 4; i ++) solve(nextX[i], nextY[i]);
            
            if (!solved) maze[x][y] = PATH;
        }
    }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) { return maze[x][y] == PATH; }

}//end class MazeSolver


public class Maze 
{
  public static void main( String[] args ) 
  {
    try {
	    String mazeInputFile = args[0];

	    MazeSolver ms = new MazeSolver( mazeInputFile );
	    //clear screen
	    System.out.println( "[2J" ); 

	    //display maze 
	    System.out.println( ms );

	    //drop hero into the maze (coords must be on path)
	    //comment next line out when ready to randomize startpos
	    ms.solve( 0, 9 ); 

	    //drop our hero into maze at random location on path
	    //the Tim Diep way:
	    Random r = new Random();
	    int startX = r.nextInt( 80 );
	    int startY = r.nextInt( 25 );
	    while ( !ms.onPath(startX,startY) ) {
      startX = r.nextInt( 80 );
      startY = r.nextInt( 25 );
	    }

	    ms.solve( startX, startY );
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    } catch( Exception e ) { 
	    System.out.println( "Error reading input file." );
	    System.out.println( "Usage: java Maze <filename>" ); 
    }
  }

}//end class Maze