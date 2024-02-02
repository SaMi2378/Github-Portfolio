package assignmentCode;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/** Creating the class College*/
public class College {
	
	/**
	 * Stores details of Students Courses and enrolments.
	 * 
	 * @author (Sami Ullah) 
	 * @version (12/05/2023)
	 */
	
	
	
	/**
	 * Creating 3 arraylists to save student details, courses details and enrolments.
	 */
	private ArrayList<Student> students;
	private ArrayList<Courses> courses; 
	private ArrayList<Enrolment> enrolments;
	
	
	/**
	 * Creating the constructor with no parameters
	 * The reason is that the lists will be initiated as empty lists.
	 */
	public College (){
		students = new ArrayList<Student>();
		courses = new ArrayList<Courses>();
		enrolments= new ArrayList<Enrolment>();
	}
	
	/**
	 * Funtion to add students.
	 */
	public void addNewStudent() 
	{
		System.out.println();
		System.out.println("Adding new Student");           /** printing header title*/ 
		Scanner s1 = new Scanner(System.in);      			/** initiating the scanner variable s1*/
		System.out.print("Please insert the firstname: ");	/** asking the user to insert the firstName*/
		String name = s1.next();							/** scanner will read the input of the user and save it in the variable.*/
		System.out.print("Please insert the lastname: ");   /** asking the user to insert the lastName*/
		String lastName = s1.next();						/** scanner will read the input of the user and save it in the variable.*/
		System.out.print("Please insert the phone number: "); /** asking the user to insert the phone number*/
		String number = s1.next();							/** scanner will read the input of the user and save it in the variable.*/
		Student S1 = new Student(name,lastName,number);		/** The variables read, will be assigned to a Student Class S1 which will take as parameters these variables.*/
		students.add(S1);									/** Then this Student will be added to the list of students*/
		System.out.println("Student has been added!!");		/** output message of the process done*/
		System.out.println("The Id assigned is: " +S1.getStudentId());	/** outputs the id which has been assigned to the student we just created*/
		
	}
	
	/**
	 * The next function returns a student details inputting his student id.
	 * 
	 */
	
	public void studentById() {
		System.out.println();
		System.out.println("Student details by ID");  /** printing header title*/ 
		Scanner s1 = new Scanner(System.in);          /** initiating the scanner variable s1*/
		System.out.print("Please insert the student ID: "); /** asking the user to insert the student id*/
		int studentid = s1.nextInt();				  /** scanner will read the input of the user and save it in the variable.*/
		Iterator<Student> it = students.iterator();   /** We Start a iterator called "it" in the students list.*/ 
//		System.out.println();
//		System.out.println("+--------------------------------------------------------------------+");
//		System.out.printf("| %-10s %-20s %-15s|%n", "ID", "Name", "Phone Number");
//		System.out.println("+--------------------------------------------------------------------+");
		boolean found = false;					/** Creating a boolean variable named found.*/
		while (it.hasNext())					/** when the iterator has a next the loop will continue running.*/
		{
			Student S1 = it.next();				/** we initiate a student class variable with the iterator actual element.*/
			if (S1.getStudentId() == studentid) /** If the id of the actual Student element is equal to the student id the user has entered*/
			{
				System.out.println();			/** Then the system will output the details of that student. The output is in the same custom format.*/
				System.out.println("+--------------------------------------------------------------------+");
				System.out.printf("| %-15s %-30s %-20s|%n", "ID", "Name", "Phone Number"); /** header of the columns*/
				System.out.println("+--------------------------------------------------------------------+");
				S1.printDetails();
				found = true;					/** The found boolean variable will be true.*/ 
			}
						
			
		}
		if (found == false) {					/** if the boolean variable remains false, that means the user has inserted a wrong id*/
			System.out.println("Error! - The Id number Incorrect, Try Again..."); /** pop up a error message*/
			studentById();		/** start again the function.*/
		}
	}
	
	
	/**
	 * Print All student function
	 * This will print out all the students created in the list students.
	 * The format will be the same as before and it will have a custom header format.
	 */
	public void printAllStudents() {
		System.out.println();
		System.out.println("List of All Students");
		System.out.println();
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-15s %-30s %-20s|%n", "ID", "Name", "Phone Number");
		System.out.println("+--------------------------------------------------------------------+");
		for(Student S1 : students)
		{
			S1.printDetails();
		}
		
	}
	
