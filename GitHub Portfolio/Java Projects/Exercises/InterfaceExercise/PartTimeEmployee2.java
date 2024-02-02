

/**
 * PartTimeEmployee.java
 * The PartTimeEmployee class extends the Employee superclass (abstract), which implements the Payable interface.
 * 
 * @author A.Razak
 *
 */

public class PartTimeEmployee2 extends Employee2 implements Payable
{
   private double weeklySalary;

   // four-argument constructor
   public PartTimeEmployee2( String first, String last, String ssn, 
      double salary )
   {
      super( first, last, ssn ); // pass to Employee constructor
      setWeeklySalary( salary ); // validate and store salary
   } // end four-argument PartTimeEmployee constructor

   // set salary
   public void setWeeklySalary( double salary )
   {
	  if (salary>=0) 
      weeklySalary = salary;
   } // end method setWeeklySalary

   // return salary
   public double getWeeklySalary()
   {
      return weeklySalary;
   } // end method getWeeklySalary
   

   // calculate earnings; implement interface Payable method that was
   // abstract in superclass Employee
   
   public double getPaymentAmount()
   {
	  System.out.println("Payment due: "+weeklySalary);
	  System.out.println();
      return getWeeklySalary();
   } // end method getPaymentAmount
   
   public void printDetails()
   {
	   System.out.println("part time employee name: "+firstName +" " +lastName);
	   System.out.println("Social security number: "+socialSecurityNumber);
	   System.out.println("Weekly salary: "+weeklySalary);
	  
   }// end method prinDetails
   
} // end class PartTimeEmployee


