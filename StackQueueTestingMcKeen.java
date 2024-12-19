//StackQueueTestingMcKeen
//McKeen
//Runner to test StackQueueTester and RingBuffer


public class StackQueueTestingMcKeen
{
	// FOR TESTING PURPOSES:  pass in an array of Strings
	// return a QueueList of Strings
	private static QueueList<String> createQ(String[] s)
	{
		QueueList <String> q = new QueueList<String>();
		for (String e: s)
			q.add(e);
		return q;		
	}

	// FOR TESTING PURPOSES:  pass in an array of Strings
	// return a StackList of Strings
	private static StackList<String> createS(String[] s)
	{
		StackList <String> sl = new StackList<String>();
		for (String e: s)
			sl.push(e);
		return sl;		
	}	
		
	// FOR TESTING PURPOSES:  When passed an array of strings, it 
	// displays correct answer separated by spaces
	public static void displayAnswer(String[] s)
	{
			for (int i = 0; i < s.length; i++)
			{
				System.out.print(s[i]);
				if (i < s.length-1)
					System.out.print(" ");
			}
	}
	
	// Main testing method
	// You must UNCOMMENT the findDuplicates method to test it
	public static void main(String[] args)
	{
		KeyboardReader reader = new KeyboardReader();
		char letter;
		int selection = 0;
		int step=1, testCaseNum=1;

		
		StackQueueTester t = new StackQueueTester();
		QueueList<String> q = new QueueList<String>();
		StackList <String> s = new StackList<String>();
		
		System.out.println("");
		do
		{			
			System.out.println("\nWelcome to the Stack and Queue Testing Options"+
			"\n1.) removeName"+
			"\n2.) stackSearch"+
			"\n3.) splitString"+
			"\n4.) longestWords"+
			"\n5.) findDuplicates (BONUS) - must be UNCOMMENTED"+
			"\n6.) RingBuffer methods"+
			"\n0.) Exit");
			selection = reader.readInt("Enter a selection: ");

////////////////////////////////////////////////////////////////////////////////////////////////
/////////////// Testing removeName  ////////////////////////////////////////////////////////////			

			if (selection == 1)
			{

				System.out.println("removeName Test Cases");

				//1 beginning
				testCaseNum = 1;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String[] s1 = {"a","b","c","d","e","f"};
				String[] c1 = {"b","c","d","e","f"};
				q = createQ(s1);
				
				t.removeName(q, "a");
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println(t.stringDump(q));
				System.out.println("\nCORRECT ANSWER:");
				displayAnswer(c1);
				System.out.println("\n");
							
				reader.pause();

				//2 middle duplicates
				testCaseNum++;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);
				
				String[] s2 = {"a","b","c","c", "d","e","f"};
				String[] c2 = {"a", "b","d","e","f"};
				q = createQ(s2);
				
				t.removeName(q, "c");
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println(t.stringDump(q));
				System.out.println("\nCORRECT ANSWER:");
				displayAnswer(c2);
				System.out.println("\n");
				
				reader.pause();

				//3 end
				testCaseNum++;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);
				
				String[] s3 = {"a","b","c","d","e","f"};
				String[] c3 = {"a", "b","c","d","e"};
				q = createQ(s3);
				
				t.removeName(q, "f");
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println(t.stringDump(q));
				System.out.println("\nCORRECT ANSWER:");
				displayAnswer(c3);
				System.out.println("\n");
				
				reader.pause();	
								
				//4  not found
				testCaseNum++;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);
				
				String[] s4 = {"a","b","c","d","e","f"};
				String[] c4 = {"a","b","c","d","e","f"};
				q = createQ(s4);
				
				t.removeName(q, "g");
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println(t.stringDump(q));
				System.out.println("\nCORRECT ANSWER:");
				displayAnswer(c4);
				System.out.println("\n");
				
				reader.pause();			

				//5   empty
				testCaseNum++;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);
				
				String[] s5 = {};
				String[] c5 = {};
				q = createQ(s5);
				
				t.removeName(q, "g");
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println(t.stringDump(q));
				System.out.println("\nCORRECT ANSWER:");
				displayAnswer(c5);
				System.out.println("\n");
				
				reader.pause();
			}