	/**
	 * Course Functions
	 */
	
	/**
	 * The following function asks the user to inssert the course title and the course Fee.
	 * Then it creates a Courses class variable C1, and inserts the previously entered parameter in this variable.
	 * And finally it adds this course to the courses list. The Course Id is randomly generated when it creates a Courses Class variable.
	 */
	
	public void addNewCourse() {
		System.out.println();
		System.out.println("Adding new Course");
		Scanner c1 = new Scanner(System.in);
		System.out.print("Please insert the course title: ");
		String title = c1.nextLine();
		Scanner c2 = new Scanner(System.in);
		System.out.print("Please insert the course fee: ");
		double number = c2.nextDouble();
		Courses C1 = new Courses(title,number);
		courses.add(C1);
		System.out.println("Course has been added!!");
		System.out.println(C1.getCourseId());
	}
	
	/**
	 * The function takes the id of a course and prints out the details of the course/
	 * First it asks the user to enter the id, then it initiates the Scanner and reads the id. This id is saved in a variable
	 * Then it creates an iterator which will run into the courses arraylist.
	 * Each time the iterator has a next element the while loop will be active.
	 * in the while loop the if of the iterator current element is compared to the id which the user has entered
	 * IF it is same then the details of the course will be printed. If not the system will print out that the id inserted is incorrect and try again.
	 */
	public void courseById() {
		System.out.println();
		System.out.println("Course details by ID");
		Scanner c1 = new Scanner(System.in);
		System.out.print("Please insert the course ID: ");
		int courseid = c1.nextInt();
		Iterator<Courses> it = courses.iterator();
//		System.out.println();
//		System.out.println("+--------------------------------------------------------------------+");
//		System.out.printf("| %-15s %-35s %-15s|%n", "ID", "Course Title", "Course Fee");
//		System.out.println("+--------------------------------------------------------------------+");
		boolean found = false;
		while (it.hasNext())
		{
			Courses C1 = it.next();
			if (C1.getCourseId() == courseid)
			{
				System.out.println();
				System.out.println("+--------------------------------------------------------------------+");
				System.out.printf("| %-15s %-35s %-15s|%n", "ID", "Course Title", "Course Fee");
				System.out.println("+--------------------------------------------------------------------+");
				C1.printDetails();
				found = true;
			}
			
		}
		
		if (found == false) {
			System.out.println("Error! - The Course Id Incorrect, Try Again...");
			courseById();
		}
	}
	
	/**
	 * This printing all courses works same as the student function
	 * It creates a For each loop, and prints the datails of all the courses which have been saved in the arraylist courses.
	 */
	
	public void printAllCourses() {
		System.out.println();
		System.out.println("List of All Courses");
		System.out.println();
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-15s %-35s %-15s|%n", "ID", "Course Title", "Course Fee");
		System.out.println("+--------------------------------------------------------------------+");
		for (Courses C1: courses) {
			C1.printDetails();
		}
	}
	
	
	/**
	 * Requirements B - Starting From here
	 * 
	 * 3. Student Records 
	 * 
	 * a. Return Student Object with a particular ID
	 */
	
