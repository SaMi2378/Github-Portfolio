package assignmentCode;
import java.util.Random; /** Importing random function from the java.util library */


public class Courses {
	/**
	 * Creates details of Courses.
	 * 
	 * @author (Sami Ullah) 
	 * @version (12/05/2023)
	 */
	
	
	/** Here we create a String variable for the title */ 
	private String title;
	/** Creating the courseFee variable*/
	private double courseFee;
	/** Creating the course id field*/
	private int courseId;
	
	/** Constructor of the class which has 2 parameter which the user must insert 
	 *  It has a 3th field inside the constructor (courseId) which will be generated automatically.
	 * */
	public Courses (String newTitle, double d) {
		
		int previousID = 0;        /** Creating a variable which will save the previous student id*/
		int currentID = generateRandomID(); /** The currentId variable will save the actual id which has been generated.*/
		while (currentID != previousID)   /** we start a while loop to check if the id are equal or not */
		{
			/**
			 * If Yes  the program will generate another Id using the function generateRandomID()
			 * And it will be transfered to the previous ID variable.
			 */
			currentID = generateRandomID();
			previousID = currentID;
		}
		
		/**
		 * Here we initiate all the fields, Two of the fields will be initiated which the customer input
		 * and the Id will be generated automatically each time the class Course is being called
		 * This id later on will be saved in a list in college.
		 */
		title = newTitle;
		courseFee = d;
		this.courseId = currentID;
	}
	
	/**
	 * This is the function which allows the to generate a random number which will be used to assign the id
	 * It uses random utility, and a private int variable which is assigned which a random number
	 * The length of the number is the following, from 10000 to 30000.
	 * And it returns the ID
	 * @return id
	 */
	public int generateRandomID() {
        Random rand = new Random();
        int id = rand.nextInt(30000) + 10000; // generates a random integer between 1 and 10000
        return id;
    }
	
	
	/**
	 * Getter method which returns the title.
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	
	/**
	 * Getter method which returns the course id
	 * @return courseId
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * Setter method function which sets the new courseId.
	 * @param courseId
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	
	/**
	 * Setter method which sets new title.
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Getter method which returns the courseFee.
	 * @return courseFee
	 */
	public double getCourseFee() {
		return courseFee;
	}
	
	/**
	 * Setter Method which sets a new course fee
	 * @param courseFee
	 */
	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}
	
	/**
	 * Function printDetails which will print the course details,
	 * including title, course fee, and course id.
	 * The output is given a custom format with the following commands | %-15s %-35s %-15s|%n".
	 */
	public void printDetails() {
		System.out.printf("| %-15s %-35s %-15s|%n",courseId, title,"£"+courseFee); 
		System.out.println("+--------------------------------------------------------------------+");
	}
	
		

}
