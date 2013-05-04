/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator.quarter.project;
import java.util.ArrayList;

/**
 *
 * @author ZGraceffa & Craig
 */
public class RegElevatorController implements ElevatorController, Lift
{
    private ArrayList<Elevator> elevators;
    private static RegElevatorController instance = null;
    
    private ElevatorController RegElevatorController()
    {
        synchronized(ElevatorController.class)
        {
            if(instance == null)
            {
                instance = new RegElevatorController();
            }
            return instance;
        }
    }
    
    /*/**
     * This method recieves a request from an elevator CallBox, it intelligently 
     * decides which elevator to send but takes NO ACTION; it then tells the 
     * private up/down methods to somehow service that request.
     * @param aFloor
     * @param direction
     */
   /* @Override
    public void request(Floor aFloor, int direction)
    {
        Elevator sendElevator;
        
       
        for(int i = 0; i < elevators.size(); i++)
        {
            if (elevators[i].getstate() == ElevatorState.IDLE)
            {
                sendElevator = elevators[i];
                
            }
        }
        
    }*/
    /**
     * Simple ElevatorController method that does not intelligently choose 
     * elevator.
     * @param floorIn
     * @param elevatorIn
     * @param direction 
     */
    public void request(Floor floorIn, Elevator elevatorIn)
    {   
        if(elevatorIn.getCurrentFloor() < floorIn.getID())
            sendElevatorUp(floorIn, elevatorIn);
        else if(elevatorIn.getCurrentFloor() > floorIn.getID())
            sendElevatorDown(floorIn, elevatorIn);
        
            
    }
    
    private void sendElevatorUp(Floor whichFloor, Elevator whichElevator)//will change direction to enumerstor eventually
    {
        //if elevator is already headed in correct direction hasn't passed desired floor, simply add floor to destination list.
    }
    private void sendElevatorDown(Floor whichFloor, Elevator whichElevator)//will change direction to enumerstor eventually
    {
    
    }
}