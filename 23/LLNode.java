/*
Tim Marder
APCS2 pd02
HW#21b -- We Got a Litte Ol' Convoy...
2018-03-20  
*/

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode {
    //instance vars

	private String cargo;
	private LLNode next;

    // constructor 

	public LLNode( String cargoI , LLNode nextI ) {
		
		cargo = cargoI;
		next = nextI;
		
	}

    //--------------v  ACCESSORS  v--------------
    public String getCargo() {
		
		return cargo;
		
    }

    public LLNode getNext() {
		
		return next;
		
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String cargoN ) {
		
		String temp = cargo;
		cargo = cargoN;
		return temp;
		
    }

    public LLNode setNext( LLNode nextN ) {
		
		LLNode temp = next;
		next = nextN;
		return next;
		
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() {

		return cargo.toString();
	
    }


    //main method for testing
    public static void main( String[] args ) {
		
		LLNode node0 = new LLNode( "Node 3" , null );
		LLNode node1 = new LLNode( "Node 2" , node0 );
		LLNode node2 = new LLNode( "Node 1" , node1 );
		//Realized that these are these the order of the variable
		//names and the cargo names have to be swapped (order wise)
		//so that its possible to instantiate them as well as number
		//them in the appropriate order.
		
		System.out.println("\n");
		
		System.out.println("Printing Nodes...");
		System.out.println(node0);
		System.out.println(node1);
		System.out.println(node2);
		
		System.out.println("\n");
		
		System.out.println("Getting Cargo...");
		System.out.println(node0.getCargo());
		System.out.println(node1.getCargo());
		System.out.println(node2.getCargo());
	
		System.out.println("\n");
		
		System.out.println("Getting Next...");
		System.out.println(node0.getNext());
		System.out.println(node1.getNext());
		System.out.println(node2.getNext());
		
		System.out.println("\n");
		
		System.out.println("Setting Cargo...");
		
		System.out.println("node0: Changing from " + node0.setCargo("Third Node") + " to " + node0);
		System.out.println("node1: Changing from " + node1.setCargo("Second Node") + " to " + node1);
		System.out.println("node2: Changing from " + node2.setCargo("First Node") + " to " + node2);
		
		System.out.println("\n");
		
		System.out.println("Setting Next...");
		System.out.println("node0: Changing from " + node0.setNext(null) + " to " + node0.getNext()); //Doesnt change
		System.out.println("node1: Changing from " + node1.setNext(node2) + " to " + node0.getNext());
		System.out.println("node2: Changing from " + node2.setNext(node0) + " to " + node0.getNext());
		
		System.out.println("\n");
		
		System.out.println("Printing new order of nexts...");
		System.out.println(node0.getNext());
		System.out.println(node1.getNext());
		System.out.println(node2.getNext());
    }//end main

}//end class LLNode
