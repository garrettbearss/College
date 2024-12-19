/// 2019
/// 2019
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.UnboundedGrid;
// SpecialCritterRunner_McKeenTestCase2019
// McKeen
/// You must comment out all of the Critters that you DO NOT want to have tested

import info.gridworld.grid.Location;


import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Actor;

import java.awt.Color;

import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpecialCritterRunner_McKeenTestCase2019
{
    public static void main(String[] args)
    {

    	Scanner reader = new Scanner(System.in);
        int choice;
        ActorWorld world;

		do
		{
		
		System.out.println("#############################################");
		System.out.println("Special Critter test cases                              Click here to start.\n"+
								"1. DonkeyKritter in a 1X9 with 2 victims\n"+
								"2. DonkeyKritter in a 9X9 with 4 corner victims\n"+
								"3. <RESIZE WINDOW> DonkeyKritter in a 21x21 battle each other\n"+
								"4. DonkeyKritter vs Bug\n"+
								"5. DonkeyKritter in Unbounded\n"+
									
								"10. Pokemon in 2x8 collects Critters and battles\n"+
								"11. Pokemon in 2x8 doesn't collect non-Critters\n"+
								"12. Pokemon Red 4+ Yellow 5 > Green 8 -- Red kills Yellow then Green\n"+
								"13. Pokemon Gotta Catch Em All - clears the screen - 0 or 1 left\n"+
								"14. Pokemon all die :(\n"+
									
								"20. Medusa(2) in 1X5 with 1 victim\n"+
								"21. Medusa(5) in 1X5 with protected victim\n"+
								"22. Medusa(0) in 20X1 with 2 victims\n"+
								"23. Medusa(2) in 10X10 with 2 rings of critters -- inner ring dies\n"+
									
								"30. WesleyCritter falls asleep and dies\n"+
								"31. 3 WesleyCritters in 3X6 keep waking up \n"+
								"32. 3 WesleyCritters in 7X5 eventually die\n"+
								"33. <RESIZE WINDOW> Many WesleyCritters in 20X20 eat all the flowers and eventually die\n"+
									

								"40. RodenbucherCritter gets 1 phone\n"+
								"41. RodenbucherCritter takes 1 phone from 2 critters\n"+
								"42. RodenbucherCritter with corner victims\n"+
								"43. RodenbucherCritter takes hall of phones\n"+
									
								"50. MarioCritter eats flowers and shoots\n"+
								"51. MarioCritter in 9X1 - FireRocks collide then one MC dies \n"+
								"52. <RESIZE WINDOW> MarioCritters eat all of the Flowers and shoot each other \n"+
									
								"\n60. Combined -- Must comment out any critters that don't exist \n"+

								"\n99. Exit");
		System.out.print("Please select a testing option: ");
		choice = reader.nextInt();

			// Hack++ from Landon Smith
			// Closes all open Window objects (but not the terminal window)
			for (Frame f : Frame.getFrames()) {
				f.dispose();
			}

////DonkeyKritter ##########################################################################################    
////DonkeyKritter ##########################################################################################    
	    if (choice == 1) 
        {
		   	world = new ActorWorld(new BoundedGrid(1,9));
    		DonkeyKritter d1 = new DonkeyKritter();
    		    			
  			world.add(new Location(0,4), d1);
  			world.add(new Location(0,0), new DumbCritter());
  			world.add(new Location(0,8), new DumbCritter());
	
 			world.show();
         }
 	    if (choice == 2) 
        {
		   	world = new ActorWorld(new BoundedGrid(9,9));
    		DonkeyKritter d1 = new DonkeyKritter();
    		    			
  			world.add(new Location(4,4), d1);
  			world.add(new Location(1,1), new DumbCritter());
  			world.add(new Location(1,7), new DumbCritter());
  			world.add(new Location(7,1), new DumbCritter());
  			world.add(new Location(7,7), new DumbCritter());
  			world.add(new Location(1,4), new DumbCritter());
  			world.add(new Location(4,1), new DumbCritter());
  			world.add(new Location(7,4), new DumbCritter());
  			world.add(new Location(4,7), new DumbCritter());
	
 			world.show();
         } 			
         	
 	    if (choice == 3) 
        {
		   	world = new ActorWorld(new BoundedGrid(21,21));
    		DonkeyKritter d1 = new DonkeyKritter();
    		    			
  			world.add(new Location(0,0), new DonkeyKritter());
  			world.add(new Location(0,4), new DonkeyKritter());
  			world.add(new Location(0,8), new DonkeyKritter());
  			world.add(new Location(0,12), new DonkeyKritter());
  			world.add(new Location(0,16), new DonkeyKritter());
  			world.add(new Location(0,20), new DonkeyKritter());

  			world.add(new Location(20,0), new DonkeyKritter());
  			world.add(new Location(20,4), new DonkeyKritter());
  			world.add(new Location(20,8), new DonkeyKritter());
  			world.add(new Location(20,12), new DonkeyKritter());
  			world.add(new Location(20,16), new DonkeyKritter());
  			world.add(new Location(20,20), new DonkeyKritter());

  			world.add(new Location(4,0), new DonkeyKritter());
  			world.add(new Location(8,0), new DonkeyKritter());
  			world.add(new Location(12,0), new DonkeyKritter());
  			world.add(new Location(16,0), new DonkeyKritter());

  			world.add(new Location(4,20), new DonkeyKritter());
  			world.add(new Location(8,20), new DonkeyKritter());
  			world.add(new Location(12,20), new DonkeyKritter());
  			world.add(new Location(16,20), new DonkeyKritter());

   			for (int i = 7; i<=13; i++)
   				for (int j = 7; j<=13; j++)
   				{
 					if((i+j)%2==1)
 						world.add(new Location(i,j), new DumbCritter());
   					else
  						world.add(new Location(i,j), new Flower());
  								
   				}


	
 			world.show();
         } 	
 	    if (choice == 4) 
        {
		   	world = new ActorWorld(new BoundedGrid(9,9));
    		DonkeyKritter d1 = new DonkeyKritter();
    		    			
  			world.add(new Location(4,4), d1);
  			world.add(new Location(6,0), new Bug());
			
	
 			world.show();
         } 	
	    if (choice == 5) 
        {
			world = new ActorWorld(new UnboundedGrid());
   			
   			int size = 7;
			int r1=0;
			int r3=24;
			
   			for (int i = 1; i<=size; i++)
			{
				world.add(new Location(r1,12), new DumbCritter());   // vertical
				world.add(new Location(r1,r1), new DumbCritter());  // top left to bottom right
				world.add(new Location(12,r1), new DumbCritter());	// horizontal
				world.add(new Location(r3,r1), new DumbCritter());
				r1+=4;
				r3-=4; 
				
			}
			
  			world.add(new Location(12,12), new DonkeyKritter());
 
			world.show();	  
        }  
//// PokemonMasterCritter ##########################################################################################    
//// PokemonMasterCritter ##########################################################################################    

	    /*if (choice == 10) 
        {
			world = new ActorWorld(new BoundedGrid(2,8));
   			
   			PokemonMasterCritter p1 = new PokemonMasterCritter();
   			world.add(new Location(1,1), p1);

   			PokemonMasterCritter p2 = new PokemonMasterCritter();
   			p2.setColor(Color.GREEN);
   			world.add(new Location(1,6), p2);

   			// Give 3 to the left, 2 to the right
   			world.add(new Location(0,0), new DumbCritter());
   			world.add(new Location(0,1), new DumbCritter());
   			world.add(new Location(1,0), new DumbCritter());
   			world.add(new Location(1,7), new DumbCritter());
   			world.add(new Location(0,7), new DumbCritter());

			world.show();	  
        }
	    if (choice == 11) 
        {
			world = new ActorWorld(new BoundedGrid(2,8));
   			
   			PokemonMasterCritter p1 = new PokemonMasterCritter();
   			world.add(new Location(0,1), p1);

   			PokemonMasterCritter p2 = new PokemonMasterCritter();
   			p2.setColor(Color.GREEN);
   			world.add(new Location(0,6), p2);

   			// Give 3 to the left, 2 to the right
   			world.add(new Location(1,0), new Rock());
   			world.add(new Location(1,1), new Flower());
   			world.add(new Location(0,0), new DumbCritter());
   			world.add(new Location(0,7), new Rock());
   			world.add(new Location(1,7), new Flower());
   			world.add(new Location(1,6), new Flower());
   			world.add(new Location(1,5), new Flower());

			world.show();	  
        }
	    if (choice == 12) 
        {
			world = new ActorWorld(new BoundedGrid(6,8));
   			
   			PokemonMasterCritter p1 = new PokemonMasterCritter();
   			world.add(new Location(1,1), p1);

   			PokemonMasterCritter p2 = new PokemonMasterCritter();
   			p2.setColor(Color.YELLOW);
   			world.add(new Location(1,4), p2);

   			PokemonMasterCritter p3 = new PokemonMasterCritter();
   			p3.setColor(Color.GREEN);
   			world.add(new Location(4,1), p3);

   			// Give 5 to the red, 4 to the blue, 8 to the yellow
  			world.add(new Location(0,0), new DumbCritter());
  			world.add(new Location(0,1), new DumbCritter());
  			world.add(new Location(0,2), new DumbCritter());
  			world.add(new Location(1,0), new DumbCritter());
  			world.add(new Location(1,2), new DumbCritter());

  			world.add(new Location(1,3), new DumbCritter());
  			world.add(new Location(0,3), new DumbCritter());
  			world.add(new Location(0,4), new DumbCritter());
  			world.add(new Location(0,5), new DumbCritter());

  			world.add(new Location(3,0), new DumbCritter());
  			world.add(new Location(3,1), new DumbCritter());
  			world.add(new Location(3,2), new DumbCritter());
  			world.add(new Location(4,0), new DumbCritter());
  			world.add(new Location(4,2), new DumbCritter());
  			world.add(new Location(5,0), new DumbCritter());
  			world.add(new Location(5,1), new DumbCritter());
  			world.add(new Location(5,2), new DumbCritter());

			for(int i = 0; i<=7; i++)
   				world.add(new Location(2,i), new Rock());
			

			world.show();	  
        }

	    if (choice == 13) 
        {
			world = new ActorWorld(new BoundedGrid(10, 10));
   			
   			for (int i = 0; i<=9; i++)
   				for (int j = 0; j<=9; j++)
 					world.add(new Location(i,j), new DumbCritter());
   					
   			PokemonMasterCritter p1 = new PokemonMasterCritter();
   			world.add(new Location(0,0), p1);
 
			world.show();	  
        }
  
	    if (choice == 14) 
        {
			world = new ActorWorld(new BoundedGrid(10, 10));
   			
   			for (int i = 0; i<=9; i++)
   				for (int j = 0; j<=9; j++)
   				{
   					if(i%2 == 0 && j%2 == 1)
 						world.add(new Location(i,j), new PokemonMasterCritter());
   				}

 
			world.show();	  
        }         
//// MedusaCritter ##########################################################################################    
//// MedusaCritter ##########################################################################################    
	   
	    if (choice == 20) 
        {
			world = new ActorWorld(new BoundedGrid(1,5));
   			
   			MedusaCritter m1 = new MedusaCritter(2);
   			world.add(new Location(0,0), m1);
   			
   			DumbCritter d1 = new DumbCritter();
   			d1.setDirection(270);
   			world.add(new Location(0,4), d1);

			world.show();	  
        }
	    if (choice == 21) 
        {
			world = new ActorWorld(new BoundedGrid(1,5));
   			
   			MedusaCritter m1 = new MedusaCritter(5);
   			world.add(new Location(0,0), m1);
 
 			Rock r1 = new Rock();
 			r1.setDirection(270);
 			world.add(new Location(0,3), r1);
   			
   			DumbCritter d1 = new DumbCritter();
   			d1.setDirection(270);
   			world.add(new Location(0,4), d1);

			world.show();	  
        }
	    if (choice == 22) 
        {
			world = new ActorWorld(new BoundedGrid(8,1));
   			
   			MedusaCritter m1 = new MedusaCritter(0);
   			world.add(new Location(4,0), m1);
   			
   			DumbCritter d1 = new DumbCritter();
   			d1.setDirection(180);
   			world.add(new Location(0,0), d1);
   			DumbCritter d2 = new DumbCritter();
   			d2.setDirection(0);
   			world.add(new Location(7,0), d2);

			world.show(); 
        }	
	    if (choice == 23) 
        {
			world = new ActorWorld(new BoundedGrid(10,10));
   			MedusaCritter m1;
   			
   			m1 = new MedusaCritter(2); //inner
   			m1.setDirection(90);
   			world.add(new Location(4,5), m1);

			//outer
   			m1 = new MedusaCritter(10); //inner
   			m1.setDirection(45);
   			world.add(new Location(0,0), m1);
   			m1 = new MedusaCritter(10); //inner
   			m1.setDirection(225);
   			world.add(new Location(0,9), m1);
   			m1 = new MedusaCritter(10); //inner
   			m1.setDirection(45);
   			world.add(new Location(9,0), m1);
   			m1 = new MedusaCritter(10); //inner
   			m1.setDirection(315);
   			world.add(new Location(9,9), m1);

   			
   			for (int i = 0; i <=7; i++)  //Top outer row facing south
   			{
    			DumbCritter d1 = new DumbCritter();
   				d1.setDirection(180);
  	   			world.add(new Location(1,i+1), d1);
   			}
   			for (int i = 1; i <=7; i++)  //Bottom outer row facing north
   			{
     			DumbCritter d1 = new DumbCritter();
   				d1.setDirection(0);
  	   			world.add(new Location(8,i+1), d1);
   			}
    		for (int i = 3; i <=6; i++)  //Top inner row facing south
   			{
    			DumbCritter d1 = new DumbCritter();
   				d1.setDirection(180);
  	   			world.add(new Location(2,i), d1);
   			}
   			for (int i = 3; i <=6; i++)  //Bottom inner row facing north
   			{
     			DumbCritter d1 = new DumbCritter();
   				d1.setDirection(0);
  	   			world.add(new Location(7,i), d1);
   			}
   			
   			for (int i = 0; i <7; i++)  //left outer row facing east
   			{
     			DumbCritter d1 = new DumbCritter();
   				d1.setDirection(90);
 	   			world.add(new Location(2+i,1), d1);
   			}
  			for (int i = 0; i <7; i++)  //right outer row facing west
   			{
    			DumbCritter d1 = new DumbCritter();
   				d1.setDirection(270);
  	   			world.add(new Location(2+i,8), d1);
   			}
   			for (int i = 3; i <=6; i++)  //left inner row facing east
   			{
     			DumbCritter d1 = new DumbCritter();
   				d1.setDirection(90);
 	   			world.add(new Location(i,2), d1);
   			}
  			for (int i = 3; i <=6; i++)  //right outer row facing west
   			{
    			DumbCritter d1 = new DumbCritter();
   				d1.setDirection(270);
  	   			world.add(new Location(i,7), d1);
   			}
			DumbCritter d1;
   			d1 = new DumbCritter();
			d1.setDirection(135);
   			world.add(new Location(1,1), d1);
    		d1 = new DumbCritter();
			d1.setDirection(135);
   			world.add(new Location(2,2), d1);
   			d1 = new DumbCritter();
			d1.setDirection(225);
   			world.add(new Location(1,8), d1);
    		d1 = new DumbCritter();
			d1.setDirection(225);
   			world.add(new Location(2,7), d1);
   			d1 = new DumbCritter();
			d1.setDirection(315);
   			world.add(new Location(7,7), d1);
    		d1 = new DumbCritter();
			d1.setDirection(315);
   			world.add(new Location(8,8), d1);
   			d1 = new DumbCritter();
			d1.setDirection(45);
   			world.add(new Location(8,1), d1);
    		d1 = new DumbCritter();
			d1.setDirection(45);
   			world.add(new Location(7,2), d1);
	
			world.show();	  
        }

//// WesleyCritter ##########################################################################################    
//// WesleyCritter ##########################################################################################    

	    if (choice == 30) 
        {
		   	world = new ActorWorld(new BoundedGrid(3,3));
    		WesleyCritter w = new WesleyCritter(2);

  			world.add(new Location(1,1), w);
   			
   			world.add(new Location(0,1), new Rock());    		   			
   			world.add(new Location(2,1), new Rock());
	
			world.show();	  
        }
	    if (choice == 31) 
        {
		   	world = new ActorWorld(new BoundedGrid(3,6));
    		WesleyCritter w1 = new WesleyCritter(1);
    		WesleyCritter w2 = new WesleyCritter(1);
   			WesleyCritter w3 = new WesleyCritter(1);

			for (int c = 0; c <= 5; c++) // two rows: rocks and N-facing DumbCritters
			{
   				world.add(new Location(0,c), new Rock());    		   			
   				world.add(new Location(2,c), new DumbCritter());    		   			
 				
			}   			
  			world.add(new Location(1,0), w1);
  			world.add(new Location(1,2), w2);
  			world.add(new Location(1,4), w3);
 	
			world.show();	  
        }
        if (choice == 32) 
        {
		   	world = new ActorWorld(new BoundedGrid(7,5));
    		WesleyCritter w1 = new WesleyCritter(1);
    		WesleyCritter w2 = new WesleyCritter(1);
    		WesleyCritter w3 = new WesleyCritter(1000);

			for (int r = 0; r <= 6; r++) // two columns of rocks to separate wesleys
			{
   				world.add(new Location(r,1), new Rock());    		   			
   				world.add(new Location(r,3), new Rock());    		   			
   				world.add(new Location(r,4), new Flower());    		   			
				
			}   			
  			world.add(new Location(3,0), w1);
  			world.add(new Location(3,2), w2);
  			world.add(new Location(3,4), w3);
 	
			world.show();	  
        }
	    if (choice == 33) 
        {
			world = new ActorWorld(new BoundedGrid(21, 21));
   			
   			for (int i = 0; i<=20; i++)
   				for (int j = 0; j<=20; j++)
   				{
 					if (i%5==0 && j%5 == 0)
 	 					world.add(new Location(i,j), new WesleyCritter(1));
					else
 						world.add(new Location(i,j), new Flower());
   					
   				}
   					
			world.show();	  
        }*/

//// RodenbucherCritter ##########################################################################################    
//// RodenbucherCritter ##########################################################################################    

	    if (choice == 40) 
        {
		   	world = new ActorWorld(new BoundedGrid(5,8));
    		RodenbucherCritter r = new RodenbucherCritter();

  			world.add(new Location(2,2), r);
   			
 	
			for(int i = 0; i <= 4; i++)
			{
				if (i != 2)
				{
					for(int j = 3; j <= 7; j++)
					{
						Rock phone = new Rock();
						world.add(new Location(i, j), phone);
					}
				}
			}
  			world.add(new Location(2,0), new Rock());
  			world.add(new Location(2,1), new Rock());
  			world.add(new Location(1,0), new Rock());
  			world.add(new Location(1,1), new Rock());
  			world.add(new Location(1,2), new Rock());
  			world.add(new Location(3,0), new Rock());
  			world.add(new Location(3,1), new Rock());
  			world.add(new Location(3,2), new Rock());
  			
  			world.add(new Location(2,5), new DumbCritter());
			world.show();	  
        }	
 	    if (choice == 41) 
        {
		   	world = new ActorWorld(new BoundedGrid(2,6));
 
    		RodenbucherCritter d1 = new RodenbucherCritter();
  			world.add(new Location(0,0), d1);
 
  			world.add(new Location(1,4), new DumbCritter());
  			world.add(new Location(0,4), new DumbCritter());
 
  			world.add(new Location(0,5), new Rock());

 			world.show();
        }
   	    if (choice == 42) 
        {
		   	world = new ActorWorld(new BoundedGrid(9,9));
 
    		RodenbucherCritter d1 = new RodenbucherCritter();
  			world.add(new Location(4,4), d1);
 
  			world.add(new Location(1,1), new DumbCritter());
  			world.add(new Location(7,7), new DumbCritter());
  			world.add(new Location(1,7), new DumbCritter());
  			world.add(new Location(7,1), new DumbCritter());

  			world.add(new Location(3,3), new Rock());  // center rocks
  			world.add(new Location(3,5), new Rock());
  			world.add(new Location(5,3), new Rock());
  			world.add(new Location(5,5), new Rock());

  			world.add(new Location(0,0), new Flower());
  			world.add(new Location(0,1), new Rock());

  			world.add(new Location(0,7), new Rock());
  			world.add(new Location(0,8), new Flower());

  			world.add(new Location(8,8), new Flower());
  			world.add(new Location(7,8), new Rock());

  			world.add(new Location(8,0), new Flower());
  			world.add(new Location(8,1), new Rock());
	
 			world.show();
         } 			
   	    if (choice == 43) 
        {
		   	world = new ActorWorld(new BoundedGrid(5,10));
 
    		RodenbucherCritter d1 = new RodenbucherCritter();
  			world.add(new Location(2,0), d1);
 
 			for (int i = 0; i<=9; i++)
 			{
 				if(i%2==1)
 				{
   					world.add(new Location(1,i), new Flower());					
   					world.add(new Location(3,i), new Flower());					
 				}
 				else
 				{
   					world.add(new Location(1,i), new DumbCritter());					
   					world.add(new Location(3,i), new DumbCritter());					
 					
 				}
   				world.add(new Location(0,i), new Rock());					
				world.add(new Location(4,i), new Rock());					
 			}

	
 			world.show();
         } 			

//// MarioCritter ##########################################################################################    
//// MarioCritter ##########################################################################################    
	   
	    /*if (choice == 50) 
        {
			world = new ActorWorld(new BoundedGrid(9,9));
   			
   			MarioCritter m1 = new MarioCritter();
   			world.add(new Location(4,4), m1);
   			
   			world.add(new Location(0,4), new DumbCritter());
   			world.add(new Location(8,4), new DumbCritter());
   			world.add(new Location(4,0), new DumbCritter());
   			world.add(new Location(4,8), new DumbCritter());

			world.add(new Location(4,5), new Flower());
			
			world.show();	  
        }
 	    if (choice == 51) 
        {
			world = new ActorWorld(new BoundedGrid(9,1));
   			
   			MarioCritter m1 = new MarioCritter();
   			MarioCritter m2 = new MarioCritter();
   			world.add(new Location(1,0), m1);
   			world.add(new Location(7,0), m2);
   			
   			world.add(new Location(0,0), new Flower());
   			world.add(new Location(8,0), new Flower());
			
			world.show();	  
        }     	       
	    if (choice == 52) 
        {
			int size = 21;
			world = new ActorWorld(new BoundedGrid(size,size));
   			
   			for (int i=0; i < size; i++)
   			{
   				for (int j = 0; j< size; j++)
   				{
   					if (i%5 == 0 && j%5 == 0)
   					{
     					world.add(new Location(i,j), new MarioCritter()); 						
   					}
   					else
   					{
      					world.add(new Location(i,j), new Flower()); 									
   					}
   				}	
   			}
			world.show();	  
        }

//Multiple Critter Test Case ##########################################################################################    	        	
//Multiple Critter Test Case ##########################################################################################   	        	
       	
	    */if (choice == 60) 
        {
			world = new ActorWorld(new BoundedGrid(10,10));

		//*********************************************************   			   			
		//IMPORTANT:  Comment out all of the Critters that are not completed:

	  		world.add(new Location(0,0), new DonkeyKritter());
	  		world.add(new Location(0,9), new DonkeyKritter());
   			
//   			world.add(new Location(1,3), new PokemonMasterCritter());
//   			world.add(new Location(2,8), new PokemonMasterCritter());
//   			
//   			world.add(new Location(4,0), new MedusaCritter(5));
//   			world.add(new Location(3,7), new MedusaCritter(5));
   			world.add(new Location(3,9), new Rock());   			

   			world.add(new Location(7,1), new Rock());
   			world.add(new Location(7,2), new Rock());
//   			world.add(new Location(7,3), new WesleyCritter(10));
//   			world.add(new Location(7,9), new WesleyCritter(10));
  			   			
   			world.add(new Location(7,7), new RodenbucherCritter());
   			world.add(new Location(9,3), new RodenbucherCritter());
//
//   			world.add(new Location(3,2), new MarioCritter());
//   			world.add(new Location(9,0), new MarioCritter());
   			world.add(new Location(8,0), new Flower());
   			world.add(new Location(7,0), new Flower());
   			world.add(new Location(6,1), new Flower());
   			world.add(new Location(5,1), new Flower());
   			world.add(new Location(7,4), new Flower());

			DumbCritter d1 = new DumbCritter();
  			world.add(new Location(4,5), d1);
  			d1 = new DumbCritter();
			world.add(new Location(6,8), d1);
  			d1 = new DumbCritter();
			world.add(new Location(5,2), d1);
   			d1 = new DumbCritter();
			world.add(new Location(1,6), d1);

			world.show();
        }

//*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Do NOT delete or comment out these lines:

		}while(choice != 99);
		
		System.out.println("Thanksgiving was only a few weeks ago.");
		System.out.println("Mr. McKeen is thankful that he gets to work with smart, motivated people like YOU!");
		System.out.println("He hopes that you have a fun, safe, restful winter break!\n\n");
		System.out.println("Good luck on Midterms!\n\n");
		
		System.exit(0);
    
    }
}