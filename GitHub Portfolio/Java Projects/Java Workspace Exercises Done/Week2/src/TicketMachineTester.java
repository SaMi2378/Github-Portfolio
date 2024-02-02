/**
 * Tester class to test the ticket machine and its methods
 * @author A. Razak
 * @version 17/01/2021
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
		 tm1 = new TicketMachine(200,10);
		 
		
		 tm1.insertMoney(300);
		 tm1.getBalance();
		 tm1.printBalance();
		 tm1.insertMoney(200);
		 tm1.printBalance();
		 tm1.setChangePrice(110);
		 tm1.getTicketPrice();
		 tm1.printTicket();
		 tm1.getBalance();
		 tm1.printBalance();
		 
		 System.out.println("---------------- Second Machine -----------------------");
		 System.out.println("");
		 
		 
		 TicketMachine tm2;
		 tm2 = new TicketMachine(150, 10);
		 
		 tm2.insertMoney(700);
		 tm2.getBalance();
		 tm2.printBalance();
		 tm2.insertMoney(5000);
		 tm2.printBalance();
		 tm2.getTicketPrice();
		 tm2.printTicket();
		 tm2.getBalance();
		 tm2.printBalance();
		 
		 
		 
	 }

}
