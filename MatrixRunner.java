// MatrixRunner.java
// Garrett Bearss
// Testing the APMatrix class

public class MatrixRunner
{
	public static void main(String[] args)
	{
		KeyboardReader reader = new KeyboardReader();
		int selection = 0;
		while(selection != 6) //Keeps running till exit
		{
			System.out.println("\nWelcome to my menu. Please select from the following options: \n");
			System.out.println("		1. (Test Constructor) \n");
			System.out.println("		2. (Test Copy) \n");
			System.out.println("		3. (Test Multiply) \n");
			System.out.println("		4. (Test Cross) \n");
			System.out.println("		5. (Test removeCross) \n");
			System.out.println("		6. Exit");
			selection = reader.readInt("Enter your selection (1-6): ");
			System.out.println("\n");
			switch(selection)
			{
				case 1:
						int row = 3, col = 2;
						APMatrix m1 = new APMatrix(row,col, true);
						System.out.println(m1);
						break;
				case 2:
						int[][] testMatrix = {{1,0,0},{0,1,0},{0,0,1}};
						APMatrix m2 = new APMatrix(testMatrix);
						System.out.println(m2);
						break;
				case 3:
						//APMatrix dog = new APMatrix(2,3, true);
						//int[][] identity = {{1,0,0},{0,1,0},{0,0,1}};
						//APMatrix cat = new APMatrix(identity);
						APMatrix dog = new APMatrix(2,3, true);
						APMatrix cat = new APMatrix(3,3, true);
						APMatrix m3 = dog.matrixMultiply(cat);
						System.out.println(m3);
						break;
				case 4:
						APMatrix m4 = new APMatrix(3,4, true);
						System.out.println("The sum of the row 2 and column 3 is " + m4.sumCross(2,3));
						break;
				case 5:
						int [][] Garrett = {{11,22,33,5,44,55},{22,33,44,6,55,66},{4,5,6,7,8,9},{33,44,55,8,66,77},{44,55,66,9,77,88}};
						APMatrix m5 = new APMatrix(Garrett);
						System.out.println(m5);
						APMatrix newmatrix = m5.removeCross(3, 4);
						System.out.println(newmatrix);
						break;
				case 6:
						System.out.println("Have a nice day!");
						System.exit(0);//Ends program
				default:
					System.out.println("Invalid input, please try again!"); break;
			}
		
		}
	}
}