import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class PhraseRunner 
{
    public static void main(String[] args) 
    {
			Phrase phrase1 = new Phrase( "rrrrrr" );	
			
			System.out.println( phrase1.findLastOccurrence( "r" ) );		
			System.out.println( phrase1.findLastOccurrence( "rr" ) );	
			System.out.println( phrase1.findLastOccurrence( "rrr" ) );
			System.out.println( phrase1.findLastOccurrence( "rrrr" ) );
			System.out.println( phrase1.findLastOccurrence( "rrrrr" ) );
			System.out.println( phrase1.findLastOccurrence( "rrrrrr" ) );		
			System.out.println( phrase1.findLastOccurrence( "funny" ) );			
				
			phrase1.replaceNthOccurrence( "sci", 1, "pooter" );					
			System.out.println( phrase1 );	
				
			Phrase phrase2 = new Phrase( "Aplus comp sci rocks the rock house of rock!" );	
			phrase2.replaceNthOccurrence( "rock", 6, "paper" );	
			System.out.println( phrase2 );	
				
			Phrase phrase3 = new Phrase( "Aplus comp sci rocks the rock house of rock!" );
			phrase3.replaceNthOccurrence( "us", 2, "xx" );	
			System.out.println( phrase3 );	
				
			Phrase phrase4 = new Phrase( "11112345678901111234567890" );	
			phrase4.replaceNthOccurrence( "11", 1, "chicken" );	
			System.out.println( phrase4 );	
				
			Phrase phrase5 = new Phrase( "11112345678901111234567890" );	
			phrase5.replaceNthOccurrence( "56", 2, "aplus" );	
			System.out.println( phrase5 );	
				
			Phrase phrase6 = new Phrase( "11112345678901111234567890" );	
			phrase6.replaceNthOccurrence( "1111", 7, "dogs" );	
			System.out.println( phrase6 );

			Phrase phrase7 = new Phrase( "" );	
			phrase7.replaceNthOccurrence( "1", 2, "empty" );	
			System.out.println( phrase7 );

			Phrase phrase8 = new Phrase( "1" );	
			phrase8.replaceNthOccurrence( "1", 1, "not empty" );	
			System.out.println( phrase8 );																									
    }
}

/*
OUTPUT

5
4
3
2
1
0
-1
rrrrrr
Aplus comp sci rocks the rock house of rock!
Aplus comp sci rocks the rock hoxxe of rock!
chicken112345678901111234567890
11112345678901111234aplus7890
11112345678901111234567890

not empty

*/		
