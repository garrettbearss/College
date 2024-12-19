//Fraction.java
//Garrett Bearss
//Has a bunch of different methods that pretain to fractions

public class Fraction implements FractionInterface            
{
	// private instance variables
	private int myNumerator;
	private int myDenominator;
	
	// default constructor method -- no parameters
	public Fraction()
	{
		myNumerator = 0;
		myDenominator = 1;
	}
	// constructor method to input numerator and denominator
	public Fraction(int newNumerator, int newDenominator)
	{
		this.myNumerator = newNumerator;
		this.myDenominator = newDenominator;
		this.simplify();
	}
	
	public Fraction(double NumeratorDenominator)// Will transform the decimal into a fraction by starting off by multiplying it by 10
	{
		int whole = 0;
		if(NumeratorDenominator > 1)// If the fraction is greater than 1
		{
			while(NumeratorDenominator > 1)// Removes whole numbers
			{
				NumeratorDenominator--;
				whole++;
			}
		}
		int n = 10;
		for(int i = 0; this.myNumerator <= 1; i += n)// Runs while Numerator is still less than 1 or is 1
		{
			n = n*10;
			this.myDenominator = i;// Denominator will always be in a power of 10
			this.myNumerator = (int)(NumeratorDenominator*i);// Multiples the decimal by a power of 10
		}
		this.myNumerator = this.myNumerator + (whole*this.myDenominator);// Adds back the whole number to the new fraction
		this.simplify();
	}

	//Accessor methods -- return the private variable values
	public int getNumerator()// Gets the numerator and returns it
	{
		return myNumerator;
	}
	
	public int getDenominator()// Gets the denominator and returns it
	{
		return myDenominator;
	}
	
	public Fraction add(Fraction amount)// Adds two fractions together
	{
		Fraction result = new Fraction();
		
		result.myNumerator = (this.myNumerator * amount.myDenominator) + (amount.myNumerator * this.myDenominator);// Multiples the Num by the Denom and then adds (opposite of each other)
		result.myDenominator = this.myDenominator * amount.myDenominator;// Multiples the two denominators together
		
		result.simplify();
		return result;
	}
	
	public Fraction subtract(Fraction amount)// Subtracts two fractions
	{
		Fraction result = new Fraction();
		
		result.myNumerator = (this.myNumerator * amount.myDenominator) - (amount.myNumerator * this.myDenominator);// Multiples the Num by the Denom and then subtracts (opposite of each other)
		result.myDenominator = this.myDenominator * amount.myDenominator;// Multiples the two denominators together
		
		result.simplify();
		return result;
	}
	
	public Fraction multiply(Fraction amount)//Multiplies two fractions together
	{
		Fraction result = new Fraction();
		
		result.myNumerator = this.myNumerator * amount.myNumerator;// Multiplies the two numerators together
		result.myDenominator = this.myDenominator * amount.myDenominator;// Multiplies the two denominators together
		
		result.simplify();
		return result;
	}
	
	public Fraction divide(Fraction amount)//Divides two fractions
	{
		Fraction result = new Fraction();
		
		result.myNumerator = this.myNumerator * amount.myDenominator;// Multiples the numerator with the opposite denominator
		result.myDenominator = this.myDenominator * amount.myNumerator;// Multiples the denominator with the opposite numerator
		
		result.simplify();
		return result;
	}

	public double toDouble()//Turns fraction into decimal
	{
		double decimal = (double)this.myNumerator/(double)this.myDenominator;//Divdes numerator by denominator to get decimal
		return decimal;
	}
	
	public int compareTo(Fraction amount)// Compares the values of two fractions to one another
	{
		if(((double)this.myNumerator/(double)this.myDenominator) == ((double)amount.myNumerator/(double)amount.myDenominator))// If the two fractions are equal to one another
		{
			return 0;
		}
		else if(((double)this.myNumerator/(double)this.myDenominator) > ((double)amount.myNumerator/(double)amount.myDenominator))//If the fraction calling the method is higher than the input fraction
		{
			return 1;
		}
		else// If the fraction input is higher in value
		{
			return -1;
		}
	}
	
	public boolean equals(Fraction amount)// Checks to see if the two fractions are equal to one another
	{
		if(((double)this.myNumerator/(double)this.myDenominator) == ((double)amount.myNumerator/(double)amount.myDenominator))// If they are equal
		{
			return true;
		}
		else// If they are not equal
		{
			return false;
		}
	}
	
	public boolean equals(double amount)// Checks to see if the fraction and the decimal are equal to one another
	{
		if(((double)this.myNumerator/(double)this.myDenominator) == amount)// If they are equal
		{
			return true;
		}
		else// If they are not equal
		{
			return false;
		}	
	}
	
	public boolean equals(int Numerator, int Denominator)// Checks to see if the fraction and the input num/denum are equal to one another
	{
		if(((double)this.myNumerator/(double)this.myDenominator) == ((double)Numerator/(double)Denominator))
		{
			return true;
		}
		else// If they are not equal
		{
			return false;
		}
	}
	
	private void simplify()// Cuts down the fraction to it's most basic form
	{
		int n = this.myNumerator; // n stands for new numerator
		int d = this.myDenominator;// d stands for new denominator
		int divisor = 0;// Used to inhibit how far i goes in the loop
		int gcd = 0;// GCD of the two fractions
		
		if(n < 0)// If the Numerator is negative
		{
			n = -n; 
		}
		
		if(n > d)// If the numerator is greater than the denominator (fraction is greater than 1) or fraction is negative with the numerator being smaller than the denominator
		{
			divisor = n;
		}
		else// If the fraction is less than 1 or equal to 1
		{
			divisor = d;
		}
		
		for(int i = divisor; i >= 2; i --)//Runs until the i = 2 (2 being the lowest divisor)
		{
			if(n%i == 0 && d%i == 0)// Finds if both the numerator divided by the common divider
			{
				gcd = i;// If it is able to divide both numbers than the gcd becomes i
				break;
			}
		}
		
		if(gcd != 0)//Makes sure that you arn't dividing by zero
		{
			this.myNumerator /= gcd;// Calculates the new numerator
			this.myDenominator /= gcd;// Calculates the new denominator
		}
		
		if(this.myNumerator < 0 && this.myDenominator < 0)// If both the Numerator and Denominator are negative
		{
			this.myDenominator = Math.abs(this.myDenominator);// Flips the denominator to be postive
			this.myNumerator = this.myNumerator - (this.myNumerator*2);// Flips the numerator to be negative
		} 
		else if(this.myNumerator > 0 && this.myDenominator < 0)// If only the Denominator is negative
		{
			this.myDenominator = Math.abs(this.myDenominator);// Flips the denominator to be postive
			this.myNumerator = this.myNumerator - (this.myNumerator*2);// Makes the numerator become negative
		}
		
		if(this.myDenominator == 0 || this.myNumerator == 0)
		{
			this.myDenominator = 1;
			this.myNumerator = 0;
		}
		
	}
	
	public void print()// Prints the fraction by calling toString
	{
			System.out.println(this.toString());
	}

	public String toString()// Prints the fraction to the screen
	{
		String s1;
		s1 = (this.myNumerator + "/" + this.myDenominator);
		return s1;
	}
}