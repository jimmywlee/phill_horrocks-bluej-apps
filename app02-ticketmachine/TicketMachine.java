/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Phill Horrocks
 */

import java.util.Date;

public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    
    private int change;
    
    // Setup the 3 tickets and assign their values
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
        selectedTicket = null; // Ensure no ticket is selected when initiated
        balance = 0;
        total = 0;
        price = 0;
    }

    /**
     * Print all destinations
     */
    public void printAllDestinations()
    {
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("=-= Tickets Available =-=");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        
        System.out.println("Destination: " + AYLESBURY_TICKET.getDestination());
        System.out.println("Ticket Cost:" + AYLESBURY_TICKET.getTicketPrice());
        System.out.println();
        
        System.out.println("Destination: " + AMERSHAM_TICKET.getDestination());
        System.out.println("Ticket Cost:" + AMERSHAM_TICKET.getTicketPrice());
        System.out.println();
        
        System.out.println("Destination: " + HIGHWYCOMBE_TICKET.getDestination());
        System.out.println("Ticket Cost:" + HIGHWYCOMBE_TICKET.getTicketPrice());
        System.out.println();
    }
    
    /**
    * Let's build the individual tickets: Aylesbury, Amersham, High Wycombe
    * and assign them
    */
    
    public void addAylesburyTicket()
    {
       selectedTicket = AYLESBURY_TICKET;
       System.out.println("Alyesbury Ticket Added");
    }
    
    public void addAmershamTicket()
    {
       selectedTicket = AMERSHAM_TICKET;
       System.out.println("Amersham Ticket Added");
    }
    
    public void addHighWycombeTicket()
    {
       selectedTicket = HIGHWYCOMBE_TICKET;
       System.out.println("High Wycombe Ticket Added");
    }
    
    /**
     * Display the ticket selected
     */
    public void showTicketSelected ()
    {
        System.out.println(selectedTicket.destination+" selected");
    }
    
    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }
    
    // Manually update the balance for testing
    public void balanceUpdate(int cash)
    {
        
        balance = balance + cash;
        System.out.println("Cash in "+cash);
        displayBalance();
        
    }
    
    public void displayBalance()
    {
        System.out.println("Your balance is: " + balance);
    }
    
    // For diagnostics
    public void showAllInfo()
    {
        System.out.println("Balance: "+balance);
        System.out.println("Total: "+total);
        System.out.println("Ticket Destination: "+selectedTicket.destination);
        System.out.println("Ticket Price: "+selectedTicket.price);
    }
    
    /**
     * This is the Coin Enum method.
     * I tried it to test if it works - it does (and documented)
     * Switch method more elegant IMHO. Just saying.
     */
    public void insertCoin(Coin coin)
    {
        balanceUpdate(coin.getValue());
        System.out.println("You just inserted: " + coin.getValue());
    }
        
    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= selectedTicket.price){
            // Simulate the printing of a ticket.
            System.out.println("#########################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# Destination: " + selectedTicket.destination);
            System.out.println("# Date:" + selectedTicket.currentDate);
            System.out.println("# Ticket Price: " + selectedTicket.price + " pence.");
            System.out.println("#########################");
            System.out.println();
            
            // print out any change due back
            change = balance - selectedTicket.price;
            System.out.println("Change due: " + change);

            // Update the total collected with the price.
            total = total + selectedTicket.price;
            // Reduce the balance by the prince.
            balance = balance - selectedTicket.price;
        }
        else{ 
            System.out.println("You must insert at least: " +
                               (selectedTicket.price - balance) + " more pence.");
                    
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