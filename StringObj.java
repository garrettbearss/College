// StringObj.java
// Garrett Bearss
// The class file for StringObj

public class StringObj
{
	private String word;
	private int vowels;
	KeyboardReader reader = new KeyboardReader();
	
	public StringObj(String s1)
	{
		vowels = 0;
		word = s1;
		for(int i = 0; i < word.length(); i++)
		{
			if(word.substring(i,i+1).equals("a") || word.substring(i,i+1).equals("A"))// If there is an A in the word
			{
				vowels++;
			}
			if(word.substring(i,i+1).equals("e") || word.substring(i,i+1).equals("E"))// If there is an E in the word
			{
				vowels++;
			}
			if(word.substring(i,i+1).equals("i") || word.substring(i,i+1).equals("I"))// If there is an I in the word
			{
				vowels++;
			}
			if(word.substring(i,i+1).equals("o") || word.substring(i,i+1).equals("O"))// If there is an O in the word
			{
				vowels++;
			}
			if(word.substring(i,i+1).equals("u") || word.substring(i,i+1).equals("U"))// If there is an U in the word
			{
				vowels++;
			}
		}
	}
	
	public int getNumVowels()// Gets number of vowels
	{
		return vowels;
	}
	
    public String toString()// Gets the word
    {
        return word;
    }
    
    public boolean areAlphabetized(StringObj str)// Checks which word is first in the alphabet
    {
    	String word1 = this.word;
    	String word2 = str.word;
    	word1 = word1.toLowerCase();// Sets both to lowercase
    	word2 = word2.toLowerCase();
    	
    	if(word1.equals(word2))// If they are the same word
    	{
    		return true;
    	}
    	if(word1.compareTo(word2) < 0)// if word1 comes first
    	{
    		return true;
    	}
    	if(word1.compareTo(word2) > 0)// if word2 comes first
    	{
    		return false;
    	}
    	else// Shouldn't go here
    	{
    		return true;
    	}
    }
    
    public boolean isPalindrome()// Checks if the word is a palindrome (without spaces/ punc)
    {
        String word1 = this.word;
        word1 = word1.toLowerCase();
        String word2 = "";
        for(int i = word1.length()-1; i >= 0; i--)// Creates the opposite of the word
        {
        	word2 += word1.substring(i, i+1);
        }
        if(word1.equals(word2))// Checks if the words are equal
        {
            return true;
        }
        else// If they arn't the same word
        {
        	return false;
        }
    }
    
    public boolean isPalindromeBONUS()// Checks if the word is a palindrome (with spaces/ punc)
    {
        String word1 = this.word;
        word1 = word1.toLowerCase();
        int length = word1.length();
        for(int i = 0; i < length-1; i++)// Gets rid of all punctuation
        {
            if(word1.substring(i,i+1).equals(" "))// If there is a space
            {
                word1 = word1.substring(0,i) + word1.substring(i+1 , length-1);
                length--;
                i--;
            }
            if(word1.substring(i,i+1).equals(","))// If there is a comma
            {
                word1 = word1.substring(0,i) + word1.substring(i+1 , length-1);
                length--;
                i--;
            }
            if(word1.substring(i,i+1).equals("."))// If there is a period
            {
                word1 = word1.substring(0,i) + word1.substring(i+1 , length-1);
                length--;
                i--;
            }
            if(word1.substring(i,i+1).equals(";"))// If there is a semi colon
            {
                word1 = word1.substring(0,i) + word1.substring(i+1 , length-1);
                length--;
                i--;
            }
            if(word1.substring(i,i+1).equals(":"))// If there is a colon
            {
                word1 = word1.substring(0,i) + word1.substring(i+1 , length-1);
                length--;
                i--;
            }
            if(word1.substring(i,i+1).equals("'"))//If there is a apostrophe
            {
                word1 = word1.substring(0,i) + word1.substring(i+1 , length-1);
                length--;
                i--;
            }
        }
        String word2 = "";
        for(int i = word1.length()-1; i >= 0; i--)// Adds word1 letter by letter
        {
        	word2 += word1.substring(i, i+1);
        }
        if(word1.equals(word2))//If the words are the same
        {
            return true;
        }
        else// If the words arn't the same
        {
        	return false;
        }
    }
    
    public int wordCount(String str)// Calculates the number a word appears (stand alone)
    {
        String word1 = this.word.toLowerCase();
        str = str.toLowerCase();
        int count = 0;
        String word2 = "";
        for(int i = 0; i < word1.length(); i++)// Goes through the word1 to find the search word
        {
            if(word1.substring(i,i+1).equals(" ") || word1.substring(i,i+1).equals("."))// Once it hits a space it looks to see if the word is a match or is a period
            {
                if(str.equals(word2))// If the words match
                {
                    count++;
                    word2 = "";
                }
                else// If they don't
                {
                    word2 = "";
                }
            }
            else// Adds another letter to the word2
            {
                word2 += word1.substring(i,i+1);
            }
        }
        return count;
    }
    
    public int wordCountBONUS(String str)// Calculates the number a word appears
    {
		String word1 = this.word.toLowerCase();
        str = str.toLowerCase();
        int count = 0;
        String word2 = "";
        String keyword = str.substring(str.length()-1, str.length());// Gets the last letter of the search word
        boolean counted = false;// Makes sure that something doesn't get counted twice
        for(int i = 0; i < word1.length(); i++)
        {
            if(word1.substring(i,i+1).equals(" "))// If it's a space it checks the word2
            {
                if(str.equals(word2))
                {
                    count++;
                    word2 = "";
                }
                else
                {
                    word2 = "";
                }
                counted = true;
            }	
            else
            {
                word2 += word1.substring(i,i+1);// Adds another letter to the word2
            }
            if(word1.substring(i,i+1).equals(keyword) && word2.length() == str.length())// If it hits the last letter and matches the size
            {
            	if(counted == false)
            	{
            		if(str.equals(word2))
            		{
            			count++;
            			word2 = "";
            		}
            		else
            		{
            			word2 = "";
            		}
            		counted = true;
            	}
            }
            if(word1.substring(i,i+1).equals(keyword) && word2.length() > str.length())// If it hits the last letter and is greater than the search word
            {
            	if(counted == false)
            	{
            		String word3 = word2.substring(word2.length()-str.length(), word2.length());// Finds the word in size within the last letter
            		if(str.equals(word3))
            		{
            			count++;
            			word2 = "";
            		}		
            	}
            }
            counted = false;
        }
        return count;
    }
}