// StackQueueTester.java
// Garrett Bearss
// Tests the StackList and QueueList classes

public class StackQueueTester
{
    public StackQueueTester()// Constructor of nothing
    {
    }
    
    String stringDump(QueueList <String> q)// Gets all of the Strings from the QueueList
    {
        String dump = "";
        while(!(q.isEmpty()))// While the QueueList isn't empty
        {
        	dump += q.remove();// Add each string to the sentence
        	dump += " ";
        }
        return dump;// Return the sentence
    }
    
    String stringDump(StackList <String> s)// Gets all of the Strings from the StackList
    {
        String dump = "";
        while(!(s.isEmpty()))// While the StackList isn't empty
        {
        	dump += s.pop();// Add each string to the sentence
        	dump += " ";
        }
        return dump;// Return the sentence
    }
    
    void removeName(QueueList <String> q, String name)// Removes the given string from the QueueList
    {
    	QueueList <String> temp = new QueueList();
        while(!(q.isEmpty()))// While the QueueList isn't empty
        {
        	if(q.peek().equals(name))// If you found the name, remove it
        	{
        		q.remove();
        	}
        	else// Remove it then add it to the temp QueueList
        	{
        		temp.add(q.remove());
        	}
        }
        while(!(temp.isEmpty()))// Add back the list from temp
        {
        	q.add(temp.remove());
        }
    }
    
    boolean stackSearch(StackList <String> s, String name)// Checks if the String is in the StackList
    {
       StackList <String> temp = new StackList();
       boolean value = false;
       while(!(s.isEmpty()))// While the StackList isn't empty
       {
           if(s.peek().equals(name))// If the value equals the string
           {
               if(value == false)
               {
               		value = true;
               		temp.push(s.pop());
               }
           }
           else
           {
               temp.push(s.pop());
           }
       }
       while(!(temp.isEmpty()))// Resets S
       {
       		s.push(temp.pop());
       }
       return value;
    }
    
    QueueList <String> splitString(String s)// Takes one String into a QueueList of Words
    {
       QueueList uturn = new QueueList();
       String word = "";
       for(int i = 0; i< s.length(); i++)// Goes down the length of the String
       {
       		
       		
           if(s.substring(i, i+1).equals(" "))// If the substring equals a space
           {
           	 uturn.add(word);
             word = "";
           }
           else if(s.substring(i, i+1).equals("."))// If the substring equals a period
           {
           	 uturn.add(word);
             word = "";
           }
           else// Add the substring to the word
           {
           	 word += s.substring(i, i+1);
           }
       }
       return uturn;
    }
    
    QueueList <String> longestWords(QueueList <String> q)// Finds the longest String in the QueueList
    {
        QueueList <String> uturn = new QueueList();
        QueueList <String> original = new QueueList();
        while(!(q.isEmpty()))// While the QueueList isn't empty
        {
        	if(uturn.isEmpty())// While the temp QueueList is empty
        	{
        		uturn.add(q.peek());
        		original.add(q.remove());
        	}
            else if(uturn.peek().length() < q.peek().length())// If the temp's length is smaller than the orignal's length
            {
				while(!(uturn.isEmpty()))// Remove all the values from the temp's QueueList
				{
					uturn.remove();
				}
				uturn.add(q.peek());// Adds the longest value to the QueueList
				original.add(q.remove());
            }
            else if(uturn.peek().length() == q.peek().length())// If the value is just a long as the longest current value
            {
                uturn.add(q.peek());
                original.add(q.remove());
            }
            else// Removes a String that isn't the longest
            {
            	original.add(q.remove());
            }
        }
        while(!(original.isEmpty()))// Resets Q
        {
        	q.add(original.remove());
        }
        return uturn;
    }
    
