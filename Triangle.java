// Triangle.java
// McKeen 
// Triangle extends Polygons, but adds another variable and relevant methods

//import TerminalIO.KeyboardReader;

//A subclass of Polygons just for triangles
public class Triangle extends Polygons
{
	// Adding a new variable just for kicks -- the classification 
	// of the triangle by its angles
	private String angleClassify;  // should be "acute", "right", or "obtuse"
	
	//non-default constructor
	public Triangle(double w, double h, String ac)
	{
		super(w, h);
		angleClassify = ac;
	}
	
	//mutator method
	public void setClassify(String ac)
	{
		angleClassify = ac;
	}
	
	//accessor method
	public String getClassify()
	{
		return angleClassify;
	}
	
	//Hey, look! It's POLYMORPHISM!!!
	public double getArea()
	{
		return getWidth()*getHeight()/2;  //Where do getWidth() and getHeight() come from?  I don't see them here!
			
	}
	
	//Displays info to the screen
	public void displayInfo()
	{
		System.out.println("\n\nSHAPE INFO:");
		System.out.println("The figure is a triangle.");
		System.out.println("Angle classification:  " + angleClassify);
		super.displayInfo();		//What is this madness?  Is it calling itself?  
	}								//Why didn't I have to say super.getWidth() in the getArea method?
}									



















