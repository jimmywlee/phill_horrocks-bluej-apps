
/**
 * Testing automation to auto-create a StockManager object and StockDemo object to save all the right clicking!
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
        demo.executeDemo();
    }
}
