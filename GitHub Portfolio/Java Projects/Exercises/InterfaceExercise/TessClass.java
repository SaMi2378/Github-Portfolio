
public class TessClass {
	
	public static void main(String[] args)
	{
		

		// Create an array of Payable objects
		Payable[] payables = new Payable[4];
		        
		// Populate the array with objects of different types
		payables[0] = new PartTimeEmployee2("Sami", "Ullah", "123-45-6789", 500.0);
		payables[1] = new PartTimeEmployee2("Naveed", "gio", "987-65-4321", 600.0);
		payables[2] = new Invoice("001", "Widget", 5, 10.0);
		payables[3] = new Invoice("002", "Gadget", 2, 25.0);

		// Process and print details for each object
		for (Payable payable : payables) 
		{
			
			System.out.println("Processing: " + payable.getClass().getName());
		    payable.printDetails(); // Polymorphic method call
		    System.out.println("Payment Amount: " + payable.getPaymentAmount()); // Polymorphic method call
		    System.out.println();
		
		}
		    

		
	}

}
