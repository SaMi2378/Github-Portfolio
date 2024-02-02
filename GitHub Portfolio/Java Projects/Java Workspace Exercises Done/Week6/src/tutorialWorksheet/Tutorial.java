package tutorialWorksheet;

/**
 * 
 * A simple class called Tutorial to design and inplement programs on Selection (if statement)and iteration (looping)
 * @author Abdul Razak
 * @version 1
 * 
 */
public class Tutorial
{
    private String myTutorial;
    

    /**
     * Constructor for objects of class Tutorial
     */
    public Tutorial()
    {
        // initialise instance variables
        myTutorial = "";
    }
    
   
    /**
     * Example 1
     * The following program (method) prints all even number between 0 and 40 inclisive using a while loop
     */
    public void displayEven ()  // methode header
    
    {    // start of method body
    	System.out.println("---[Even Numbers]---");        
        int number;  //declaring a variable called number of type int
        number =0;   // initiallising number to 0
        while (number <=40){   // the while loop header
            System.out.println(number);   // print statement
            number = number+2;   // increment number by 2
        }
    }   //end of method
    
    
    /**
     * Exercise 1 
     */
    public void displayOdd ()
    { 
    	System.out.println("");
    	System.out.println("---[Odd numbers from 3 to 33.]---");
        // aded code here.
        int number2;					// declaring a variable called number of type int.
        number2 = 3;					// initiallising number to 3.
        while (number2<=33)			// while loop when number less or equal than 33.
        {
        	System.out.println(number2); //print statement.
        	number2 = number2+2;   // increment number by 2.
        	
        }
    }
    
    
    /**
     * Exercise 2 
     */
    
    public void multipleOfFive()
    {
        //Add code here
    	System.out.println("");
    	System.out.println("---[Multiples of five from 20 to 85.]---");
        // aded code here.
        int number2;					// declaring a variable called number of type int.
        number2 = 20;					// initiallising number to 20.
        while (number2<=85)			// while loop when number less or equal than 85.
        {
        	System.out.println(number2); //print statement.
        	number2 = number2+5;   // increment number by 5.
        	
        }
    }
    

    
    /**
     * Exercise 3 
     */
    
    public void sum ( int a, int b)
    {
        // add code here
    	
    	System.out.println("");
    	System.out.println("---[The Sum of all numbers between A and B]---");
    
    	    int result = 0;				// declaring a variable called result of type int, and initialising it to 0.
    	    int current = a;			// declaring a variable called current of type int, and initialising it to a.

    	    while (current <= b) {		// while loop, when current will be less or equal to b.
    	        result += current;		// the system will sum the value of current to result.
    	        current++;				// and current will increase by 1.
    	    }
    	    
    	   System.out.println("The sum is: " +result);	// print out the result variable
    }
    
    
        
    
    /**
     * Exercise 4 
     */
     public void reverse (int number)
     {
         //add code here
    	 System.out.println("");				
     	System.out.println("---[The reverse of a numeber.]---");
     	
     	System.out.println("Calculating reverse of " +number);
    	 int reversed = 0;									// create a variable and initialising it to 0.

    	    while (number != 0) {							// while loop condition, when number is different than 0.
    	        int digit = number % 10;					// a variable digit of int type, will store the modulo 10 of that number.
    	        reversed = reversed * 10 + digit;			// the reversed variable will take the value of reversed * 10 + digit variable.
    	        number /= 10;								//Finally, the method divides number by 10 to "chop off" the last digit, and repeats the loop until number is 0.
    	    }
    	    
    	    System.out.println("The reverse is: " +reversed); // prints out the reversed.
    	 
     }
    /**
     * Exercise 5 
     */
    
    public void evenOrOdd (int number)
    {
        //Add code here
	    	System.out.println("");	
	    	System.out.println("---[Even or Odd]---");
    		System.out.println("NUMBER TO CHECK: " +number);
    	    if (number % 2 == 0)
    	    {
    	        System.out.println("The number "+ number+" is Even");
    	        
    	    } 
    	    else 
    	    {
    	    	System.out.println("The number "+ number+" is Odd");
    	    }
    	
        
    }
            
    
    /**
     * Exercise 6 
     */
    
    public void isLeap (int year)

    {
    	System.out.println("");	
    	System.out.println("---[Is a leap year?]---");
		System.out.println("Year to Check: " +year);
        // add code here
    	if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }
    
    
    
    /**
     * Exercise 7: challenge exercise
     */
    
    public void extractAndPrint (int number)
    {
    	System.out.println("");	
    	System.out.println("---[Number in English]---");
		System.out.println("Number --> " +number);
        //Add code here
    	// Convert the integer to a string to make it easier to iterate over the digits
        String numString = Integer.toString(number);
        
        // Define an array of strings to represent the English names of the digits
        String[] digitNames = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        // Iterate over each digit in the string and print its English name
        for (int i = 0; i < numString.length(); i++) {
            int digit = Character.getNumericValue(numString.charAt(i));
            String digitName = digitNames[digit];
            System.out.print(digitName + " ");
        }
    	
    }
    
    
    public static void main(String args[]){
    	Tutorial myTutorial = new Tutorial();
    	myTutorial.displayEven();
    	myTutorial.displayOdd();
    	myTutorial.multipleOfFive();
    	myTutorial.sum(1, 5);
    	myTutorial.reverse(1235);
    	myTutorial.evenOrOdd(5);
    	myTutorial.isLeap(1955);
    	myTutorial.extractAndPrint(632);
    }

    
}
   

