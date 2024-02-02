package rolling_dice;

import java.util.Random;

public class Dice 
{
    private int value;
    private Random rnd;

    public Dice() 
    {
        rnd = new Random();
        value = rnd.nextInt(6) + 1;
    }

	
	public int getValue()
	{
		return value;
	}
	
	public void roll()
	{
		
		
		value = (rnd.nextInt(6)+1);
		
	}
	
	public void roll10()
	{
		
		value = rnd.nextInt(10)+1;
		
	}
	
	
	/*
 * Roll the dice a given number of times and display the 
 * result each time
 * 
 * @param time number of rolls
 */
	public void rollDice01(int times)
	{
		System.out.println("=====================================");
		System.out.println("Roll dice " + times + " and display results");
		for(int i = 0; i < times; i++){
			// Start new line after 5 
			if((i % 5) == 0) {
				System.out.println();
			}
			Dice d = new Dice();
			d.roll();
			System.out.print(d.getValue() + "\t");
		}
		System.out.println("\nEnd of test");
		System.out.println("=====================================");
	
	
	}
	public void rollDice02(int times) 
	{
	    int lowest = 1000;
	    int highest = -1000;

	    for (int i = 0; i < times; i++) {
	    	roll();
	        int roll = getValue();
	        if (roll < lowest) {
	            lowest = roll;
	        }
	        if (roll > highest) {
	            highest = roll;
	        }
	    }

	    System.out.println();
	    System.out.println("=====================================");
	    System.out.println("After " + times + " rolls the results are");
	    System.out.println("Lowest value rolled = " + lowest);
	    System.out.println("Highest value rolled = " + highest);
	    System.out.println();
	    System.out.println("End of test");
	    System.out.println("=====================================");
	}
	
	
	
	
}
