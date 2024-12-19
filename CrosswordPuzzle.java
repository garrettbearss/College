import java.util.List;
import java.util.ArrayList;

public class CrosswordPuzzle
{
	private Square[][] puzzle;
	
	public CrosswordPuzzle( boolean[][] blackSquares ) 
	{ 
		////////////////////////////////////////////////////////////////
		//add code here for Part B of Question 3 
		puzzle = new Square[blackSquares.length][blackSquares[0].length];
		int index = 1;
		for(int i = 0; i < blackSquares.length; i++)
		{
			for(int j = 0; j < blackSquares[0].length; j++)
			{
				if(blackSquares[i][j] == true)
				{
					puzzle[i][j] = new Square(true, 0);
				}
				else
				{
					if(toBeLabeled(i, j, blackSquares))
					{
						puzzle[i][j] = new Square(false, index);
						index++;
					}
					else
					{
						puzzle[i][j] = new Square(false, index);
					} 
				}
			}
		}
		
  			
	} 
    	
	public boolean toBeLabeled( int r, int c, boolean[][] blackSquares )
	{
		////////////////////////////////////////////////////////////////
		//add code here for Part A of Question 3 	
   		if(r-1 > 0)
   		{
   			if(blackSquares[r-1][c] == true)
   			{
   				return true;
   			}
   		}
   		if(c-1 > 0)
   		{
   			if(blackSquares[r][c-1] == true)
   			{
   				return true;
   			}
   		}
   		if(r-1 < 0 || c-1 < 0)
   		{
   			if(r != 0 || c != 0)
   			{
   				return true;
   			}
   		}
   		else
   		{
   			return false;
   		}
   		return false;
	}   
    	
    	//not part of the exam, but helpful to see the grid
    public String toString()
    {
    	String ret = "";
    	for( Square[] row : puzzle )
    	{
    		for( Square it : row )
    		{
    			if( it == null )
    				ret += String.format("%-9s","null");
    			else
    				ret += it;
    		}
    		ret += "\n";
    	}
    	return ret;
    }
}