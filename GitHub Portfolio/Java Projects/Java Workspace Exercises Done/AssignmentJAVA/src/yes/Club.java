package yes;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Store details of club memberships.
 * 
 * @author (Sami Ullah) 
 * @version (05/03/2023)
 */
public class Club
{
    // Define any necessary fields here ...
	private ArrayList<Member> membersList;
//	private ArrayList<Integer> monthList;
	
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
    	membersList = new ArrayList<Member>();
    	
    	
       
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Member newMember)
    {
    	membersList.add(newMember);
    	
//    	monthList.add(newMember.getMonth());

    }
        /* 
     * Prints All the members who have been add in the list.
     */
    public void listMembersOfEach() 
    {
    	for (Member element : membersList)
    	{
    		
    		System.out.println(element.printDetails());    		
    	}
    	
    	
    }

    
    public int joinedInMonth (int month)
    {
    	
    	int count = 0;
    	int i = 0;
    // add code here.
    	if (month > 0 && month<=12)
    	{
    		
    	
    		while ((membersList.size())>=0 && i < (membersList.size())) {
    			for (Member element : membersList)
    			{
    				if (month == element.getMonth())
					{
						count= count +1 ;
						i++;
					}
					else
					{
						i++;
					}
    			}
    			
    			
    			
    			System.out.println("Month to check: " +month+ " --> "  +count+ " Members joined.");
    			}
    	
    	}	
    	else
    	{
    		System.out.println("Error! Wront month inserted.... Try again!");
    	}
    		return count;
    }
    		
    	


    public ArrayList<Member>removedMembers(int month, int year)
    {
    	
    	ArrayList<Member> removedboys = new ArrayList<Member>();
    	Iterator<Member> it = membersList.iterator();
    	
    	
    	
    	
    	
    		
    				while (it.hasNext()) 
    				{
    					Member John = it.next();
    					if ((John.getMonth()) == month && year ==(John.getYear()))
    					{
    						it.remove();
    						removedboys.add(John);
    					}
    				}
    				
    				
    			
    		
    		
    			
			
    			
    		
    		
    	System.out.println("---[Removed Members List]---");
    	for (Member element2 : removedboys)
    	{
    	
    		System.out.println(element2.printDetails());
    	}
    	return removedboys;
    	
    	
    }
    
    public ArrayList<Member>removedMembersByName(String name)
    {
    	
    	ArrayList<Member> removedboys = new ArrayList<Member>();
    	Iterator<Member> it = membersList.iterator();
    		
    				while (it.hasNext()) 
    				{
    					Member John = it.next();
    					if ((John.getName()) == name)
    					{
    						it.remove();
    						removedboys.add(John);
    					}
    				}
    				

    	System.out.println("---[Removed Members List]---");
    	for (Member element2 : removedboys)
    	{
    	
    		System.out.println(element2.printDetails());
    	}
    	return removedboys;
    	
    	
    }
    
    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers() 
    {    	
    	return membersList.size();        
    }
}
