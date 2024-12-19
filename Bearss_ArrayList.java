//Bearss_ArrayList.java
//Garrett Bearss
//Menu for running the ArrayList

import java.util.ArrayList;

public class Bearss_ArrayList
{
	public static void main(String[] args)
	{
		KeyboardReader reader = new KeyboardReader();
		int selection = 0;
		ArrayList<Fraction> list = new ArrayList<Fraction>();
		while(selection != 7) //Keeps running till exit
		{
			System.out.println("\nWelcome to my menu. Please select from the following options: \n");
			System.out.println("		1. Display the list of fractions \n");
			System.out.println("		2. Add a fraction to the end of the list \n");
			System.out.println("		3. Insert a fraction at a specific location \n");
			System.out.println("		4. Remove a fraction from a specific location \n");
			System.out.println("		5. Remove a fraction by value \n");
			System.out.println("		6. Replace a fraction at a specific location \n");
			System.out.println("		7. Exit \n");
			selection = reader.readInt("Enter your selection (1-7): ");
			System.out.println("\n");
			switch(selection)
			{
				case 1:// Display the list of fractions
                    System.out.println("The list currently contains: ");
                    int value = 1;
                    if(list.size() != 0)
                    {
                    	for(int i = 0; i < list.size(); i++)// Loops untill it gets to the last slot
                   		{
                    	   System.out.println("	" + value + "	" + list.get(value-1));
                     	   value++;
                   		}
                    }
                    else// If there are no values
                    {
                    	System.out.println("\n");
                    	System.out.println("Error: There are no values in the current list.");
                    }
                    reader.pause();
                    break;
				case 2:// Add a fraction to the end of the list
					int numerator = reader.readInt("Enter the numerator of the fraction: ");
                    int denominator = reader.readInt("Enter the denominator of the fraction: ");
                    Fraction Garrett = new Fraction(numerator, denominator);// Stores the old value
                    list.add(list.size(), Garrett);// Creates new fraction in list
                    if(list.get(list.size()-1) == Garrett)// Checks if the two fractions match
                    {
                    	System.out.println("\n");
                        System.out.println("The fraction " + Garrett + " has been successfully added to the end of the list.");
                    }
                    else// If they don't match (If there was an error)
                    {
                    	System.out.println("\n");
                        System.out.println("The fraction " + Garrett + " has failed to be added to the end of the list.");
                    }
                    reader.pause();
                    break;
				case 3:// Insert a fraction at a specific location
                    int location = reader.readInt("Enter the location of where the fraction should be inserted: ");
                    location--;// Turns the user value to the array location
                    if(location < 0)// If the user entered 0 or less
                    {
                    	System.out.println("\n");
                    	System.out.println("Error: Location does not exist/ location is negative.");
                    	break;
                    }
					int numerator2 = reader.readInt("Enter the numerator of the new fraction: ");
					int denominator2 = reader.readInt("Enter the denominator of the new fraction: ");
					Fraction Garrett2 = new Fraction(numerator2, denominator2);// Stores the old value
					if(location > (list.size()))// Checks if the location is out of the array
					{
                        System.out.println("\n");
						System.out.println("Error: The location is out of the array.");
                        break;
					}
					else if(location == (list.size()))// Checks if this is the first value or location is greater than the list size by 1
					{
						list.add(list.size(), Garrett2);// Adds the fraction to end of list
						if(list.get(list.size()-1) == Garrett2)// Checks if the two fractions match
                  		{
                    		System.out.println("\n");
                        	System.out.println("The fraction " + Garrett2 + " has been successfully inserted into the list at location " + (list.size()) + ".");
                  		}
                   		else// If they don't match (If there was an error)
                   		{
                   			System.out.println("\n");
                       		System.out.println("The fraction " + Garrett2 + " has failed to be inserted into the list.");
                    	}	
					}
					else // If the location was in the list
					{
						list.add(location, Garrett2);// Adds fraction to the location
						if(list.get(location) == Garrett2)// Checks if the two fractions match
                  		{
                    		System.out.println("\n");
                        	System.out.println("The fraction " + Garrett2 + " has been successfully inserted into the list at location " + (location+1) + ".");
                  		}
                   		else// If they don't match (If there was an error)
                   		{
                   			System.out.println("\n");
                       		System.out.println("The fraction " + Garrett2 + " has failed to be inserted into the list.");
                    	}	
					}
                    reader.pause();
                    break;
				case 4:
					int location2 = reader.readInt("Enter the location of where the fraction should be removed: ");
                    location2--;// Turns the user value to the array location
                    if(location2 < 0)// If the user entered 0 or less
                    {
                    	System.out.println("\n");
                    	System.out.println("Error: Location does not exist/ location is negative.");
                    	break;
                    }
                    else if(location2 > list.size())// If the location is higher than the size
                    {
                        System.out.println("\n");
                        System.out.println("Error: The location is out of the array.");
                        break;
                    }
                    Fraction Test = list.get(location2);// Stores the old value
					list.remove(location2);// Removes the fraction at the location
                    if(location2 == list.size() || list.get(location2) != Test)// If the new value in the location is not equal to the last
                    {
                    	System.out.println("\n");
                        System.out.println("The fraction " + Test + " has been successfully removed from the list.");
                    }
                    else// If the value stayed the same
                    {
                    	System.out.println("\n");
                        System.out.println("The fraction " + Test + " has failed to be removed from the list.");
                    }
                    reader.pause();
                    break;
				case 5:
					int numerator3 = reader.readInt("Enter the numerator of the fraction to remove: ");
					int denominator3 = reader.readInt("Enter the denominator of the fraction to remove: ");
                    boolean remove = false;// Used to check if something was removed in the for loop
					Fraction Garrett3 = new Fraction(numerator3, denominator3);// Stores the old value
                    for(int i = 0; i < list.size(); i++)// Loops through the whole menu
                    {
                        if(Garrett3.equals(list.get(i)) == true)// If the value input equals the value in the menu
                        {
                            list.remove(i);// Removes the value in the menu
                            remove = true;
                            break;
                        }
                    }
                    if(remove == false)// If nothing was removed
                    {
                    	System.out.println("\n");
                        System.out.println("Error: The fraction " + Garrett3 + " is not in the list.");
                    }
                    else// If something was removed
                    {
                    	System.out.println("\n");
                        System.out.println("The first fraction of " + Garrett3 + " have been removed from the list.");
                    }         
                    reader.pause();
                    break;
				case 6:
					int location4 = reader.readInt("Enter the location of the fraction to replace: ");
					location4--;// Turns the user value to the array location
					if(location4 < 0)// If the user entered 0 or less
                    {
                    	System.out.println("\n");
                    	System.out.println("Error: Location does not exist/ location is negative.");
                    	break;
                    }
                    else if(location4 > list.size())// If location is greater than the list size
                    {
                        System.out.println("\n");
						System.out.println("Error: The location is out of the array.");
                        break;
                    }
                    else
                    {
                    	int numerator4 = reader.readInt("Enter the numerator of the fraction: ");
						int denominator4 = reader.readInt("Enter the denominator of the fraction: ");
						Fraction Garrett4 = new Fraction(numerator4, denominator4);// Stores the old value
                  	  	Fraction Replaced = list.get(location4);// Stores the new value
						list.set(location4, Garrett4);// Replaces fraction
						if(list.get(location4) == Garrett4)// Checks if the two fractions match
                  	  	{
                   	 		System.out.println("\n");
                   	    	System.out.println("The fraction " + Replaced + " has been replaced with the fraction " + Garrett4 + ".");
                  	 	}
                  	  	else// If they don't match (If there was an error)
                   		{
                    		System.out.println("\n");
                        	System.out.println("The fraction " + Replaced + " has failed to be replaced.");
                    	}
                   	 }
                    reader.pause();
                    break;
				case 7:
					System.out.println("Have a nice day!");
					System.exit(0);//Ends program
				default:
					System.out.println("Invalid input, please try again!");
					break;
			}
		}
	}
}