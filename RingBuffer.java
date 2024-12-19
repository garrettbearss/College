// RingBuffer.java
// Garrett Bearss
// The RingBuffer class

public class RingBuffer
{
	private int front;
	private int rear;
	private char[] characters;
	
	public RingBuffer(int capacity)// Constructor
    {
        characters = new char[capacity +1];
        front = 0;
        rear = 0;
    }
    
    boolean isEmpty()
    {
        if(rear == front)// If no values have been added or flushed
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    void flush()// Sets front to rear
    {
        front = rear;
    }
    
    boolean add(char ch)// Adds a character to the array
    {
        if((rear-front) == characters.length-1)// If the array is full
        {
            return false;
        }
        else if((front-rear) == 1)// If the array is full
        {
            return false;
        }
        else// If array isn't full
        {
            characters[rear] = ch;
            if((rear + 1) == characters.length)// If the rear would go out of bounds
            {
                rear = 0;
            }
            else
            {
                rear++;
            }
            return true;
        }
    }
    
    char remove()// Removes a character from the array
    {
        if(front == rear)// If there is nothing in the array
        {
            return ' ';
        }
        else// If there is something in the array
        {
            char value = characters[front];
            if((front + 1) == characters.length)// If the front would go out of bounds
            {
                front = 0;
            }
            else
            {
                front++;
            }
            return value;
        }
    }
    
    char peek()// Gets front's value
    {
        if(front == rear)// If there is nothing in the array
        {
            return '!';
        }
        else// If there is something in the array
        {
            return characters[front];
        }
    }
    
    int getFront()// Returns front
    {
        return front;
    }
    
    int getRear()// Returns rear
    {
        return rear;
    }
}