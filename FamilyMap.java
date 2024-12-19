import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;
import java.util.Set;

// You
// FamilyMap
// Allows the user to store Sets of Strings

// The key is the family's last name
// The value is the Set of Strings containing all of the family's first names

// You must complete three lines of code so that the following methods work properly:
//		addFamily
// 		showAll

// Good luck

public class FamilyMap
{

	KeyboardReader reader = new KeyboardReader(); 
	private Map<String, Set<String>> family; 
	////// Explain to your partner what the private variable on the line above will contain ///////
	/// Draw a small picture that illustrates sample values in the map using your two families ////
	///////////////////////////////////////////////////////////////////////////////////////////////	
	///////////////////////////////////////////////////////////////////////////////////////////////	
	
	public FamilyMap()
	{
		family = new TreeMap<String, Set<String>>();
	}
	
	public void addFamily()
	{
		
		// The String surname stores the last name of the family
		String surname = reader.readLine("Enter surname (last name): "); 
		
		// The Set firstNames will store all of the first names in the family
		Set<String> firstNames = new TreeSet<String>(); 
		
		String name; 
		do{
			name = reader.readLine("Enter first name (999 to quit): "); 
			if(!name.equals("999"))
			{
			
				///////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////
				// Add the line of code here that adds name to the set named firstNames
				firstNames.add(name);
				
			}
		}while(!name.equals("999")); 
		
		/////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////
		// Add the line of code here that puts the (surname, set) pair into the private map named family
		 family.put(surname, firstNames);
	}
	
	public void showAll(){

		for(String lastName : family.keySet())
		{ 
			for(String firstName : family.get(lastName))
			{
				////////////////////////////////////////////////////////////////////////
				////////////////////////////////////////////////////////////////////////
				// Add a S.O.Pln that displays every lastName, firstName pair in the Map
				System.out.println(lastName + ", " + firstName);
				
			}		
		}

	}
	

	
}