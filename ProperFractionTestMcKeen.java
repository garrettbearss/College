//McKeen
//AP JAVA Test cases
//ProperFractionTestMcKeen.java

//tests ProperFraction class


public class ProperFractionTestMcKeen
{
	public static void main(String[]args)
	{
		KeyboardReader reader = new KeyboardReader();
		
		ProperFraction[] farray = new ProperFraction[10];

//Instantiate array of ProperFractions		
		farray[0] = new ProperFraction(8,3);
		farray[1] = new ProperFraction(25, 24);
		farray[2] = new ProperFraction(12, 2);
		farray[3] = new ProperFraction(-8, 1);
		farray[4] = new ProperFraction(9, -2);
		farray[5] = new ProperFraction(-7, -3);
		farray[6] = new ProperFraction(12321, 111);
		farray[7] = new ProperFraction(-41, 143);
		farray[8] = new ProperFraction(15, 10);
		farray[9] = new ProperFraction(1, 0);


//Display values with print and toString
//		System.out.println("Test Case One -- Constructors and print");
		int i;
//		for(i = 0; i<farray.length; i++)
//		{
//			System.out.print("Value #" + (i+1) + " = ");
//			farray[i].print();
//			System.out.println();
//		}
//		reader.pause();
//		
		System.out.println("Test Case Two -- toString");
		for(i = 0; i<farray.length; i++)
		{
			System.out.println("Value #" + (i+1) + " = " + farray[i]);
		}
		reader.pause();
		
		System.out.println("Mr. McKeen hopes you and your gradee both get a perfect on this assignment. \n"
			+ "He also hopes that you go on to live a happy and productive life. \n\n\n"
			+ "Finally, he hopes that you can find something to write a good Grader's Comparison about \n"
			+ "even though this was a relatively easy assignment.");
	}
}
		