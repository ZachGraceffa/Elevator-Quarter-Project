/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator.quarter.project;

/**
 * Elevator callbox (up/down buttons), 1 per floor; top and bottom floor will 
 * have their corresponding button disabled.
 * @author ZGraceffa
 */
public interface CallBox
{
    public void upButton();
    public void downButton();
    //public void setFloor(int floorLevel){};

    public boolean seeDownButtonState();

    public boolean seeUpButtonState();
}
