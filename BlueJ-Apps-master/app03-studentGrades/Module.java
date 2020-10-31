
/**
 * Write a description of class Module here.
 *
 * @author Phill Horrocks
 * @version 0.1
 */
public class Module
{
    // Setup the variables to be used in the Module
    
    public String moduleTitle;
    public String moduleCode;
    public int moduleMark;
    
    /**
     * Module constructor
     */
    
    public Module(String title, String code)
    {
        moduleTitle = title;
        moduleCode = code;
        moduleMark = 0;
    }
    
    /**
     * Add a mark to module - Testing Method
     * This was to manually test conditional logic to check marks entered
     * could not exceed 100
     * 
     * It works, so this is now redundant
     */
    
    public void giveMark(int mark)
    {
        if ((mark >= 0) && (mark <= 100))
        {
            moduleMark = mark;
        } else
        {
            System.out.println("Please supply a valid mark between 0 and 100");
        }
        
    }
}