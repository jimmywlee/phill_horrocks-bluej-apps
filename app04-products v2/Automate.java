
/**
 * Write a description of class Automate here.
 *
 * @author Phill Horrocks
 * @version 0.1
 */
public class Automate
{
    private static StockManager manager;
    private static StockDemo demo;
    
    public static void main()
    {
        manager = new StockManager();
        demo = new StockDemo(manager);
    }
}
