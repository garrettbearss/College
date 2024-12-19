// AnimalList.java
// Garrett Bearss
// Uses the ListNode class

public class AnimalList
{
	// Instance variables
	private ListNode head;
	private int numAddRemove;
    
    // Constructor
    public AnimalList()
    {
        head = null;
        numAddRemove = 0;
    }
	
	// Instance methods
	public void addAnimal(Comparable addValue)// Adds an animal alphabetically
	{
		ListNode current = head;
		ListNode previous = null;
		ListNode add = null;
		if(head == null)// If the list is empty
		{
			head = new ListNode(addValue, null);
			numAddRemove++;
		}
		else// If the list contains a value
		{
			while(current != null)
			{
				if(addValue.compareTo(current.getValue()) < 0)//Adds something before current
				{
					add = new ListNode(addValue, current);
					if(previous == null)// If you are at the start of the list
					{
						head = add;
					}
					else// Somewhere else in the list
					{
						previous.setNext(add);
					}
					current = null;
					numAddRemove++;
				}
				else if(addValue.compareTo(current.getValue()) > 0)// Moves down the list
				{
					if(current.getNext() == null)// If you are at the end of the list
					{
						add = new ListNode(addValue, current.getNext());
                        current.setNext(add);
						numAddRemove++;
						current = null;
					}
					else// If there is still list to traverse
					{
						previous = current; 
						current = current.getNext();
					}
				}
				else// If they both equal each other
				{
					add = new ListNode(addValue, current.getNext());
                    current.setNext(add);
					numAddRemove++;
					current = null;
				}
			}
		}
	}
	
	public boolean removeAnimal(Comparable searchValue)// Removes the first instance of the animal searchValue
	{
        ListNode current = head;
		ListNode previous = null;
		ListNode add = null;
		if(head == null)// If the list is empty
        {
            //System.out.println("There is nothing in the list to remove.");
            return false;
        }
        else// If the list contains a value
        {
            while(current != null)// If you are not at the end of the list
            {
                if(current.getValue().equals(searchValue))// If you have found the value
                {
                    if(previous == null)// If you are at the start
                    {
                        if(current.getNext() == null)// If the list only has one thing stored
                        {
                            head = null;
                            current = null;
                            previous = null;
                            numAddRemove++;
                            return true;
                        }
                        else// If the list has more than one thing stored
                        {
                            head = head.getNext();
                            current = null;
                            previous = null;
                            numAddRemove++;
                            return true;
                        }
                    }
                    else// If you are at the middle/ end of the list
                    {
                        previous.setNext(current.getNext());
                        current = null;
                        numAddRemove++;
                        return true;
                    }
                }
                else// Traverse the list
                {
                        previous = current; 
						current = current.getNext();
                }
            }
            //System.out.println("There was no instance of the searchValue in the list.");
        }
		return false;
	}
	
	public void displayList()// Displays the list of animal names
	{
		ListNode current = head;
		int index = 1;
		if(head == null)// If the list is empty
		{
			System.out.println("No animals in the list.");
		}
		else// If the list contains some values
		{
			while(current != null)
			{
				System.out.println(index + ".\t" + current.getValue());
				current = current.getNext();
				index++;
			}
		}
	}
	
	public int getnumAddRemove()// returns the number of successful additions/ removals
	{
		return numAddRemove;
	}
}