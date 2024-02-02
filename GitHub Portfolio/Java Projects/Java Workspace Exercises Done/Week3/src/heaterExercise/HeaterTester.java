package heaterExercise;

public class HeaterTester {

	 public static void main (String[] args)
	 {
		 
		 Heater h1;
		 h1 = new Heater(10,80);   //We are giving the pMax and pMin values in the constructor.
		 System.out.println("Default Temperature Settings...");
		 h1.printDetails();
		 System.out.println("");
		 System.out.println("##############################");
		 System.out.println("Warming up....");
		 h1.setWarmer();
		 h1.setWarmer();
		 System.out.println("Done!!");
		 System.out.println("##############################");
		 System.out.println("");
		 h1.printDetails();
		 
		 System.out.println("");
		 System.out.println("##############################");
		 System.out.println("Cooling down....");
		 h1.setCooler();
		 System.out.println("Done!!");
		 System.out.println("##############################");
		 System.out.println("");
		 h1.printDetails();
		 
		 
		 System.out.println("Updating increment value....");
		 h1.setIncrement(2);
		 System.out.println("Done....");
		 h1.printDetails();
		 
		 System.out.println("");
		 System.out.println("##############################");
		 System.out.println("Cooling down....");
		 h1.setCooler();
		 System.out.println("Done!!");
		 System.out.println("##############################");
		 System.out.println("");
		 h1.printDetails();
		 
		 
		 
	 }
	
}
