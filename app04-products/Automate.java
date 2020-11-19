/**
 * Write a description of class Program here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Automate
{
    //private static StockDemo demo;
    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main()
    {
        StockManager stock = new StockManager();
        StockDemo demo = new StockDemo(stock);
    }
}
