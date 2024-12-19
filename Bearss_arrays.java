//Garrett Bearss
//Bearss_arrays.java
//A menu with programs for arrays

public class Bearss_arrays
{
	public static void main(String [] args)
	{
		KeyboardReader reader = new KeyboardReader();
		int selection = 0;
		
		while(selection != 4) //Keeps running till exit
		{
			System.out.println("\nWelcome to my menu. Please select from the following options: \n");
			System.out.println("		1. max-min-avg \n");
			System.out.println("		2. high-values \n");
			System.out.println("		3. BONUS \n");
			System.out.println("		4. Exit");
			selection = reader.readInt("Enter your selection (1-4): ");
			System.out.println("\n");
			switch(selection)
			{
				case 1:
						maxminavg(); break;
				case 2:
						highvalues(); break;
				case 3:
						bonus(); break;
				case 4:
						System.out.println("Have a nice day!");
						System.exit(0);
				default:
					System.out.println("Invalid input, please try again!"); break;
			}
		}
	}
	public static void maxminavg()
	{
		KeyboardReader reader = new KeyboardReader();
		int[] numarray = new int[10]; //10 slots
		int max, min;
		double avg;
		for(int i = 1; i<11; i++) //Runs 10 times, enters values into array
		{
			int value = i;
			numarray[i-1]= (reader.readInt("Enter value " + value + ": "));
		}
		
		avg = (double)(numarray[1] + numarray[2] + numarray[3] + numarray[4] + numarray[5] + numarray[6] + numarray[7] + numarray[8] + numarray[9] + numarray[0])/10;
		max = numarray[0];
		min = numarray[0];
		for(int i = 0; i<numarray.length; i++)//Runs 10 times
		{
			if(numarray[i] > max) //Finds max
			{
				max = numarray[i];
			}
		}
		for(int i = 0; i<numarray.length; i++)//Runs 10 times
		{
			if(numarray[i] < min)
			{
				min = numarray[i];
			}
		}
		for(int i = 0; i<numarray.length; i++)//Runs 10 times
		{
			System.out.println("Value " + (i+1) + ": " + numarray[i]);
		}
		System.out.println("\n");
		System.out.println("Average = " + avg);
		System.out.println("Max = " + max);
		System.out.println("Min = " + min);
	}
	public static void highvalues()
	{
		KeyboardReader reader = new KeyboardReader();
		final int value = reader.readInt("Enter how many numbers are you inputting: ");
		int[] numarray = new int[value]; //Makes array based on what it reads in
		for(int i = 1; i <= value; i++) //Enters values into array based on # of times read from value
		{
			int n = i;
			numarray[i-1]= (reader.readInt("Enter value " + n + ": "));
		}
		System.out.print("List of values: ");
		int high1, high2, high3, max, min, before1, before2;
		high1 = 1; 
		high2 = 1;
		high3 = 1;
		max = numarray[0]; //If only one value is entered it shows up as highest value
		min = numarray[0];
		before1 = 0; // before1 variable is used to make sure that the next 2 highest variables arn't accounting the first one
		before2 = 0; // before2 variable is used to make sure that the last highest doesn't account the 1st and 2nd highest values
		for(int i = 0; i<numarray.length; i++) //calculates the min for prep. for negative numbers
		{
			if(numarray[i] < min)
			{
				min = numarray[i];
			}
		}
		for(int i = 1; i <= value; i++)//prints all of the values in order when entered
		{
			int n = i;
			if(i != value)
			{
				System.out.print(numarray[i-1] + ", ");
			}
			else
			{
				System.out.print(numarray[i-1]);
			}
		}
		
		System.out.println("\n");
		
		for(int i = 0; i<numarray.length; i++)
		{
			if(numarray[i] >= max)
			{
				max = numarray[i];
				high1 = i+1;//used at end to let the receiver know at what value the highest was entered on
				before1 = i;//used to make sure there are no recounts of the same value
			}
		}
		if(max > 0)//if the previous number was a positive
		{
			max = 0;
		}
		else//if the previous number was a negative
		{
			max = -1;
		}
		for(int i = 0; i<numarray.length; i++)
		{
			if(i != before1)//make sure no recounts
			{
				if(max >= 0)//catchs positives
				{
					if(numarray[i] >= max)
					{
							max = numarray[i];
							high2 = i+1;//used at end for the second highest value
							before2 = i;//used to make sure this value doesn't get recounted
					}
				}
				else//catchs negatives
				{
					if(numarray[i] <= max && numarray[i] >= min)//runs if the number is negative 
					{
							max = numarray[i];
							high2 = i+1;//used at the end for the second highest value
							before2 = i;//doesn't get recounted
							min = numarray[i];//moves the min higher to prevent a lower negative from becomming a new higher value
					}
				}
			}
		}
		for(int i = 0; i<numarray.length; i++)
		{
			if(numarray[i] < min)//changes the min back to the min of the entire array
			{
				min = numarray[i];
			}
		}
		if(max > 0)//if the previous number was a positive
		{
			max = 0;
		}
		else//if the previous number was a negative
		{
			max = -1;
		}
		for(int i = 0; i<numarray.length; i++)
		{
			if(i != before1 && i != before2)//makes sure it doesn't count the past two highest values
			{
				if(max >= 0)//catchs positives
				{
					if(numarray[i] >= max)
					{
							max = numarray[i];
							high3 = i+1;	
					}
				}
				else//catchs negatives
				{
					if(numarray[i] <= max && numarray[i] >= min)
					{
							max = numarray[i];
							high3 = i+1;//3rd highest value in the array
							min = numarray[i];//finds min to lower the range for the next higher number
					}
				}
			}
		}
		
		System.out.println("There were a total of " + value + " numbers entered.\n");
		System.out.println("The highest number was in sequence # " + high1);//inputs all high values with their respective order
		System.out.println("The second highest number was in sequence # " + high2);
		System.out.println("The third highest number was in sequence # " + high3);
	}
	public static void bonus()
	{
		KeyboardReader reader = new KeyboardReader();
		final int value = reader.readInt("Enter how many names/ grades are you inputting: ");
		System.out.println("\n");
		String[] names = new String[value];//makes a string array for names
		int[] grades = new int[value];//makes a int array for grades
		int[] best = new int[value];//puts # of which student has the best score by sequence number
		int highest;
		int mean = 0;
		highest = -1;//grades will always be higher because you can't have a negative grade
		for(int i = 1; i <= value; i++)
		{
			int n = i;
			names[i-1]= (reader.readLine("Enter name " + n + ": "));
			grades[i-1]= (reader.readInt("Enter grade " + n + ": "));
		}
		for(int i = 0; i<grades.length; i++)
		{
			if(grades[i] >= highest)//finds highest grade
			{
				highest = grades[i];
				best[i] = i;
				System.out.println(best[i]);
			}
		}
		System.out.println("\n");
		for(int i = 0; i<names.length; i++)
		{
			if(i == best[i])//if the person had the highest score gives them some stars
			{
				System.out.println("*" + names[i] + "*, *" + grades[i] + "*");
			}
			else//rest of the people go here
			{
				System.out.println(names[i] + ", " + grades[i]);
			}
		}
		for(int i = 0; i<grades.length; i++)//adds all values to mean
		{
			mean = grades[i] + mean;
		}
		mean = mean/value;//then divides to find the mean
		System.out.println("The mean score was: " + mean + " but, the highest score is: " + highest);
	}
}