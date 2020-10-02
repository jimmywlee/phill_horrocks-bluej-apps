
/**
 * Write a description of class Course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Course
{
    // instance variables - replace the example below with your own
    private String courseName;
    private String courseID;

    /**
     * Constructor for objects of class Course
     */
    public Course(String courseName, String courseID)
    {
        this.courseName = courseName;
        this.courseID = courseID;
    }
    
    public void print()
    {
        System.out.println("course "+ courseName +" ID "+courseID);
    }
    

}
