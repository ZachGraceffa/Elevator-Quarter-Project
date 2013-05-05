package elevator.quarter.project;

/**
 * 
 * @author ZGraceffa
 */

public class RegCallBox implements CallBox
{
    
    //final int floorLevel;
    
    private boolean upButtonPressed = false; 
    private boolean downButtonPressed = false; 
    
    /**
     * Checks to see if the upButton has already been pressed; if not, sends 
     * request to elevator controller.
     */
    @Override
    public void upButton()
    {
        upButtonPressed = true;
       //send request to elevator call box here.
    }
    
    @Override
    public void downButton()
    {
       downButtonPressed = true;
       //send request to elevator call box.
    }
    
    @Override
    public boolean seeUpButtonState()
    {
        return upButtonPressed;
    }
    
    @Override
    public boolean seeDownButtonState()
    {
        return downButtonPressed;
    }
    
    //will eventually need turn off button methods
}
