package elevator.quarter.project;

/**
 *
 * @author ZGraceffa & Craig
 */
public interface ElevatorController {
    //public void sendElevatorUp(Elevator whichElevator, Floor whichFloor, int direction);//int direction will eventually be changed to enumerator
    //public void sendElevatorDown(Elevator whichElevator, Floor whichFloor, int direction);
    public void request(Floor aFloor, int direction);
}
