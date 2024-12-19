//Money.java
//Garrett Bearss
//Has a bunch of different methods that pretain to money

public class Money             
{
	// private instance variables
	private int myDollars;
	private int myCents;
	
	// default constructor method -- no parameters
	public Money()
	{
		myDollars = 0;
		myCents = 0;
	}
	// constructor method to input dollars and cents
	public Money(int newDollars, int newCents)
	{
		this.myDollars = newDollars;
		this.myCents = newCents;
		this.normalize();
	}

	//Accessor methods -- return the private variable values
	public int getDollars()
	{
		return myDollars;
	}
	
	public int getCents()
	{
		return myCents;
	}
	
	//  One Money parameter add method -- THIS METHOD IS COMPLETE AS IS -- DO NOT CHANGE IT
	//  This method combines the totals in this and the parameter amount
	public Money add(Money amount)
	{
		Money result = new Money();
		
		result.myCents = this.myCents + amount.myCents;// Adds this's cents to the input money's cents
		result.myDollars = this.myDollars + amount.myDollars;// Add this's dollars to the input money's dollars
		
		result.normalize();
		return result;
	}
	
	// 	Two int parameter add method  -- YOU WILL ADD THIS AND MUCH MORE!!!
	//  This method gets passed dollars and cents instead of a Money object
	public Money add(int value1, int value2)
	{
		Money result = new Money();
		
		result.myCents = this.myCents + value2;// Adds this's cents to the input value
		result.myDollars = this.myDollars + value1;// Adds this's dollars to the input value
		
		result.normalize();
		return result;
	}
	
	public Money subtract(Money amount)
	{
		Money result = new Money();
		
		result.myCents = this.myCents - amount.myCents;// Subtracts this's cents to the input money's cents
		result.myDollars = this.myDollars - amount.myDollars;// Subtracts this's dollars to the input money's dollars
		
		result.normalize();
		return result;
	}
	
	public Money subtract(int value1, int value2)
	{
		Money result = new Money();
		
		result.myCents = this.myCents - value2;// Subtracts this's cents to the input value
		result.myDollars = this.myDollars - value1;// Subtracts this's dollars to the input value 

		result.normalize();
		return result;
	}
	
	public Money multiply(int value)
	{
		Money result = new Money();
		
		result.myCents = this.myCents * value;// Multiplies this's cents to the input value
		result.myDollars = this.myDollars * value;// Multiplies this's dollars to the input value
		
		result.normalize();
		return result;
	}


	//This method should fix the problem of myCents > 99 or myCents < 0
	//Think carefully about which methods should call normalize()
	//COMPLETING THIS METHOD IS THE MAIN PART OF THIS ASSIGNMENT
	private void normalize()
	{
		if(this.myDollars >= 0)// Checks if dollars is positive
		{		
			if(this.myCents > 99)//Checks if you can make a dollar
			{
				int newDollars = this.myCents/100;
				this.myDollars = newDollars + this.myDollars;
				this.myCents = this.myCents%100;
			}
			else if(this.myCents < 0)// Checks if you have a negative amount of cents
			{
				while(this.myCents < 0)// Turns dollars into cents till the cents is postive
				{
					this.myDollars = this.myDollars - 1;
					this.myCents = this.myCents + 100;
					if(this.myDollars <= 0)// Checks if you've run out of dollars to convert
					{
						this.myDollars = 0;
						break;
					}
				}
			}
			
		}
		if(this.myDollars < 0 && this.myCents < 0)// Checks both dollars and cents are negative
		{
			this.myDollars = 0;
			this.myCents = 0;
		}
		else if(this.myDollars < 0 && this.myCents >= 100)// Checks if dollars is negative and cents can make a dollar
		{
			while(this.myCents > 0)// Loops till dollars have been made
			{
				this.myCents = this.myCents - 100;
				this.myDollars = this.myDollars + 1;
				if(this.myCents <= 0)// If no more cents is there breaks
				{
					this.myCents = 0;
					break;
				}
				else if(this.myCents < 100) // If cents can't make a dollar
				{
					break;
				}
			}
		}
		else if(this.myDollars < 0 && (this.myCents < 100 || this.myCents > 0))
		{
			while(this.myDollars < 0)// Turns cents into dollars till the dollars is postive
			{
				this.myCents = this.myCents - 100;
				if(this.myDollars <= 0)// Checks if you've run out of cents to convert
				{
					this.myCents = 0;
					break;
				}
				this.myDollars++;
			}	
		}
		if(this.myDollars < 0)// Checks if dollars are still negative
		{
			this.myDollars = 0;
		}
		if(this.myCents < 0)// Checks if cents are still negative
		{
			this.myCents = 0;
		}
	}

	//This method (incorrectly) displays the values attractively to the screen 
	// THIS METHOD REQUIRES ONLY A SMALL MODIFICATION TO WORK PROPERLY
	public void print()
	{
		if(this.myCents < 10 && this.myCents >= 0)// Checks if cents is 0 - 9
		{
			System.out.println("$" + this.myDollars + ".0" + this.myCents);
		}
		else
		{
			System.out.println("$" + this.myDollars + "." + this.myCents);
		}
	}

	
	// This method (incorrectly) overwrites the automatic toString() method	
	// THIS METHOD REQUIRES ONLY A SMALL MODIFICATION TO WORK PROPERLY
	public String toString()
	{
		String s1;
		if(this.myCents < 10 && this.myCents >= 0)// Checks if cents is 0 - 9
		{
			s1 = ("$" + this.myDollars + ".0" + this.myCents);
		}
		else
		{
			s1 = ("$" + this.myDollars + "." + this.myCents);
		}
		return s1;
	}
}






