package array2;
/**
 * A simple tester class to test the StaffList class methods
 * @author A. Razak
 * version 17/03/2019
 */

public class TestStaffList {
	
	public static void main(String args[]){
		// using the default constructor which size is 5. 
		// If we want to add more people we can use the constructor with max limit of the size.
		StaffList list = new StaffList();
		
		// Add your code here
		list.addPerson(new Person("Sami",21));
		list.addPerson(new Person("Martina",14));
		list.addPerson(new Person("Naveed Hussain",23));
		list.addPerson(new Person("Mahid",22));
		list.addPerson(new Person("Kalman",18));
		list.showAllStaff();
		list.showStaffInAgeRange(14, 22);
		list.lowestAge();
		list.highestAge();
	}

}
