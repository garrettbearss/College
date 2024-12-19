// Garrett Bearss
// HelloWorld.java
// Displays a few words to the screen

public class HelloWorld
{
	public static void main(String[] args)
	{
		KeyboardReader reader = new KeyboardReader();
		System.out.println("Hello world. How are you doing?");
		String name = reader.readLine("What is your name? ");
		System.out.println("Your name is " + name);
	}
}