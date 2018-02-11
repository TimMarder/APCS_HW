//Hasif Ahmed
//APCS1 pd2
//HW #46: Al<B> Sorted!.
//2017-12-05
import java.util.ArrayList; //importing ArrayList to use
public class ALTester{
    public static boolean Sorted(ArrayList<Comparable> x){
	for(int i = 0; i < x.size() - 1; i++ ){ //goes through the arraylist
	    if(x.get(i).compareTo(x.get(i+1)) > 0){ //if current slot is greater than the latter one it returns false signifying this is a least to greatest sort method
		return false;
	    }
	}
	return true;
	       
    }

    public static void main(String[] args){
        ArrayList<Comparable> foo = new ArrayList<Comparable>(); //creates an ArrayList containing Comparable 
	for(int i = 0; i < 23; i++){ //adds 23 elements to foo
	    foo.add(5);
	}
	System.out.println(Sorted(foo)); //prints whether or not the ArrayList is sorted
	
	
 
        
       
	
    }
}
