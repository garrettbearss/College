import java.util.List;
import java.util.ArrayList;

public class CrosswordPuzzleRunner 
{
    public static void main(String[] args) 
    {
    	//add code to test the CrosswordPuzzle class
    	boolean [][] fun = {{false, false, true, false},
    											{true, false,true,true},
    											{false, true, false, true},
    											{false, false, false, false}};
    	CrosswordPuzzle puzz = new CrosswordPuzzle( fun );
    	System.out.println( puzz );	
    }
}

/*OUTPUT
false 1  false 2  true 0   false 3
true 0   false 4  true 0   true 0
false 5  true 0   false 6  true 0
false 7  false 8  false 0  false 9
*/
