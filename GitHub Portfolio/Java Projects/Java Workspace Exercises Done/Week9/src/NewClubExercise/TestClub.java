package NewClubExercise;
/**
 * Provide a demonstration of the Club and Member
 * classes.
 * 
 * @author A.Razak 
 * @version version 1 - 26/02/2023
 */
public class TestClub
{
	
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class TestClub
     */
    public TestClub()
    {
      
   }
   
    public void test_001()
    {
    	Club myClub = new Club();
       	
        myClub.join(new Member("John", 2, 2017));
        myClub.join(new Member("Abdi", 4, 2017));
        myClub.join(new Member("Michael", 7, 2018));
        myClub.join(new Member("Naveed", 4, 2017));
        
        
        
        //show total number of members joined.
        System.out.println("---[Number of Members Joined the Club]---");
        System.out.println("The club has " +
                           myClub.numberOfMembers() +
                           " members.");
        
        // Print all the members
        System.out.println("");
        System.out.println("---[List Of All Members]---");
        myClub.listMembersOfEach();
    }
    	
    public void test_002()
    {
    	Club myClub = new Club();
       	
        myClub.join(new Member("John", 2, 2017));
        myClub.join(new Member("Abdi", 4, 2017));
        myClub.join(new Member("Michael", 7, 2018));
        myClub.join(new Member("Naveed", 4, 2017));
    
    	myClub.removedMembers(2, 2017);
    	System.out.println("---[Remaining Members List]---");
    	myClub.listMembersOfEach();
    	
       	
    	
    }
   
    public void test_003()
    {
    	Club myClub = new Club();
       	
        myClub.join(new Member("John", 2, 2017));
        myClub.join(new Member("Abdi", 4, 2017));
        myClub.join(new Member("Michael", 7, 2018));
        myClub.join(new Member("Naveed", 4, 2017));
        myClub.join(new Member("Naveed", 4, 2017));
    
    	myClub.removedMembersByName("Naveed");
    	System.out.println("---[Remaining Members List]---");
    	myClub.listMembersOfEach();
    	
    	
    	
    	
    }
    
    
    public static void main(String args[]){
    
    /**
     * Add some members to the club, and then
     * show how many there are.
     * Further example calls could be added if more functionality
     * is added to the Club class.
     */
    	TestClub t = new TestClub();
    	System.out.println("###### Test 1 ######");
    	t.test_001();
    	
    	System.out.println("");
    	System.out.println("###### Test 2 ######");
    	
    	t.test_002();
    	
    	System.out.println("");
    	System.out.println("###### Test 3 - Remove by Name ######");
    	t.test_003();
    	
    }
    
}
