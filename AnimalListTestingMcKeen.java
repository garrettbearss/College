// Runner file 
// McKeen
// Test the AnimalList Assignment 
public class AnimalListTestingMcKeen
{
	public static void main(String[]args)
	{
		KeyboardReader reader = new KeyboardReader();
		AnimalList list; // = new AnimalList();
		int selection;
		int casenum;  
		char answer; //records bonus yes or no
		boolean bonus = false; //is the bonus being graded?
		
		do
		{			
			list = new AnimalList();
			System.out.println("\n1.) Grade the assignment using Test Group A"+
			"\n2.) Grade the assignment using Test Group B"+
			"\n3.) Grade the assignment using Test Group C"+
			"\n4.) Grade the assignment using Test Group D"+
			"\n0.) Exit ");
			selection = reader.readInt("Enter a selection: ");
			
			//Test Cases -- Group A				
			if (selection == 1)
			{
				answer = reader.readChar("\nAre you grading the BONUS too? (y or n)");
				if (answer == 'y' || answer == 'Y')
					bonus = true;
				
///***********************************************************
				casenum = 1;  //used to increment the case number
				//Test Cases -- Group A				
				System.out.println("Test Group A\n\n");
								
				System.out.println("\nCASE " + casenum + ": ");
				System.out.println("*** Adding koala to an empty list ***\n");
				list.addAnimal("koala");
				displayBonus(bonus, "Added", "koala", "NONE", "NONE");

				System.out.println("The CORRECT display is: \nkoala\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
				
///***********************************************************
				//2
				casenum = 2;  //used to increment the case number
				System.out.println("\n\n\n\nCASE " + casenum + ": ");
				System.out.println("*** Adding goat to the list ***\n");
				list.addAnimal("goat");
				displayBonus(bonus, "Added", "goat", "NONE", "koala");

				System.out.println("The CORRECT display is: \ngoat\nkoala\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
				
///***********************************************************
				//3
				casenum = 3;  //used to increment the case number
				System.out.println("\n\n\n\nCASE " + casenum + ": ");
				System.out.println("*** Removing koala from the list ***\n");
				list.removeAnimal("koala");
				displayBonus(bonus, "Removed", "koala", "goat", "NONE");

				System.out.println("The CORRECT display is: \ngoat\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
				
///***********************************************************
				//4		
				casenum = 4;  //used to increment the case number
				System.out.println("\n\n\n\nCASE " + casenum + ": ");
				System.out.println("*** Adding ant to the list ***\n");
				list.addAnimal("ant");
				displayBonus(bonus, "Added", "ant", "NONE", "goat");

				System.out.println("The CORRECT display is: \nant\ngoat\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
				
///***********************************************************
				//5		
				casenum = 5;  //used to increment the case number
				System.out.println("\n\n\n\nCASE " + casenum + ": ");
				System.out.println("*** Removing goat from the list ***\n");
				list.removeAnimal("goat");
				displayBonus(bonus, "Removed", "goat", "ant", "NONE");

				System.out.println("The CORRECT display is: \nant\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
				
				
///***********************************************************
				//6		
				casenum = 6;  //used to increment the case number
				System.out.println("\n\n\n\nCASE " + casenum + ": ");
				System.out.println("*** Adding zebra to the list ***\n");
				list.addAnimal("zebra");
				displayBonus(bonus, "Added", "zebra", "ant", "NONE");

				System.out.println("The CORRECT display is: \nant\nzebra\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
				
				
///***********************************************************
				//7		
				casenum = 7;  //used to increment the case number
				System.out.println("\n\n\n\nCASE " + casenum + ": ");
				System.out.println("*** Removing ant from the list ***\n");
				list.removeAnimal("ant");
				displayBonus(bonus, "Removed", "ant", "NONE", "zebra");

				System.out.println("The CORRECT display is: \nzebra\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
				
				
///***********************************************************
				//8		
				casenum = 8;  //used to increment the case number
				System.out.println("\n\n\n\nCASE " + casenum + ": ");
				System.out.println("*** Removing zebra to make an empty list ***\n");
				list.removeAnimal("zebra");
				displayBonus(bonus, "Removed", "zebra", "NONE", "NONE");

				System.out.println("The CORRECT display is: \n<empty list>\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "\n(in other words, no values are displayed) \ngive 1/1 point.");
				reader.pause();

///***********************************************************
				//9
				casenum = 9;  //used to increment the case number
				System.out.println("\n\n\n\nCASE " + casenum + ": ");
				System.out.println("*** Displaying the numAddRemove ***\n");
				System.out.println("The CORRECT display is: 8\n");
				System.out.println("The STUDENT's display is: " + list.getnumAddRemove());
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
//				System.out.print("\nThis program will terminate when you ");
				reader.pause();
//				System.exit(0);
				casenum++;

			}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
			//Test Cases -- Group B				
			else if (selection == 2)
			{
				answer = reader.readChar("\nAre you grading the BONUS too? (y or n)");
				if (answer == 'y' || answer == 'Y')
					bonus = true;
				
				casenum = 1;  //used to increment the case number
				//Test Cases -- Group B				
				System.out.println("Test Group B\n\n");
								
				System.out.println("\nCASE " + casenum + ": ");
				System.out.println("*** Adding bear, deer, frog, halibut, koala to an empty list ***\n");
				list.addAnimal("bear");
				displayBonus(bonus, "Added", "bear", "NONE", "NONE");
				list.addAnimal("deer");
				displayBonus(bonus, "Added", "deer", "bear", "NONE");
				list.addAnimal("frog");
				displayBonus(bonus, "Added", "frog", "deer", "NONE");
				list.addAnimal("halibut");
				displayBonus(bonus, "Added", "halibut", "frog", "NONE");
				list.addAnimal("koala");
				displayBonus(bonus, "Added", "koala", "halibut", "NONE");
				System.out.println("The CORRECT display is: \nbear\ndeer\nfrog\nhalibut\nkoala\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
				
///***********************************************************
				//2				
				casenum = 2;  //used to increment the case number
				System.out.println("\nCASE " + casenum + ": ");
				System.out.println("*** Adding goat to the list ***\n");
				list.addAnimal("goat");
				displayBonus(bonus, "Added", "goat", "frog", "halibut");
				System.out.println("The CORRECT display is: \nbear\ndeer\nfrog\ngoat\nhalibut\nkoala\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
				
///***********************************************************
				//3
				casenum = 3;  //used to increment the case number
				System.out.println("\nCASE " + casenum + ": ");
				System.out.println("*** Removing koala from the list ***\n");
				list.removeAnimal("koala");
				displayBonus(bonus, "removed", "koala", "halibut", "NONE");
				System.out.println("The CORRECT display is: \nbear\ndeer\nfrog\ngoat\nhalibut\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
				
///***********************************************************
				//4
				casenum = 4;  //used to increment the case number
				System.out.println("\nCASE " + casenum + ": ");
				System.out.println("*** Adding ant to the list ***\n");
				list.addAnimal("ant");
				displayBonus(bonus, "Added", "ant", "NONE", "bear");
				System.out.println("The CORRECT display is: \nant\nbear\ndeer\nfrog\ngoat\nhalibut\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
				
///***********************************************************
				//5
				casenum = 5;  //used to increment the case number
				System.out.println("\nCASE " + casenum + ": ");
				System.out.println("*** Removing goat from the list ***\n");
				list.removeAnimal("goat");
				displayBonus(bonus, "Removed", "goat", "frog", "halibut");
				System.out.println("The CORRECT display is: \nant\nbear\ndeer\nfrog\nhalibut\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
					
///***********************************************************
				//6
				casenum = 6;  //used to increment the case number
				System.out.println("\nCASE " + casenum + ": ");
				System.out.println("*** Adding zebra to the list ***\n");
				list.addAnimal("zebra");
				displayBonus(bonus, "Added", "zebra", "halibut", "NONE");
				System.out.println("The CORRECT display is: \nant\nbear\ndeer\nfrog\nhalibut\nzebra\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
				
///***********************************************************
				//7
				casenum = 7;  //used to increment the case number
				System.out.println("\nCASE " + casenum + ": ");
				System.out.println("*** Removing ant from the list ***\n");
				list.removeAnimal("ant");
				displayBonus(bonus, "Removed", "ant", "NONE", "bear");
				System.out.println("The CORRECT display is: \nbear\ndeer\nfrog\nhalibut\nzebra\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();
						
				
///***********************************************************
				//8
				casenum = 8;  //used to increment the case number
				System.out.println("\nCASE " + casenum + ": ");
				System.out.println("*** Attempting to remove fox, which is not in the list ***\n");
				System.out.println("*** Attempting to remove aardvark, which is not in the list ***\n");
				System.out.println("*** Attempting to remove zzyzx, which is not in the list ***\n");
				System.out.println("*** Attempting to remove zebra, which is in the list ***\n");
				System.out.println("The CORRECT display is: \nfalse\nfalse\nfalse\ntrue\n");
				System.out.println("The STUDENT's display is: ");
				System.out.println(list.removeAnimal("fox"));
				System.out.println(list.removeAnimal("aardvark"));
				System.out.println(list.removeAnimal("zzyzx"));
				System.out.println(list.removeAnimal("zebra"));
				
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.  \nIf only one mistake, give .5/1 points.  Give 0/1 otherwise.");

				reader.pause();
				
///***********************************************************
				//9
				casenum = 9;  //used to increment the case number
				System.out.println("\nCASE " + casenum + ": ");
				System.out.println("*** Attempting to remove all animals in the following order: ***\n");
				System.out.println("*** frog - deer - bear - halibut - whale***\n");
				System.out.println("The CORRECT display is: \ntrue\ntrue\ntrue\ntrue\nfalse\n");
				System.out.println("The STUDENT's display is: ");
				System.out.println(list.removeAnimal("frog"));
				System.out.println(list.removeAnimal("deer"));
				System.out.println(list.removeAnimal("bear"));
				System.out.println(list.removeAnimal("halibut"));
				System.out.println(list.removeAnimal("whale"));
				
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.  \nIf only one mistake, give .5/1 points.  Give 0/1 otherwise.");

				reader.pause();
				
///***********************************************************
				//10
				casenum = 10;  //used to increment the case number
				System.out.println("\n\n\n\nCASE " + casenum + ": ");
				System.out.println("*** Displaying the empty list ***\n");
				System.out.println("The CORRECT display is: \n<empty list>\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				
///***********************************************************
				//11
				System.out.println("\n\n\n\nCASE " + casenum + ": ");
				System.out.println("*** Displaying the numAddRemove ***\n");
				System.out.println("The CORRECT display is: 16\n");
				System.out.println("The STUDENT's display is: " + list.getnumAddRemove());
				System.out.println("\nCase " + casenum + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 1/1 point.");
				reader.pause();

				casenum++;
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
			//Test Cases -- Group C		-- Using Integers instead
			else if (selection == 3)
			{
				casenum = 1;  //used to increment the case number
				//Test Cases -- Group C				
				System.out.println("Test Group C\n\n");
								
				list.addAnimal(new Integer(10));
				list.addAnimal(new Integer(8));
				list.addAnimal(new Integer(6));
				list.addAnimal(new Integer(7));
				list.addAnimal(new Integer(9));
				list.removeAnimal(new Integer(5));
				list.removeAnimal(new Integer(6));
				list.removeAnimal(new Integer(10));
				System.out.println("*** Attempting to add and remove Integers: ***\n");
				System.out.println("The CORRECT display is: \n7\n8\n9\n\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nTest Group C" + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 2/2 points.");
				reader.pause();
			}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
			//Test Cases -- Group D		-- Duplicates
			else if (selection == 4)
			{
				casenum = 1;  //used to increment the case number
				//Test Cases -- Group D				
				System.out.println("Test Group D\n\n");
								
				list.addAnimal("antelope");
				list.addAnimal("antelope");
				list.addAnimal("antelope");
				list.addAnimal("spider");
				list.addAnimal("spider");
				list.addAnimal("spider");
				list.removeAnimal("antelope");
				list.removeAnimal("spider");
				System.out.println("*** Attempting to add and remove duplicates: ***\n");
				System.out.println("The CORRECT display is: \nantelope\nantelope\nspider\nspider\n\n");
				System.out.println("The STUDENT's display is: ");
				list.displayList();
				System.out.println("\nTest Group D" + ": If the CORRECT display and the STUDENT's file match, "
									+ "give 2/2 points.");
				System.out.print("\nMr. McKeen hopes you are happy and proud of your accomplishments. ");
				System.out.print("\nHe is also relieved that your interest in CS allows him to feed his children. ");
				System.out.print("\n\nThis program will terminate when you ");
				reader.pause();
				System.exit(0);
			}

			else if (selection == 5)
			{
				String animal = reader.readLine("Enter the name: ");
				list.addAnimal(animal);
			}
			else if(selection == 6)
			{
				String animal = reader.readLine("Enter the name: ");
				boolean success = list.removeAnimal(animal);
				if (success == true)
					System.out.println("Delete was successful.");
				else
					System.out.println("The search term was not found.");
			}
			else if (selection == 7)
			{
				list.displayList();
			}
			else if (selection == 8)
			{
				System.out.println("The total number of adds and removes is: " + list.getnumAddRemove());
			}

			
			
		}while (selection != 0);
	}

	// To simplify the display of the bonus output
	public static void displayBonus(boolean bonus, String act, String animal, String before, String after)	
	{
		if (bonus)
		{
			System.out.println("$$ " + 
			act + ":  " + animal + "   BEFORE: " + before + "   AFTER: "+ after + "\n");
		}
		
	}

}