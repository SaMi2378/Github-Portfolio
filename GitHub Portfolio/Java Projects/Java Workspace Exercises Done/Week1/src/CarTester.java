/**
 * A test class to test the creation of different car objects and the use of the setters and getters methods.
 * @author A. Razak
 *
 */
public class CarTester {
	
	/**
	 * The maim method.
	 * @param args
	 */
	 public static void main (String[] args)
	 {
	  Car car1 = new Car("Toyota", "Corolla" , 2003);
	  Car car2 = new Car("Nissan", "Murano" , 2004);
	  Car car3 = new Car("Infinity", "Mazda" , 2013);
	   
	  car1.setMake("BMW");
	  car1.printDetails();
	  System.out.println(car1.getYear());
	 
	  car2.setModel("Altima");
	  car2.printDetails();
	  System.out.println(car2.getMake());
	   
	  car3.setYear(2012);
	  car3.printDetails();
	  System.out.println(car3.getModel());
	 
	 
	 }

}
