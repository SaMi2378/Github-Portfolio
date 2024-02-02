// PartTimeEmployee class - AR 

class PartTimeEmployee extends Employee
{
	private double hourlyPay;
	public PartTimeEmployee(String numberIn, String nameIn)
	{
		super(numberIn, nameIn);
	}
	public double getHourlyPay()
	{
		return hourlyPay;
		
	}
	public void setHourlyPay(double hourlyPayIn)
	{
		hourlyPay = hourlyPayIn;
	}
	public double calculateWeeklyPay(int noOfHoursIn)
	{
		return noOfHoursIn*hourlyPay;
	}
}
