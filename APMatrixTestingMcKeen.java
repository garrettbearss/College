// APMatrixTestingMcKeen
// Practice with matrices
// This document parallels the test case sheet
   
public class APMatrixTestingMcKeen
{
	static KeyboardReader reader = new KeyboardReader();
	
	public static void main(String[] args)
	{
		int method, row, col;
		APMatrix m1, m2, m3, a1;
		do
		{
			System.out.println("***********************************************************************");
			System.out.println("**************** APMatrix Testing *************************************");
			method = reader.readInt("\n\nPlease select a testing option:\n"+
									"1. Menu 1 -- Constructor 1 and toString \n"+
									"2. Menu 2 -- Matrix Multiply \n"+
									"3. Menu 3 -- sumCross \n"+
									"4. Menu 4 -- removeCross \n"+

									"0. Exit\n");
			System.out.println("***********************************************************************");
			if(method ==1)
			{
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\nMenu 1 -- Constructor and toString Testing\n");
				row = reader.readInt("Enter the number of rows:\t");
				col = reader.readInt("Enter the number of columns:\t");
				m1 = new APMatrix(row, col,true);  
				System.out.println("The STUDENT matrix is: \n" + m1);
				System.out.println("If the STUDENT matrix matches the CORRECT matrix on the Test Cases, \n"
									+ "give 2/2 pt.");
				reader.pause();
			}
			else if(method ==2)
			{
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 2 -- matrixMultiply Testing");
				System.out.println("***** CASE 1 *****\n\n");
				int [][]test1 = {{1,2},{3,4}};
				int [][]test2 = {{1,0},{0,1}};
				m1 = new APMatrix(test1);  
				m2 = new APMatrix(test2);  


				m3 = m1.matrixMultiply(m2);
				System.out.println("The STUDENT matrix is: \n" + m3);
				System.out.println("The CORRECT matrix is: \n" + m1);
				System.out.println("If the STUDENT matrix matches the CORRECT matrix, \n"
									+ "give 2/2 pt.");
				reader.pause();

				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 2 -- matrixMultiply Testing");
				System.out.println("***** CASE 2 ***** \n\n");
				int [][]test3 = {{1,2},{3,4}, {5,6}};
				int [][]test4 = {{1},{1}};
				int [][]answ1 = {{3},{7},{11}};
				m1 = new APMatrix(test3);  
				m2 = new APMatrix(test4);
				a1 = new APMatrix(answ1);  
				m3 = m1.matrixMultiply(m2);
				System.out.println("The STUDENT matrix is: \n" + m3);
				System.out.println("The CORRECT matrix is: \n" + a1);
				System.out.println("If the STUDENT matrix matches the CORRECT matrix, \n"
									+ "give 2/2 pt.");
				reader.pause();

				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 2 -- matrixMultiply Testing");
				System.out.println("***** CASE 3 ***** \n\n");
				int [][]test5 = {{1,2},{3,4}};
				int [][]test6 = {{1,0}};
				m1 = new APMatrix(test5);  
				m2 = new APMatrix(test6);
				m3 = m1.matrixMultiply(m2);
				System.out.println("The STUDENT matrix is: \n" + m3);
				System.out.println("\nIf the STUDENT response above contains a message stating that "
									+ "the matrices \ncan NOT be multiplied and if the "
									+" STUDENT matrix says null, \n"
									+ "give 2/2 pt.");
				reader.pause();
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 2 -- matrixMultiply Testing");
				System.out.println("***** CASE 4 ***** \n\n");
				int [][]test7 = {{1,2,3},{4,5,6}};
				int [][]test8 = {{7},{8},{9}};
				int [][]answ2 = {{50},{122}};
				m1 = new APMatrix(test7);  
				m2 = new APMatrix(test8);
				a1 = new APMatrix(answ2);  
				m3 = m1.matrixMultiply(m2);
				System.out.println("The STUDENT matrix is: \n" + m3);
				System.out.println("The CORRECT matrix is: \n" + a1);
				System.out.println("If the STUDENT matrix matches the CORRECT matrix, \n"
									+ "give 1/1 pt.");
				reader.pause();
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 2 -- matrixMultiply Testing");
				System.out.println("***** CASE 5 ***** \n\n");
				int [][]test9 = {{5}};
				int [][]test10 = {{-6}};
				int [][]answ3 = {{-30}};
				m1 = new APMatrix(test9);  
				m2 = new APMatrix(test10);
				a1 = new APMatrix(answ3);  
				m3 = m1.matrixMultiply(m2);
				System.out.println("The STUDENT matrix is: \n" + m3);
				System.out.println("The CORRECT matrix is: \n" + a1);
				System.out.println("If the STUDENT matrix matches the CORRECT matrix, \n"
									+ "give 1/1 pt.");
				reader.pause();
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 2 -- matrixMultiply Testing");
				System.out.println("***** CASE 6 ***** \n\n");
				int [][]test11 = {{1},{2},{3},{4}};
				int [][]test12 = {{0,0,0}};
				int [][]answ4 = {{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
				m1 = new APMatrix(test11);  
				m2 = new APMatrix(test12);
				a1 = new APMatrix(answ4);  
				m3 = m1.matrixMultiply(m2);
				System.out.println("The STUDENT matrix is: \n" + m3);
				System.out.println("The CORRECT matrix is: \n" + a1);
				System.out.println("If the STUDENT matrix matches the CORRECT matrix, \n"
									+ "give 1/1 pt.");
				reader.pause();
			}
			else if(method ==3)
			{
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 3 -- sumCross Testing");
				System.out.println("***** CASE 1 ***** \n\n");
				int [][]testa1 = {{77,22,1,33},{5,3,10,4},{66,44,2,55}};
				m1 = new APMatrix(testa1);  
				System.out.println("The STUDENT result is: \n" + m1.sumCross(2,3));
				System.out.println("The CORRECT result is: \n" + 25);
				System.out.println("If the STUDENT result matches the CORRECT result, \n"
									+ "give 2/2 pt.");
				reader.pause();

				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 3 -- sumCross Testing");
				System.out.println("***** CASE 2 ***** \n\n");
				System.out.println("The STUDENT result is: \n" + m1.sumCross(1,2));
				System.out.println("The CORRECT result is: \n" + 180);
				System.out.println("If the STUDENT result matches the CORRECT result, \n"
									+ "give 1/1 pt.");
				reader.pause();
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 3 -- sumCross Testing");
				System.out.println("***** CASE 3 ***** \n\n");
				System.out.println("The STUDENT result is: \n" + m1.sumCross(3,4));
				System.out.println("The CORRECT result is: \n" + 204);
				System.out.println("If the STUDENT result matches the CORRECT result, \n"
									+ "give 1/1 pt.");
				reader.pause();
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 3 -- sumCross Testing");
				System.out.println("***** CASE 4 ***** \n\n");
				int [][]testa2 = {{1,2},{3,4}};
				m1 = new APMatrix(testa2);  
				System.out.println("The STUDENT result is: \n" + m1.sumCross(2,2));
				System.out.println("The CORRECT result is: \n" + 9);
				System.out.println("If the STUDENT result matches the CORRECT result, \n"
									+ "give 1/1 pt.");
				reader.pause();
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 3 -- sumCross Testing");
				System.out.println("***** CASE 5 ***** \n\n");
				System.out.println("The STUDENT result is: \n" + m1.sumCross(1,2));
				System.out.println("The CORRECT result is: \n" + 7);
				System.out.println("If the STUDENT result matches the CORRECT result, \n"
									+ "give 1/1 pt.");
				reader.pause();
			}
			else if(method ==4)
			{
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 4 -- removeCross Testing");
				System.out.println("***** CASE 1 ***** \n\n");
				int [][]sc1 = {{1,2},{3,99}};
				int [][]sc2 = {{99}};
				m1 = new APMatrix(sc1);  
				m2 = new APMatrix(sc2);  
				m3 = m1.removeCross(1,1);
				System.out.println("The STUDENT matrix is: \n" + m3);
				System.out.println("The CORRECT matrix is: \n" + m2);
				System.out.println("If the STUDENT matrix matches the CORRECT matrix, \n"
									+ "give 1/1 pt.");
				reader.pause();

				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 4 -- removeCross Testing");
				System.out.println("***** CASE 2 ***** \n\n");
				int [][]sc5 = {{3}};
				m2 = new APMatrix(sc5);  
				m3 = m1.removeCross(1,2);
				System.out.println("The STUDENT matrix is: \n" + m3);
				System.out.println("The CORRECT matrix is: \n" + m2);
				System.out.println("If the STUDENT matrix matches the CORRECT matrix, \n"
									+ "give 1/1 pt.");
				reader.pause();
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 4 -- removeCross Testing");
				System.out.println("***** CASE 3 ***** \n\n");
				int [][]sc3 = {{11,22,33,5,44,55},{22,33,44,6,55,66},{4,5,6,7,8,9},{33,44,55,8,66,77},{44,55,66,9,77,88}};
				int [][]sc4 = {{11,22,33,44,55},{22,33,44,55,66},{33,44,55,66,77},{44,55,66,77,88}};
				m1 = new APMatrix(sc3);  
				m2 = new APMatrix(sc4);  
				m3 = m1.removeCross(3,4);
				System.out.println("The STUDENT matrix is: \n" + m3);
				System.out.println("The CORRECT matrix is: \n" + m2);
				System.out.println("If the STUDENT matrix matches the CORRECT matrix, \n"
									+ "give 1/1 pt.");
				reader.pause();
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 4 -- removeCross Testing");
				System.out.println("***** CASE 4 ***** \n\n");
				int [][]sc6 = {{11,22,33,44},{22,33,44,55},{33,44,55,66}};
				m2 = new APMatrix(sc6);  
				m3 = m3.removeCross(4,5);
				System.out.println("The STUDENT matrix is: \n" + m3);
				System.out.println("The CORRECT matrix is: \n" + m2);
				System.out.println("If the STUDENT matrix matches the CORRECT matrix, \n"
									+ "give 1/1 pt.");
				reader.pause();
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 4 -- removeCross Testing");
				System.out.println("***** CASE 5 ***** \n\n");
				int [][]sc7 = {{33,44,55},{44,55,66}};
				m2 = new APMatrix(sc7);  
				m3 = m3.removeCross(1,1);
				System.out.println("The STUDENT matrix is: \n" + m3);
				System.out.println("The CORRECT matrix is: \n" + m2);
				System.out.println("If the STUDENT matrix matches the CORRECT matrix, \n"
									+ "give 1/1 pt.");
				reader.pause();
				//////////////////////////////////////////////////////////////////////
				System.out.println("\n\n\n\n\n\n\n\nMenu 4 -- removeCross Testing");
				System.out.println("***** CASE 6 ***** \n\n");
				int [][]sc8 = {{33,55}};
				m2 = new APMatrix(sc8);  
				m3 = m3.removeCross(2,2);
				System.out.println("The STUDENT matrix is: \n" + m3);
				System.out.println("The CORRECT matrix is: \n" + m2);
				System.out.println("If the STUDENT matrix matches the CORRECT matrix, \n"
									+ "give 1/1 pt.");
				reader.pause();

			}/*
			else if(method ==11)
			{
				row = reader.readInt("How many rows?\t");
				col = reader.readInt("How many columns?\t");
				m1 = new APMatrix(row, col, true);  
				System.out.println("Your new matrix is: \n" + m1);
				reader.pause();
			}
			else if(method ==12)
			{
				row = reader.readInt("How many rows in Matrix 1?\t");
				col = reader.readInt("How many columns in matrix 1?\t");
				m1 = new APMatrix(row, col,true);
				row = reader.readInt("How many rows in Matrix 2?\t");
				col = reader.readInt("How many columns in matrix 2?\t");
				m2 = new APMatrix(row, col, true);
				m3 = m1.matrixMultiply(m2);
				if (m3 != null)
					System.out.println("/nThe multiplied matrix is: \n" + m3);
				reader.pause();
			}
			else if(method ==13)
			{
				row = reader.readInt("How many rows in the Matrix?\t");
				col = reader.readInt("How many columns in the matrix?\t");
				m1 = new APMatrix(row, col,true);
				row = reader.readInt("Which row do you want to sum?\t");
				col = reader.readInt("Which column do you want to sum?\t");
				System.out.println("/nThe sum of the row and column is " + m1.sumCross(row,col));
				reader.pause();
				
			}
			else if(method ==14)
			{
				row = reader.readInt("How many rows in the Matrix?\t");
				col = reader.readInt("How many columns in the matrix?\t");
				m1 = new APMatrix(row, col);
				row = reader.readInt("Which row do you want to remove?\t");
				col = reader.readInt("Which column do you want to remove?\t");
					System.out.println("/nThe new matrix is: \n" + m1.removeCross(row,col));
				reader.pause();
			}*/
		}while (method !=0);
		System.out.println("\nThank you for using the APMatrix Tester.");
		System.out.println("\nI hope you and your gradee both got a perfect and your grading experience was a pleasant one.\n\n");
		
		System.out.println("\nPlease write a good quality Grader's Comparison.");
		
	}

}
