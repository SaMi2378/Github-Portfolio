// Employee class -AR
class Employee
{
	private String number;
	private String name;
	private double annualSalary;
	
	public Employee(String numberIn, String nameIn)
	{
		number = numberIn;
		name = nameIn;
		
	}
public void setName(String nameIn)
{
	name = nameIn;
	
}
public void setAnnualsalary(double salaryIn)
{
	annualSalary = salaryIn;
	
}
public String getNumber()
{
	return number;
	
}
public String getName()
{
	return name;
}
public double getAnnualSalary()
{
	return annualSalary;
}
public double calculateMonthlyPay()
{
	return annualSalary/12;
}
}