////////////////////////////////////////////////////////////////////////////////////////////////
/////////////// Testing stackSearch  ////////////////////////////////////////////////////////////			

			if (selection == 2)
			{
				System.out.println("stackSearch Test Cases");

				boolean answer;
				
				//1 finds in beginning
				testCaseNum = 1;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String[] s1 = {"h","i","j","k","l","m"};
				String[] c1 = {"m","l","k","j","i","h"};
				s = createS(s1);
				
				answer = t.stackSearch(s, "h");
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println(answer + " " + t.stringDump(s));
				System.out.println("\nCORRECT ANSWER:");
				System.out.print("true ");
				displayAnswer(c1);
				System.out.println("\n");
				
				reader.pause();
				
				//2 finds at end
				testCaseNum++;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String[] s2 = {"h","i","j","k","l","m"};
				String[] c2 = {"m","l","k","j","i","h"};
				s = createS(s2);
				
				answer = t.stackSearch(s, "m");
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println(answer + " " + t.stringDump(s));
				System.out.println("\nCORRECT ANSWER:");
				System.out.print("true ");
				displayAnswer(c2);
				System.out.println("\n");
				
				reader.pause();				
				
				//3 doesn't find it in a populated stack
				testCaseNum++;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String[] s3 = {"h","i","j","k","l","m"};
				String[] c3 = {"m","l","k","j","i","h"};
				s = createS(s3);
				
				answer = t.stackSearch(s, "z");
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println(answer + " " + t.stringDump(s));
				System.out.println("\nCORRECT ANSWER:");
				System.out.print("false ");
				displayAnswer(c3);
				System.out.println("\n");
				
				reader.pause();	
					
				//4 doesn't find in an empty stack
				testCaseNum++;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String[] s4 = {};
				s = createS(s4);
				
				answer = t.stackSearch(s, "z");
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println(answer + " " + t.stringDump(s));
				System.out.println("\nCORRECT ANSWER:");
				System.out.print("false ");
				displayAnswer(s4);
				System.out.println("\n");
				
				reader.pause();						
									
			}
////////////////////////////////////////////////////////////////////////////////////////////////
/////////////// Testing splitString  ////////////////////////////////////////////////////////////			

			if (selection == 3)
			{

				System.out.println("splitString Test Cases");

				//1 Normal sentence
				testCaseNum = 1;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String s1 = "The quick brown fox jumped over the lazy red dog.";
				String[] c1 = {"The","quick","brown","fox","jumped", "over", "the", "lazy", "red", "dog"};

				
				q = t.splitString(s1);
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println(t.stringDump(q));
				System.out.println("\nCORRECT ANSWER:");
				displayAnswer(c1);
				System.out.println("\n");
				
				reader.pause();

				//2 Two word sentence
				testCaseNum++;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);
				System.out.println("This case makes sure there are no extra spaces before/after the words.");

				String s2 = "Fall down.";
				String[] c2 = {"Fall","down"};

				
				q = t.splitString(s2);
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println("$$"+t.stringDump(q)+"$$");
				System.out.println("\nCORRECT ANSWER:");
				System.out.print("$$");
				displayAnswer(c2);
				System.out.print("$$");
				System.out.println("\n");
				
				reader.pause();			

				//3 One word sentence
				testCaseNum++;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String s3 = "Wait.";
				String[] c3 = {"Wait"};

				
				q = t.splitString(s3);
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println(t.stringDump(q));
				System.out.println("\nCORRECT ANSWER:");
				displayAnswer(c3);
				System.out.println("\n");
				
				reader.pause();			

			}
	
