package elevator.quarter.project;

/**
 *
 * @author ZGraceffa & Craig
 */
public interface ElevatorController
{
    enum Direction { UP, DOWN };
    
    public void request(int elevatorIn, int floorIn);
    public void initialize(int numOfElevatorsIn);
    
    //accessors
    public int getElevatorCount();
}
