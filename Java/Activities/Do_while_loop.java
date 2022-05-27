package javaActivity1;

public class Do_while_loop 
{
	public static void main(String args[])
	{
		int x = 10;
		do 
		{
			// The line will be printed even
			// if the condition is false
			System.out.println("Value of x:" + x);
			x++;
		}
		while (x < 20);
	}
}
