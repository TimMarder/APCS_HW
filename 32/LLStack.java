/*
Tim Marder
APCS2 pd02
HW#32 -- Leon Leonwood Stack
2018-04-12
*/

/*******************
 *  Class LLStack  *
 ******************/

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE> {

	private LinkedList<PANCAKE> _stack;
	private int _stackSize;
	
	public LLStack() {
		
		_stack = new LinkedList<PANCAKE>();
		_stackSize = 0;
		
	}
	
	public boolean isEmpty() {
		
		return _stackSize == 0;
		
	}
	
	public PANCAKE peek() {
		
		return _stack.get( _stackSize - 1 );
		
	}
	
	public PANCAKE pop() {
		
		if ( !isEmpty() ) {
			PANCAKE removed = _stack.get( _stackSize - 1 );
			_stack.remove( _stackSize - 1 );
			_stackSize--;
			return removed;
		}
		return null;
		
	}
	
	public void push( PANCAKE x ) {

		_stack.add( x );
		_stackSize++;
	
	}

}