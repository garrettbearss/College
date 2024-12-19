// Garrett Bearss
// HeapPriorityQueue.java
// The HeapPriorityQueue class

public class HeapPriorityQueue implements MaxPriorityQueue
{
	private Comparable[] heaparray;
	
	private int count;
	private int maxSize;
	
	public HeapPriorityQueue(int max)// Constructor
	{
		count = 0;
		maxSize = max;// MaxSize of array
		heaparray = new Comparable[max + 1];// Skips the first value
	}
	
	public boolean add(Comparable val)// Adds a value to the array
	{
		if(this.isFull())// If the array is full
		{
			System.out.println("Error: Attempting to add move values than allowed");
			return false;
		}
		else// If the array is not full
		{
			count++;
			heaparray[count] = val;
			helper(count);
			return true;
		}
	}
	
	private void helper(int a)// Recursive method for sorting from add
	{
		if(((a/2) == 0))// If the next level is the top
		{
			if(heaparray[a].compareTo(heaparray[1]) > 0)// If the value is greater
			{
				swap(a, 1);// Swap them
				return;
			}
			else// If the value isn't greater
			{
				return;
			}
		}
		else// If it's not the top level
		{
			if(heaparray[a].compareTo(heaparray[(a/2)]) > 0)// If the value is greater
			{
				swap(a, (a/2));// Swap them
				helper((a/2));// Countine with the sort
				return;
			}
			else// If the value isn't greater
			{
				return;
			}
		}
	}
	
	
	public boolean isEmpty()// Checks to see if the array is empty
	{
		if(count == 0)// If the array is empty
		{
			return true;
		}
		else// If it's not empty
		{
			return false;
		}
	}
	
	public Comparable removeMax()// Removes the top value from the array
	{
		if(!(this.isEmpty()))// If the array is not empty
		{
			Comparable value = heaparray[1];
			heaparray[1] = heaparray[count];
			heaparray[count] = null;
			count--;
			helper2(1);
            return value;		
        }
		else// If the array is empty
		{
			System.out.println("Error: Attempting to remove from an empty heap");
			return null;
		}
	}
	
	private void helper2(int a)// Recursive method for sorting when removing
	{
		if(((a*2)+1) > count)// If you've hit the end
		{
			if((a*2 > count))// If you've hit the end
			{
				return;
			}
			else// If there is only one child
			{
				if(heaparray[a].compareTo(heaparray[(a*2)]) < 0)// If the value is less than the lower value than it's child
				{
					swap(a, a*2);// Swaps them
					return;
				}
				else// If the value isn't less than
				{
					return;
				}
			}
		}
		else// If you haven't hit the end
		{
			if(heaparray[a].compareTo(heaparray[(a*2)]) < 0)// If the value is less than its one child
			{
				if(heaparray[a].compareTo(heaparray[(a*2)+1]) < 0)// If the value is less than both its children
				{
					Comparable value3 = heaparray[a*2];
					Comparable value4 = heaparray[(a*2)+1];
					if(value3.compareTo(value4) > 0)// Checks to see which child is greater
					{
						swap(a,a*2);// Swaps them
						helper2(a*2);// Countines with the sorting
						return;
					}
					else// If only one child is greater
					{
						swap(a,(a*2)+1);// Swaps them
						helper2((a*2)+1);// Countines with the sorting
						return;
					}
				}
				else// If only one value is larger
				{
					swap(a,a*2);
					helper2(a*2);
					return;
				}
			}
			else if(heaparray[a].compareTo(heaparray[(a*2)+1]) < 0)// If the value is less than its other child
			{
				swap(a,(a*2)+1);// Swaps them 
				helper2((a*2)+1);// Countines with the sorting
				return;
			}
			else// If both children are smaller than the value
			{
				return;
			}
		}
	}
	
	public Comparable peekMax()// Returns the top value in the array
	{
		if(count >= 1)// If there is a top
		{
			return heaparray[1];
		}
		else// If the array is empty
		{
			return null;
		}
	}
	
	public String toString()// Prints the array
	{
		String word = "[";
		for(int i = 1; i <= count; i++)
		{
			if(i == count)// If your at the end of the array
			{
				word += heaparray[i];
			}
			else// If your in the array
			{
				word += heaparray[i] + ",";
			}
		}
		word += "]";
		return word;
	}
	
	public boolean isFull()// Checks to see if the array is full
	{
		if(count == maxSize)// If the array is at it's max size
		{
			return true;
		}
		else// If the array isn't at it's max size
		{
			return false;
		}
	}
	
	public int getCount()// Returns the count
	{
		return count;
	}
	
	private void swap(int a, int b)// Swaps the values in the array
	{
		Comparable value1 = heaparray[a];
		Comparable value2 = heaparray[b];
		heaparray[b] = value1;
		heaparray[a] = value2;
	}
}