/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator.quarter.project;

/**
 *
 * @author Craig
 */
public class RegElevator implements Elevator
{
    //current floor & queue information
    private Floor currentFloor;
    private ArrayList<Floor> destinations;
    private int doorState;
     
    //people currently on the elevator
    private ArrayList<Movable> movablesOnElevator;
    
    //other elevator components
    private int state;
    private FloorPanel elevatorFloorPanel;    
    
    @Override
    public int move(Floor floorIn)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int doorOpen()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int doorClose()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Checks that an entry request for the elevator is valid. First checks that the elevator is not at capacity, then checks that the Movable that made the request is currently on the same floor as the elevator.
     * @param movableIn
     * @throws OverCapacityException 
     */
    @Override
    public void entryRequest(Movable movableIn) throws OverCapacityException
    {
        if(movablesOnElevator.count < ELEVATOR_CAPACITY)
        {
            if(movableIn.getCurrentFloor().equals(this.currentFloor))
            {
                
            }
            else
            {
                throw new Movable
            }
        }
        else
        {
            throw new OverCapacityException();
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
        movablesOnElevator.delete(movableIn);
        currentFloor.getMovablesOnFloor().add(movableIn);
    }
}
