// QueueList.java
// Garrett Bearss
// The QueueList class

import java.util.LinkedList; 

public class QueueList<E>
{ 
  private LinkedList<E> list;
 
  public QueueList()
  { 
  		list = new LinkedList<E>(); 
  } 
  public boolean add(E element) 
  { 
  		list.add(element);
  		return true; 
  } 
  public E remove() 
  { 
  		return list.remove(0); 
  } 
  public E peek() 
  { 
  		return list.get(0); 
  } 
  public boolean isEmpty() 
  { 
  		return list.size() == 0; 
  } 
}