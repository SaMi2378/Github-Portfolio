package array2;

/**
 * A simple class to track the staff working for a small company. It
 * uses an array to store the name and age of each member of staff.
 * 
 * @author Abdul Razak 
 * @version 1.0
 */
public class StaffList
{
    // instance variables
    private Person[] people;
    private int numPeople;
    
    /**
     * This constructor will create an array to store upto 5 staff
     */
    public StaffList()
    {
        // create an array of Person objects
        people = new Person[5];
        numPeople = 0;
    }
    
     /**
     * This constructor can be used to create arrays not less than 5 elements
     * to store upto  staff details
     */
   public StaffList(int maxNbrStaff)
    {
       if(maxNbrStaff < 5){
           maxNbrStaff = 5;
        }
        // create an array of Person objects
        people = new Person[maxNbrStaff];
        numPeople = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  p   the Person to add
     */
    public void addPerson(Person p)
    {
        // put your code here
        people[numPeople] = p;
        numPeople++;
    }
    
    public int getNbrPeople(){
        return numPeople;
    }
    
    /**
     * Display the people in the array
     */
    public void showAllStaff()
    {
    	System.out.println("---[Show All Staff List]---");
        for(Person p : people)        {
            System.out.println(p);
        }
    }
   
    public void showStaffInAgeRange(int min, int max)
    {
    	System.out.println("");
    	System.out.println("---[Show Staff in Age Range]---");
    	System.out.println("The Selected Age Range: "+min+"-"+max+" years.");
    	
    	for (Person element: people)
    	{
    		if (min <= element.getAge() && ( element.getAge()<=max))
    		{
    			System.out.println(element);
    		}
    		
    	}
    	
    }
    
    public void lowestAge()
    {
    	int lowest = 0;
    	String Name = "";
    	for (Person p: people) 
    	{
    		
    		if (lowest == 0)
    		{
    			lowest = p.getAge();
    		}
    		else if (lowest >= p.getAge())
    		{
    			lowest = p.getAge();
    			Name = p.getName();
    		}
    		
    	}
    	System.out.println("");
    	System.out.println("---[The lowest age]---");
    	System.out.println(Name+" (" + lowest + " years old)");
    	
    }
    
    public void highestAge()
    {
    	int highest = 0;
    	String Name = "";
    	for (Person p: people) 
    	{
    		
    		if (highest == 0)
    		{
    			highest = p.getAge();
    		}
    		else if (highest <= p.getAge())
    		{
    			highest = p.getAge();
    			Name = p.getName();
    		}
    		
    	}
    	System.out.println("");
    	System.out.println("---[The Highest age]---");
    	System.out.println(Name+" (" + highest + " years old)");
    	
    }
    
}
