//import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     * NOTE: This needs extra logic to break out of the input if
     * a blank input is detected. At the moment, this just states
     * that the input is empty
     */
    public String getString()
    {
        boolean isValidEntry = false; // testing
        
        System.out.print("> ");         // print prompt
        String inputLine = reader.nextLine();
        if(inputLine.isBlank() || inputLine.isEmpty())
        {
            System.out.println("Input value is empty");
        }
        
        return inputLine;
    }
    
    /**
     * Test method for separate integer input - NOT USED
     */
    public int getInt()
    {
        System.out.print("> ");         // print prompt
        int inputLine = reader.nextInt();
        return inputLine;
    }
}