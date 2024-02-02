package assignmentCode;
import java.util.Random; /** Importing random function from the java.util library */

public class Student {
	/**
	 * creates details of Student.
	 * 
	 * @author (Sami Ullah) 
	 * @version (12/05/2023)
	 */
	
	
	private String firstName;
	/** Here we create a variable for the lastname */ 
	private String lastName;
	/** Creating the phone number field */
	private String	mobileNumber;
	/** Creating the student id field*/
	private int studentId;
	
	
	
	/** Constructor of the class which has 3 parameter which the user must insert 
	 *  Also it has a 4th field inside the constructor (studentId) which will be generated automatically.
	 * */
	public Student(String firstName, String lastName, String mobileNumber) {
		int previousID = 0;					/** Creating a variable which will save the previous student id*/	
		int currentID = generateRandomID(); /** The currentId variable will save the actual id which has been generated.*/
		while (currentID != previousID)		/** we start a while loop to check if the id are equal or not */
		{
			/**
			 * If Yes  the program will generate another Id using the function generateRandomID()
			 * And it will be transfered to the previous ID variable.
			 */
			currentID = generateRandomID();  
			previousID = currentID;
		}
		/**
		 * Here we initiate all the fields, Three of the fields will be initiated which the customer input
		 * and the Id will be generated automatically each time the class Student is being called
		 * This id later on will be saved in a list in collge class
		 */
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber; 
		this.studentId = currentID;
		
	}
	/**
	 * This is the function which allows the to generate a random number which will be used to assign the id
	 * It uses random utility, and a private int variable which is assigned which a random number
	 * The length of the number is the following, from 2000000 to 2500000.
	 * And it returns the ID
	 * @return id  Stores the id which has been generate between the range
	 */
	public int generateRandomID() {
        Random rand = new Random();
        int id = rand.nextInt(500000) + 2000000; // generates a random integer between 1 and 10000
        return id;
    }
	
	/**
	 * Getter method function to get the studentId
	 * @return studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * The Student id don't have a setter method because it is already being generated randomly.
	 */
	
	
	/**
	 * Getter method function to get the firstName
	 * @return firstName
	 */
	
	public String getFirstName() {
		return firstName;
	}
	
	
	/**
	 * Setter method function to set the firstName
	 * @param firstName.
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	/**
	 * Getter method function to get the lastName.
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter method function to set the lastName.
	 * @param lastName
	 */
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter method which allows to get the MobileNumber.
	 * @return mobileNumber
	 */
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	/**
	 * Setter method to change or set the mobileNumber.
	 * @param mobileNumber
	 */

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	/**
	 * Function printDetails which will print the student details,
	 * including full name phone number and student id.
	 * The output is given a custom format with the following commands | %-15s %-30s %-20s|%n"
	 */
	
	public void printDetails()
	{

		System.out.printf("| %-15s %-30s %-20s|%n",+studentId, firstName+" " + lastName, mobileNumber); 
		System.out.println("+--------------------------------------------------------------------+");
	}
	
	
}
