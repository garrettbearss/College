// AnimalListRunner.java
// Garrett Bearss
// Tests the AnimalList class

public class AnimalListRunner
{
	public static void main(String[] args)
	{
		// Handle add first case
		// Handle null case
		// Handle add anywhere case
		// Handle int case
		// Handle double case
		KeyboardReader reader = new KeyboardReader();
		int selection = 0;
		AnimalList Garrett = new AnimalList();
		while(selection != 13) //Keeps running till exit
		{
			System.out.println("\nWelcome to my menu. Please select from the following options: \n");
			System.out.println("		1. (Test addAnimal) \n");
			System.out.println("		2. (Test removeAnimal) \n");
			System.out.println("		3. (Test displayList) \n");
            System.out.println("		4. (Test getnumAddRemove) \n");
			System.out.println("		5. (Test addAnimal) [ints] \n");
			System.out.println("		6. (Test removeAnimal) [ints] \n");
			System.out.println("		7. (Test addAnimal) [doubles] \n");
			System.out.println("		8. (Test removeAnimal) [doubles] \n");
            System.out.println("		9. (Test addAnimal) [Intergers] \n");
            System.out.println("		10. (Test removeAnimal) [Intergers] \n");
            System.out.println("		11. (Test addAnimal) [Doubles] \n");
            System.out.println("		12. (Test removeAnimal) [Doubles] \n");
            System.out.println("		13. (Exit)");
			selection = reader.readInt("Enter your selection (1-13): ");
			System.out.println("\n");
			switch(selection)
			{
				case 1:// Tests the addAnimal
						String word1 = "Garrett";
						String word2 = "Gabe";
						String word3 = "Bearss";
						String word4 = "Zach";
						Garrett.addAnimal(word1);
						Garrett.addAnimal(word2);
						Garrett.addAnimal(word3);
						Garrett.addAnimal(word4);
						break;
				case 2:// Tests the removeAnimal
						String word5 = "Garrett";
						String word6 = "Gabe";
						String word7 = "Bearss";
						String word9 = "Bearss";
						String word8 = "Zach";
						Garrett.addAnimal(word5);
						Garrett.addAnimal(word8);
						Garrett.addAnimal(word7);
						Garrett.addAnimal(word6);
						Garrett.addAnimal(word9);
						System.out.println(Garrett.removeAnimal(word8));
						break;
				case 3:// Tests the displayList
						Garrett.displayList();
						break;
				case 4:// Tests the getnumAddRemove
						System.out.println(Garrett.getnumAddRemove());
						break;
                case 5:// Tests ints instead of Strings
                        int one = 1;
                        int two = 2;
                        int three = 3;
                        int random = (int)(Math.random()*100);
                        int zero = 0;
                        Garrett.addAnimal(one);
                        Garrett.addAnimal(two);
                        Garrett.addAnimal(three);
                        Garrett.addAnimal(random);
                        Garrett.addAnimal(zero);
                        break;
                case 6:
                		int one2 = 1;
                        int two2 = 2;
                        int three2 = 3;
                        int random2 = (int)(Math.random()*100);
                        int zero2 = 0;
                        Garrett.addAnimal(one2);
                        Garrett.addAnimal(two2);
                        Garrett.addAnimal(three2);
                        Garrett.addAnimal(random2);
                        Garrett.addAnimal(zero2);
                        System.out.println(Garrett.removeAnimal(three2));
                        break;
                case 7:
                		double half = 0.5;
                		double thrid = 0.33;
                		double fourth = 0.25;
                		double random3 = Math.random()*100;
                		Garrett.addAnimal(half);
                		Garrett.addAnimal(thrid);
                		Garrett.addAnimal(fourth);
                		Garrett.addAnimal(random3);
                		break;
                case 8:
                		double half2 = 0.5;
                		double thrid2 = 0.33;
                		double fourth2 = 0.25;
                		double tenth2 = 0.10; 
                		double random4 = Math.random()*100;
                		Garrett.addAnimal(half2);
                		Garrett.addAnimal(tenth2);
                		Garrett.addAnimal(thrid2);
                		Garrett.addAnimal(fourth2);
                		Garrett.addAnimal(random4);
                		System.out.println(Garrett.removeAnimal(tenth2));
                		System.out.println(Garrett.removeAnimal(0.10));
                		break;
                case 9:
                        Integer one3 = new Integer(1);
                        Integer two3 = new Integer(2);
                        Integer three3 = new Integer(3);
                        Integer random5 = new Integer((int)(Math.random()*100));
                        Integer zero3 = new Integer(0);
                        Garrett.addAnimal(one3);
                        Garrett.addAnimal(two3);
                        Garrett.addAnimal(three3);
                        Garrett.addAnimal(random5);
                        Garrett.addAnimal(zero3);
                        break;
                case 10:
                        Integer one4 = new Integer(1);
                        Integer two4 = new Integer(2);
                        Integer three4 = new Integer(3);
                        Integer random6 = new Integer((int)(Math.random()*100));
                        Integer zero4 = new Integer(0);
                        Garrett.addAnimal(one4);
                        Garrett.addAnimal(two4);
                        Garrett.addAnimal(three4);
                        Garrett.addAnimal(random6);
                        Garrett.addAnimal(zero4);
                        System.out.println(Garrett.removeAnimal(three4));
                        break;
                case 11:
                        Double half3 = new Double(0.5);
                        Double third3 = new Double(0.33);
                        Double fourth3 = new Double(0.25);
                        Double tenth3 = new Double(0.10);
                        Double random7 = new Double(Math.random()*100);
                        Garrett.addAnimal(half3);
                		Garrett.addAnimal(tenth3);
                		Garrett.addAnimal(third3);
                		Garrett.addAnimal(fourth3);
                		Garrett.addAnimal(random7);
                		System.out.println(Garrett.removeAnimal(tenth3));
                        break;
                case 12:
                        Double half4 = new Double(0.5);
                        Double third4 = new Double(0.33);
                        Double fourth4 = new Double(0.25);
                        Double tenth4 = new Double(0.10);
                        Double random8 = new Double(Math.random()*100);
                        Garrett.addAnimal(half4);
                		Garrett.addAnimal(tenth4);
                		Garrett.addAnimal(third4);
                		Garrett.addAnimal(fourth4);
                		Garrett.addAnimal(random8);
                        System.out.println(Garrett.removeAnimal(tenth4));
                        System.out.println(Garrett.removeAnimal(0.10));
                        break;
				case 101:
						System.out.println("Have a nice day!");
						System.exit(0);//Ends program
				default:
					System.out.println("Invalid input, please try again!"); 
					break;
			}
		
		}
	}
}