// StringObjRunner.java
// Garrett Bearss
// Testing the StringObj class

public class StringObjRunner
{
	public static void main(String[] args)
	{
		KeyboardReader reader = new KeyboardReader();
		int selection = 0;
		while(selection != 8) //Keeps running till exit
		{
			System.out.println("\nWelcome to my menu. Please select from the following options: \n");
			System.out.println("		1. (Test Constructor) \n");
			System.out.println("		2. (Test Alphabetized) \n");
			System.out.println("		3. (Test Palindrome) \n");
            System.out.println("		4. (Test PalindromeBONUS) \n");
            System.out.println("		5. (Test wordCount) \n");
            System.out.println("		6. (Test wordCountBONUS) \n");
            System.out.println("		7. (Test displayAnalysisBONUS) \n");
			System.out.println("		8. Exit");
			selection = reader.readInt("Enter your selection (1-8): ");
			System.out.println("\n");
			switch(selection)
			{
				case 1:
						String str1 = "Rupert";
						StringObj s1 = new StringObj(str1);
						System.out.println(s1);
						System.out.println(s1.getNumVowels());
						break;
				case 2:
						StringObj s2 = new StringObj("apple");
						StringObj s3 = new StringObj("BOB");
						System.out.println(s2.areAlphabetized(s3));
						System.out.println(s3.areAlphabetized(s2));
						break;
				case 3:
						StringObj s4 = new StringObj("MadamImAdam");
						StringObj Garrett = new StringObj("BOB");
						StringObj Gabe = new StringObj("Gabe");
						System.out.println(s4.isPalindrome());
						System.out.println(Garrett.isPalindrome());
						System.out.println(Gabe.isPalindrome());
						break;
				case 4:
                        StringObj s5 = new StringObj("Madam, I'm Adam.");
                        StringObj s6 = new StringObj("B...O...' ,B.");
                        StringObj s7 = new StringObj("Garrett");
                        System.out.println(s5.isPalindromeBONUS());
                        System.out.println(s6.isPalindromeBONUS());
                        System.out.println(s7.isPalindromeBONUS());
						break;
				case 5:
                        String st1 = "Dog faced Dogbert ran doggedly into the dog house to study endogamous dogma.";
                        StringObj sobj1 = new StringObj(st1);
                        String search1 = "DOG";
                        System.out.println("The count is: " + sobj1.wordCount(search1));
                        String st3 = "Garrett went Garrettly toward the Garretttown into what Garrett thought was Garrett's.";
                        StringObj sobj3 = new StringObj(st3);
                        String search3 = "GARRETT";
                        System.out.println("The count is: " + sobj3.wordCount(search3));
                        String gabe = "oh love he's got a little crown love good for him but he is also just a man love and not a castle i want susano's snatched waist love.";
                        StringObj llvv = new StringObj(gabe);
                        String search5 = "love";
                        System.out.println("The count is: " + llvv.wordCount(search5));
						break;
                case 6:
                        String st2 = "Dog faced Dogbert ran doggedly into the dog house to study endogamous dogma.";
                        StringObj sobj2 = new StringObj(st2);
                        String search2 = "DOG";
                        System.out.println("The count is: " + sobj2.wordCountBONUS(search2));
                        String st4 = "Garrett went Garrettly toward the Garretttown into what Garrett thought was Garrett's.";
                        StringObj sobj4 = new StringObj(st4);
                        String search4 = "GARRETT";
                        System.out.println("The count is: " + sobj4.wordCountBONUS(search4));
                        String gabe2 = "oloveh love he's got a littllovee crown love good for him bloveut he is also just a man love and not a castlovele i want susano's snatched waist love.";
                        StringObj llvv1 = new StringObj(gabe2);
                        String search55 = "love";
                        System.out.println("The count is: " + llvv1.wordCountBONUS(search55));
						break;
				case 7: 
						String st5 = "Garrett returned home. Looking around Garrett could see this was not the home he had remembered.";
						StringObj Garrett2 = new StringObj(st5);
						//Garrett2.displayAnalysisBONUS();
						break;
				case 8:
						System.out.println("Have a nice day!");
						System.exit(0);//Ends program
				default:
					System.out.println("Invalid input, please try again!"); break;
			}
		
		}
	}
}