	/** 
	 * This Function works the same as student details by ID
	 * But instead of printing out the student details, the function prints the student object.
	 * The functionality is the same as the other function. 
	 * */
	public Student returnStudentById()
	{
		System.out.println();
		System.out.println("Return Student Object by ID");
		Scanner s1 = new Scanner(System.in);
		System.out.print("Please insert the student ID: ");
		int studentid = s1.nextInt();
		Iterator<Student> it = students.iterator();
//		System.out.println();
//		System.out.println("+--------------------------------------------------------------------+");
//		System.out.printf("| %-15s %-30s %-20s|%n", "ID", "Name", "Phone Number");
//		System.out.println("+--------------------------------------------------------------------+");
		boolean found = false;
		Student return1 = null;
		while (it.hasNext())
		{
			Student S1 = it.next();
			if (S1.getStudentId() == studentid)
			{
//				System.out.println();
//				System.out.println("+--------------------------------------------------------------------+");
//				System.out.printf("| %-15s %-30s %-20s|%n", "ID", "Name", "Phone Number");
//				System.out.println("+--------------------------------------------------------------------+");
				
				found = true;
				return1 = S1;
			}				
			
		}
		if (found == false) {
			System.out.println("Error! - The Id number Incorrect, Try Again...");
			
		}
		System.out.println(return1);
		return return1;
		
	}
	
	/**
	 * Requirements B - Starting From here
	 * 
	 * 3. Student Records 
	 * 
	 * b. search for and print all students where their surname contains a 
	      particular search string
	 */
	
	/**
	 * This function prints the students details whose last name matches a search string.
	 * The functionality of this function is similar to the the function to find the student details by ID
	 * In this function the system will ask for a search string which must be its surname correctly spelled.
	 * This can be modified if we use the function contains() instead of equals()
	 * So, when the compares in the if statement, it will compare the last name of the students and the search string which we have inserted
	 * with the scanner.
	 * If it matches the surname, then the system will print out the details of that student. The comparison is done converting both strings in lowercase
	 * this way no matter how the user inserts the text it will be compared anyways.
	 * If it is not equal to any surname in the list, then the system will print out a error asking to try again.
	 */
	public void studentsContainString()
	{
		System.out.println();
		System.out.println("Students Whose Surnames has String");
		Scanner s1 = new Scanner(System.in);
		System.out.print("Please insert the string to search: ");
		String search = s1.next();
		Iterator<Student> it = students.iterator();
//		System.out.println();
//		System.out.println("+--------------------------------------------------------------------+");
//		System.out.printf("| %-15s %-30s %-20s|%n", "ID", "Name", "Phone Number");
//		System.out.println("+--------------------------------------------------------------------+");
		boolean found = false;
		while (it.hasNext())
		{
			Student S1 = it.next();
			if (S1.getLastName().toLowerCase().equals(search.toLowerCase()))
			{
				System.out.println();
				System.out.println("+--------------------------------------------------------------------+");
				System.out.printf("| %-15s %-30s %-20s|%n", "ID", "Name", "Phone Number");
				System.out.println("+--------------------------------------------------------------------+");
				S1.printDetails();
				found=true;
			}		
		}
		if (found==false)
		{
			System.out.println("Error! - The search string is Incorrect, Try Again...");
			studentsContainString();
		}
	}
	
	/**
	 * Requirements B - Starting From here
	 * 
	 * 3. Student Records 
	 * 
	 * c. remove a student with a particular student ID number
	 */
	
	/**
	 * This Works same as student obejct or student details by id
	 * The unique difference is that when it compares and finds the id is same to on of the students in the list,
	 * then instead of printing the object or the student details, it removes that student from the list. 
	 * And it will pop out a message informing the delete process has been completed.
	 * The functionality is the same as the other student functions.
	 */
	public void removeStudentById()
	{
		System.out.println();
		System.out.println("Remove Student from list by ID");
		Scanner s1 = new Scanner(System.in);
		System.out.print("Please insert the student ID: ");
		int studentid = s1.nextInt();
		Iterator<Student> it = students.iterator();
//		System.out.println();
//		System.out.println("+--------------------------------------------------------------------+");
//		System.out.printf("| %-15s %-30s %-20s|%n", "ID", "Name", "Phone Number");
//		System.out.println("+--------------------------------------------------------------------+");
		boolean found = false;
		while (it.hasNext())
		{
			Student S1 = it.next();
			if (S1.getStudentId() == studentid)
			{
//				System.out.println();
//				System.out.println("+--------------------------------------------------------------------+");
//				System.out.printf("| %-15s %-30s %-20s|%n", "ID", "Name", "Phone Number");
//				System.out.println("+--------------------------------------------------------------------+");
				
				found = true;
				it.remove();
				System.out.println("Student has been removed!!");
			}				
			
		}
		if (found == false) {
			System.out.println("Error! - The Id number Incorrect, Try Again...");
			
		}
		
	}
	
	
	/**
	 * Requirements B - Starting From here
	 * 
	 * 4. Course Records 
	 * 
	 * a. Return Course Object with a particular ID
	 */
	 
