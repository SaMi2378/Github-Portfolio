/**
 * A simple class that represent a car
 * @author A. Razak
 *
 */



public class Car 

	{
	
	 private String make;
	 private String model;
	 private int year;
	 
	/**
	 * Constructor to initialise car objects 
	 * @param newMake: the make of the car.
	 * @param newModel: the model of the car.
	 * @param newYear: the year og the registration.
	 */
	 public Car(String newMake,String newModel,int newYear)
	 {
	  make = newMake;
	  model= newModel;
	  year = newYear;
	 }
	  
	 /**
	  * Mutator method to change car's make
	  * @param newMake:
	  */
	 public void setMake(String newMake)
	 {
	  make = newMake;
	 }
	 
	 /**
	  *  Getter method for the make.
	  * @return Car's make
	  */
	 public String getMake()
	 {
	  return make;
	 }
	 
	 /**
	  * Mutator method to change car's model
	  * @param newModel:
	  */
	 public void setModel(String newModel)
	 {
	  model = newModel;
	  
	 }
	  
	 /**
	  * getter method for the model.
	  * @return car's model
	  */
	 public String getModel()
	 {
	  return model;
	 }
	  
	 /**
	  * Mutator method to change car's year of registration.
	  * @param newYear:
	  */
	 public void setYear(int newYear)
	 {
	  year = newYear;
	  
	 }
	 
	 /**
	  * Getter method for the year.
	  * @return car's year of registration
	  */
	 public int getYear()
	 {
	  return year;
	 }
	  
	 /**
	  * Displaying car's details
	  */
	 public void printDetails()
	 {
	  System.out.println("Car make: " + make + ",  Car model: " + model + ",  Car Year: " + year);
     }
	  
	
	}//end of class definition.
