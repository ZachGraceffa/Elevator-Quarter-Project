/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator.quarter.project;

import java.util.ArrayList;

/**
 * 
 * @author Craig
 */
public class RegElevator implements Elevator, Lift
{
    //current floor & queue information
    private int currentFloor;
    private ArrayList<Floor> destinations;
    private static int elevatorNumberCounter = 0;
    private int elevatorID;
    
    //people currently on the elevator
    private ArrayList<Movable> movablesOnElevator;
    
    //other elevator components
    
    private FloorPanel elevatorFloorPanel;
    
    //state variables
    private Door doorState;
    private ElevatorState elevatorState;
    
    //time values
    private final int timeBetweenFloors = 1000;
    private final int doorOpenCloseTime = 250;
    private final int doorStaysOpenTime = 1000;
    
    public void Elevator()
    {
        doorState = Door.CLOSED;
        movablesOnElevator = new ArrayList<Movable>();
        destinations = new ArrayList<Floor>();
        elevatorState = ElevatorState.IDLE;
        elevatorID = elevatorNumberCounter;
        elevatorNumberCounter++;
        currentFloor = 0;
    }
    
    public int getElevatorID()
    {
        return elevatorID;
    }
    
    public int getCurrentFloor()
    {
        return currentFloor;
    }
    
    @Override
    public void move(Floor floorIn) throws ElevatorNotReadyException
    {
        if(doorState == Door.OPEN)
        {
            
        }
        else
        {
            throw new ElevatorNotReadyException("This elevator's doors are closed and cannot accept movables.");
        }
    }

    @Override
    public void doorOpen()
    {
        doorState = Door.OPEN;
    }

    @Override
    public void doorClose()
    {
        doorState = Door.CLOSED;
    }
    
    /**
     * Checks that an entry request for the elevator is valid. First checks that the elevator is not at capacity, then checks that the Movable that made the request is currently on the same floor as the elevator.
     * @param movableIn
     * @throws OverCapacityException 
     */
    @Override
    public void entryRequest(Movable movableIn) throws OverCapacityException
    {
        if(movablesOnElevator.size() < ELEVATOR_CAPACITY)
        {
            if(movableIn.getCurrentFloor().equals(this.currentFloor))
            {
                
            }
            else
            {
                throw new MovableNotAvailableException("The requested movable is not on the same floor as the elevator.");
            }
        }
        else
        {
            throw new OverCapacityException("This elevator cannot accept any more movables.");
        }
        
    }

    @Override
    public void removalRequest(Movable movableIn)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * After confirming that the entry request is valid, this method will delete the movable that requested entry from its current floor and add it to the elevator. This method can potentially be delegated using the strategy pattern.
     * @param movableIn 
     */
    private void addMovable(Movable movableIn)
    {
        movableIn.getCurrentFloor().getMovablesOnFloor().delete(movableIn);
        movablesOnElevator.add(movableIn);
    }
    
    /**
     * After confirming that the exit request is valid, this method will delete the movable that requested to exit from the elevator and add it to the elevator's current floor. This method can potentially be delegated using the strategy pattern.
     * @param movableIn 
     */
    private void removeMovable(Movable movableIn)
    {
        movablesOnElevator.remove(movableIn);
        currentFloor.getMovablesOnFloor().add(movableIn);
    }
    }
