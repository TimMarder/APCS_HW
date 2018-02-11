/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber {
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) {
    	_lo = 1;
    	_hi = 100;
    	_guessCtr = 1;
    	_target = (int) (_lo + (Math.random() * (_hi - 1)));
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
	public void playRec() {
		boolean guessed = false;
    	int result = 0;
    		System.out.print("Choose a number " + _lo + "-" + _hi + ": ");
    		result = Keyboard.readInt();
    		if (result == _target) {
    			System.out.println("Correct! It took " + _guessCtr + " guesses.");
    			guessed = true;
    		}
    		else {
    			if (result < _target) {
    				System.out.println("Too low!");
    				_lo = result + 1;
    			}
    			if (result > _target) {
    				System.out.println("Too high!");
    				_hi = result - 1;
    			}
    			_guessCtr = _guessCtr + 1;
    			playRec();
    		}
    	}

    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() {
    	boolean guessed = false;
    	int result = 0;
    	while (guessed == false) {
    		System.out.print("Choose a number " + _lo + "-" + _hi + ": ");
    		result = Keyboard.readInt();
    		if (result == _target) {
    			System.out.println("Correct! It took " + _guessCtr + " guesses.");
    			guessed = true;
    		}
    		else {
    			if (result < _target) {
    				System.out.println("Too low!");
    				_lo = result + 1;
    			}
    			if (result > _target) {
    				System.out.println("Too high!");
    				_hi = result - 1;
    			}
    			_guessCtr = _guessCtr + 1;
    		}
    	}
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() {
		//use one or the other below:
		//playRec();
		playRec();
    }


    //main method to run it all
    public static void main( String[] args ) {
		//instantiate a new game
		GuessNumber g = new GuessNumber(1,100);

		//start the game
		g.play();
    }//end main

}//end class
