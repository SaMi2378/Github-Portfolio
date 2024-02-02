package week1;

public class Vehicle {
	
	protected String regNumber;
	protected String make;
	protected int year;
	protected double currentValue; 
	
	public Vehicle()
	{
		
	}
	
	
	
	public Vehicle(String regNumber, String make, int year, double currentValue)
	{
		this.regNumber = regNumber;
		this.make = make;
		this.year = year;
		this.currentValue = currentValue;
		
	}



	public String getRegNumber() {
		return regNumber;
	}



	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}



	public String getMake() {
		return make;
	}



	public void setMake(String make) {
		this.make = make;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public double getCurrentValue() {
		return currentValue;
	}



	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	
	
	
	
	

}
