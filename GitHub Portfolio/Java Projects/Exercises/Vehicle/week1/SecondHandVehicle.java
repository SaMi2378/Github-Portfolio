package week1;

public class SecondHandVehicle extends Vehicle{
	 private int numberOfOwners;

	    public SecondHandVehicle(String regNumber, String make, int year, double currentValue, int numberOfOwners) {
	        super(regNumber, make, year, currentValue);
	        this.numberOfOwners = numberOfOwners;
	    }

	    public int getNumberOfOwners() {
	        return numberOfOwners;
	    }

	    public boolean hasMoreThanOnePreviousOwner() {
	        return numberOfOwners > 1;
	    }
	
	

}
