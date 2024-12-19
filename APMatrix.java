//APMatrix.java
//Garrett Bearss
//The class file for APMatrix

public class APMatrix
{
	private int [][] matrix;
	KeyboardReader reader = new KeyboardReader();
	
	public APMatrix(int R, int C, boolean enter)// 1st Constructor
	{
		if(enter == true)// If they wanted to enter the vaules in
		{
			matrix = new int [R][C];
			for(int i = 0; i<matrix.length; i++)
			{
				for(int j = 0; j<matrix[0].length; j++)
				{
					matrix[i][j] = reader.readInt("Enter a value into (Row: " + i + ") (Col: " + j + "): ");
					System.out.println();
				}
			}
		}
		else// If they didn't want to enter the values
		{
			matrix = new int [R][C];
		}
	}
	
	public APMatrix(int[][] copyMe)// 2nd Constructor
	{
		matrix = new int [copyMe.length][copyMe[0].length];// Makes new matrix equal to input matrix
          for(int i = 0; i<matrix.length; i++)
		  {
			 for(int j = 0; j<matrix[0].length; j++)
			 {
				matrix[i][j] = copyMe[i][j];
			 }
		  }
	}
    
    public int getRows()// 1st Accessor
    {
        int Rows = matrix.length;
        return Rows;
    }
    
    public int getColumns()// 2nd Accessor
    {
        int Columns = matrix[0].length;
        return Columns;
    }
    
    public String toString()// Prints the matrix
    {
        String s1 = ("");
        for(int i = 0; i<matrix.length; i++)
		{
			for(int j = 0; j<matrix[0].length; j++)
			{
				s1 += (matrix[i][j] + "\t");
			}
            s1 += ("\n");
		}
        return s1;
    }
    
    public APMatrix matrixMultiply(APMatrix m1)// Multiplies two matrixes together and returns the result
    {
        if(this.getColumns() == m1.getRows())// If they are able to be multiplied
        {
            int [][] mul = new int [matrix.length][m1.getColumns()];
            for(int i = 0; i< mul.length; i++)
            {
                for(int j = 0; j< mul[0].length; j++)
                {
                     mul[i][j] = this.oneCell(i, j, m1);// Calls oneCell to multiply and return the result
                }
            }
            APMatrix bob = new APMatrix(mul);// Creates new APMatrix object and returns it
            return bob;
        }
        else// If they are not able to be multiplied
        {
            System.out.println("Error: The matrices can NOT be multiplied, returning null.");
            return null;
        }
    }
    
    private int oneCell(int r, int c, APMatrix mm)// Takes the value of one cell and multiplies it to the corresponding element
    {
        int sum = 0;
        for(int i = 0; i < this.matrix[0].length; i++)
        {
        	int element = this.matrix[r][i]*mm.matrix[i][c];
        	sum += element;
        }
        return sum;
    }
    
    public int sumCross(int r, int c)// Takes the sum of all the numbers in a certain row/ col
    {
    	r--;
    	c--;
    	if(r >= this.getRows() || r < 0)
        {
            System.out.println("Error: Row is not in the matrix.");
            return -1;
        }
        if(c >= this.getColumns() || c < 0)
        {
            System.out.println("Error: Column is not in the matrix.");
            return -1;
        }
    	int sum = 0;
    	for(int i = 0; i < matrix[0].length; i++)
    	{
    		sum += matrix[r][i];
    	}
    	for(int j = 0; j < matrix.length; j++)
    	{
    		sum += matrix[j][c];
    	}
    	sum -= matrix[r][c];
    	return sum;
    }
    
    public APMatrix removeCross(int r, int c)// Removes the values from the matrix in a certain row/ col
    {
    	r--;
    	c--;
        if(r >= this.getRows() || r < 0)
        {
            System.out.println("Error: Row is not in the matrix.");
            return this;
        }
        if(c >= this.getColumns() || c < 0)
        {
            System.out.println("Error: Column is not in the matrix.");
            return this;
        }
    	int [][] Gabe = new int [this.getRows()-1][this.getColumns()-1];
    	APMatrix bob = new APMatrix(Gabe);
        for(int i = 0; i<= Gabe.length; i++)
        {
        	if(i > r)
        	{
        		for(int j = 0; j<= Gabe[0].length; j++)
            	{
            		if(j > c)
            		{
            			bob.matrix[i-1][j-1] = this.matrix[i][j];
            		}
            		else if(j < c)
            		{
            			bob.matrix[i-1][j] = this.matrix[i][j];
            		}
            	}
        	}
        	else if(i < r)
        	{
        		for(int j = 0; j<= Gabe[0].length; j++)
            	{
            		if(j > c)
            		{
            			bob.matrix[i][j-1] = this.matrix[i][j];
            		}
            		else if(j < c)
            		{
            			bob.matrix[i][j] = this.matrix[i][j];
            		}
            	}
        	}
        	
        }
        return bob;
    }
}