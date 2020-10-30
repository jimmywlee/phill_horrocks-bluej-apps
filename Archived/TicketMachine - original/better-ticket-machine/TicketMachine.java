import java.util.Date;

public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    
    // Setup the 3 tickets  
    public static final Ticket AYLESBURY_TICKET = new Ticket("Aylesbury", 220);
    public static final Ticket AMERSHAM_TICKET = new Ticket("Amersham", 300);
    public static final Ticket HIGHWYCOMBE_TICKET = new Ticket("High Wycombe", 330);
    
    private Ticket selectedTicket;

    private Date today = new Date();
 
       
    /**
    * Create a machine that issues tickets of the given price.
    */
    public TicketMachine()
    {
        selectedTicket = null;
        balance = 0;
        total = 0;
    }

    /**
    * Let's build the individual tickets: Aylesbury, Amersham, High Wycombe
    */
    
    public void addAylesburyTicket(){
       selectedTicket = AYLESBURY_TICKET;
    }
    
    public void addAmershamTicket(){
       selectedTicket = AMERSHAM_TICKET;
    }
    
    public void addHighWycombeTicket(){
       selectedTicket = HIGHWYCOMBE_TICKET;
    }
    
    

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }
        
    public void balanceUpdate(int cash){
        
        balance = balance + cash;
        System.out.println("Cash in "+cash);
        displayBalance();
        
    }
    
    public void displayBalance(){
        System.out.println("Your balance is: " + balance);
    }
        
    public void insertCoin(Coin selectCoin){
    balanceUpdate(selectCoin.getValue());
    System.out.println("You just inserted: " + selectCoin.getValue());
    }
   
    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= total) {
            // Simulate the printing of a ticket.
            System.out.println("#########################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# Destination: "+selectedTicket.destination);
            System.out.println("# Date:" + selectedTicket.currentDate);
            System.out.println("# " + selectedTicket.price + " pence.");
            System.out.println("#########################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more pence.");
                    
        }
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
        return amountToRefund;
    }
}
