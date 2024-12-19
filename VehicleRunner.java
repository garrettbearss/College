// VehicleRunner
// McKeen
// Testing the Vehicle Class 

public class VehicleRunner
{
	public static void main(String[] args)
	{
		KeyboardReader reader = new KeyboardReader();
		
		//CREATE A NEW VEHICLE and DO STUFF WITH IT
		Vehicle Yash = new Vehicle();
		Yash.getRange();
		System.out.println("Your vechicle's range is: " + Yash.getRange());
		Yash.setnumPassengers(100);
		Yash.displayInfo();
	}
}



