	/**
	 * This function works the same as returning student object or course by details.
	 * @return course object
	 */
	 public Courses returnCourseById() {
		System.out.println();
		System.out.println("Return Course object by ID");
		Scanner c1 = new Scanner(System.in);
		System.out.print("Please insert the course ID: ");
		int courseid = c1.nextInt();
		Iterator<Courses> it = courses.iterator();
//		System.out.println();
//		System.out.println("+--------------------------------------------------------------------+");
//		System.out.printf("| %-15s %-35s %-15s|%n", "ID", "Course Title", "Course Fee");
//		System.out.println("+--------------------------------------------------------------------+");
		boolean found = false;
		Courses return1 = null; 
		while (it.hasNext())
		{
			Courses C1 = it.next();
			if (C1.getCourseId() == courseid)
			{
				
				return1 = C1;
				found = true;
			}
			
		}
		
		if (found == false) {
			System.out.println("Error! - The Course Id Incorrect, Try Again...");
				
		}
		System.out.println(return1);
		return return1;
	}
	 
	 
	 
	 
	 /**
	 * Requirements B - Starting From here
	 * 
	 * 4. Course Records 
	 * 
	 * b. search for and print all courses whose title contains a particular 
          search string
	 */
	 
	 /**
		 * This function prints the course details whose title has a search string.
		 * The functionality of this function is similar to the the function to find the course details by ID
		 * In this function the system will ask for a search string which will be compared with the title of all the courses created.
		 * So, when the comparison in the if statement, it will compare the title of the courses and the search string which we have inserted
		 * with the scanner.
		 * If the title contains the search string, then the system will print out the details of that course. The comparison is done converting both strings in lowercase
		 * this way no matter how the user inserts the text it will be compared anyways.
		 * If any course does not have that string in the title, then the system will print out a error asking to try again.
		 */
	 
	 	public void coursesContainString()
	{
		System.out.println();
		System.out.println("Courses Whose titles has String");
		Scanner c1 = new Scanner(System.in);
		System.out.print("Please insert the string to search: ");
		String search = c1.next();
		Iterator<Courses> it = courses.iterator();
		boolean found = false;
		while (it.hasNext())
		{
			Courses C1 = it.next();
			if (C1.getTitle().toLowerCase().contains(search.toLowerCase()))
			{
				System.out.println();
				System.out.println("+--------------------------------------------------------------------+");
				System.out.printf("| %-15s %-35s %-15s|%n", "ID", "Course Title", "Course Fee");
				System.out.println("+--------------------------------------------------------------------+");
				C1.printDetails();
				found=true;
			}
			
		}
		if (found==false)
		{
			System.out.println("Error! - The Id number Incorrect, Try Again...");
			coursesContainString();
		}
	}
	
	
	
	
	
	/**
	 * Requirements B - Starting From here
	 * 
	 * 4. Course Records 
	 * 
	 * c. Remove a Course with a particular ID
	 */ 
	
