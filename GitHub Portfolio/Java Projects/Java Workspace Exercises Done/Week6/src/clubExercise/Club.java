package clubExercise;								// This is the package name, i usually change the package names, but by default it dont have any.

import java.util.ArrayList;						// From the java library we import the ARRAYLIST and ITERATOR.
import java.util.Iterator;

/**
 * Store details of club memberships.
 * 
 * @author (Sami Ullah) 
 * @version (05/03/2023)
 */
public class Club							// First we define the class Club
{
    // Define any necessary fields here ...
	private ArrayList<Member> membersList;		// We define the arraylist "membersList" where we are going to save the Member class details.							

	
    /**
     * Constructor for objects of class Club
     */
    public Club()								// Creating the constructor with one field
    {
        // Initialise any fields here ...
    	membersList = new ArrayList<Member>();	// Here we initialise the field MembersList
    	
    	
       
    }

    /**
     * Add a new member to the club's list of members.	
     * @param member The member object to be added.
     */	
    public void join(Member newMember)				// We create a mutator method named "join" which adds the members we 
    {												// insert, it adds them in the membersList
    	membersList.add(newMember);
    	
    	

    }
    
    /* 
     * Prints All the members who have been add in the list.
     */
    public void listMembersOfEach() 						// This method allows to print all the lines of the memberList
    {
    	for (Member element : membersList)					// First we create a Member variable called "element" which will go throughout the membersList
    	{													
    		
    		System.out.println(element.printDetails());    	// Here we tell the system to print out each element which is in the list.		
    	}
    	
    	
    }

    
    public int joinedInMonth (int month)				// "joinedInMonth" this method, it allows the system to find and print out the number of 
    {													// people who joined in the month which we enter.
    	
    	int count = 0;									// create a count which will store the total number of the members.
    	int i = 0;										// also we create another variable which will let us go through all the memberList, comparing it to the list size
    // add code here.
    	if (month > 0 && month<=12)						// first we put the condition to only insert the month to compare between 1 to 12
    	{												// if someone inserts wrong value the system will display an error.
    		
    	
    		while ((membersList.size())>=0 && i < (membersList.size()))  // here we insert a condition using .size(), and i variable. 
    		{															// the code will work when the size of the list is equal or greater than 0 and i less than the maximum size of the NumberList
    			for (Member element : membersList)						// we create a Member variable called element which will go through all the list
    			{
    				if (month == element.getMonth())					// we compare the month which we insert before with the month of the current element value.
					{
						count= count +1 ;								// if the condition is completed, then the count of the members will increase 
						i++;											// the int i variable will increase also.
					}
					else												// In case the condition is not fulfilled, only i will increase.
					{
						i++;
					}
    			}
    			
    			
    			// This statement will print the month which we check and the number of the members joined in that month.
    			System.out.println("Month to check: " +month+ " --> "  +count+ " Members joined.");  
    		}
    	
    	}	
    	else    // These lines, print out the error when a wrong value in the month variable is inserted.
    	{
    		System.out.println("Error! Wront month inserted.... Try again!");
    	}
    		return count;
    }
    		
    	


    public ArrayList<Member>removedMembers(int month, int year)	// This method removed the members joined in a given month and year
    {															// Also, it returns a ArrayList with the removed members.
    	
    	ArrayList<Member> removedboys = new ArrayList<Member>(); // we create private fields and initiate them
    	Iterator<Member> it = membersList.iterator();			// we set up the iterator which will allow us to compare the both parameters.
    	
    	if 	((1<= month && month <=12))					// first we put the condition to only insert the month to compare between 1 to 12
    													// if someone inserts wrong value the system will display an error.
    		
    	{
    		
    		System.out.println("");
    		System.out.println("---[Remove Petition]---");
    		System.out.println("Month: " + month + " ---- Year: "+ year);

    		while (it.hasNext()) 						// while the iterator which runs in all the lines of the membersList, has a next position then 
    		{
    			Member John = it.next();				// then, assign, to the new variable Member called John, the value of it.next()
    													// John will be assigned the current line of the memberList
    			if ((John.getMonth()) == month && (John.getYear())== year) // if in John's (current line of the List), month and year are equal to the month we inserted to find out. 
    			{
    				it.remove();						// then that line will be removed
    				removedboys.add(John);				// And it will be added to the new list removedboys.
    			}
    						
    		}
    				
    				
    		System.out.println("");								// After that process, the system will print out the members who has been removed, it will display a list with them.
    		System.out.println("---[Removed Members List]---");	
    		for (Member element: removedboys) 
    		{
    		
    			System.out.println(element.printDetails());	
    		}
    		System.out.println("");	
    	
    		System.out.println("---[Remaining Members List]---");	// After the removed list, the system will also print out the remaining active members list.
    		listMembersOfEach();
    	
    	}
    	else	// These lines, print out the error when a wrong value in the month variable is inserted.
    	{
    		System.out.println("");	
    		System.out.println("---[Remove Fail]---");	
    		System.out.println("Error! Wront month inserted.... Try again!");
    		
    	}
    	return removedboys;
    }
    
    
    
    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers() // this methods returns the number of members in the list.
    {    	
    	return membersList.size();        
    }
}
