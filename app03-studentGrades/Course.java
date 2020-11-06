
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Derek Peacock
 * @edited by Phill Horrocks
 * @version 0.1 28/Oct/2020
 */
public class Course
{
    // Setup the course title and code variables
    private String codeNo;
    private String title;
    
    // Setup the four module objects
    private Module moduleProgramming;
    private Module moduleWeb;
    private Module moduleDigitalTech;
    private Module moduleCompArchitecture;    
    
    // Setup the mark variable
    private int totalMark;
    private int meanMark;
    
    /**
     * Constructor for objects of class Course
     */
    
    public Course(String codeNo, String title)
    {
        // initialise instance variables
        this.codeNo = codeNo;
        this.title = title;
        
        // Setup the four individual modules
        // I did it this way as I couldn't bear pointing-and-clicking to add modules!
        moduleProgramming = new Module("Programming", "ABC001");
        moduleWeb = new Module("Web Design", "ABC002");
        moduleDigitalTech = new Module("Digital Technology", "ABC003");
        moduleCompArchitecture = new Module("Computer Architecture", "ABC004");
    }
    
    /**
     * Add marks to the modules - Please enter:
     * 1 = Programming
     * 2 = Web
     * 3 = Digital Technology
     * 4 = Computer Architecture
     * 
     * NOTE: A maximum of 100 marks can be awarded for each module
     */
    
    // Get the user to select a module number then add the user-selected mark to that module.
    // Additionally, check that a mark cannot be higher than 25% for each module
    // if the mark is higher, the condition produces an error and the mark is not recorded
    
    public void addMark(int mark, int moduleNumber)
    {
        if((moduleNumber == 1) && (mark <=100))
        {
            moduleProgramming.giveMark(mark);
        }
        else if((moduleNumber == 2) && (mark <=100))
        {
            moduleWeb.giveMark(mark);
        }
        else if((moduleNumber == 3) && (mark <=100))
        {
            moduleDigitalTech.giveMark(mark);
        }
        else if((moduleNumber == 4) && (mark <=100))
        {
            moduleCompArchitecture.giveMark(mark);
        }
        else
        {
            System.out.println("The marks awarded must be less than 100");
        }
    }
    
    /**
     * Use the Grades enumeration class to lookup the grade char and assign to the mark
     * based on the total marks awarded
     */
    
    public Grades convertToGradeChar(int mark)
    {
        if ((mark>=0) && (mark <40))
        {      
            return Grades.F;
        } else if ((mark >= 40) && (mark <= 49))
        {
            return Grades.D;
        } else if ((mark >= 50) && (mark <= 59))
        {
            return Grades.C;
        } else if ((mark >= 60) && (mark <= 69))
        {
            return Grades.B;
        } else if ((mark >= 70) && (mark <= 100))
        {
            return Grades.A;
        } 
        
        return Grades.X;
        }
    
    /**
     * Work out the total marks awarded for all modules and add to totalMark
     */
    
    public int sumOfMarks()
    {
        totalMark = moduleProgramming.moduleMark + 
        moduleWeb.moduleMark + 
        moduleDigitalTech.moduleMark + 
        moduleCompArchitecture.moduleMark;
        return totalMark;
    }
    
    /**
     * Work out the mean of the marks awarded
     */
    
    public int getMeanMarks()
    {
        meanMark = sumOfMarks() / 4;
        return meanMark;
    }
    
    
    /**
     * Prints out the details including the course, all four modules and
     * the marks for each module, the total marks for all modules and
     * the grade character, A, B, C, D, F or X if undefined
     */
    public void print()
    {
        // Print out the course number and title
        System.out.println("Course " + codeNo + " - " + title);
        
        // Print out the four individual module details along with their marks awarded
        System.out.println(
            "Module: " + moduleProgramming.moduleTitle +
            "\tCode: " + moduleProgramming.moduleCode + 
            "\tMark: " + moduleProgramming.moduleMark);
        
        System.out.println(
            "Module: " + moduleWeb.moduleTitle +
            "\tCode: "+ moduleWeb.moduleCode + 
            "\tMark: "+ moduleWeb.moduleMark);
        
        System.out.println(
            "Module: " + moduleDigitalTech.moduleTitle + 
            "\tCode: " + moduleDigitalTech.moduleCode + 
            "\tMark: " + moduleDigitalTech.moduleMark);
        
        System.out.println(
            "Module: " + moduleCompArchitecture.moduleTitle + 
            "\tCode: " + moduleCompArchitecture.moduleCode + 
            "\tMark: " + moduleCompArchitecture.moduleMark);
        
        // Print the total marks for all four modules
        System.out.println("Total Mark: " + sumOfMarks());
        
        // Print the mean marks
        System.out.println("Total mean marks: " + getMeanMarks());
        
        // Convert the total marks into a grade character
        System.out.println("Final Grade:" + convertToGradeChar(meanMark));
    }
}
