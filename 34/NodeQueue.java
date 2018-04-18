/*
Tim Marder
APCS2 pd02
HW#34 -- The English Do Not Wait In Line
2018-04-16
*/


public class NodeQueue<Quasar> implements Queue<Quasar> {
	
	private LLNode<Quasar> head;
	private LLNode<Quasar> tail;
	private int size;
	
	public NodeQueue() {
		
		head = null;
		tail = null;
		size = 0;
		
	}
	
	public Quasar dequeue() {
		
		if ( isEmpty() ) {
			return null;
		}
		Quasar rtrn = head.getValue();
		head = head.getNext();
		size--;
		return rtrn;
		
	}
	
	public void enqueue( Quasar x ) {
		
		LLNode<Quasar> temp = new LLNode<Quasar>( x , null );
		
		if ( isEmpty() ) {
			head = temp;
			tail = temp;
		}
		tail.setNext( temp );
		tail = tail.getNext();
		size++;
		
	}
	
	public boolean isEmpty() {
		
		return head == null;
		
	}
	
	public Quasar peekFront() {
		
		return head.getValue();
		
	}
	
	public static void main(String[] args) {
		
		//Thank you Colin for the test cases! 
		NodeQueue<String> test = new NodeQueue<String>();
        
        System.out.println(test.isEmpty()); //TRUE
        test.enqueue("apple");
        test.enqueue("brick");
        test.enqueue("sky");
        
        System.out.println(test.isEmpty()); //FALSE
        
        System.out.println(test.peekFront()); //apple
        System.out.println(test.dequeue()); //apple
        
        System.out.println(test.peekFront()); //brick
        System.out.println(test.dequeue()); //brick
        
        System.out.println(test.peekFront()); //sky
        System.out.println(test.dequeue()); //sky

        System.out.println(test.isEmpty()); //TRUE
        System.out.println(test.dequeue()); //null
		
	}
	
}