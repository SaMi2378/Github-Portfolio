package array1;

/**
 * Write a description of class ArrayPractice here.
 * 
 * @author Abdul Razak 
 * @version 1.0
 */
public class ArrayPractice
{
    // instance variables - in this class we have no fields so this
    // part is empty
    
    /**
     * Constructor for objects of class ArrayPractice
     */
    public ArrayPractice()
    {
    }

    
    /**
     * Exercise 1
     */
    public void PrintArray()
    {
        // An array of numbers
       int[] numbers = {4, 1, 22, 9, 14, 3, 9};					//create int array list called numbers, and initialising with several numbers.
       // Add code here to display the numbers
       System.out.println("---[Exercise 1 - Print Array]---");  // prints the title (optional)
       System.out.print("The list is --> [ ");
       for (int element : numbers)								// for loop to go through each number in the list and print it.
       {
    	   System.out.print(element + " ");						// prints each number on the list.
       }
       System.out.println("]");
    }
    
    
    /**
     * Exercise 2
     */
    public void smallestNumber()
    {
    // an array of numbers
    int[] numbers = {4, 1, 22, 9, 14, 3, 9};					//create int array list called numbers, and initialising with several numbers.
    // add code here to display the smallest number in the array
    System.out.println("");										// prints an empty line to separate from the last exercise
    System.out.println("---[Exercise 2 - Smallest Number]---");   // prints the title (optional)
    System.out.print("Given list: [ ");
    for (int element : numbers)									// last exercise for loop to print the given list.
    {
 	   System.out.print(element + " ");
    }
    System.out.println("]");
    
    int current = numbers[0];									// create a variable current of int type, and initialised to the first number of the list.
    for (int num: numbers)								// for in loop to go trought all the numbers of the list. We can use the iterator as well.
    {
    	
    	if (current >= num)								// if statement to compare when the current stored number is greater or equal to the current number of the list
    	{
    		current = num;								// the current variable will take the value of the current number in the list.
    	}
    	
    	
    }
    System.out.println("The smallest numbers is: "+ current);		// prints out the smallest number which is saved in the current variable.
    
    }
    
    /**
     * Exercise 3
     */
    public void largestNumber()
    {
    	// an array of numbers
    	int[] numbers = {4, 1, 22, 9, 14, 3, 9};
    	// add code here to display the largest number in the array
    	System.out.println("");										// prints an empty line to separate from the printarray
        System.out.println("---[Exercise 3 - Largest Number]---");   // prints the title (optional)
        System.out.print("Given list: [ ");
        for (int element : numbers)									// last exercise for loop to print the given list.
        {
     	   System.out.print(element + " ");
        }
        System.out.println("]");
        
        int current = numbers[0];									// create a variable current of int type, and initialised to the first number of the list.
        for (int num: numbers)								// for in loop to go trought all the numbers of the list. We can use the iterator as well.
        {
        	
        	if (current <= num)								// if statement to compare when the current stored number is lower or equal to the current number of the list
        	{
        		current = num;								// the current variable will take the value of the current number in the list.
        	}
        	
        	
        }
        System.out.println("The largest numbers is: "+ current);		// prints out the largest number which is saved in the current variable.
        
    
    
    }
    
    
    /**
     * Exercise 4
     */
    public void PrintFibonacci(){
        int[] fib = new int[20];
        fib[0] = 0;
        fib[1] = 1;
        // Add a for loop to fill the array with the sequence starting with element 2
        // Hint fib[2] = fib[1] + fib[0] and fib[3] = fib[2] + fib[1] and so on
        System.out.println("");										// prints an empty line to separate from the printarray
        System.out.println("---[Exercise 4 - Fibonacci]---");
        System.out.println("Length of the sequence: "+ fib.length); // prints an empty line to separate from the printarray
        System.out.println("fib[0] = 0");
        System.out.println("fib[1] = 1");
        for (int i = 2; i < fib.length ;  i++   )
        {
        	fib[i] = fib[i-1] + fib[i-2];
        	System.out.println("fib["+i+"] = "+ fib[i]);
        }
        
        
        
        
        // Once you have filled the array now display the numbers in the array
        // i.e. the Fibonacci sequence. If you can format the output so it looks
        // like this (hint use string concatenation.
        // fib[0] = 0
        // fib[1] = 1
        
    }
    
    
    /**
     * Exercise 5a
     * In this activity you are to calculate and display the average mark from 
     * a set of marks allocated by a tutor.
     * 
     * In this method you are to use a for loop.
     */
    public void markAnalysisFor()
    {
    	System.out.println("");										// prints an empty line to separate from the printarray
        System.out.println("---[Exercise 5a - Average Mark For loop]---");
    	float total =0;
    	int counter=0;
        float[] marks = {48.2f, 87.2f, 67.1f, 47.0f, 32.8f, 53.2f, 55.1f, 61.3f, 41.1f};
        System.out.print("The given list is: [ ");
        for (;counter < marks.length;)
        {
        	total += marks[counter];
        	counter++;
        	System.out.print(marks[counter-1]+ " ");
        }
        System.out.println("]");
        
        System.out.printf("The average mark is: "+"%.2f",(total/counter));
        
    }
        
    
    /**
     * Exercise 5b
     * In this activity you are to calculate and display the average mark from 
     * a set of marks allocated by a tutor.
     * 
     * In this method you are to use a while loop.
     */
    public void markAnalysisWhile()
    {
        float[] marks = {48.2f, 87.2f, 67.1f, 47.0f, 32.8f, 53.2f, 55.1f, 61.3f, 41.1f};
        System.out.println("");										// prints an empty line to separate from the printarray
        System.out.println("");										// prints an empty line to separate from the printarray
        System.out.println("---[Exercise 5b - Average Mark with While]---");
    	float total =0;
    	int counter=0;
        System.out.print("The given list is: [ ");
        while (counter < marks.length )
        {
        	total += marks[counter];
        	
        	counter++;
        	System.out.print(marks[counter-1]+ " ");
        }
        System.out.println("]");
        
        System.out.printf("The average mark is: "+"%.2f",(total/counter));
	}   
	
        
    
    /**
     * Exercise 5c
     * In this activity you are to calculate and display the average mark from 
     * a set of marks allocated by a tutor.
     * 
     * In this method you are to use a for-each loop.
     */
    public void markAnalysisForEach()
    {
        float[] marks = {48.2f, 87.2f, 67.1f, 47.0f, 32.8f, 53.2f, 55.1f, 61.3f, 41.1f};
        
        System.out.println("");										// prints an empty line to separate from the printarray
        System.out.println("");										// prints an empty line to separate from the printarray
        System.out.println("---[Exercise 5c - Average Mark ForEach]---");
    	float total =0;
    	int counter=0;
        System.out.print("The given list is: [ ");
        for (float element: marks)
        {
        	total += element;
        	counter++;
        	System.out.print(element+ " ");
        }
        System.out.println("]");
        
        System.out.printf("The average mark is: "+"%.2f",(total/counter));
        
    }
        
}