	/**
	 * This function works almost same as the course by id function.
	 * THe unique difference between these two,
	 * is that this function removes course whose id has been matched with the id which we have entered in the scanner
	 * At the end it prints a message informing the course has been deleted.
	 */
	public void removeCourseById()
	{
		System.out.println();
		System.out.println("Remove Course by ID");
		Scanner c1 = new Scanner(System.in);
		System.out.print("Please insert the course ID: ");
		int courseid = c1.nextInt();
		Iterator<Courses> it = courses.iterator();
//		System.out.println();
//		System.out.println("+--------------------------------------------------------------------+");
//		System.out.printf("| %-15s %-35s %-15s|%n", "ID", "Course Title", "Course Fee");
//		System.out.println("+--------------------------------------------------------------------+");
		boolean found = false;
		while (it.hasNext())
		{
			Courses C1 = it.next();
			if (C1.getCourseId() == courseid)
			{
				
				it.remove();
				found = true;
				System.out.println("Course has been removed!!");
			}
			
		}
		
		if (found == false) {
			System.out.println("Error! - The Course Id Incorrect, Try Again...");
			removeCourseById();	
		}
		
		 	
	}	 
	
	
	
	
	
	/**
	 * Requirements C - Starting From here
	 * 
	 * 5. Enrolment Records 
	 * 
	 * a. Add an enrolment for a given student ID and course ID numbers
	 */ 
	 
	/**
	 * This function takes two ids, the student id and the course id. These ids are transfered into a enrolment class variable E1
	 * This variable takes as parameters these two ids and generates the actual date using localdate.
	 * And it adds this Enrolment type variable E1 to the enrolment list.
	 * This way a enrolment has been added in the enrolments arraylist.
	 */
	public void addEnrolment()
	{
 		System.out.println();
		System.out.println("Adding new Enrolment");
		Scanner e1 = new Scanner(System.in);
		System.out.print("Please insert Student ID: ");
		int S_Id = e1.nextInt();
		System.out.print("Please insert Course ID: ");
		int C_Id = e1.nextInt();
		Enrolment E1 = new Enrolment(S_Id, C_Id);
		enrolments.add(E1);
		System.out.println("Enrolment has been created!!");
 		
	}
	
	/**
	 * Requirements C - Starting From here
	 * 
	 * 5. Enrolment Records 
	 * 
	 * b. Remove an enrolment for a given student ID and course ID numbers
	 */ 
	
	
	/**
	 * This function works same as the other removing items functions.
	 * It takes two ids which will be saved in two variables. These IDs are inserted by the user using the scanner tool.
	 * Once the IDs has been saved, it creates a iterator called "it" of class Enrolment, and it will run in the enrolments arraylist. 
	 * It will compare the both id when ever the iterator hasnext(), if both IDs match with an enrolment, then the function will remove
	 * this enrolment from the list. And it will send a message that the enrolment has been removed. If not it will print an error message.
	 */
	public void removeEnrolment() {
		System.out.println();
		System.out.println("Removing An Enrolment");
		Scanner e1 = new Scanner(System.in);
		System.out.print("Please insert Student ID: ");
		int S_Id = e1.nextInt();
		System.out.print("Please insert Course ID: ");
		int C_Id = e1.nextInt();
		Iterator<Enrolment> it = enrolments.iterator();
		boolean found = false;
		while (it.hasNext()) {
			Enrolment E1 = it.next();
			if ((E1.getStudentID() == S_Id )&&(E1.getCourseID()== C_Id)) {
				
				it.remove();
				found=true;
				System.out.println("Enrolment has been deleted!!");
			}
			
		}
		if (found==false)
		{
			System.out.println("Error! - Enrolment Doesn't Exist...");
		}
		
	}
	
	
	/**
	 * Requirements C - Starting From here
	 * 
	 * 5. Enrolment Records 
	 * 
	 * c. Print all Enrolments with Student and Course Details
	 */ 	
	
