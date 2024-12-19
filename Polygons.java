// Polygons.java  (added the 's' because of an existing Java Polygon class)
// McKeen 
// Inheritance and an abstract class

abstract public class Polygons   //class definition
{
	private double width;
	private double height;
	
	//constructor
	public Polygons(double w, double h)
	{
		// pretend there is error checking here to prevent invalid width/height values
		
		// initialize values
		width = w;
		height = h;
	}
	
	//accessors
	public double getWidth()
	{
		return width;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	//mutator methods
	protected void setWidth(double w)
	{
		width = w;
	}
	
	protected void setHeight(double h)
	{
		height = h;
	}
	
	public void displayInfo()
	{
		System.out.println("The width is " + width);
		System.out.println("The height is " + height);
		System.out.println("The area is " + getArea());
	}
		
	//abstract methods have no body -- they must be created in a child class
	// Finally, you can put a ; at the end of the method header and NOT get an error!
	abstract double getArea();
	
}
