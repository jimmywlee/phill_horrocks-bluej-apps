
/**
 * Write a description of class Module here.
 *
 * @author Derek Peacock
 * @author Phill Horrocks
 * @version 0.1
 */
public class Module
{
    // Setup the variables to be used in the Module
    
    public String moduleTitle;
    public String moduleCode;
    public int moduleMark;
    public static final int CREDIT = 15;
    public boolean complete;
    
    /**
     * Module constructor
     */
    
    public Module(String title, String code)
    {
        moduleTitle = title;
        moduleCode = code;
        moduleMark = 0;
        complete = false;
    }
    
    /**
     * Mark given to course - mark as complete
     */
    
    public boolean isComplete()
    {
        return complete;
    }
    
    /**
     * Add a mark to module - Testing Method
     * This was to manually test conditional logic to check marks entered
     * could not exceed 100
     */
    
    public void giveMark(int mark)
    {
        if ((mark >= 0) && (mark <= 100))
        {
            moduleMark = mark;
            complete = true;
        } else
        {
            System.out.println("Please supply a valid mark between 0 and 100");
        }
        
    }
}