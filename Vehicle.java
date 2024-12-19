// Vehicle class
// McKeen
// Used to create a Vehicle object 

class Vehicle
{
	// Characteristics of a vehicle
	private int numPassengers;  //number of people who can fit inside
	private double fuelCap;   	//total gallons
	private int mpg;   			//total miles per gallon
	private String bodytype;   	//coupe, hatchback, sedan, etc
	private int odometer;		//keeps track of total miles driven

	//Default Constructor method -- initializes the variables numPassengers, fuelCap, and mpg
	//PUT DEFAULT CONSTRUCTOR HERE:
	public Vehicle()
	{
		numPassengers = 8;
		fuelCap = 15;
		mpg = 1;
		bodytype = "Ferori";
		odometer = 250000;
	}
	//Mutator methods -- allow us to change private variables
	public void setnumPassengers(int n)
	{
		//If we wanted this code to be more realistic (and long and annoying),
		//we would include error trapping on n
		
		numPassengers = n;
		
	}
	public void setfuelCap(double fc)
	{
		//pretend there is error trapping here
		fuelCap = fc;
	}
	public void setmpg(int m)
	{
		//pretend there is error trapping here too
		mpg = m;
	}
	
	//Accessor methods -- allow us to get private variables 
	
	public int getnumPassengers()
	{
		return numPassengers;
	}
	public double getfuelCap()
	{
		return fuelCap;
	}
	public int getmpg()
	{
		return mpg;
	}

	//A method that calculates and RETURNS the range that the vehicle can travel
	//PUT METHOD HERE: getRange
	public double getRange()
	{
		double answer = fuelCap*mpg;
		return answer;
	}
	//A display method that shows the bodytype, fuelCap, and mpg of the vehicle
	public void displayInfo()
	{
		System.out.println("The max number of passengers is " + numPassengers);
		System.out.println("The vehicle's fuel capacity is " + fuelCap);
		System.out.println("The vehicle's mpg is " + mpg);
	}
	
	
}



