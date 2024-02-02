package clubExercise;
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

    public static void main(String args[]){
    
    /**
     * Add some members to the club, and then
     * show how many there are.
     * Further example calls could be added if more functionality
     * is added to the Club class.
     */
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
        
        
        //Check the number of members in a given month
        System.out.println("");
        System.out.println("---[Number of Members Joined in a Month]---");
        myClub.joinedInMonth(4);
        myClub.removedMembers(7, 2018);
        
    }
}
