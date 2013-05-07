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
}
