package elevator.quarter.project;

/**
 *
 * @author ZGraceffa & Craig
 */
public interface ElevatorController
{
    enum Direction { UP, DOWN };
    
    public void request(Floor floorIn, Elevator elevatorIn);
}