	/**
	 * This function,, uses three for each loops to print all the enrolments saved in the arraylist.
	 * First it creates a main for each loop which will run in the enrolment list, then inside this for each loop,
	 * the system creates two other for each loops for student list and course list. This two will allow the function to compare the Student id and the course id
	 * from the three lists and if IDs in the enrolment list matches with the IDs in the students and courses list then it will print the details of the
	 * enrolment, also adding the details of the student and the course which he has been enroled in. 	
	 */
	public void printAllEnrolments() {
		System.out.println();
		System.out.println("List of All Enrolments");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-15s %-30s %-20s|%n", "Student ID", "Course ID", "Date of Enrolment");
		System.out.println("+--------------------------------------------------------------------+");
		for (Enrolment E1: enrolments) {
			E1.printDetails();
			for (Student S1: students) {
				if (E1.getStudentID()== S1.getStudentId()) {
					S1.printDetails();
				}
				
			}
			for (Courses C1: courses) {
				if (E1.getCourseID()==C1.getCourseId())
				{
					C1.printDetails();
				}
			}
		}
	}
	
	
	
	
	/**
	 * Requirements D - Starting From here
	 * 
	 * 5. Enrolment Records 
	 * 
	 * a. Print all Enrolments with Student and Course Details between dates.
	 */ 	
	
	
	/**
	 * This funtion works similar to the print all enrolments fucntion.
	 * The changing are that before comparing the student and the course id with the IDs in the enrolment list, 
	 * It will compare the date of the enrolment. A start date which the user will insert in this format (yyyy-mm-dd)
	 * and then a end date which will be the actual date. 
	 * If in the enrolment list the enrolments have been done in between these dates then those enrolments will be printed out 
	 * including the student and the course details in which they are enroled.
	 */
	public void printAllEnrolmentsDates() {
		System.out.println();
		System.out.println("List of All Enrolments Between Dates");
		Scanner d1 = new Scanner(System.in);
		System.out.print("Please insert the year: ");
		int year = d1.nextInt();
		System.out.print("Please insert the Month: ");
		int month = d1.nextInt();
		System.out.print("Please insert the Day: ");
		int day = d1.nextInt();
		
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-15s %-30s %-20s|%n", "Student ID", "Course ID", "Date of Enrolment");
		System.out.println("+--------------------------------------------------------------------+");
		for (Enrolment E1: enrolments) {
			if ((E1.getEnrolmentDate().isAfter(LocalDate.of(year,month,day)))&& E1.getEnrolmentDate().isBefore(LocalDate.now())|| E1.enrolmentDate.isEqual(LocalDate.now()))
			{
				E1.printDetails();
				for (Student S1: students) {
					if (E1.getStudentID()== S1.getStudentId()) {
						S1.printDetails();
					}
				
				}
			
				for (Courses C1: courses) {
					if (E1.getCourseID()==C1.getCourseId())
					{
						C1.printDetails();
					}
				}
			}
		}	
	}
	
	/**
	 * The next coding is the design of the main menu.
	 * The menu has 4 options, Which will be asked to select by the user, 
	 * the scanner class will read this selection.
	 * If option 1 is selected then it will open the studentmenu
	 * option 2 will open the course menu
	 * option 3 will open the enrolments menu
	 * option 4 will exit the menu using the boolean variable which will terminate the while loop also.
	 * any other option will print a error message.
	 */
	
