//McKeen 
//AP JAVA Test cases
//FractionTestMcKeen.java

//AP Computer Science -- Yet another stressful grading day
//This program tests the Fraction Assignment in the Fraction class

// BEFORE testing, students should add the FractionInterface
// to make sure all of the required methods are present

public class FractionTestMcKeen
{
	public static void main(String[]args)
	{
		KeyboardReader reader = new KeyboardReader();
		
		Fraction[] farray = new Fraction[16];  //create an array of __________

//Instantiate array of Fractions		
		farray[0] = new Fraction(1,4);
		farray[1] = new Fraction(12, 24);
		farray[2] = new Fraction(-1, 7);
		farray[3] = new Fraction(1, -8);
		farray[4] = new Fraction(-2, -12);
		farray[5] = new Fraction(41, 143);
		farray[6] = new Fraction(111, 12321);
		farray[7] = new Fraction(27, 9);
		farray[8] = new Fraction(5, 10);
		farray[9] = new Fraction(18, 36);
		farray[10] = new Fraction(1, 12321);
		farray[11] = new Fraction(3, 24);
		farray[12] = new Fraction(3, 8);
		farray[13] = new Fraction(3, 8);
		farray[14] = new Fraction(1, 8);
		farray[15] = new Fraction();


//##################################################################
//Display values with print and toString
		System.out.println("\nTest Case One -- Constructors and print");
		int i;
		for(i = 0; i<farray.length; i++)
		{
			System.out.print("Value #" + (i+1) + " = ");
			farray[i].print();
			System.out.println();
		}
		reader.pause();

//##################################################################
		System.out.println("\nTest Case Two -- Addition and toString");
		for(i = 0; i<farray.length; i+=2)
		{
			System.out.println("\tSubcase #" + ((i+2)/2) + ":  " 
								+ farray[i].toString() + " + " 
								+ farray[i+1].toString() + " = \t" 
								+ farray[i].add(farray[i+1]));
		}
		reader.pause();

//##################################################################
		System.out.println("\nTest Case Three -- Subtract");
		for(i = 0; i<farray.length; i+=2)
		{
			System.out.println("\tSubcase #" + ((i+2)/2) + ":  " 
								+ farray[i].toString() + " - " 
								+ farray[i+1].toString() + " = \t" 
								+ farray[i].subtract(farray[i+1]));
		}
		reader.pause();
		
//##################################################################
		System.out.println("\nTest Case Four -- Multiply");
		for(i = 0; i<farray.length; i+=2)
		{
			System.out.println("\tSubcase #" + ((i+2)/2) + ":  " 
								+ farray[i].toString() + " X " 
								+ farray[i+1].toString() + " = \t" 
								+ farray[i].multiply(farray[i+1]));
		}
		reader.pause();

//##################################################################
		System.out.println("\nTest Case Five -- Divide");
		for(i = 0; i<farray.length-2; i+=2)
		{
			System.out.println("\tSubcase #" + ((i+2)/2) + ":  " 
								+ farray[i].toString() + " divided by " 
								+ farray[i+1].toString() + " = \t" 
								+ farray[i].divide(farray[i+1]));
		}
		reader.pause();
		
//##################################################################
		System.out.println("\nTest Case Six -- toDouble");
		for(i = 0; i<4; i++)
		{
			System.out.println("\tSubcase #" + (i+1) + ":  " 
								+ farray[i].toString() + " toDouble is \t" 
								+ farray[i].toDouble());
		} //special case for 3/1
		System.out.println("\tSubcase #" + 5 + ":  " 
								+ farray[7].toString() + " toDouble is \t" 
								+ farray[7].toDouble());

		reader.pause();
		
//##################################################################
		System.out.println("\nTest Case Seven -- compareTo");
		for(i = 0; i<farray.length-2; i+=2)
		{
			System.out.println("\tSubcase #" + ((i+2)/2) + ":  " 
								+ farray[i].toString() + " compared to " 
								+ farray[i+1].toString() + " = \t" 
								+ farray[i].compareTo(farray[i+1]));
		}
		reader.pause();
		
//##################################################################
		System.out.println("\nTest Case Eight -- compareTo");
		for(i = 0; i<farray.length-2; i+=2)
		{
			System.out.println("\tSubcase #" + ((i+2)/2) + ":  " 
								+ farray[i+1].toString() + " compared to " 
								+ farray[i].toString() + " = \t" 
								+ farray[i+1].compareTo(farray[i]));
		}
		reader.pause();
		
//##################################################################
		System.out.println("\nTest Case Nine -- equals");
		for(i = 0; i<farray.length-2; i+=2)
		{
			System.out.println("\tSubcase #" + ((i+2)/2) + ":  " 
								+ farray[i].toString() + " == " 
								+ farray[i+1].toString() + " = \t" 
								+ farray[i].equals(farray[i+1]));
		}
		reader.pause();
		
//##################################################################
		System.out.println("\nTest Case Ten -- Miscellaneous");
		System.out.print("Subcase #1");
		System.out.print("\tTesting equals(double)");
		System.out.print("\t" + farray[1].toString() + " == " 
								+ .5 + " = " 
								+ farray[1].equals(.5) + "\n");

		System.out.print("Subcase #2");
		System.out.print("\tTesting equals(int n, int d)");
		System.out.print("\t" + farray[1].toString() + " == " 
								+ " 1, 4  = " 
								+ farray[1].equals(1,4) + "\n");
		
		System.out.print("Subcase #3");
		System.out.print("\tNumerator of "+farray[1]+" is " 
											+ farray[1].getNumerator()+ "\n" );

		System.out.print("Subcase #4");
		System.out.print("\tDenominator of "+farray[1]+" is " 
											+farray[1].getDenominator());
		reader.pause();

//##################################################################
		//Using the Fraction(double) constructor
		System.out.println("\nTest Case Eleven -- Fraction(double)");
		System.out.println("Subcase #1");
		farray[0] = new Fraction(.25);
		farray[1] = new Fraction(.5);
		farray[2] = new Fraction(.1);
		farray[3] = new Fraction(-.25);
		farray[4] = new Fraction(2.25);
		farray[5] = new Fraction(100.25);
		
		for(i = 0; i<6; i++)
		{
			System.out.print("Value #" + (i+1) + " = ");
			farray[i].print();
		}
		reader.pause();


//##################################################################
// UNCOMMENT THIS TO TEST THE BONUS:

//		//// BONUS ONUS NUS US S
//		////Testing the bonus:  public Fraction FractionList(char[] operators, Fraction[] list) 		
//	
//		Fraction[] bonusArray = new Fraction[5];
//		char[] charArray = new char[5];
//		
//		bonusArray[0] = new Fraction(1,2);
//		bonusArray[1] = new Fraction(1,4);
//		bonusArray[2] = new Fraction(1,3);
//		bonusArray[3] = new Fraction(1,5);
//		bonusArray[4] = new Fraction(1,6);
//
//		charArray[0] = '+';
//		charArray[1] = '+';
//		charArray[2] = '-';
//		charArray[3] = '*';
//		charArray[4] = '/';
//		
//		
//		Fraction bonus = new Fraction(1,8);
//		
//		Fraction answer = bonus.FractionList(charArray, bonusArray);
//		
//		System.out.println("\nTest Case FractionList BONUS");
//		
//		System.out.println("\nCORRECT display should be: \t13/20");
//	
//		System.out.println("\nSTUDENT display is: \t\t" + answer);
			

		
	}
}
		