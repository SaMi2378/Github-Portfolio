// PartTimeEmpTester -AR 

public class PartTimeEmpTester 
{
	public static void main(String[] args)
	{
		String number, name;
		double pay;
		int hours;
		PartTimeEmployee emp;
	
	// get the details from the user
	System.out.print("Employee Number: ");
	number = EasyIn.getString();
	System.out.print("Employee's Name: ");
	name = EasyIn.getString();
	System.out.print("Hourly Pay: ");
	pay = EasyIn.getInt();
	System.out.print("Houres Worked This Week: ");
	hours = EasyIn.getInt();
	// Greate new part time employee
	emp = new PartTimeEmployee(number, name);
	// set the employeehourly pay
	emp.setHourlyPay(pay);
	//display emloyee's details, including the weekly pay
	System.out.println();
	System.out.println(emp.getName());
	System.out.println(emp.getNumber());
	System.out.println(emp.calculateWeeklyPay(hours));
	EasyIn.pause();
	
}// method main

}
