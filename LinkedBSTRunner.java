// Garrett Bearss
// LinkedBSTRunner.java
// Uses the LinkedBST class
public class LinkedBSTRunner
{
	public static void main(String[] args)
	{
		LinkedBST Tester = new LinkedBST();
		KeyboardReader reader = new KeyboardReader();
		int selection = -1;
		while(selection != 10) //Keeps running till exit
		{
			System.out.println("\nWelcome to my menu. Please select from the following options: \n");
			System.out.println("		0. (addNode) \n");
			System.out.println("		1. (traverse) \n");
			System.out.println("		2. (deleteNode) \n");
			System.out.println("		3. (search) \n");
			System.out.println("		4. (countLeaf) \n");
			System.out.println("		5. (findPath) \n");
			System.out.println("		6. (countNode) \n");
			System.out.println("		7. (Pre-Built Tree) \n");
			System.out.println("		8. (Pre-Built Tree) \n");
			System.out.println("		9. (Pre-Built Tree) \n");
			System.out.println("		10. Exit");
			selection = reader.readInt("Enter your selection (0-10): ");
			System.out.println("\n");
			switch(selection)
			{
				case 0: //addNode
						String add1 = reader.readLine("Add a String node to the list: ");
						System.out.println("\n");
                        if(Tester.addNode(add1))
                        {
                            System.out.println("The node was successfully added.");
                        }
                        else
                        {
                            System.out.println("The node failed to be added.");
                        }
						break;
                case 1: // traversals
                        int choice2 = reader.readInt("What traversal method would you like [preOrder(1), inOrder(2), postOrder(3)]: ");
                        System.out.println("\n");
                        if(choice2 == 1)// preorder
                        {
                            System.out.println("List = " + Tester.preOrder());
                            System.out.println("\n");
                        }
                        else if(choice2 == 2)// inorder
                        {
                            System.out.println("List = " + Tester.inOrder());
                            System.out.println("\n");
                        }
                        else if(choice2 == 3)// postorder
                        {
                            System.out.println("List = " + Tester.postOrder());
                            System.out.println("\n");
                        }
                        else// invalid
                        {
                            System.out.println("Invalid input, breaking...");
                            System.out.println("\n");
                        }
                        break;
                  case 2:// deleteNode
                  		String choice3 = reader.readLine("What value would you like deleted: ");
                  		System.out.println("\n");
                  		if(Tester.deleteNode(choice3))
                  		{
                  			System.out.println("The value: " + choice3 + " was deleted from the tree.");
                  		}
                  		else
                  		{
                  			System.out.println("The value: " + choice3 + " could not be deleted.");
                  		}
                  		break;
                  case 3:// search
                  		String choice4 = reader.readLine("What value would you like to search for: ");
                  		System.out.println("\n");
                  		if(Tester.search(choice4))
                  		{
                  			System.out.println("The value: " + choice4 + " was found in the tree.");
                  		}
                  		else
                  		{
                  			System.out.println("The value: " + choice4 + " is not in the tree.");
                  		}
                  		break;
                  case 4:// countLeaf
                  		System.out.println("\n");
                  		System.out.println("There are " + Tester.countLeaf() + " leaves in the tree.");
                  		break;
                  case 5:// findPath
                  		String choice5 = reader.readLine("What value would you like to find the path for: ");
                  		System.out.println("\n");
                  		System.out.println("Traversed " + Tester.findPath(choice5) + " branches to find the value.");
                  		break;
                  case 6:// countNode
                  		System.out.println("\n");
                  		System.out.println("There are " + Tester.countNode() + " nodes in the tree.");
                  		break;
                  case 7:// pre-built
                  		Tester.addNode("D");
                  		Tester.addNode("B");
                  		Tester.addNode("F");
                  		Tester.addNode("A");
                  		Tester.addNode("C");
                  		Tester.addNode("E");
                  		Tester.addNode("Z");
                  		Tester.addNode("X");
                  		break;
                  case 8:
                  		Tester.addNode("T");
                  		Tester.addNode("P");
                  		Tester.addNode("A");
                  		Tester.addNode("R");
                  		Tester.addNode("Q");
                  		Tester.addNode("X");
                  		Tester.addNode("Z");
                  		break;
                  case 9:
                  		Tester.addNode("Q");
                  		Tester.addNode("X");
                  		Tester.addNode("A");
                  		Tester.addNode("D");
                  		Tester.addNode("B");
                  		Tester.addNode("F");
                  		Tester.addNode("C");
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
