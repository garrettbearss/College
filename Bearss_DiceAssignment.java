//Bearss_DiceAssignment.java
//Garrett Bearss
//Rolls a dice in different situations

public class Bearss_DiceAssignment
{
	public static void main(String[] args)
	{
		KeyboardReader reader = new KeyboardReader();
		int selection = 0;	
		while(selection != 4) //Keeps running till exit
		{
			System.out.println("\nWelcome to my menu. Please select from the following options: \n");
			System.out.println("		1. Roll Two Dice (Assignment 1) \n");
			System.out.println("		2. Roll One Dice (Assignment 2) \n");
			System.out.println("		3. Play a game of Craps \n");
			System.out.println("		4. Exit");
			selection = reader.readInt("Enter your selection (1-4): ");
			System.out.println("\n");
			switch(selection)
			{
				case 1:	
						char select1 = 'Y';
						while(select1 == 'Y')//While the person chooses Yes then it will keep running
						{
							RollTwoDice();
							select1 = reader.readChar("Would you like to play again? (Y/N) ");//Person chooses weither to keep running or not
						}			
						break;
				case 2:
						RollOneDice(); break;
				case 3:
						char select2 = 'Y';
						while(select2 == 'Y')//While the person chooses Yes then it will continue to run
						{
							craps();
							select2 = reader.readChar("\nWould you like to play again? (Y/N) ");//Depending on choice the loop will run or not	
						}			
						break;
				case 4:
						System.out.println("Have a nice day!");
						System.exit(0);//Ends program
				default:
					System.out.println("Invalid input, please try again!"); break;
			}
		}
	}
	public static void RollTwoDice()
	{
		KeyboardReader reader = new KeyboardReader();
		Dice Bob = new Dice(6);
		Dice mydie = new Dice (6);
		int times = reader.readInt("How many times would you like to roll the dice? ");
		
		for(int i = 1; i <= times; i++)//Runs depending on how many times the user wants
		{
			int Roll1 = Bob.roll();
			int Roll2 = mydie.roll();
			int Sum = Roll1 + Roll2;
			System.out.print("Roll #" + i + ": \t" + Roll1 + " + " + Roll2 + " = " + Sum + ".");
			reader.pause();//Pauses after every roll for user
		}
	}
	public static void RollOneDice()
	{
		KeyboardReader reader = new KeyboardReader();
		Dice Gabe = new Dice(6);
		int times = 10000;
		int[] numarray = new int[6];//Creates array with 6 slots (0-6)
		for(int i = 1; i <= times; i++)//Runs 10000 times
		{
			int roll = Gabe.roll();
			if(roll == 1)
			{
				numarray[0]++;//Puts all 1's in the 0 slot
			}
			else if(roll == 2)
			{
				numarray[1]++;//Puts all 2's in the 1 slot
			}
			else if(roll == 3)
			{
				numarray[2]++;//Puts all 3's in the 2 slot
			}
			else if(roll == 4)
			{
				numarray[3]++;//Puts all 4's in the 3 slot
			}
			else if(roll == 5)
			{
				numarray[4]++;//Puts all 5's in the 4 slot
			}
			else if(roll == 6)
			{
				numarray[5]++;//Puts all 6's in the 5 slot
			}
		}
		System.out.println("Number of times 1 was rolled: " + numarray[0]);//Prints each array slot with corresponding numbers	
		System.out.println("Number of times 2 was rolled: " + numarray[1]);
		System.out.println("Number of times 3 was rolled: " + numarray[2]);
		System.out.println("Number of times 4 was rolled: " + numarray[3]);
		System.out.println("Number of times 5 was rolled: " + numarray[4]);
		System.out.println("Number of times 6 was rolled: " + numarray[5]);
	}
	public static void craps()
	{
		KeyboardReader reader = new KeyboardReader();
		Dice Luck = new Dice(6);
		Dice Unluck = new Dice (6);
			int Roll1 = Luck.roll();//Calculates the first roll for the set
			int Roll2 = Unluck.roll();
			int Sum = Roll1 + Roll2;
			System.out.println("Player rolled\t" + Roll1 + " + " + Roll2 + " = " + Sum + ".");
			if(Sum == 7 || Sum == 11)//Checks to see if the player instantly wins
			{
				System.out.println("Player wins!");
			}
			else if(Sum == 2 || Sum == 3 || Sum == 12)//Checks to see if the player instantly loses
			{
				System.out.println("Player loses.");
			}
			else
			{
				int point = Sum;
				int i = 0;//Used to make sure that this runs at least once
				System.out.println("Point is " + point + "\n");//Shows the player the point
				while(Sum != point || i == 0)//Keeps running untill sum is either point or 7
				{
					Roll1 = Luck.roll();//Calculates the two different rolls
					Roll2 = Unluck.roll();
					Sum = Roll1 + Roll2;
					i++;
					System.out.println("Player rolled\t" + Roll1 + " + " + Roll2 + " = " + Sum + ".");
					if(Sum == point)//If the Sum is point the player wins
					{
						System.out.println("Player wins!\n");
						break;
					}
					else if(Sum == 7)//If the Sum is 7 they lose
					{
						System.out.println("Player loses.\n");
						break;
					}
				}
			}
	}
}