package elevator.quarter.project;

/**
 *
 * @author Craig & ZGraceffa
 */
interface Definitions
{
    enum ElevatorState { GOING_UP, GOING_DOWN, IDLE };
    enum Door { OPEN, CLOSED };
    
    int NUM_OF_FLOORS = 15;
    int NUM_OF_ELEVATORS = 6;
    int NUM_OF_MOVABLES = 0;
    
    int DEFAULT_FLOOR = 1;
    int TIME_PER_FLOOR = 1000;
    int SCALE_FACTOR = 5;
    int DOOR_OPEN_TIME = 1000;
    int IDLE_WAIT_TIME = 10000;
}
