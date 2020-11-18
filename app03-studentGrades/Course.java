
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
    
    // Setup the rest of the variables
    private boolean complete;
    private int totalMark;
    private int totalCredits;
    private int meanMark;
    private int modules;
    
    /**
     * Constructor for objects of class Course
     */
    
    public Course(String codeNo, String title)
    {
        // initialise variables
        this.codeNo = codeNo;
        this.title = title;
        
        // Setup the four individual modules
        // I did it this way as I couldn't bear pointing-and-clicking to add modules!
        moduleProgramming = new Module("Programming", "ABC001");
        moduleWeb = new Module("Web Design", "ABC002");
        moduleDigitalTech = new Module("Digital Technology", "ABC003");
        moduleCompArchitecture = new Module("Computer Architecture", "ABC004");
        
        complete = false;
        totalCredits = 0;
        totalMark = 0;
    }
    
    /**
     * Print the modules in the course
     */
    public void printModules()
    {
        System.out.println("Course: " + codeNo + " " + title);
        
        System.out.println("Module 1: " + moduleProgramming.moduleTitle);
        System.out.println("Module 2: " + moduleWeb.moduleTitle);
        System.out.println("Module 3: " + moduleDigitalTech.moduleTitle);
        System.out.println("Module 4: " + moduleCompArchitecture.moduleTitle);
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
    // Additionally, check that a mark cannot be higher than 100 for each module
    // if the mark is higher, the condition produces an error and the mark is not recorded
    
    public void addMark(int mark, int moduleNumber)
    {
        if((moduleNumber == 1) && (mark <=100))
        {
            moduleProgramming.giveMark(mark);
            totalCredits += Module.CREDIT;
        }
        else if((moduleNumber == 2) && (mark <=100))
        {
            moduleWeb.giveMark(mark);
            totalCredits += Module.CREDIT;
        }
        else if((moduleNumber == 3) && (mark <=100))
        {
            moduleDigitalTech.giveMark(mark);
            totalCredits += Module.CREDIT;
        }
        else if((moduleNumber == 4) && (mark <=100))
        {
            moduleCompArchitecture.giveMark(mark);
            totalCredits += Module.CREDIT;
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
        if (totalCredits >= 60)
        {
            // Print out the course number and title
            System.out.println("Course " + codeNo + " - " + title);
            
            // Print out the four individual module details along with their marks awarded
            System.out.println(
                "Module: " + moduleProgramming.moduleTitle +
                "\t\tCode: " + moduleProgramming.moduleCode + 
                "\tMark: " + moduleProgramming.moduleMark);
            
            System.out.println(
                "Module: " + moduleWeb.moduleTitle +
                "\t\tCode: "+ moduleWeb.moduleCode + 
                "\t\tMark: "+ moduleWeb.moduleMark);
            
            System.out.println(
                "Module: " + moduleDigitalTech.moduleTitle + 
                "\t\tCode: " + moduleDigitalTech.moduleCode + 
                "\t\tMark: " + moduleDigitalTech.moduleMark);
            
            System.out.println(
                "Module: " + moduleCompArchitecture.moduleTitle + 
                "\t\tCode: " + moduleCompArchitecture.moduleCode + 
                "\t\tMark: " + moduleCompArchitecture.moduleMark);
            
            // Print the total marks for all four modules
            System.out.println("Total Mark: " + sumOfMarks());
            
            // Print the mean marks
            System.out.println("Total mean marks: " + getMeanMarks());
            
            // Convert the total marks into a grade character
            System.out.println("Final Grade:" + convertToGradeChar(meanMark));
        } else
            System.out.println("You haven't completed all the modules yet");
    }
}