////////////////////////////////////////////////////////////////////////////////////////////////
/////////////// Testing longestWords  ////////////////////////////////////////////////////////////			

			if (selection == 4)
			{

				System.out.println("longestWords Test Cases");

				String answer;
				QueueList<String> qa;
				
				//1 longest word first
				testCaseNum = 1;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String[] s1 = {"aaaaaa","b","cc","ddd","eeee","fffff"};
				String c1 = "aaaaaa";

				
				q = createQ(s1);
				
				qa = t.longestWords(q);
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println("Longest Word(s): " + t.stringDump(qa));
				System.out.println("Queue: " + t.stringDump(q));
				
				System.out.println("\nCORRECT ANSWER:");
				System.out.println("Longest Word(s): " + c1);
				System.out.print("Queue: ");
				displayAnswer(s1);
				System.out.println("\n");
				
				reader.pause();

				//2 longest word last
				testCaseNum = 2;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String[] s2 = {"aaaaaa","b","cc","ddd","eeee","fffffff"};
				String c2 = "fffffff";

				
				q = createQ(s2);
				
				qa = t.longestWords(q);
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println("Longest Word(s): " + t.stringDump(qa));
				System.out.println("Queue: " + t.stringDump(q));
				
				System.out.println("\nCORRECT ANSWER:");
				System.out.println("Longest Word(s): " + c2);
				System.out.print("Queue: ");
				displayAnswer(s2);
				System.out.println("\n");
				
				reader.pause();

				//3 longest word first and last
				testCaseNum = 3;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String[] s3 = {"aaaaaa","b","cc","ddd","eeee","ffffff"};
				String c3 = "aaaaaa ffffff";

				
				q = createQ(s3);
				
				qa = t.longestWords(q);
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println("Longest Word(s): " + t.stringDump(qa));
				System.out.println("Queue: " + t.stringDump(q));
				
				System.out.println("\nCORRECT ANSWER:");
				System.out.println("Longest Word(s): " + c3 + "          (order does not matter)");
				System.out.print("Queue: ");
				displayAnswer(s3);
				System.out.println("\n");
				
				reader.pause();

				//4 all longest words
				testCaseNum = 4;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String[] s4 = {"a","b","c","d","e","f"};
				String c4 = "a b c d e f";

				
				q = createQ(s4);
				
				qa = t.longestWords(q);
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println("Longest Word(s): " + t.stringDump(qa));
				System.out.println("Queue: " + t.stringDump(q));
				
				System.out.println("\nCORRECT ANSWER:");
				System.out.println("Longest Word(s): " + c4 + "          (order does not matter)");
				System.out.print("Queue: ");
				displayAnswer(s4);
				System.out.println("\n");
				
				reader.pause();

				//5 only one word
				testCaseNum = 5;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String[] s5 = {"bobalu"};
				String c5 = "bobalu";

				
				q = createQ(s5);
				
				qa = t.longestWords(q);
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println("Longest Word(s): " + t.stringDump(qa));
				System.out.println("Queue: " + t.stringDump(q));
				
				System.out.println("\nCORRECT ANSWER:");
				System.out.println("Longest Word(s): " + c5);
				System.out.print("Queue: ");
				displayAnswer(s5);
				System.out.println("\n");
				
				reader.pause();

				//6 empty Queue - dirty
				testCaseNum = 6;
				System.out.println("\n\n\nTEST CASE #" + testCaseNum);

				String[] s6 = {""};
				String c6 = "";

				
				q = createQ(s6);
				
				qa = t.longestWords(q);
				
				System.out.println("\nSTUDENT ANSWER:");
				System.out.println("Longest Word(s): " + t.stringDump(qa));
				System.out.println("Queue: " + t.stringDump(q));
				
				System.out.println("\nCORRECT ANSWER:");
				System.out.println("Longest Word(s): " + c6);
				System.out.print("Queue: ");
				displayAnswer(s6);
				System.out.println("\n");
				
				reader.pause();		
			}	
				
////////////////////////////////////////////////////////////////////////////////////////////////
/////////////// Testing findDuplicates BONUS  ////////////////////////////////////////////////////////////			

