//Garrett Bearss
//PolygonsRunner.java 
//An introduction to inheritance in OOP -- very exciting!


public class PolygonsRunner
{
	public static void main(String[]args)
	{
		KeyboardReader reader = new KeyboardReader();
		
		Polygons[] polygonsArray = new Polygons[4];
		polygonsArray[0] = new Triangle(2, 4, "acute");
		polygonsArray[1] = new Triangle(3, 10, "obtuse");
		polygonsArray[2] = new Rectangles(2, 4);
		polygonsArray[3] = new Rectangles(4, 4);
		
		for(int i = 0; i < polygonsArray.length; i++)
		{
			polygonsArray[i].displayInfo();
		}
	}
}
