/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator.quarter.project;

/**
 *
 * @author ZGraceffa
 */
public class RegPerson implements Movable
{
    private int currentFloor;
    
    public int getCurrentFloor()
    {
        return currentFloor;
    }
       

    @Override
    public void callBoxRequestUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void callBoxRequestDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void waitOnFloor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void floorPanelRequest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
