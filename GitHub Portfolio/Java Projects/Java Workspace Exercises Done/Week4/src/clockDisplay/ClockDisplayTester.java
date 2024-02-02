package clockDisplay;
/**
 * A simple tester class to test the ClockDisplay class methods
 * @author A. Razak
 * version 12/02/2023
 */
public class ClockDisplayTester {
	
	// the main method where execution of the program starts.
	
	public static void main(String args[]){
		
		
		
	/* Exercise 1 Using the default constructor to create a clock display object.
	 * Notice what is displayed when using the default constructor. */
		
		// Creating a ClockDisplay object "clock1" using the default constructor.
		System.out.println("########### Clock 1 ###########");
		
		ClockDisplay clock1 = new ClockDisplay();// Creating a clock default constructor.
		clock1.printTime();   //printing the time.
		clock1.timeTick();  //incrementing the minutes by 1 minutes.
		clock1.printTime();   //printing the time.
		clock1.timeTick();  //incrementing the minutes by 1 minutes.
		clock1.printTime();   //printing the time.
		System.out.println("");
	/* Exercise 2 Using the parameter constructor to create a clock display object.
	 * Notice what is displayed when using the parameter constructor. */	
	
		// Creating a ClockDisplay object "clock2" using the parameter constructor.
		System.out.println("########### Clock 2 ###########");
		
		ClockDisplay clock2 = new ClockDisplay(23,59,58);
		clock2.printTime();   //printing the time.
		clock2.timeTick();  //incrementing the minutes by 1 minutes.
		clock2.printTime();   //printing the time.
		clock2.timeTick();  //incrementing the minutes by 1 minutes.
		clock2.printTime();   //printing the time.
		clock2.timeTick();  //incrementing the minutes by 1 minutes.
		clock2.printTime();   //printing the time.
		System.out.println("");
		
	/* Exercise 3 
	 * Create a third object called clock3 using parameter constructor and set time to 15:25
	 */
		System.out.println("########### Clock 3 ###########");
		ClockDisplay clock3 = new ClockDisplay(15,25,25);
		clock3.printTime();
		clock3.setTime(-5, 35, 00);
		clock3.printTime();
		clock3.setTime(11, 78, 00);
		clock3.printTime();
		clock3.setTime(11, 58, 00);
		clock3.printTime();
		System.out.println("");
		
		
		
		
	}

}