////// MUST BE UNCOMMENTED TO TEST THE BONUS
///////////////////////////////////////
//			if (selection == 5)
//			{
//				
//				StackList <String> ans;
//
//				System.out.println("findDuplicates BONUS Test Cases");
//
//				//1 beginning and end - one duplicate
//				testCaseNum = 1;
//				System.out.println("\n\n\nTEST CASE #" + testCaseNum);
//
//				String[] s1 = {"a","b","c","d","e","f"};
//				String[] q1 = {"g","h","i","j","k","a"};
//				String[] c1 = {"a"};
//				String[] sc1 = {"f","e","d","c","b","a"};
//				q = createQ(q1);
//				s = createS(s1);
//					
//				ans = t.findDuplicates(s, q);
//
//				
//				System.out.println("\nSTUDENT ANSWER:");
//				System.out.println("Duplicate words: " + t.stringDump(ans));
//				System.out.println(t.stringDump(q));
//				System.out.println(t.stringDump(s));
//				
//				
//				System.out.println("\nCORRECT ANSWER:");
//				System.out.print("Duplicate words: ");
//				displayAnswer(c1);
//				System.out.println();
//				displayAnswer(q1);
//				System.out.println();				
//				displayAnswer(sc1);
//				System.out.println();
//
//				
//				reader.pause();
//
//				//2  2 last same as 2 first
//				testCaseNum = 2;
//				System.out.println("\n\n\nTEST CASE #" + testCaseNum);
//
//				String[] s2 = {"a","b","c","d","e","f", "g"};
//				String[] q2 = {"f", "g","g", "h","i","j"};
//				String[] c2 = {"f", "g"};
//				String[] sc2 = {"g", "f","e","d","c","b","a"};
//				q = createQ(q2);
//				s = createS(s2);
//					
//				ans = t.findDuplicates(s, q);
//
//				
//				System.out.println("\nSTUDENT ANSWER:");
//				System.out.println("Duplicate words: " + t.stringDump(ans) + "\t\t(order does not matter)");
//				System.out.println(t.stringDump(q));
//				System.out.println(t.stringDump(s));
//				
//				
//				System.out.println("\nCORRECT ANSWER:");
//				System.out.print("Duplicate words: ");
//				displayAnswer(c2);
//				System.out.println();
//				displayAnswer(q2);
//				System.out.println();
//				displayAnswer(sc2);
//				System.out.println();
//
//				
//				reader.pause();
//
//
//				//3 all words same
//				testCaseNum = 3;
//				System.out.println("\n\n\nTEST CASE #" + testCaseNum);
//
//				String[] s3 = {"z","z","z","z","z","z","z"};
//				String[] q3 = {"z", "z","z", "z","z","z"};
//				String[] c3 = {"z"};
//				q = createQ(q3);
//				s = createS(s3);
//					
//				ans = t.findDuplicates(s, q);
//
//				
//				System.out.println("\nSTUDENT ANSWER:");
//				System.out.println("Duplicate words: " + t.stringDump(ans) + "\t\t(order does not matter)");
//				System.out.println(t.stringDump(q));
//				System.out.println(t.stringDump(s));
//				
//				
//				System.out.println("\nCORRECT ANSWER:");
//				System.out.print("Duplicate words: ");
//				displayAnswer(c3);
//				System.out.println();
//				displayAnswer(q3);
//				System.out.println();
//				displayAnswer(s3);
//				System.out.println();
//
//				
//				reader.pause();
//
//				//4 all words same but 1
//				testCaseNum = 4;
//				System.out.println("\n\n\nTEST CASE #" + testCaseNum);
//
//				String[] s4 = {"b","z","z","z","z","z","z", "z"};
//				String[] q4 = {"z", "z","z", "z","z","z","a"};
//				String[] c4 = {"z"};
//				String[] sc4 = {"z","z","z","z","z","z","z","b"};
//				q = createQ(q4);
//				s = createS(s4);
//					
//				ans = t.findDuplicates(s, q);
//
//				
//				System.out.println("\nSTUDENT ANSWER:");
//				System.out.println("Duplicate words: " + t.stringDump(ans) + "\t\t(order does not matter)");
//				System.out.println(t.stringDump(q));
//				System.out.println(t.stringDump(s));
//				
//				
//				System.out.println("\nCORRECT ANSWER:");
//				System.out.print("Duplicate words: ");
//				displayAnswer(c4);
//				System.out.println();
//				displayAnswer(q4);
//				System.out.println();
//				displayAnswer(sc4);
//				System.out.println();
//
//				
//				reader.pause();
//
//			}					


