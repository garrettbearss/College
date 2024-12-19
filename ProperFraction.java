//ProperFraction.java
//Garrett Bearss
//Proper Fraction extends Fraction, but adds some new methods 

public class ProperFraction extends Fraction
{
	public ProperFraction(int numerator, int denominator)
	{
		super(numerator, denominator);
	}
	
	public int getWhole()// Gets the whole number of the fraction
	{
		int whole = 0;
		int n = Math.abs(super.getNumerator());//Makes fraction positive
		int d = super.getDenominator();
        for(int i = 0; i <= whole; i++)// Runs until whole number has been increased or stays the same
        {
		  if(n/d >= 1)// If the fraction can make a whole number
          {
          	while(n/d >= 1)// While the fraction can make a whole number
          	{
          			n = n - d;// Subtract the denominator from the numerator
            		whole++;	
          	}
          }
        }
        if(super.getNumerator() < 0)// If the fraction was orignally negative
        {
        	whole = whole - (whole*2);
        }
		return whole;
	}
	
	public int getRemainder()// Gets the numerator after whole is calculated
	{
		int whole = 0;
		int n = Math.abs(super.getNumerator());// Makes fraction positive
		int d = super.getDenominator();
		for(int i = 0; i <= whole; i++)// Runs until whole number has been increased or stays the same
        {
		  if(n/d >= 1)// If the fraction can make a whole number
          {
          	while(n/d >= 1)// While the fraction can make a whole number
          	{
          		n = n - d;// Subtract the denominator from the numerator
            	whole++;
          	}
          }
          if(super.getNumerator() < 0 && whole == 0)// If the fraction was orignally negative
          {
          	n = n - (n*2);
          }
        }
        return n;
	}
	
	public void print()
	{
        System.out.println(toString());
	}
	
	public String toString()
	{
        String s1;
        if(this.getWhole() == 0)// If the fraction is not greater than one
        {
            s1 = (this.getRemainder() + "/" + super.getDenominator());
        }
        else if(this.getWhole() != 0 && this.getRemainder() == 0)// If there is a whole number and no remainder
        {
        	s1 = ("" + this.getWhole());
        }
        else// If there is a whole number and a remainder 
        {
            s1 = (this.getWhole() + " " + Math.abs(this.getRemainder()) + "/" + super.getDenominator());
        }
        return s1;
	}
}