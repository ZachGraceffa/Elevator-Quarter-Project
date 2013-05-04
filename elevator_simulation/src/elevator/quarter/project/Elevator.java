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
    
    public void move(Floor floorIn) throws ElevatorNotReadyException;
    public void doorOpen();
    public void doorClose();
    public void entryRequest(Movable movableIn) throws OverCapacityException;
    public void removalRequest(Movable movableIn) throws OverCapacityException;
}

