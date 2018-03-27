/*****************************************************
* class DLLNode
* Implements a doubly-linked node,
* for use in lists and other collection classes.
* Stores data of type T
*****************************************************/

public class DLLNode<T>
{
  private T _cargo;    //cargo may be of any type
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

  //YOUR IMPLEMENTATION HERE...

  // constructor -- initializes instance vars
  public DLLNode( DLLNode previous, T value, DLLNode next ) {
    _prevNode = previous;
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public DLLNode getPrev() {return _prevNode; }

  public T getCargo() { return _cargo; }

  public DLLNode getNext() { return _nextNode; }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------

  public DLLNode setPrev( DLLNode newPrev ) {
      DLLNode foo = getPrev();
      _prevNode = newPrev;
      return foo;
  }

  public T setCargo( T newCargo ) {
    T foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode setNext( DLLNode newNext ) {
    DLLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toT
  public String toString() { return _cargo.toString(); }

}//end class DLLNode
