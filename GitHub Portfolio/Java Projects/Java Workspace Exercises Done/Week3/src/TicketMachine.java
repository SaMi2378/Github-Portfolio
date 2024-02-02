/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author A.Razak
 * @version 20.01.2021
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int ticketPrice;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int newTicketPrice)
    {
        ticketPrice = newTicketPrice;
        balance = 0;
        total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return ticketPrice;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money in cents from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    
    {
    	int amountLeftToPay;
    	amountLeftToPay = ticketPrice - balance;
        if(amountLeftToPay <= 0) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            
            System.out.println("# You have bought a ticket");
            System.out.println("# Ticket cost is:  " + ticketPrice + " Pounds.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + ticketPrice;
            // Reduce the balance by the prince.
            balance = balance - ticketPrice;
        }
        else {
        	System.out.println("# Ticket cost is:  " + ticketPrice + " Pounds.");
            System.out.println("# In order to buy a ticket, you must insert at least: " +
                               (ticketPrice - balance) + " more pounds.");
                    
        }
    }
    
    public int emptyMachine()
    {
    	int oldTotal;
    	oldTotal = total;
    	total = 0;
    	System.out.println("#############################");
    	System.out.println("# Empyting machine...");
    	System.out.println("# The total is: " + oldTotal+ " pounds.");
    	System.out.println("#############################");
    	return oldTotal;
    
    	
    }
    
    
    
    public void printBalance() {
    	
    	System.out.println("##################");
        System.out.println("# Printing the balance");
        System.out.println("# The balance is: " + balance + " Pounds");
        System.out.println("##################");
        System.out.println();
    }
    
    
    public void printTotal() {
    	
    	System.out.println("#####################################");
        System.out.println("# Printing the total amount earned...");
        System.out.println("# The total is: " + total + " Pounds");
        System.out.println("#####################################");
        System.out.println();
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        System.out.println("# The amount to refund is: " + amountToRefund + " Pounds.");
        System.out.println();
        return amountToRefund;
        
    }
}