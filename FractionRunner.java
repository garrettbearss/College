// FractionRunner
// Garrett Bearss
// Testing the Fraction Class

public class FractionRunner
{
	public static void main(String[] args)
	{
		KeyboardReader reader = new KeyboardReader();
		int selection = 0;
		int value1, value2, value3, value4, value6, value7;
		double value5;
		value1 = reader.readInt("What is the Numerator you want Ludwig to have? ");// Used to test whatever case I want
		value2 = reader.readInt("What is the Denominator you want Ludwig to have? ");//Most used was (1/2), (2/4), (0.25)
		value3 = reader.readInt("What is the Numerator you want Daniel to have? ");
		value4 = reader.readInt("What is the Denominator you want Daniel to have? ");
		value5 = reader.readDouble("What is the Decimal you want Gabe to have? ");
		value6 = reader.readInt("What is the Numerator you want Garrett to have? ");
		value7 = reader.readInt("What is the Denominator you want Garrett to have? ");
		
		Fraction Ludwig = new Fraction(value1, value2);// Creates Fraction objects
		Fraction Daniel = new Fraction(value3, value4);
		Fraction Gabe = new Fraction(value5);
		ProperFraction Garrett = new ProperFraction(value6, value7);
		while(selection != 12) //Keeps running till exit
		{
			System.out.println("\nWelcome to my menu. Please select from the following options: \n");
			System.out.println("		1. (Test Adding) \n");
			System.out.println("		2. (Test Subtracting) \n");
			System.out.println("		3. (Test Multiply) \n");
			System.out.println("		4. (Test Divide) \n");
			System.out.println("		5. (Test toDouble) \n");
			System.out.println("		6. (Test compareTo) \n");
			System.out.println("		7. (Test equals) \n");
			System.out.println("		8. (Test getNumerator) \n");
			System.out.println("		9. (Test getDenominator) \n");
			System.out.println("		10. (Test toString) \n");
			System.out.println("		11. (Test Proper Fraction) \n");
			System.out.println("		12. Exit");
			selection = reader.readInt("Enter your selection (1-12): ");
			System.out.println("\n");
			switch(selection)
			{
				case 1://Tests add
						Fraction Dragon = Ludwig.add(Daniel);
						Dragon.print();
						break;
				case 2://Tests subtract
						Fraction Dragon2 = Daniel.subtract(Ludwig);
						Dragon2.print();
						break;
				case 3://Tests multiply
						Fraction Dragon3 = Gabe.multiply(Ludwig);
						Dragon3.print();
						break;
				case 4://Tests divide
						Fraction Dragon4 = Ludwig.divide(Gabe);
						Dragon4.print();
						break;
				case 5://Tests toDouble
						Double Dragon5 = Ludwig.toDouble();
						System.out.println(Dragon5);
						break;
				case 6://Tests compareTo
						int Dragon6 = Ludwig.compareTo(Gabe);
						System.out.println(Dragon6);
						break;
				case 7://Tests equals
						boolean Dragon7 = Ludwig.equals(Daniel);
						System.out.println(Dragon7);
						boolean Dragon8 = Ludwig.equals(0.25);
						System.out.println(Dragon8);
						boolean Dragon9 = Ludwig.equals(25, 100);
						System.out.println(Dragon9);
						break;
				case 8://Tests getNumerator
						System.out.println(Ludwig.getNumerator());
						break;
				case 9://Tests getDenominator
						System.out.println(Ludwig.getDenominator());
						break;
				case 10://Tests toString
						System.out.println(Ludwig.toString());
						break;
				case 11://Tests ProperFraction
						System.out.println(Garrett.getWhole());
						System.out.println(Garrett.getRemainder());
						System.out.println(Garrett);
						System.out.println(Garrett.toString());
						Fraction Dragon10 = Garrett.add(Ludwig);
						Dragon10.print();
						ProperFraction Dragon11 = new ProperFraction(1,2);
						break;
						//ProperFraction Dragon12 = Garrett.add(Dragon11);
						//System.out.println(Dragon12);
				case 12:
						System.out.println("Have a nice day!");
						System.exit(0);//Ends program
				default:
					System.out.println("Invalid input, please try again!"); break;
			}
		
		}
	}
}