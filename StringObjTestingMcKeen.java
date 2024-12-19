//McKeen -- APCS
//StringObjTestingMcKeen
//Automated testing of the String Project -- Good times and SO MUCH BONUS available

/* IMPORTANT BONUS INFORMATION:
 * Make sure you remove both the /* AND the corresponding */  
/* In order to test isPalindromeBONUS, you must uncomment 
 * the block of code following:  
 *		else if(program == 4)
 * In order to test WordCountBONUS, you must uncomment 
 * the block of code following:  
 *		else if(program == 5)
 * In order to test displayAnalyisBONUS, you must uncomment 
 * the block of code following:  
 *		else if(program == 6)
*/ 

public class StringObjTestingMcKeen
{
	public static void main(String[]args)
	{
		KeyboardReader reader = new KeyboardReader();
		
		int prog, caseNum;
		StringObj s1, s2;
		String st1, search;
		do
		{
			System.out.println("\n#############################################");
			System.out.println("\nWelcome to the String Project test cases.");
			System.out.println("What Test Case # do you want to run?\n\n"+
									"1. areAlphabetized Testing\n"+
									"2. isPalindrome Testing\n"+
									"3. wordCount Testing\n\n"+
									"4. isPalindromeBONUS Testing -- must be uncommented\n"+
									"5. wordCountBONUS Testing -- must be uncommented\n"+
									"6. displayAnalysisBONUS() Testing -- must be uncommented\n" +
									"7. Exit\n");
			System.out.println("#############################################");
			prog = reader.readInt("Please select a testing option: ");
									
			if(prog == 1)  //areAlphabetized
			{
				caseNum = 1;
				System.out.println("\n\n\n\nareAlphabetized -- Case # " + caseNum);
				s1 = new StringObj("dog");
				s2 = new StringObj("cat");
				System.out.println(s1 + " comes before " + s2 + " -- \n\nSTUDENT ANSWER: " + s1.areAlphabetized(s2));   // should display true
				System.out.println("\n\t\nCORRECT ANSWER:  false"); 
				System.out.println("\nIf the answers match, give 1/2 point for case #" + caseNum); 
				reader.pause();
				
				caseNum= 2;
				System.out.println("\n\n\n\nareAlphabetized -- Case # " + caseNum);
				s1 = new StringObj("dog");
				s2 = new StringObj("CAT");
				System.out.println(s1 + " comes before " + s2 + " -- \n\nSTUDENT ANSWER: " + s1.areAlphabetized(s2));   // should display true
				System.out.println("\n\t\nCORRECT ANSWER:  false"); 
				System.out.println("\nIf the answers match, give 1/2 point for case #" + caseNum); 
				reader.pause();

				caseNum = 3;
				System.out.println("\n\n\n\nareAlphabetized -- Case # " + caseNum);
				s1 = new StringObj("doglike");
				s2 = new StringObj("DoG");
				System.out.println(s1 + " comes before " + s2 + " -- \n\nSTUDENT ANSWER: " + s1.areAlphabetized(s2));   // should display true
				System.out.println("\n\t\nCORRECT ANSWER:  false"); 
				System.out.println("\nIf the answers match, give 1/2 point for case #" + caseNum); 
				reader.pause();

				caseNum=4;
				System.out.println("\n\n\n\nareAlphabetized -- Case # " + caseNum);
				s1 = new StringObj("cat");
				s2 = new StringObj("cat");
				System.out.println(s1 + " comes before " + s2 + " -- \n\nSTUDENT ANSWER: " + s1.areAlphabetized(s2));   // should display true
				System.out.println("\n\t\nCORRECT ANSWER:  true"); 
				System.out.println("\nIf the answers match, give 1/2 point for case #" + caseNum); 
				reader.pause();
				
				caseNum=5;
				System.out.println("\n\n\n\nareAlphabetized -- Case # " + caseNum);
				System.out.println("\nIf no points have been missed in areAlphabetized,");
				System.out.println("give 1 point for case #" + caseNum); 
				reader.pause();
			}
			else if (prog == 2)  //isPalindrome
			{
				caseNum = 1;
				System.out.println("\n\n\n\nisPalindrome -- Case # " + caseNum);
				s1 = new StringObj("maam");
				System.out.println(s1 + " is a palindrome -- \n\nSTUDENT ANSWER: " + s1.isPalindrome());   // should display true
				System.out.println("\nCORRECT ANSWER:  true"); 
				System.out.println("\nIf the answers match, give 1 point for case #" + caseNum); 
				reader.pause();

				caseNum=2;
				System.out.println("\n\n\n\nisPalindrome -- Case # " + caseNum);
				s1 = new StringObj("amana");
				System.out.println(s1 + " is a palindrome -- \n\nSTUDENT ANSWER: " + s1.isPalindrome());   // should display true
				System.out.println("\nCORRECT ANSWER:  false"); 
				System.out.println("\nIf the answers match, give 1 point for case #" + caseNum); 
				reader.pause();

				caseNum=3;
				System.out.println("\n\n\n\nisPalindrome -- Case # " + caseNum);
				s1 = new StringObj("racecar");
				System.out.println(s1 + " is a palindrome -- \n\nSTUDENT ANSWER: " + s1.isPalindrome());   // should display true
				System.out.println("\nCORRECT ANSWER:  true"); 
				System.out.println("\nIf the answers match, give 1 point for case #" + caseNum); 
				reader.pause();

				caseNum=4;
				System.out.println("\n\n\n\nisPalindrome -- Case # " + caseNum);
				s1 = new StringObj("moon");
				System.out.println(s1 + " is a palindrome -- \n\nSTUDENT ANSWER: " + s1.isPalindrome());   // should display true
				System.out.println("\nCORRECT ANSWER:  false"); 
				System.out.println("\nIf the answers match, give 1 point for case #" + caseNum); 
				reader.pause();

				caseNum=5;
				System.out.println("\n\n\n\nisPalindrome -- Case # " + caseNum);
				s1 = new StringObj("amanaplanacanalpanama");
				System.out.println(s1 + " is a palindrome -- \n\nSTUDENT ANSWER: " + s1.isPalindrome());   // should display true
				System.out.println("\nCORRECT ANSWER:  true"); 
				System.out.println("\nIf the answers match, give 1 point for case #" + caseNum); 
				reader.pause();
				
				caseNum=6;
				System.out.println("\n\n\n\nisPalindrome -- Case # " + caseNum);
				System.out.println("\nIf no points have been missed in isPalindrome,");
				System.out.println("give 2 points for case #" + caseNum); 
				reader.pause();
			}
			else if(prog == 3)   //wordCount testing
			{
				//Case 1//////////////////////////////////////////////////////////////////////
				caseNum = 1;
				System.out.println("\n\n\n\nwordCount -- Case # " + caseNum);
				st1 = "Ryan cat cat Ryan.";
				s1 = new StringObj(st1);
				search = "cat";
				System.out.println("The number of times that \"" + search + "\" appears in \"" 
						+ s1 + "\" -- \n\nSTUDENT ANSWER: " + s1.wordCount(search)); 
				System.out.println("\nCORRECT ANSWER:  2"); 
				System.out.println("\nIf the answers match, give 2 points for case #" + caseNum+"a"); 
				reader.pause();
				System.out.println("\nNumber of vowels -- \nSTUDENT ANSWER: " + s1.getNumVowels());
				System.out.println("\nCORRECT ANSWER:  4"); 
				System.out.println("\nIf the answers match, give 1 more point for case #" + caseNum+"b"); 
				reader.pause();

				//Case 2//////////////////////////////////////////////////////////////////////
				caseNum = 2;
				System.out.println("\n\n\n\n\n\nwordCount -- Case # " + caseNum);
				st1 = "CAT dog.";
				s1 = new StringObj(st1);
				search = "cat";
				System.out.println("The number of times that \"" + search + "\" appears in \"" 
						+ s1 + "\" -- \n\nSTUDENT ANSWER: " + s1.wordCount(search)); 
				System.out.println("\nCORRECT ANSWER:  1"); 
				System.out.println("\nIf the answers match, give 1 point for case #" + caseNum+"a"); 
				reader.pause();
				System.out.println("\nNumber of vowels -- \nSTUDENT ANSWER: " + s1.getNumVowels());
				System.out.println("\nCORRECT ANSWER:  2"); 
				System.out.println("\nIf the answers match, give 1 more point for case #" + caseNum+"b"); 
				reader.pause();

				//Case 3//////////////////////////////////////////////////////////////////////
				caseNum=3;
				System.out.println("\n\n\n\n\n\nwordCount -- Case # " + caseNum);
				st1 = "Dog cat.";
				s1 = new StringObj(st1);
				search = "cat";
				System.out.println("The number of times that \"" + search + "\" appears in \"" 
						+ s1 + "\" -- \n\nSTUDENT ANSWER: " + s1.wordCount(search)); 
				System.out.println("\nCORRECT ANSWER:  1"); 
				System.out.println("\nIf the answers match, give 1 point for case #" + caseNum); 
				reader.pause();

				//Case 4//////////////////////////////////////////////////////////////////////
				caseNum=4;
				System.out.println("\n\n\n\n\n\nwordCount -- Case # " + caseNum);
				st1 = "Cattle scat dog catatonic dog scat.";
				s1 = new StringObj(st1);
				search = "cat";
				System.out.println("The number of times that \"" + search + "\" appears in \"" 
						+ s1 + "\" -- \n\nSTUDENT ANSWER: " + s1.wordCount(search)); 
				System.out.println("\nCORRECT ANSWER:  0"); 
				System.out.println("\nIf the answers match, give 1 point for case #" + caseNum); 
				reader.pause();

				//Case 5//////////////////////////////////////////////////////////////////////
				caseNum=5;
				System.out.println("\n\n\n\n\n\nwordCount -- Case # " + caseNum);
				st1 = "Cat cut catatonic cat cat catcatcat.";
				s1 = new StringObj(st1);
				search = "cat";
				System.out.println("The number of times that \"" + search + "\" appears in \"" 
						+ s1 + "\" -- \n\nSTUDENT ANSWER: " + s1.wordCount(search)); 
				System.out.println("\nCORRECT ANSWER:  3"); 
				System.out.println("\nIf the answers match, give 2 points for case #" + caseNum); 
				reader.pause();

				//Case 6//////////////////////////////////////////////////////////////////////
				caseNum=6;
				System.out.println("\n\n\n\n\n\nwordCount -- Case # " + caseNum);
				st1 = "Dog faced Dogbert ran doggedly into the dog house to study endogamous dogma.";
				s1 = new StringObj(st1);
				search = "DOG";
				System.out.println("The number of times that \"" + search + "\" appears in \"" 
						+ s1 + "\" -- \n\nSTUDENT ANSWER: " + s1.wordCount(search)); 
				System.out.println("\nCORRECT ANSWER:  2"); 
				System.out.println("\nIf the answers match, give 1 point for case #" + caseNum+"a"); 
				reader.pause();
				System.out.println("\nNumber of vowels -- \nSTUDENT ANSWER: " + s1.getNumVowels());
				System.out.println("\nCORRECT ANSWER:  24"); 
				System.out.println("\nIf the answers match, give 1 more point for case #" + caseNum+"b"); 
				reader.pause();
				System.out.println("\ntoString -- \nSTUDENT ANSWER: ###" + s1+"###");
				System.out.println("\nCORRECT ANSWER: ###Dog faced Dogbert ran doggedly into the dog house to study endogamous dogma.###"); 
				System.out.println("\nBoth sentences are TOTALLY identical: capitalization, spacing, punctuation, etc."); 
				System.out.println("\nIf the answers match, give 1 more point for case #" + caseNum+"c"); 
				reader.pause();

				//Case 7//////////////////////////////////////////////////////////////////////
				caseNum=7;
				System.out.println("\n\n\n\n\n\nwordCount -- Case # " + caseNum);
				st1 = "Wait.";
				s1 = new StringObj(st1);
				search = "wait";
				System.out.println("The number of times that \"" + search + "\" appears in \"" 
						+ s1 + "\" -- \n\nSTUDENT ANSWER: " + s1.wordCount(search)); 
				System.out.println("\nCORRECT ANSWER:  1"); 
				System.out.println("\nIf the answers match, give 1 point for case #" + caseNum); 
				reader.pause();
				
				//Case 8///////////////////////////////////Thanks Larry///////////////////////////////////
				caseNum=8;
				System.out.println("\n\n\n\n\n\nwordCount -- Case # " + caseNum);
				st1 = "A dog a cat a.";
				s1 = new StringObj(st1);
				search = "A";
				System.out.println("The number of times that \"" + search + "\" appears in \"" 
						+ s1 + "\" -- \n\nSTUDENT ANSWER: " + s1.wordCount(search)); 
				System.out.println("\nCORRECT ANSWER:  3"); 
				System.out.println("\nIf the answers match, give 1 point for case #" + caseNum); 
				reader.pause();

				//Case 9//////////////////////////////////////////////////////////////////////
				caseNum=9;
				System.out.println("\n\n\n\nwordCount -- Case # " + caseNum);
				System.out.println("\nIf no points have been missed in wordCount,");
				System.out.println("give 1 point for case #" + caseNum); 
				reader.pause();

			}
			//######################################################
			else if(prog == 4) //isPalindromeBONUS testing
			{
				caseNum = 1;
				System.out.println("\n\n\n\nisPalindromeBONUS -- Case # " + caseNum);
				s1 = new StringObj("A man, a plan, a canal, panama.");
				System.out.println(s1 + " is a palindrome -- \n\nSTUDENT ANSWER: " + s1.isPalindromeBONUS());   // should display true
				System.out.println("\nCORRECT ANSWER:  true"); 
				System.out.println("\nIf the answers match, check the box for case #" + caseNum); 
				reader.pause();

				caseNum++;
				System.out.println("\n\n\n\nisPalindromeBONUS -- Case # " + caseNum);
				s1 = new StringObj("Madam, I'm Adam.");
				System.out.println(s1 + " is a palindrome -- \n\nSTUDENT ANSWER: " + s1.isPalindromeBONUS());   // should display true
				System.out.println("\nCORRECT ANSWER:  true"); 
				System.out.println("\nIf the answers match, check the box for case #" + caseNum); 
				reader.pause();
				
				caseNum++;
				System.out.println("\n\n\n\nisPalindromeBONUS -- Case # " + caseNum);
				s1 = new StringObj("ab.");
				System.out.println(s1 + " is a palindrome -- \nSTUDENT ANSWER: " + s1.isPalindromeBONUS());   // should display true
				System.out.println("\nCORRECT ANSWER:  false"); 
				System.out.println("\nIf the answers match, check the box for case #" + caseNum); 
				reader.pause();
			}

			//######################################################
			else if(prog == 5) //wordCountBONUS testing
			{
				caseNum = 1;
				System.out.println("\n\n\n\nwordCountBONUS -- Case # " + caseNum);
				st1 = "Cat cat catatonic cat cat catcatcat.";
				s1 = new StringObj(st1);
				search = "cat";
				System.out.println("The number of times that \"" + search + "\" appears in \"" 
						+ s1 + "\" -- \n\nSTUDENT ANSWER: " + s1.wordCountBONUS(search)); 
				System.out.println("\nCORRECT ANSWER:  8"); 
				System.out.println("\nIf the answers match, check the box for case #" + caseNum); 
				reader.pause();

				caseNum++;
				System.out.println("\n\n\n\nwordCountBONUS -- Case # " + caseNum);
				st1 = "Dog faced Dogbert ran doggedly into the dog house to study endogamous dogma.";
				s1 = new StringObj(st1);
				search = "DOG";
				System.out.println("The number of times that \"" + search + "\" appears in \"" 
						+ s1 + "\" -- \nSTUDENT ANSWER: " + s1.wordCountBONUS(search)); 
				System.out.println("\nCORRECT ANSWER:  6"); 
				System.out.println("\nIf the answers match, check the box for case #" + caseNum); 
				reader.pause();
			}

			//######################################################
/*			else if(prog == 6) //displayAnalysis() Testing 
			{
				caseNum = 1;
				System.out.println("\n\n\n\ndisplayAnalysisBONUS -- Case # " + caseNum);
				st1 = "The quick brown fox jumped over the lazy sleeping dog.";
				s1 = new StringObj(st1);
				System.out.println("Confirm that the analysis information is correct for the following sentence:");
				System.out.println("\n\n" + st1 + "\n\n");
				s1.displayAnalysisBONUS(); 
				reader.pause();

			}
*/
		}while(prog !=7);
		
		System.out.println("\n\n\nGoodbye!  I hope that you have a pleasant day and an enjoyable life.");
	}
}