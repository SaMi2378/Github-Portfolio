
/**
 * The Invoice.java
  *The Invoice class implements the Payable interface.
 * @author A.Razak
 *
 */

public class Invoice implements Payable
{
   private String partNumber; 
   private String partDescription;
   private int quantity;
   private double pricePerItem;

   // four-argument constructor
   public Invoice( String part, String description, int count, 
      double price )
   {
      partNumber = part;
      partDescription = description;
      setQuantity( count ); // validate and store quantity
      setPricePerItem( price ); // validate and store price per item
   } // end four-argument Invoice constructor

   // set part number
   public void setPartNumber( String part )
   {
      partNumber = part;  
   } // end method setPartNumber

   // get part number
   public String getPartNumber()
   {
      return partNumber;
   } // end method getPartNumber

   // set description
   public void setPartDescription( String description )
   {
      partDescription = description;
   } // end method setPartDescription

   // get description
   public String getPartDescription()
   {
      return partDescription;
   } // end method getPartDescription

   // set quantity
   public void setQuantity( int count )
   {
      quantity = ( count < 0 ) ? 0 : count; // quantity cannot be negative
   } // end method setQuantity

   // get quantity
   public int getQuantity()
   {
      return quantity;
   } // end method getQuantity

   // set price per item
   public void setPricePerItem( double price )
   {
      pricePerItem = price; // validate price
   } // end method setPricePerItem

   // get price per item
   public double getPricePerItem()
   {
      return pricePerItem;
   } // end method getPricePerItem
   
   public void printDetails()
   {
	   System.out.println("invoice: ");
	   System.out.println("Part number: "+ partNumber);
	   System.out.println("Part description: "+partDescription);
	   System.out.println("Quantiy: "+quantity);
	   System.out.println("Price per item: "+pricePerItem);
	   
   }

      // method required to carry out contract with interface Payable
   public double getPaymentAmount() 
   {
	   
	  double total =  getQuantity() * getPricePerItem();
	  System.out.println("Payment due: "+total);
	  System.out.println();
      return getQuantity() * getPricePerItem(); // calculate total cost
     
   } // end method getPaymentAmount
} // end class Invoice


