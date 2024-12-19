// PetRunner
// Garrett Bearss
// A client file that uses the Pet class
 

public class PetRunner
{
	public static void main(String[] args)
	{
		KeyboardReader reader = new KeyboardReader();
		int choice, food, slap, ink, time;
		Pet Wilbert = new Pet();
		
		System.out.println("You own a Octopus named Wilbert. What would you like him to do?");		
		//Looping menu
		do
		{
			choice = reader.readInt("\n 1.  Make Wilbert eat some fish."
								   +"\n 2.  Show the pet's info."
								   +"\n 3.  Make Wilbert evade a shark."
								   +"\n 4.  Make Wilbert slap fight another Octopus."
								   +"\n 5.  Make Wilbert ink fish."
								   +"\n 6.  Mutate Wilbert."
								   +"\n 0.	Exit \n");
								   
			if (choice == 1)
			{
				food = reader.readInt("How much would you like to feed the pet? ");
				Wilbert.EatFish(food);
			}
			else if (choice == 2)
			{
				Wilbert.displayInfo();
			}
			else if (choice == 3)
			{
				Wilbert.evadePredator();
			}
			else if (choice == 4)
			{
				slap = reader.readInt("How many times should he slap the other octopuses? ");
				System.out.println("Wilbert knocked " + Wilbert.slapFight(slap) + " Octopuses out of the ring.");
			}
			else if (choice == 5)
			{
				ink = reader.readInt("How many fish should Wilbert ink? ");
				System.out.println("Wilbert blinded " + Wilbert.inkFish(ink) + " fish with its ink and inked a total of " + ink + " fish.");
			}
			else if (choice == 6)
			{
				time = reader.readInt("How long would you like Wilbert to sit by a major source of irradiated objects?(in seconds) ");
				System.out.println("Wilbert gains " + Wilbert.irradiate(time) + " tenticles from being by the objects.");
			}
		}while (choice != 0);
		
		
	}
}







		
