package assignmentCode;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class test {
	/**
	 * Provides a demonstration of All the classes and its functions.
	 * 
	 * @author (Sami Ullah) 
	 * @version (12/05/2023)
	 */
	
	
	public static void main(String[] args) throws InterruptedException {
		/**
		 * Testing Code IGnore
		 */
//		Student s1 = new Student ("Sami", "Ullah", "07441235532");
//	
//		int id = s1.getStudentId();
//		System.out.println("+------------------------------------------------+");
//		System.out.printf("| %-10s %-20s %-15s|%n", "ID", "Name", "Phone Number");
//		System.out.println("+------------------------------------------------+");
//		
//		s1.printDetails();
//		System.out.printf("| %-10s %-20s %-15s|%n",+id, s1.getFirstName()+" " + s1.getLastName(),s1.getMobileNumber()); 
//		System.out.println("+------------------------------------------------+");
		
		/** Course testing :) 
		 * 
		 * 
		 */
	
//		Courses c1 = new Courses ("BEng (Hons) Software Engineering", 9250);
//		Courses c2 = new Courses ("BSc Computing", 9250);
//		System.out.println();
//		System.out.println("+--------------------------------------------------------------------+");
//		System.out.printf("| %-10s %-40s %-15s|%n", "ID", "Course Title", "Course Fee");
//		System.out.println("+--------------------------------------------------------------------+");
//		c1.printDetails();
//		c2.printDetails();
//		System.out.printf("| %-10s %-40s %-15s|%n",c1.getCourseId(), c1.getTitle(),"£"+c1.getCourseFee()); 
//		System.out.println("+--------------------------------------------------------------------+");
//		System.out.printf("| %-10s %-40s %-15s|%n",c2.getCourseId(), c2.getTitle(),"£"+c2.getCourseFee()); 
//		System.out.println("+--------------------------------------------------------------------+");
		
		
//		System.out.print("Please enter Student id");
//		int studentid =
//		System.out.print("Please enter Course id");
//		Scanner input = new Scanner(System.in);
//		System.out.print("Please Insert the Student ID: ");
//		int id1 = input.nextInt();
//		System.out.print("Please Insert the Course ID: ");
//		int courseid= input.nextInt();
//		Enrolment e1 = new Enrolment (id1,courseid);
//		System.out.println();
//		System.out.println("+--------------------------------------------------------------------+");
//		System.out.printf("| %-15s %-30s %-20s|%n", "Student ID", "Course ID", "Date of Enrolment");
//		System.out.println("+--------------------------------------------------------------------+");
//		e1.printDetails();
//		if (courseid == c1.getCourseId())
//		{
//			System.out.println(c1.getTitle());
//		}
//		
//		GregorianCalendar calendar = new GregorianCalendar();
//		System.out.println(LocalDate.now());
//		
		
		/**
		 * End of TEsting COde 
		 */
		
		
		/**
		 * Main Menu Code Start
		 */
		
//		System.out.println();
//		System.out.println();
//		System.out.println("Main Program --> ");
//		College C1 = new College();
////		C1.addNewStudent(new Student("Sami","Ullah","07448755123"));
//		C1.addNewStudent(new Student("Naveed","Sabir","0756295666"));
//		C1.studentById();
//		C1.printAllStudents();
//		C1.addNewCourse(new Courses("BEng (Hons) Software Engineering", 9250.52));
//		C1.addNewCourse(new Courses("BSc Computing", 9250.52));
//		C1.courseById();
//		C1.printAllCourses();
		
		
		
		
		/*
		 * ##############
		 * Requirements B
		 * Student Records
		 * ##############
		 */
		
//		System.out.println(C1.returnStudentById());
//		C1.studentsContainString();
//		C1.removeStudentById();
//		C1.printAllStudents();
		
		
		
		
		
		/**
		 * Requirements B
		 * Course Records
		 */
//		System.out.println(C1.returnCourseById());
//		C1.coursesContainString();
//		C1.removeCourseById();
//		C1.printAllCourses();
		

		
		/**
		 * Requirements C
		 * Enrolment Records
		 */
//		C1.addEnrolment();
//		C1.addEnrolment();
//		C1.removeEnrolment();
//		C1.printAllEnrolments();
		
		
//		C1.printAllEnrolmentsDates();
		
		/**
		 * The Above lines were used to test the functionalities before inserting the Menu interface.
		 * This line calls the Main Menu which will be enough to run all the functionalities of the program
		 */
		System.out.println();
		System.out.println();
		System.out.println("Main Program --> ");
		College C1 = new College();
		C1.mainMenu();
//		C1.studentMenu();
//		C1.coursesMenu();
//		C1.enrolmentMenu();
	 }

	
}
