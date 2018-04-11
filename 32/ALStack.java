/*
Tim Marder
APCS2 pd02
HW#32 --
2018-04-12
*/

/*******************
 *  Class ALStack  *
 ******************/

import java.util.ArrayList;

public class ALStack implements Stack<PANCAKE> {

    private ArrayList<PANCAKE> _stack;
    private int _stackSize;

    public ALStack(int size) {
	_stack = new ArrayList<PANCAKE>[size];
	_stackSize = 0;
    }

    public boolean isEmpty() {

    }

    public PANCAKE peek() {
	return _stack.get(_stackSize - 1);
    }

    public PANCAKE pop() {
	_stackSize -= 1;
	return _stack.remove(_stackSize - 1);
    }

    public void push( PANCAKE x ) {
	_stack.add(x);
	_stackSize += 1;
    }
	
}
