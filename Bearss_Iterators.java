// Bearss_Iterators.java
// Garrett Bearss
// Uses Iterators

import java.util.LinkedList;
import java.util.ListIterator;

public class Bearss_Iterators
{
	public static void main(String[] args)
	{
		LinkedList Garrett = new LinkedList();
		Garrett.addFirst("Garrett");
		Garrett.addFirst("Gabe");
		Garrett.addLast("Bailey");
		Garrett.addLast("Alexis");
		ListIterator itter = Garrett.listIterator();
		itter.add("Bearss");
		itter.next();
		itter.add("John");
		itter.next();
		itter.add("Edward");
		for(Object o : Garrett)// Prints each object in the list
		{
			System.out.println(o);
		}
		System.out.println("");
		itter = Garrett.listIterator();
		
		while(itter.hasNext())// Goes through and prints each value then removes it
		{
		 	System.out.println(itter.next());
		 	itter.remove();
		}
		
		for(Object o : Garrett)// Should print nothing
		{
			System.out.println(o);
		}
		if(!(itter.hasNext()))
		{
			System.out.println("There is nothing in this list");
		}
	}
}