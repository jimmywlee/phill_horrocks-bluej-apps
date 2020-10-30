
/**
 * A class to simulate a central heating boiler / heater.
 *
 * @author Phill Horrocks
 * @version 23-10-20 v0.1
 */

public class Heater
{
    // set the temperature field
    private double temperature;
    
    /*
     * Create an initial Heater object set at 15.0 degrees
     */
    
    public Heater()
    {
        temperature = 15.0;
    }
    
    /*
     * Raise the temperature by 1.0 degree at a time
     */
    
    public void raiseTemp()
    {
        if(temperature >= 23.0){
            System.out.println("Too hot - resetting to 15.0");
            temperature = 15.0;
        }
        temperature += 1.0;
    }
    
    /*
     * Lower the temperature by 1.0 degree at a time
     */
    
    public void lowerTemp()
    {
        if(temperature <= 10.0){
            System.out.println("Too cold - resetting to 15.0");
            temperature = 16.0;
        }
        temperature -= 1.0;
    }
    
    /*
     * Display the current temperature
     * 
     */
    
    public void checkTemp()
    {
        System.out.println("The current temperature is: " + temperature +" degrees");
    }
    
    /*
     * Reset the boiler to default
     * 
     */
    
    public void resetHeater()
    {
        temperature = 15.0;
        System.out.println("Heater temperature reset to: " + temperature + " degrees");
    }
    
    /*
     * Ask the user for a direct temperature input
     * 
     */
    
    public void enterTemp(double temp)
    {
        if(temp >= 23.0)
        {
            System.out.println("Temp too high - please enter lower than 23.0 degrees");
        }
        else
        {
            temperature = temp;
            System.out.println("Temperature set to " + temperature + " degrees");
        }
    }
    
}

