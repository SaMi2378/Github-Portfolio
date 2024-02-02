/**
 * Tester class
 * @author A. Razak
 *
 */
public class TicketMachineTester {
	
	/**
	 * The maim method.
	 * @param args
	 */
	 public static void main (String[] args)
	 {
	 
		 TicketMachine tm1;
		 tm1 = new TicketMachine(200);
		 
		// Exercise 1 part a) inserting negative amount
		

		 /* coding for exercise 1 part a)
		  * 
		 
		 tm1.insertMoney(-300);
		 tm1.getBalance();
		 tm1.printBalance();
		 */
		 
		 //Exercise 1 part b) not inserting enough money
		 
		 /* coding for exercise 1 part b)
		  */ 
		 tm1.insertMoney(200);
		 tm1.printBalance();
		 tm1.printTicket();
		 tm1.printTicket();
		 tm1.printTotal();
		 tm1.emptyMachine();		 
		    
	     
		 
	 }
}