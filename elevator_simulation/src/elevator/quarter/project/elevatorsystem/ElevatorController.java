package elevator.quarter.project.elevatorsystem;

/**
 *
 * @author ZGraceffa & Craig
 */
public interface ElevatorController
{
    enum Direction { UP, DOWN };
    
    //public void request(int elevatorIn, int floorIn);
    public void initialize(int numOfElevatorsIn);
    
    //accessors
    public int getElevatorCount();
    public Elevator1 getElevatorWithIndex(int indexIn);
}