////////////////////////////////////////////////////////////////////////////////////////////////
/////////////// Testing RingBuffer  ////////////////////////////////////////////////////////////							
			if (selection == 6)
			{
				RingBuffer rb = new RingBuffer(3);
				step = 1;
				
				//1
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("\nResult from peek, getFront, getRear, and isEmpty:");
				System.out.println( "\n\tgetFront = "+ rb.getFront() + "\t\tCORRECT getFront = 0");
				System.out.println( "\n\tgetRear = "+ rb.getRear()+ "\t\tCORRECT getRear = 0");
				System.out.println( "\n\tisEmpty = "+ rb.isEmpty()+ "\t\tCORRECT isEmpty = true");
				System.out.println( "\n\tpeek = "+ rb.peek()+ "\t\tCORRECT peek = !");
				reader.pause();
				step++;
				
				//2
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("Result from add a, b, and c");
				System.out.println("\tadd = "+ rb.add('a')+ "\t\tCORRECT add = true");
				System.out.println("\tadd = "+ rb.add('b')+ "\t\tCORRECT add = true");
				System.out.println("\tadd = "+ rb.add('c')+ "\t\tCORRECT add = true");
				reader.pause();
				step++;
				
				//3
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("\nResult from peek, getFront, getRear, and isEmpty:");
				System.out.println( "\n\tgetFront = "+ rb.getFront()+ "\t\tCORRECT getFront = 0");
				System.out.println( "\n\tgetRear = "+ rb.getRear()+ "\t\tCORRECT getRear = 3");
				System.out.println( "\n\tisEmpty = "+ rb.isEmpty()+ "\t\tCORRECT isEmpty = false");
				System.out.println( "\n\tpeek = "+ rb.peek()+ "\t\tCORRECT peek = a");
				reader.pause();
				step++;
				
				//4
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("Result from add d");
				System.out.println("\tadd = "+ rb.add('d')+ "\t\tCORRECT add = false");
				reader.pause();
				step++;
				
				
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("Result from remove");
				System.out.println("\tremove = "+ rb.remove()+ "\t\tCORRECT remove = a");
				reader.pause();
				step++;
				
				//6
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("\nResult from peek, getFront, getRear, and isEmpty:");
				System.out.println( "\n\tgetFront = "+ rb.getFront()+ "\t\tCORRECT getFront = 1");
				System.out.println( "\n\tgetRear = "+ rb.getRear()+ "\t\tCORRECT getRear = 3");
				System.out.println( "\n\tisEmpty = "+ rb.isEmpty()+ "\t\tCORRECT isEmpty = false");
				System.out.println( "\n\tpeek = "+ rb.peek()+ "\t\tCORRECT peek = b");
				reader.pause();
				step++;
				
				//7
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("Result from add d");
				System.out.println("\tadd = "+ rb.add('d')+ "\t\tCORRECT add = true");
				reader.pause();
				step++;
				
				//8
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("\nResult from peek, getFront, getRear, and isEmpty:");
				System.out.println( "\n\tgetFront = "+ rb.getFront()+ "\t\tCORRECT getFront = 1");
				System.out.println( "\n\tgetRear = "+ rb.getRear()+ "\t\tCORRECT getRear = 0");
				System.out.println( "\n\tisEmpty = "+ rb.isEmpty()+ "\t\tCORRECT isEmpty = false");
				System.out.println( "\n\tpeek = "+ rb.peek()+ "\t\tCORRECT peek = b");
				reader.pause();
				step++;
				
				//9
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("Result from remove");
				System.out.println("\tremove = "+ rb.remove()+ "\t\tCORRECT remove = b");
				reader.pause();
				step++;
				
				//10
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("\nResult from peek, getFront, getRear, and isEmpty:");
				System.out.println( "\n\tgetFront = "+ rb.getFront()+ "\t\tCORRECT getFront = 2");
				System.out.println( "\n\tgetRear = "+ rb.getRear()+ "\t\tCORRECT getRear = 0");
				System.out.println( "\n\tisEmpty = "+ rb.isEmpty()+ "\t\tCORRECT isEmpty = false");
				System.out.println( "\n\tpeek = "+ rb.peek()+ "\t\tCORRECT peek = c");
				reader.pause();
				step++;
				
				//11
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("Result from add e");
				System.out.println("\tadd = "+ rb.add('e')+ "\t\tCORRECT add = true");
				reader.pause();
				step++;
				
				//12
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("\nResult from peek, getFront, getRear, and isEmpty:");
				System.out.println( "\n\tgetFront = "+ rb.getFront()+ "\t\tCORRECT getFront = 2");
				System.out.println( "\n\tgetRear = "+ rb.getRear()+ "\t\tCORRECT getRear = 1");
				System.out.println( "\n\tisEmpty = "+ rb.isEmpty()+ "\t\tCORRECT isEmpty = false");
				System.out.println( "\n\tpeek = "+ rb.peek()+ "\t\tCORRECT peek = c");
				reader.pause();
				step++;
				
				//13
				System.out.println("\n\nRingBuffer SUBCASE " + step);
				System.out.println("Result from flush");
				rb.flush();
				System.out.println("\nResult from peek, getFront, getRear, and isEmpty:");
				System.out.println( "\n\tgetFront = "+ rb.getFront()+ "\t\tCORRECT getFront = any value");
				System.out.println( "\n\tgetRear = "+ rb.getRear()+ "\t\tCORRECT getRear = same value as getFront");
				System.out.println( "\n\tisEmpty = "+ rb.isEmpty()+ "\t\tCORRECT isEmpty = true");
				System.out.println( "\n\tpeek = "+ rb.peek()+ "\t\tCORRECT peek = !");
				reader.pause();
				step++;
				
			}
				
