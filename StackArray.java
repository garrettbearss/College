
//The private variable in the file below is an ArrayList.

//When you create your own StackList and QueueList, it will look very much
//like the file below EXCEPT that the private variable will be a 
//LinkedList instead.

//Remember to keep the E's in place!

import java.util.ArrayList; 

public class StackArray<E>
{ 
  private ArrayList<E> array;
 
  public StackArray()
  { 
  		array = new ArrayList<E>(); 
  } 
  public void push(E element) 
  { 
  		array.add(element); 
  } 
  public E pop() 
  { 
  		return array.remove(array.size() - 1); 
  } 
  public E peek() 
  { 
  		return array.get(array.size() - 1); 
  } 
  public boolean isEmpty() 
  { 
  		return array.size() == 0; 
  } 
}
