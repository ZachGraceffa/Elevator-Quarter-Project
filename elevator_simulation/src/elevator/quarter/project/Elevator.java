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
    int ELEVATOR_CAPACITY = 20;
    
    public int move(Floor floorIn);
    public int doorOpen();
    public int doorClose();
    public void entryRequest(Movable movableIn) throws OverCapacityException;
    public void removalRequest(Movable movableIn) throws OverCapacityException;
}

