package elevator.quarter.project.elevatorsystem;
import elevator.quarter.project.structures.Floor;
import elevator.quarter.project.population.Movable;

/**
 *
 * @author Craig
 */
public interface Elevator
{
    public void doorOpen();
    public void doorClose();
    public void entryRequest(Movable movableIn) throws OverCapacityException;
    public void removalRequest(Movable movableIn) throws OverCapacityException;
    public void addDestination(int floorIn) throws InvalidFloorRequestException;
    public void endRun(); 

    
    //accessors
    public int getElevatorID();
    public Floor getCurrentFloor();
    
    //mutators
    public void initiallySetCurrentFloor();
}

