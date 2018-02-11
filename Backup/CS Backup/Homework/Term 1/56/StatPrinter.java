/*
Tim Marder
APCS1 pd02
HW#56 -- His Toe Grammar
2017-12-19
*/

/*====================================================================
  An AP-style question, for practice:
  Write the StatPrinter class below. The StatPrinter Object receives an
  ArrayList of nonnegative integers, then builds a frequency ArrayList in which
  the index values are the data and the entry at the index is the frequency.
  For example, if the received data is    2,3,2,5,1,3    then the frequency 
  list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
  2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
  the maximum value of the data.

  A capability of the class is to calculate local modes from the frequency 
  list. A local mode is a value that is greater than the value at index-1 
  and greater than the value at index+1. A local mode is never at the end
  points of the list. For example, if the frequency list is [1,2,1,4,2,3,5] 
  then the local modes are 2 and 4.

  This class is also capable of printing a histogram of the frequencies, using
  '*'s to indicate a frequency amount. To print a histogram, the user specifies
  the longest sequence of '*'s used and then all other values are printed in 
  proportion to this value. For example, if longest bar is 10 and the frequency
  list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

  0 : **
  1 : ****
  2 : **
  3 : ********
  4 : ****
  5 : ******
  6 : **********

  For each method, state run time efficiency using Big O notation.

  Tips for Awesome:
  * Keys to Success are so named for a reason.
  * Look over all fxns, think a bit, decide which to tackle first.
  ( Simplest?  Prerequisites? . . . )
  * Develop 1 fxn at a time, test it, then move to next.
  * For coding today, what extra code do you need to get past compiler?
  ====================================================================*/

import java.util.ArrayList;


public class StatPrinter {

    // instance variable for frequencies of each integer in input ArrayList
    private ArrayList <Integer> _frequency;


    //*************** QUESTION 02 **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data) + 1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]
    public StatPrinter( ArrayList <Integer> data ) {
    	_frequency = new ArrayList<Integer>();
    	if (data.size() > 0) { //Checks to see if there are elements in the arraylist
    		for (int counter = 0 ; counter < max(data) + 1 ; counter++) {
    			_frequency.add(0); //expands the size of the _frequency arraylist
    		}
    		for (int i = 0 ; i < data.size() ; i++) {
    			if (0 <= data.get(i) && data.get(i) <= 100) { //makes sure that each of the elements are within a 0-100 range
    				_frequency.set(data.get(i) , _frequency.get(data.get(i)) + 1); //sets the elements of _frequency arraylist
    			}
    			else {
    				System.out.println("One of the elements is not within the allowed range (0-100).");
    			}
    		}
    	}
    	else {
    		System.out.println("Enter an array with a size larger than 0.");
    	}
    }


    //*************** QUESTION 01 **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data
    public Integer max( ArrayList <Integer> data ) {
    	int max = data.get(0); //a max variable to be kept updated
    	for (int counter = 0 ; counter < data.size() ; counter++) {
    		if (data.get(counter) > max) { // checks if the current element is greater than the current max value
    			max = data.get(counter); //if greater, sets the max value to that greater element
    		}
    	}
    	return max; //returns the final max element
    }


    //*************** QUESTION 03 **************************
    //postcond: returns true if i > 0 and i < _frequency.size() - 1
    //          and _frequency.get( i - 1 ) < _frequency.get( i )
    //          and _frequency.get( i + 1 ) < _frequency.get( i )
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
    public boolean isLocalMode( int i ) {
    	boolean mode = false; //element is not local mode by default
    	if (i > 0 &&  //element at index 0 cannot be local mode
    		i < _frequency.size() - 1 && //element at last index cannot be local mode
    		_frequency.get(i - 1) < _frequency.get(i) && //element larger than the previous element
    		_frequency.get(i + 1) < _frequency.get(i)) { //element larger than the next element
    		mode = true; //if everything is true, the element is a local mode
    	}
    	return mode; //returns the truth value of the mode variable
    }


    //*************** QUESTION 04 **************************
    //postcond: returns list of modes in _frequency
    public ArrayList<Integer> getLocalModes() {
    	ArrayList<Integer> modes = new ArrayList<Integer>();
    	for (int counter = 0 ; counter < _frequency.size() - 1 ; counter++) {
    		if (_frequency.get(counter - 1) < _frequency.get(counter) && //element larger than the previous element
    			_frequency.get(counter + 1) < _frequency.get(counter)) { //element larger than the next element
    			modes.add(_frequency.get(counter)); //adds the element as the local mode to the arraylist of modes
    		}
    	}
    	return modes; //returns the arraylist of modes
    }


    //*************** QUESTION 05 **************************
    //precond:  longestBar > 0
    public void printHistogram( int longestBar ) {
    	String result = ""; //empty string to start off with
    	double multiple = longestBar / max(_frequency); //figures out what the amount of *'s are per actual value (coefficients in a way) 
    	for (int row = 0 ; row < _frequency.size() ; row++) { //figures out how many rows are needed for the histogram
    		result += row + " : "; //Adds the row number
    		for (int star = 0 ; star < _frequency.get(row) * multiple ; star++) { //figures out how many stars (astericks) are going to be present 
    			result += "*"; //adds the astericks to the string
    		}
    		result += "\n"; //adds a line break so that the next row can be on a new line
		}
		System.out.println(result); //prints the entire final string
    }
 
}//end class StatPrinter
