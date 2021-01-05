import java.io.IOException;
import java.lang.InterruptedException;

/**
 * Write a description of class Program here.
 *
 * @author Phill Horrocks
 * @version 0.1
 */
public class Program
{
    private static StockApp app;

    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main() throws IOException, InterruptedException
    {
        app = new StockApp();
        app.run();
    }
}
