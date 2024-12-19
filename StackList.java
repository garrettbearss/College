// StackList.java
// Garrett Bearss
// The StackList class

import java.util.LinkedList; 

public class StackList<E>
{ 
  private LinkedList<E> list;
 
  public StackList()
  { 
  		list = new LinkedList<E>(); 
  } 
  public void push(E element) 
  { 
  		list.add(element); 
  } 
  public E pop() 
  { 
  		return list.remove(list.size() - 1); 
  } 
  public E peek() 
  { 
  		return list.get(list.size() - 1); 
  } 
  public boolean isEmpty() 
  { 
  		return list.size() == 0; 
  } 
}