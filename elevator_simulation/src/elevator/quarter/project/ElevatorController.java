package elevator.quarter.project;

/**
 *
 * @author ZGraceffa & Craig
 */
public interface ElevatorController
{
    enum Direction { UP, DOWN };
    
    public void request(int elevatorIn, int floorIn);
    public void initializeElevators();
    
    //accessors
    public int getElevatorCount();
}
