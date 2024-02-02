package assignmentCode;

import java.time.LocalDate; /** Importing localdate utility from java.time library*/

public class Enrolment{
	
	/**
	 * Creates details of Enrolment.
	 * 
	 * @author (Sami Ullah) 
	 * @version (12/05/2023)
	 */
	
	
	
	/**
	 * Creating fields of the enrolment class
	 * Student id, courseID, and a local date.
	 */
	private int studentID;
	private int courseID;
	LocalDate enrolmentDate;
	
	/** The constructor initiated which 2 parameters.*/
	public Enrolment (int studentID, int courseID)
	
	{
		/**
		 * The user will insert the parameters above indicated, this parameters will initiate the value of the fields
		 * studentID and courseID.
		 * The enrolmentDate variable will have the date of the day of enrolment thanks to the tool localdate.now()
		 */
		this.studentID = studentID;  
		this.courseID = courseID;
		enrolmentDate = LocalDate.now();
		
	}
	
	/**
	 * Getter method which will return the studentID used in the enrolment.
	 * @return studentID
	 */
	public int getStudentID() {
		return studentID;
	}
	
	/**
	 * Setter method to set a new id of the student in enrolment class.
	 * @param studentID
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	
	/**
	 * Getter method which will return the courseID used in the enrolment.
	 * @return
	 */
	public int getCourseID() {
		return courseID;
	}
	
	
	/**
	 * Setter method to set a new id of the course in enrolment class.
	 * @param courseID
	 */
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	
	/**
	 * Getter method which will return the enrolmentDate.
	 * @return enrolmentDate
	 */
	public LocalDate getEnrolmentDate() {
		return enrolmentDate;
	}
	
	/**
	 * Setter method to set a new date of enrolment.
	 * @param enrolmentDate
	 */
	public void setEnrolmentDate(LocalDate enrolmentDate) {
		this.enrolmentDate = enrolmentDate;
	}
	
	
	/**
	 * A printing method which will print out the details of the enrolment giving a personalised format.
	 */
	public void printDetails() {
		System.out.printf("| %-15s %-30s %-20s|%n",studentID, courseID, enrolmentDate); 
		System.out.println("+--------------------------------------------------------------------+");
	}
	
}
