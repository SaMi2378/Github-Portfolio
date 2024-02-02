


/**
 * The Employee.java
 * The Employee abstract superclass implements the Payable interface.
 * 
 * @author A.Razak
 *
 */

public abstract class Employee2 implements Payable
{
   protected String firstName;
   protected String lastName;
   protected String socialSecurityNumber;

   // three-argument constructor
   public Employee2( String first, String last, String ssn )
   {
      firstName = first;
      lastName = last;
      socialSecurityNumber = ssn;
   } // end three-argument Employee constructor

   // set first name
   public void setFirstName( String first )
   {
      firstName = first;
   } // end method setFirstName

   // return first name
   public String getFirstName()
   {
      return firstName;
   } // end method getFirstName

   // set last name
   public void setLastName( String last )
   {
      lastName = last;
   } // end method setLastName

   // return last name
   public String getLastName()
   {
      return lastName;
   } // end method getLastName

   // set social security number
   public void setSocialSecurityNumber( String ssn )
   {
      socialSecurityNumber = ssn; // should validate
   } // end method setSocialSecurityNumber

   // return social security number
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   } // end method getSocialSecurityNumber
   
   public void printDetails()
   {
	   System.out.println(firstName);
	   System.out.println(lastName);
	   System.out.println(socialSecurityNumber);
	   System.out.println();
	   System.out.println();
   } //end method printDetails
   

  
   // Note: We do not implement Payable method "getPaymentAmount" here so  
   // this class must be declared abstract to avoid a compilation error.

} // end abstract class Employee


