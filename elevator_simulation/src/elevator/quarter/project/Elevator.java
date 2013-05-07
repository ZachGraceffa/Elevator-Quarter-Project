/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator.quarter.project;

/**
 *
 * @author Craig
 */
public interface Elevator
{
    public void addFloorToDestList(Floor floorIn);
    public void doorOpen();
    public void doorClose();
    public void entryRequest(Movable movableIn) throws OverCapacityException;
    public void removalRequest(Movable movableIn) throws OverCapacityException;
    
    //accessors
    public int getElevatorID();
    public Floor getCurrentFloor();
    
    //mutators
    public void initiallySetCurrentFloor();
}

