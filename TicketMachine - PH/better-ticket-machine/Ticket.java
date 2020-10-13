import java.util.Date;
/**
 * Write a description of class Ticket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ticket
{
    // instance variables
    private int price;
    private String destination;
    private Date currentDate = new Date();
    
    /** 
     * Construct the ticket
     */
    
    public Ticket (String destination, int price){
        //Initialise
        this.destination = destination;
        this.price = price;
    }
    
    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(){
    

    }

}
