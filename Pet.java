// Garrett Bearss
// Pet 
// The Pet Class -- A starter file for the final Pet Project

public class Pet
{
	// Characteristics (Variables)
	public double weight;
	public int tenticles;
	public int speed;
	public int numOfTimesInked;
	public int count;
	
	public Pet()
	{
		weight = 20;
		tenticles = 8;
		speed = 20;
		numOfTimesInked = 0;
		count = 0;
	}
	// Behaviors (Methods)
	
	// Adds to the pet's weight as it eats
	public void EatFish(int pounds)
	{
		weight = weight + pounds;
		System.out.println("Wilbert ate " + pounds + " pounds of fish.  Wilbert now weighs " + weight + " pounds.");
		count++;
	}
	
	// Shows all of the pet's characteristics
	public void displayInfo()
	{
		System.out.println("\nWILBERT'S INFO");
		System.out.println("Wilbert's Weight (in pounds): " + weight);
		System.out.println("Wilbert's Number of Tenticles: " + tenticles);
		System.out.println("Wilbert's Speed (in miles per hour): " + speed);
		System.out.println("Wilbert's Number of Times Inked: " + numOfTimesInked);
		System.out.println("Wilbert's Number of Actions done: " + count);
	}
	
	// The Octopus evades a predator
	public void evadePredator()
	{
		if(speed > 10)
		{
			System.out.println("Wilbert evaded the shark quickly using his ink and suffered no harm.");
			numOfTimesInked++;
			count++;
		}
		else if(speed <= 5 || tenticles <= 4)
		{
			System.out.println("Wilbert evaded the shark slowly but lost a tenticle.");
			tenticles--;
			speed--;
			count++;
		}
		else
		{
			System.out.println("Wilbert doesn't have enough tenticles/ speed to evade the shark. It died. Game over!");
			System.exit(0);
		}
	}
	
	// The Octopus slap fights other Octopuses
	public int slapFight(int Slap)
	{
		for(int i = 0; i <= Slap; i++)
		{
			System.out.println("Wilbert slaps the other Octopuses. SMACK!");
			count++;
		}
		if(Slap > 20)
		{
			System.out.println("Wilbert slaps the other Octopuses " + Slap + " times, knocking some of the Octopuses out of the ring.");
			System.out.println("Wilbert has also gotten faster at slapping.");
			speed++;
			return 5;
		}
		else if(Slap < 20 || Slap >= 10)
		{
			System.out.println("Wilbert slaps the other Octopuses but not enough to knock them out of the ring.");
			System.out.println("The other Octopuses slap Wilbert in the face. He gets knocked out of the ring and suffers damage to one of his tenticles.");
			System.out.println("Wilbert's tenticle had to be removed.");
			tenticles--;
			if(tenticles == 0)
			{
				System.out.println("Wilbert has lost all of his tenticles and can no longer swim. He floats to the bottom of the ocean and rots.");
				System.exit(0);
			}
			return 0;
		}
		else if(Slap <= 0)
		{
			System.out.println("Wilbert can't fight in the Slap Fight if it doesn't slap anything.");
			return 0;
		}
		else
		{
			return 0;
		}
		
	}
	
	// Make your Octopus ink other fish
	public int inkFish(int fish)
	{
		for(int i = 0; i <= fish; i++)
		{
			System.out.println("Wilbert inks a nearby fish. SPLOOSH!");
			count++;
		}
		if(fish > 10)
		{
			System.out.println("Wilbert inked a lot of fish. This angered the nearby sharks, attracting them to you. They rip off one of Wilbet's tenticles.");
			tenticles--;
			if(tenticles == 0)
			{
				System.out.println("Wilbert has lost all of his tenticles and can no longer swim. He floats to the bottom of the ocean and rots.");
				System.exit(0);
			}				
			return fish/4;
		}
		else if(fish <= 10 && fish > 0)
		{
			System.out.println("Wilbert inked a small amount of fish, the nearby fish don't seem to like you very much.");
			return fish/2;		
		}
		else if(fish <= 0)		
		{
			System.out.println("Wilbert doesn't ink any fish. He seems very dissapointed in you.");
			return 0;
		}
		else
		{
			return 0;
		}
	}
	
	//Make the Octopus sit by a bunch of radiated materials to regen his tenticles
	public int irradiate(int seconds)
	{
		if(seconds <= 0)
		{
			System.out.println("Wilbert doesn't go near the objects under your command.");
			return 0;
		}
		else if(seconds >= 0 && seconds < 400)
		{
			System.out.println("Wilbert goes near the objects for a little bit.");
			int radiation = (int)(10*Math.random());
			if(radiation <= 6)
			{
				System.out.println("Wilbert gets sick from sitting next to the irradiated objects for too long. He dies from too much radiation. You are a bad owner!");
				System.exit(0);
			}
			tenticles = radiation + tenticles;
			count++;
			return radiation;
		}
		else
		{
			System.out.println("Wilbert goes near the objects for a longer time.");
			int radiation = (int)(20*Math.random());
			if(radiation <= 12)
			{
				System.out.println("Wilbert gets sick from sitting next to the irradiated objects for too long. He dies from too much radiation. You are a bad owner!");
				System.exit(0);
			}
			tenticles = radiation + tenticles;
			count++;
			return radiation;
		}
		
	}
}