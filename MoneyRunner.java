// MoneyRunner
// Garrett Bearss
// Testing the Money Class

public class MoneyRunner
{
	public static void main(String[] args)
	{
		KeyboardReader reader = new KeyboardReader();
		int selection = 0;
		int value1, value2, value3, value4, value5, value6;
		value1 = reader.readInt("How many Dollars do you want Ludwig to have? ");// Used to test whatever case I want
		value2 = reader.readInt("How many Cents do you want Ludwig to have? ");	
		value3 = reader.readInt("How many Dollars do you want Daniel to have? ");// Common cases were: #1 = (100,100) (200,200) (300,300) #2 = (100,100) (50,50) (25,25)
		value4 = reader.readInt("How many Cents do you want Daniel to have? ");// #3 = (-200,-200) (2000, -2000) (20, -10)
		value5 = reader.readInt("How many Dollars do you want Gabe to have? ");
		value6 = reader.readInt("How many Cents do you want Gabe to have? ");
		
		Money Ludwig = new Money(value1, value2);// Creates Money objects
		Money Daniel = new Money(value3, value4);
		Money Gabe = new Money(value5, value6);
		while(selection != 7) //Keeps running till exit
		{
			System.out.println("\nWelcome to my menu. Please select from the following options: \n");
			System.out.println("		1. (Test Adding) \n");
			System.out.println("		2. (Test Subtracting) \n");
			System.out.println("		3. (Test Multiply) \n");
			System.out.println("		4. (Test toString) \n");
			System.out.println("		5. (Test getDollars) \n");
			System.out.println("		6. (Test getCents) \n");
			System.out.println("		7. Exit");
			selection = reader.readInt("Enter your selection (1-7): ");
			System.out.println("\n");
			switch(selection)
			{
				case 1:	
						Money Dragon = Ludwig.add(Daniel);
						Dragon.print();
						Money Lizard = Ludwig.add(100, 100);
						Lizard.print();
						break;
				case 2:
						Money Dragon2 = Daniel.subtract(Ludwig);
						Dragon2.print();
						Money Lizard2 = Daniel.subtract(200, 200);
						Lizard2.print();
						break;
				case 3:
						Money Dragon3 = Gabe.multiply(2);
						Dragon3.print();
						break;
				case 4:
						System.out.println(Ludwig);
						break;
				case 5:
						System.out.println(Ludwig.getDollars());
						break;
				case 6:
						System.out.println(Ludwig.getCents());
						break;
				case 7:
						System.out.println("Have a nice day!");
						System.exit(0);//Ends program
				default:
					System.out.println("Invalid input, please try again!"); break;
			}
		
		}
	}
}






