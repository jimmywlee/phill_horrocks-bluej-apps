import java.util.Date;
/**
 * Write a description of class Ticket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ticket
{
    private int price;
    private String destination;
    private Date currentDate = new Date();
    
    /** 
     * Construct the ticket
     */
    
    public Ticket(String destination, int price)
    {
        this.destination = destination;
        this.price = price;
    }

    public String getDestination()
    {
        return destination;
    }
    
    public int getTicketPrice()
    {
         return price;
    }
}
