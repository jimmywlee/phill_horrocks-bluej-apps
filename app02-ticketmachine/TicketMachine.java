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
    
    
    public static final Ticket AYLESBURY_TICKET = new Ticket("Aylesbury", 220);
    
    public static final Ticket AMERSHAM_TICKET = new Ticket("Amersham", 300);
    
    public static final Ticket HIGHWYCOMBE_TICKET = new Ticket("Hight Wycombe", 330);
    
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    
    // Define Aylesbury ticket
    //private double aylesburyTicketPrice;
    // private String destinationAylesbury;
    // Define Amersham ticket 
    private int amershamTicketPrice;
    private String destinationAmersham;
    // Define High Wycombe ticket
    private int highWycombeTicketPrice;
    private String destinationHighWycombe;
      

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost)
    {
        price = cost;
        balance = 0.00;
        total = 0.00;
    }

    /**
     * Create a ticket to Aylesbury
     */
    
    public void ticketAylesbury() {
        
        aylesburyTicketPrice = 2.20;
        destinationAylesbury = "Aylesbury";
        
    }
    
    /**
     * Create a ticket to Amersham
     */
    
    public void ticketAmersham() {
        
        amershamTicketPrice = 3.00;
        destinationAmersham = "Amersham";
        
    }
    
    /**
     * Create a ticket to Aylesbury
     */
    
    public void ticketHighWycombe() {
        
        highWycombeTicketPrice = 3.30;
        destinationHighWycombe = "High Wycombe";
        
    }
    
    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
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
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(double amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
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
        if(balance >= price) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " Pounds.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more pounds.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        double amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
