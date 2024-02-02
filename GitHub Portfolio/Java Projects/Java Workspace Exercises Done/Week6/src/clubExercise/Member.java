package clubExercise;
/**
 * A class to store details of a club membership.
 * 
 * @author A. Razak
 * @version 26/02/2023
 */
public class Member
{
    // The name of the member.
    private String name;
    // The month in which the membership was taken out.
    private int month;
    // The year in which the membership was taken out.
    private int year;

    /**
     * Constructor for objects of class Membership.
     * @param name The name of the member.
     * @param month The month in which they joined. (1 ... 12)
     * @param year The year in which they joined.
     */
    public Member(String name, int month, int year)
    {
    	// Validation for the month parameter.
        if(month < 1 || month > 12){
            System.out.println("Invalid month number");
        }
        else {

        
        this.name = name;
        this.month = month;
        this.year = year;
    }
    }
    
    /**
     * @return The member's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return The month in which the member joined.
     *         A value in the range 1 ... 12
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * @return The year in which the member joined.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @return A string representation of this member.
     */
    public String printDetails()
    {
        return "Member: " + name + "," +
               " Joined month: " +
               month+"," + " Year: " + year+".";
    }
}
