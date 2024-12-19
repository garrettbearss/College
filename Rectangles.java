// Rectangles.java
// Garrett Bearss
// Rectangles extends Polygons, but adds another variable and relevant methods

//A subclass of Polygons just for triangles
public class Rectangles extends Polygons
{
	private boolean isSquare;
	//non-default constructor
	public Rectangles(double w, double h)
	{
		super(w, h);
		if(w == h)
		{
			isSquare = true;
		}
		else
		{
			isSquare = false;
		}
	}
	//accessor method
	public boolean getIsSquare()
	{
		return isSquare;
	}
	
	//Hey, look! It's POLYMORPHISM!!!
	public double getArea()
	{
		return getWidth()*getHeight();  //Where do getWidth() and getHeight() come from?  I don't see them here!
			
	}
	
	//Displays info to the screen
	public void displayInfo()
	{
		System.out.println("\n\nSHAPE INFO:");
		System.out.println("The figure is a rectangle.");
		if(isSquare == true)
		{
			System.out.println("This figure is a square");
		}
		else
		{
			System.out.println("This figure isn't a square");
		}
		super.displayInfo();		//What is this madness?  Is it calling itself?  
	}								//Why didn't I have to say super.getWidth() in the getArea method?
}									
