/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator.quarter.project;

/**
 *
 * @author Craig
 */
interface Lift
{
    enum ElevatorState { GOING_UP, GOING_DOWN, IDLE };
    enum Door { OPEN, CLOSED };
    
    int DEFAULT_FLOOR = 1;
    int TIME_PER_FLOOR = 1000;
    int SCALE_FACTOR = 1;
    int DOOR_OPEN_TIME = 1000;
    int IDLE_WAIT_TIME = 10000;
}
