/*
Tim Marder
APCS2 pd02
HW#35 --
2018-04-17
*/

import java.util.ArrayList;

public class ALQueue<Quasar> implements Queue<Quasar> {

    private ArrayList<Quasar> queue;
    private int size;

    public ALQueue( int s ) {

	queue = new ArrayList<Quasar>( s );
	size = s;
    }

    public Quasar dequeue() {

	if ( isEmpty() ) {
	    return null;
	}
	Quasar rtrn = queue.remove(0);
	size--;
	return rtrn;

    }

    public void enqueue( Quasar x ) {

	queue.add( x );
	size++;

    }

    public boolean isEmpty() {

	return size == 0;

    }

    public Quasar peekFront() {

	return queue.get(0);

    }

}