	public void mainMenu() throws InterruptedException {
		System.out.println();
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-65s  |%n", "                         Welcome Main Menu");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", " Num", "|","                 Option Name");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  1", "|","               Student Records");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  2", "|","               Courses Records");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  3", "|","              Enrolment Records");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  4", "|","                     Exit");
		System.out.println("+--------------------------------------------------------------------+");
		Scanner s1 = new Scanner(System.in);
		Boolean quit = false;
		while (quit==false) {
			System.out.print("Please choose a option: ");
			int option = s1.nextInt();
			if (option==1)
			{
				studentMenu();
				break;
			}
			else if (option==2) {
				coursesMenu();
				break;
			}
			else if (option==3) {
				enrolmentMenu();
				break;
			}
			else if (option == 4){
			System.out.println("Bye-bye :)");
			quit = true;
			break;
			}
			else
			{
				System.out.println("Error!! Wrong input... Try again");
				
			}
			
		}
		
	}
	
	/**
	 * The next coding is the design of the student menu.
	 * The menu has 8 options, Which will be asked to select by the user, 
	 * the scanner class will read this selection.
	 * option 1 is selected then it will run the add student function after it will return to the student menu.
	 * option 2 will run the print student details by ID function and after it will return to the student menu.
	 * option 3 will run the corresponding function... and so on
	 * all the options will run the functions which they are indicated. And after the function has run successfully it will return to the menu again.
	 * the option 7 is to return to the main menu
	 * and the option 8 is to exit the menu.
	 * any other option will print a error message.
	 */
	

	public void studentMenu() throws InterruptedException {
		System.out.println();
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-65s  |%n", "                      Students Records Menu");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", " Num", "|","              Student Options");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  1", "|","            Add Student Details");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  2", "|","        Print Student Details by ID");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  3", "|","            Print All Students");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  4", "|","       Return a Student Object by ID");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  5", "|","       Search a Student with Surname");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  6", "|","          Remove a Student by ID");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  7", "|","            Back to Main Menu");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  8", "|","                  Exit");
		System.out.println("+--------------------------------------------------------------------+");
		
		Scanner s2 = new Scanner(System.in);
		
			System.out.print("Please choose a option: ");
			int option = s2.nextInt();
			if (option==1)
			{
				addNewStudent();
				Thread.sleep(3000);
				studentMenu();
			}
			else if (option==2) {
				studentById();
				Thread.sleep(3000);
				studentMenu();
			}
			else if (option==3) {
				printAllStudents();
				Thread.sleep(3000);
				studentMenu();
			}
			else if (option==4) {
				returnStudentById();
				Thread.sleep(3000);
				studentMenu();
			}
			else if (option==5) {
				studentsContainString();
				Thread.sleep(3000);
				studentMenu();
			}
			else if (option==6) {
				removeStudentById();
				Thread.sleep(3000);
				studentMenu();
			}
			else if (option == 7) {
				mainMenu();
			}
			else if (option == 8) {
				System.out.println("Bye-bye :)");
				
			}
			else {
				System.out.println("Error!! Wrong input... Try again");
				Thread.sleep(2000);
				studentMenu();
			}
			
	}
	
	/**
	 * The next coding is the design of the course menu.
	 * The menu has 8 options, Which will be asked to select by the user, 
	 * the scanner class will read this selection.
	 * option 1 is selected then it will run the add course function after it will return to the course menu.
	 * option 2 will run the print course details by ID function and after it will return to the course menu.
	 * option 3 will run the corresponding function... and so on
	 * all the options will run the functions which they are indicated. And after the function has run successfully it will return to the menu again.
	 * the option 7 is to return to the main menu
	 * and the option 8 is to exit the menu.
	 * any other option will print a error message.
	 */
	public void coursesMenu() throws InterruptedException {
	System.out.println();	
	System.out.println("+--------------------------------------------------------------------+");
	System.out.printf("| %-65s  |%n", "                      Courses Records Menu");
	System.out.println("+--------------------------------------------------------------------+");
	System.out.printf("| %-5s %-4s %-55s |%n", " Num", "|","              Courses Options");
	System.out.println("+--------------------------------------------------------------------+");
	System.out.printf("| %-5s %-4s %-55s |%n", "  1", "|","            Add Course Details");
	System.out.println("+--------------------------------------------------------------------+");
	System.out.printf("| %-5s %-4s %-55s |%n", "  2", "|","        Print Course Details by ID");
	System.out.println("+--------------------------------------------------------------------+");
	System.out.printf("| %-5s %-4s %-55s |%n", "  3", "|","            Print All Courses");
	System.out.println("+--------------------------------------------------------------------+");
	System.out.printf("| %-5s %-4s %-55s |%n", "  4", "|","        Return a Course Object by ID");
	System.out.println("+--------------------------------------------------------------------+");
	System.out.printf("| %-5s %-4s %-55s |%n", "  5", "|","        Search a Course with String");
	System.out.println("+--------------------------------------------------------------------+");
	System.out.printf("| %-5s %-4s %-55s |%n", "  6", "|","           Remove a Course by ID");
	System.out.println("+--------------------------------------------------------------------+");
	System.out.printf("| %-5s %-4s %-55s |%n", "  7", "|","            Back to Main Menu");
	System.out.println("+--------------------------------------------------------------------+");
	System.out.printf("| %-5s %-4s %-55s |%n", "  8", "|","                   Exit");
	System.out.println("+--------------------------------------------------------------------+");
	
	Scanner s3 = new Scanner(System.in);
	
	System.out.print("Please choose a option: ");
	int option = s3.nextInt();
	if (option==1)
	{
		addNewCourse();
		Thread.sleep(3000);
		coursesMenu();
	}
	else if (option==2) {
		courseById();
		Thread.sleep(3000);
		coursesMenu();
	}
	else if (option==3) {
		printAllCourses();
		Thread.sleep(3000);
		coursesMenu();
	}
	else if (option==4) {
		returnCourseById();
		Thread.sleep(3000);
		coursesMenu();
	}
	else if (option==5) {
		coursesContainString();
		Thread.sleep(3000);
		coursesMenu();
	}
	else if (option==6) {
		removeCourseById();
		Thread.sleep(3000);
		coursesMenu();
	}
	else if (option == 7) {
		mainMenu();
	}
	else if (option == 8) {
		System.out.println("Bye-bye :)");
		
	}
	else {
		System.out.println("Error!! Wrong input... Try again");
		Thread.sleep(2000);
		coursesMenu();
	}
		
	}
	
	/**
	 * The next coding is the design of the enrolment menu.
	 * The menu has 6 options, Which will be asked to select by the user, 
	 * the scanner class will read this selection.
	 * option 1 is selected then it will run the add enrolment function after it will return to the student menu.
	 * option 2 will run the print enrolment details by course and student IDs function and after it will return to the student menu.
	 * option 3 will run the corresponding function... and so on
	 * all the options will run the functions which they are indicated. And after the function has run successfully it will return to the menu again.
	 * the option 5 is to return to the main menu
	 * and the option 6 is to exit the menu.
	 * any other option will print a error message.
	 */
	public void enrolmentMenu() throws InterruptedException {
		System.out.println();
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-65s  |%n", "                      Enrolments Records Menu");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", " Num", "|","             Enrolments Options");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  1", "|","              Add New Enrolment");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  2", "|","             Remove An Enrolment ");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  3", "|","            Print All Enrolments");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  4", "|","      Print All Enrolments Between Dates");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  5", "|","            Back to Main Menu");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.printf("| %-5s %-4s %-55s |%n", "  6", "|","                    Exit");
		System.out.println("+--------------------------------------------------------------------+");
		
		Scanner s4 = new Scanner(System.in);
		
		System.out.print("Please choose a option: ");
		int option = s4.nextInt();
		if (option==1)
		{
			addEnrolment();
			Thread.sleep(3000);
			enrolmentMenu();
		}
		else if (option==2) {
			removeEnrolment();
			Thread.sleep(3000);
			enrolmentMenu();
		}
		else if (option==3) {
			printAllEnrolments();
			Thread.sleep(3000);
			enrolmentMenu();
		}
		else if (option==4) {
			printAllEnrolmentsDates();
			Thread.sleep(3000);
			enrolmentMenu();
		}
		else if (option == 5) {
			mainMenu();
		}
		else if (option == 6) {
			System.out.println("Bye-bye :)");
			
		}
		else {
			System.out.println("Error!! Wrong input... Try again");
			Thread.sleep(2000);
			enrolmentMenu();
		}
	}
	
	
}
