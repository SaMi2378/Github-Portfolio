package week1;

public class VehicleTesterClass {
	 public static void main(String[] args) {
	        // Create a SecondHandVehicle instance with 2 previous owners
	        SecondHandVehicle vehicle1 = new SecondHandVehicle("AB15CDE", "Toyota", 2015, 15000.0, 2);

	        // Create another SecondHandVehicle instance with 1 previous owner
	        SecondHandVehicle vehicle2 = new SecondHandVehicle("XY68EFG", "Honda", 2018, 18000.0, 1);

	        // Access and print the attributes
	        System.out.println("Vehicle 1:");
	        System.out.println("Registration Number: " + vehicle1.getRegNumber());
	        System.out.println("Make: " + vehicle1.getMake());
	        System.out.println("Year: " + vehicle1.getYear());
	        System.out.println("Current Value: " + "$"+ vehicle1.getCurrentValue());
	        System.out.println("Number of Owners: " + vehicle1.getNumberOfOwners());
	        System.out.println("Has more than one previous owner? --> " + vehicle1.hasMoreThanOnePreviousOwner());

	        System.out.println();

	        System.out.println("Vehicle 2:");
	        System.out.println("Registration Number: " + vehicle2.getRegNumber());
	        System.out.println("Make: " + vehicle2.getMake());
	        System.out.println("Year: " + vehicle2.getYear());
	        System.out.println("Current Value: " + "$"+ vehicle2.getCurrentValue());
	        System.out.println("Number of Owners: " +  vehicle2.getNumberOfOwners());
	        System.out.println("Has more than one previous owner? --> " + vehicle2.hasMoreThanOnePreviousOwner());
	    }

}
