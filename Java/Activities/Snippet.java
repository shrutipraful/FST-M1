package javaActivity4;

public class Snippet {
	public static void main(String args[])
		{
			int x = 21;
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