    public static void main(String[] args)
	{
		StackQueueTester mckeen = new StackQueueTester();
		QueueList <String> garrett = new QueueList();
		StackList <String> gabe = new StackList();
		RingBuffer bearss = new RingBuffer(4);
		KeyboardReader reader = new KeyboardReader();
		int selection = 0;
		while(selection != 11) //Keeps running till exit
		{
			System.out.println("\nWelcome to my menu. Please select from the following options: \n");
			System.out.println("		0. (Test stringDump (QueueList)) \n");
			System.out.println("		1. (Test stringDump (StackList)) \n");
			System.out.println("		2. (Test removeName (QueueList)) \n");
			System.out.println("		3. (Test stackSearch (StackList)) \n");
			System.out.println("		4. (Test splitString (String)) \n");
			System.out.println("		5. (Test longestwords (String)) \n");
            System.out.println("		6. (Test remove (RingBuffer)) \n");
            System.out.println("		7. (Test peek (RingBuffer)) \n");
            System.out.println("		8. (Test getFront (RingBuffer)) \n");
            System.out.println("		9. (Test getRear (RingBuffer)) \n");
            System.out.println("		10.(Test Special Cases (RingBuffer)) \n");
			System.out.println("		11. Exit");
			selection = reader.readInt("Enter your selection (1-11): ");
			System.out.println("\n");
			switch(selection)
			{
				case 0:// stringDump (QL)
						String word1 = "garrett";
						String word2 = "gabe";
						String word3 = "bailey";
						String word4 = "alexis";
						garrett.add(word1);
						garrett.add(word2);
						garrett.add(word3);
						garrett.add(word4);
						System.out.println(mckeen.stringDump(garrett));
						break;
				case 1:// stringDump (SL)
						String word5 = "garrett";
						String word6 = "gabe";
						String word7 = "bailey";
						String word8 = "alexis";
						gabe.push(word5);
						gabe.push(word6);
						gabe.push(word7);
						gabe.push(word8);
						System.out.println(mckeen.stringDump(gabe));
						break;
				case 2:// removeName (QL)
						String word9 = "garrett";
						String word10 = "gabe";
						String word11 = "bailey";
						String word12 = "alexis";
						garrett.add(word9);
						garrett.add(word10);
						garrett.add(word11);
						garrett.add(word12);
						mckeen.removeName(garrett, "garrett");
						System.out.println(mckeen.stringDump(garrett));
						break;
				case 3:// stackSearch (SL)
						String word13 = "garrett";
						String word14 = "gabe";
						String word15 = "bailey";
						String word16 = "alexis";
						gabe.push(word13);
						gabe.push(word14);
						gabe.push(word15);
						gabe.push(word16);
						System.out.println(mckeen.stackSearch(gabe, "garrett"));
						System.out.println(mckeen.stringDump(gabe));
                        break;
                case 4:// splitString (QL)
                        String word17 = "garrett gabe bailey alexis.";
                        //String word17 = "garrett.";
                        garrett = mckeen.splitString(word17);
                        System.out.println(mckeen.stringDump(garrett));
                        break;
                case 5:// longestWords (QL)
                        String word18 = "garrett";
						String word19 = "gabe";
						String word20 = "bailey";
						String word21 = "alexis";
                        String word22 = "1234567";
                        garrett.add(word18);
                        garrett.add(word19);
                        garrett.add(word20);
                        garrett.add(word21);
                        garrett.add(word22);
                        QueueList longest = (mckeen.longestWords(garrett));
                        System.out.println(mckeen.stringDump(longest));
                        System.out.println(mckeen.stringDump(garrett));
                        break;
                case 6:// remove (RBQ)
                		bearss.add('G');
                		bearss.add('A');
                		bearss.add('R');
                		bearss.add('E');
                		System.out.println(bearss.add('T'));
                		System.out.println(bearss.remove());
                        break;
                case 7:// peek (RBQ)
                        bearss.add('g');
                        bearss.add('a');
                        bearss.add('r');
                        bearss.add('e');
                        System.out.println(bearss.add('t'));
                        System.out.println(bearss.peek());
                        break;
                case 8:// getFront (RBQ)
                        bearss.getFront();
                        break;
                case 9:// getRear (RBQ)
                        bearss.getRear();
                        break;
                case 10:// Special cases RingBuffer
                		RingBuffer home = new RingBuffer(5);
                		System.out.println(home.add('g'));
                		System.out.println(home.add('g'));
                		System.out.println(home.add('g'));
                		System.out.println(home.add('g'));
                		System.out.println(home.add('g'));
                		System.out.println(home.add('g'));
                		System.out.println(home.getFront());
                		System.out.println(home.getRear());
                        RingBuffer yeet = new RingBuffer(10);
                        yeet.add('z');
                        yeet.add('z');
                        System.out.println(yeet.remove());
                        System.out.println(yeet.remove());
                        yeet.add('a');
                        yeet.add('b');
                        yeet.add('x');
                        yeet.add('y');
                        yeet.add('r');
                        yeet.add('t');
                        yeet.add('v');
                        System.out.println(yeet.getFront());
                        System.out.println(yeet.getRear());
                        while(!(yeet.isEmpty()))
                        {
                            System.out.println(yeet.remove());
                        }
                        System.out.println(yeet.getFront());
                        System.out.println(yeet.getRear());
                        System.out.println("---------------");
                        System.out.println("End Case");
                        System.out.println("---------------");
                        yeet.flush();
                        yeet.add('x');
                        yeet.add('y');
                        yeet.add('r');
                        yeet.add('t');
                        yeet.add('v');
                        yeet.add('d');
                        yeet.add('o');
                        yeet.add('g');
                        yeet.add('1');
                        yeet.add('2');
                        System.out.println("The rear before: " + yeet.getRear());
                        yeet.add('3');
                        System.out.println(yeet.getFront());
                        System.out.println("The rear after: " + yeet.getRear());
                        while(!(yeet.isEmpty()))
                        {
                            System.out.println(yeet.remove());
                        }
                        System.out.println(yeet.getFront());
                        System.out.println(yeet.getRear());
                        System.out.println("---------------");
                        System.out.println("End Case");
                        System.out.println("---------------");
                        yeet.flush();
                        RingBuffer zach = new RingBuffer(1);
                        System.out.println(zach.add('z'));
                        System.out.println(zach.add('a'));
                        System.out.println(zach.getFront());
                        System.out.println(zach.getRear());
                        System.out.println("-------------");
                        System.out.println(zach.remove());
                        System.out.println(zach.remove());
                        System.out.println(zach.remove());
                        break;
				case 11:
						System.out.println("Have a nice day!");
						System.exit(0);//Ends program
				default:
					System.out.println("Invalid input, please try again!"); 
                    break;
			}
		}
	}
	
}