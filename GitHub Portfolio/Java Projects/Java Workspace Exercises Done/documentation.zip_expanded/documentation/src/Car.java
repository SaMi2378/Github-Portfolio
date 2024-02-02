/**
 * A class to generate Car details
 * 
 * 
 * @author Sami Ullah
 * @version 12/05/2023
 * 
 */


public class Car
{
    // make of the car, model and regNo.
    private String make;
    private String model;
    private String regNo;
    /** Price the dealer bought the car for */
    private float boughtFor;
    /** Price the dealer sold the car for */
    private float soldFor;

    /**
     * 
     * @param make the make of the car, for instance Ford
     * @param model the model of the car, for instance Mondeo
     * @param regNo the regNo of the car, for instance WE12RFG
     * @param boughtFor	the price of the car.
     */
    public Car(String make, String model, String regNo, float boughtFor)
    {
        // initialise instance variables
        this.make = make;
        this.model = model;
        this.regNo = regNo;
        this.boughtFor = boughtFor;
        // Set soldFor = 0 to indicate we have not yet sold it.
        soldFor = 0.0f;
    }

    /**
     * @return get the make of car
     */
    public String getMake() 
    {
        return make;
    }
    
    /**
     * @return The model of the car
     */
    public String getModel() 
    {
        return model;
    }
    
    
    /**
     * @return the RegNo of the car
     */
    public String getRegNo() 
    {
        return regNo;
    }
    
    /**
     * 
     * @return the price of the car when bought
     */
    public float getBoughtFor() 
    {
        return boughtFor;
    }

    /**
     * 
     * @return the price of the car when sold
     */
    public float getSoldFor() 
    {
        return soldFor;
    }
    
    
    /**
     * Set the price of SoldFor
     * @param soldFor the price of selling
     */
    public void setSoldFor(float soldFor) 
    {
        this.soldFor = soldFor;
    }
    
    /**
     * Returns the profit generated after doing the calculations
     * @return profit generated
     */
    public float profit()
    {
        if(soldFor > 0){
            return soldFor - boughtFor;
        }
        else {
            return 0;
        }
    }
    
    /**
     * Create a string that can be used for printing.
     * 
     */
 public void printDetails()
	 {
	  System.out.println("Car make: " + make + ",  Car model: " + model + ",  Car registration number: " + regNo);
     }
    
}
