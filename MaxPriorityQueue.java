// This interface contains the proper method signatures for 
// the methods in the HeapPriorityQueue assignment
// It must be implemented at the top of the HeapPriorityQueue
// with the line:
// public class HeapPriorityQueue implements MaxPriorityQueue
//
public interface MaxPriorityQueue
{
	boolean isEmpty();
	boolean add(Comparable x);
	Comparable removeMax();
	Comparable peekMax();
	
	String toString( );		
	boolean isFull( );
	int getCount();
 
}
