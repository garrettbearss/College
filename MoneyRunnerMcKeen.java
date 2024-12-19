//McKeen 
//AP Computer Science -- Money Project Test cases
//MoneyRunnerMcKeen.java

//AP Computer Science -- Grading methodology
//This program tests the Money Assignment 
//using the Money class


//Test cases parallel the accompanying handout

public class MoneyRunnerMcKeen
{
	public static void main(String[]args)
	{
		KeyboardReader reader = new KeyboardReader();
		
// Create array that will store Money objects
		Money[] marray = new Money[10];  //create an array of __________

		int selection = 0;
		do
		{
		
		System.out.println("##############################################");
		System.out.println("##############################################");
		System.out.println("Welcome to Mr. McKeen's Money Menu");
		System.out.println("Please select from the following list of options:");
		System.out.println("\n\t\t1.  Test Case 1" + 
						   "\n\t\t2.  Test Case 2" + 
						   "\n\t\t3.  Test Case 3" +
						   "\n\t\t4.  BONUS SortMoney method -- Must be uncommented!!!" +
						   "\n\t\t5.  Exit\n");
		selection = reader.readInt();
		
		/////////////////////////////////////////////////////////
		///############################################///
		if (selection == 1)
		{
		
			System.out.print("Test Case One");
			System.out.println("\n\n");
			
			marray[0] = new Money(3,2);
			marray[1] = new Money(1,199);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object1 = $3.02");
			System.out.println("\tMoney object2 = $2.99");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object1 = " + marray[0]);
			System.out.println("\tMoney object2 = " + marray[1]);
			
			System.out.println("\n\nPart A -- Creating two money objects:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
	
			/////////////////////////////////////////////////////////
			System.out.print("Test Case One");
			System.out.println("\n\n");
	
			marray[2] = marray[1].add(marray[0]);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object3 = $6.01");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object3 = " + marray[2]);
			
			System.out.println("\n\nPart B -- adding two money objects:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
		
			/////////////////////////////////////////////////////////
			System.out.print("Test Case One");
			System.out.println("\n\n");
	
			marray[3] = marray[0].add(1,9);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object4 = $4.11");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object4 = " + marray[3]);
			
			System.out.println("\n\nPart C -- adding money object and two ints:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
		
			/////////////////////////////////////////////////////////
			System.out.print("Test Case One");
			System.out.println("\n\n");
	
			marray[4] = marray[0].subtract(marray[1]);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object5 = $0.03");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object5 = " + marray[4]);
			
			System.out.println("\n\nPart D -- Object 1 minus Object 2:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
		
			/////////////////////////////////////////////////////////
			System.out.print("Test Case One");
			System.out.println("\n\n");
	
			marray[5] = marray[1].subtract(marray[0]);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object6 = $0.00");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object6 = " + marray[5]);
			
			System.out.println("\n\nPart E -- Object 2 minus Object 1:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
	
			/////////////////////////////////////////////////////////
			System.out.print("Test Case One");
			System.out.println("\n\n");
	
			marray[6] = marray[0].subtract(1,9);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object7 = $1.93");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object7 = " + marray[6]);
			
			System.out.println("\n\nPart F -- Object 1 minus two ints:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
	
			/////////////////////////////////////////////////////////
			System.out.print("Test Case One");
			System.out.println("\n\n");
	
			marray[7] = marray[0].multiply(3);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object8 = $9.06");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object8 = " + marray[7]);
			
			System.out.println("\n\nPart G -- Object 1 times 3:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
		} // end selection == 1
		///############################################///
		else if(selection == 2)
		{
			System.out.print("Test Case Two");
			System.out.println("\n\n");
			
			marray[0] = new Money(0,301);
			marray[1] = new Money(4,0);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object1 = $3.01");
			System.out.println("\tMoney object2 = $4.00");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object1 = " + marray[0]);
			System.out.println("\tMoney object2 = " + marray[1]);
			
			System.out.println("\n\nPart A -- Creating two money objects:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
	
			/////////////////////////////////////////////////////////
			System.out.print("Test Case Two");
			System.out.println("\n\n");
	
			marray[2] = marray[1].add(marray[0]);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object3 = $7.01");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object3 = " + marray[2]);
			
			System.out.println("\n\nPart B -- adding two money objects:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
		
			/////////////////////////////////////////////////////////
			System.out.print("Test Case Two");
			System.out.println("\n\n");
	
			marray[3] = marray[0].add(1,99);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object4 = $5.00");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object4 = " + marray[3]);
			
			System.out.println("\n\nPart C -- adding money object and two ints:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
		
			/////////////////////////////////////////////////////////
			System.out.print("Test Case Two");
			System.out.println("\n\n");
	
			marray[4] = marray[0].subtract(marray[1]);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object5 = $0.00");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object5 = " + marray[4]);
			
			System.out.println("\n\nPart D -- Object 1 minus Object 2:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
		
			/////////////////////////////////////////////////////////
			System.out.print("Test Case Two");
			System.out.println("\n\n");
	
			marray[5] = marray[1].subtract(marray[0]);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object6 = $0.99");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object6 = " + marray[5]);
			
			System.out.println("\n\nPart E -- Object 2 minus Object 1:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
	
			/////////////////////////////////////////////////////////
			System.out.print("Test Case Two");
			System.out.println("\n\n");
	
			marray[6] = marray[0].subtract(1,99);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object7 = $1.02");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object7 = " + marray[6]);
			
			System.out.println("\n\nPart F -- Object 1 minus two ints:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
	
			/////////////////////////////////////////////////////////
			System.out.print("Test Case Two");
			System.out.println("\n\n");
	
			marray[7] = marray[0].multiply(10);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object8 = $30.10");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object8 = " + marray[7]);
			
			System.out.println("\n\nPart G -- Object 1 times 3:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();

		}
		///############################################///
		else if (selection == 3)
		{
			
			System.out.print("Test Case Three");
			System.out.println("\n\n");
			
			marray[0] = new Money(-10,1001);
			marray[1] = new Money(5,-501);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object1 = $0.01");
			System.out.println("\tMoney object2 = $0.00");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object1 = " + marray[0]);
			System.out.println("\tMoney object2 = " + marray[1]);
			
			System.out.println("\n\nMystery Test Case Part A -- Creating two money objects:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
	
			/////////////////////////////////////////////////////////
			System.out.print("Test Case Three");
			System.out.println("\n\n");
	
			marray[2] = marray[0].subtract(marray[1]);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object3 = $0.01");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object3 = " + marray[2]);
			
			System.out.println("\n\nMystery Test Case Part B -- subtracting two money objects:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
		
			/////////////////////////////////////////////////////////
			System.out.print("Test Case Three");
			System.out.println("\n\n");
	
			marray[3] = marray[1].subtract(marray[0]);
			
			System.out.println("Correct display should be:");
			System.out.println("\tMoney object4 = $0.00");
	
			System.out.println("Student display is:");
			System.out.println("\tMoney object4 = " + marray[3]);
			
			System.out.println("\n\nMystery Test Case Part C -- subtracting two money objects:");
			System.out.println("If the Correct display matches the Student display,");
			System.out.println("give 1/1");
			System.out.println("\n\n\n\n\n");
			reader.pause();
			
		}
		//REMOVE the comment marks if you want to test the bonus SortMoney method
		else if (selection == 4)
		{
//			Money.SortMoney();
		}
	}while (selection != 5);
	System.out.println("\n\n\nGoodbye.  I hope that this was a pleasant testing experience for you.\n\n\n");
	}
}
		