public class Phrase
{
	private String currentPhrase;
	
    public Phrase( String p )
    {
    	// You could not see this implementation of the constructor
    	currentPhrase = p;
    }
    
    public int findNthOccurrence( String str, int n )
    {
    	/// You were REQUIRED to use this method without seeing the implementation
    	int counter = 0;
    	for(int i = 0; i<=currentPhrase.length()-str.length(); i++)
    	{
    		if(currentPhrase.substring(i,i+str.length()).equals(str))
    		{
    			counter++;
    			if(counter == n)
    				return i;
    		}
     	}
    	return -1;
    }	
    	
    public void replaceNthOccurrence( String str, int n, String repl )
    {
    	///////////////////////////////////////////////////////
    	// Add code here for Part A
		String word = "";
		int index = findNthOccurrence(str, n);
		if(index == -1)
		{
			return;
		}
		else
		{
			for(int i = 0; i < str.length(); i++)
			{
				if(i == index)
				{
					for(int j = 0; j < repl.length(); j++)
					{
						word += repl.substring(j, j+1);
					}
				}
				else
				{
					word += str.substring(i, i+1);
				}
			}
		}
		currentPhrase = word;
    }
    
    public int findLastOccurrence( String str )
    {
    	///////////////////////////////////////////////////////
    	// Add code here for Part B
		int index;
		int guess = 0;
		index = findNthOccurrence(str, 1);
		if(index == -1)
		{
			return index;
		}
		else
		{
			for(int i = 1; i < str.length(); i++)
			{
				guess = findNthOccurrence(str, i);
				if(index < guess)
				{
					index = guess;
				}
			}
			return index;
		}
    }       	
    	
    public String toString()
    {
    	return "" + currentPhrase;
    }    
}