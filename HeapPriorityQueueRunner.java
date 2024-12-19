// Garrett Bearss
// HeapPriorityQueueRunner.java
// Runs the HeapPriorityQueue class

public class HeapPriorityQueueRunner
{
	public static void main(String[] args)
	{
		HeapPriorityQueue Tester = new HeapPriorityQueue(15);
		KeyboardReader reader = new KeyboardReader();
		int selection = -1;
		while(selection != 10) //Keeps running till exit
		{
			System.out.println("\nWelcome to my menu. Please select from the following options: \n");
			System.out.println("		0. (add) \n");
            System.out.println("		1. (isEmpty) \n");
            System.out.println("		2. (removeMax) \n");
            System.out.println("		3. (peekMax) \n");
            System.out.println("		4. (isFull) \n");
            System.out.println("		5. (getCount) \n");
            System.out.println("		6. (Pre-Built) \n");
            System.out.println("		7. (Pre-Built) \n");
            System.out.println("		8. (Remove All) \n");
            System.out.println("		9. (Print) \n");
			System.out.println("		10. Exit");
			selection = reader.readInt("Enter your selection (0-10): ");
			System.out.println("\n");
			switch(selection)
			{
				case 0:
						int thing = reader.readInt("Enter the number you want added: ");
						Tester.add(thing);
						System.out.println(Tester);
						break;
                case 1:
                        System.out.println(Tester.isEmpty());
                        break;
                case 2:
                        System.out.println(Tester.removeMax());
                        System.out.println(Tester);
                        break;
                case 3:
                        System.out.println(Tester.peekMax());
                        break;
                case 4:
                        System.out.println(Tester.isFull());
                        break;
                case 5:
                        System.out.println(Tester.getCount());
                        break;
                case 6:
                		Tester.add(10);
                		Tester.add(9);
                		Tester.add(8);
                		Tester.add(11);
                		Tester.add(6);
                		System.out.println(Tester);
                		break;
                case 7:
                		Tester.add(10);
                		Tester.add(9);
                		Tester.add(8);
                		Tester.add(9);
                		Tester.add(7);
                		Tester.add(6);
                		Tester.add(4);
                		Tester.add(11);
                		Tester.add(9);
                		Tester.add(9);
                		Tester.add(8);
                		Tester.add(7);
                		Tester.add(5);
                		Tester.add(3);
                		Tester.add(4);
                		System.out.println(Tester);
                		break;
                case 8: 
                		while(!(Tester.isEmpty()))
                		{
                			System.out.println(Tester.removeMax());
                		}
                		break;
                case 9:
                		System.out.println(Tester);
                		break;
                case 10:
                        System.out.println("Have a nice day!");
						System.exit(0);//Ends program
                default:
                        System.out.println("Invalid input, please try again!"); 
                        break;
	   		}
		}
	}
}