////////////////////////////////////////////////////////////////////////////////////////////////
/////////////// Testing QueueList  ////////////////////////////////////////////////////////////	
// Currently UNUSED
			if (selection == 7)
			{
				q = new QueueList<String>();
				step = 1;
				
				//1
				System.out.println("\n\nQueue SUBCASE " + step);
				System.out.println("isEmpty() = " + q.isEmpty());
				reader.pause();
				step++;
				
				System.out.println("\n\nQueue SUBCASE " + step);
				q.add("AA");
				System.out.println("add(\"AA\")");
				System.out.println("peek() = " + q.peek());
				reader.pause();
				step++;
				
				System.out.println("\n\nQueue SUBCASE " + step);
				q.add("ZZ");
				q.add("RR");
				System.out.println("add(\"ZZ\")");
				System.out.println("add(\"RR\")");
				System.out.println("peek() = " + q.peek());
				System.out.println(q.peek());
				System.out.println("isEmpty() = " + q.isEmpty());
				reader.pause();
				step++;
				
				
				System.out.println("\n\nQueue SUBCASE " + step);
				System.out.println("remove() = " + q.remove());
				System.out.println("remove() = " + q.remove());
				reader.pause();
				step++;
				
				
				System.out.println("\n\nQueue SUBCASE " + step);
				q.add("CC");
				System.out.println("add(\"CC\")");
				System.out.println("remove() = " + q.remove());
				System.out.println("remove() = " + q.remove());
				reader.pause();
				step++;
				
				System.out.println("\n\nQueue SUBCASE " + step);
				System.out.println("isEmpty() = " + q.isEmpty());
				reader.pause();
				step++;
				
		
			}
			
			
		} while (selection != 0);
		System.out.println("Mr. McKeen is so fortunate to get to teach a student like you.");
		System.out.println("Thank you for taking APCS!");
		System.out.println("Please encourage other students to take it too!");
	}

	
	

}