public class Square
{
	private boolean val;
	private int number;
	
    public Square( boolean isBlack, int num ) 
    {
    	val = isBlack;
    	number = num;
    }  
    	
    public boolean getBlack()
    {
    	return val;
    }
    
    public int getNumber()
    {
    	return number;
    }
        
    public String toString()
    {
    	return String.format("%-9s",(val + " " + number));
    }
}