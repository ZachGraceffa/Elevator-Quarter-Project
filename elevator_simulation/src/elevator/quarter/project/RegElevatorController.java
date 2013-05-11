
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
    
    private int elevatorCount;
    
    /**
     * Default constructor creates an elevator controller with 6 elevators.
     */
    private RegElevatorController()
    {
        elevators = new ArrayList<Elevator>();
    }

    /**
     * Initializes the ElevatorController with a given number of elevators. This method initializes all elevators to the first floor.
     * @param numOfElevatorsIn 
     */
    @Override
    public void initialize(int numOfElevatorsIn)
    {
        for(int i = 0; i < numOfElevatorsIn; i++)
        {
            elevators.add(new RegElevator());
        }
        
        elevatorCount = numOfElevatorsIn;
        
        for(int i = 0; i < elevators.size(); i++)
        {
            elevators.get(i).initiallySetCurrentFloor();
        }
    }
    
    /**
     * This is the singleton getInstance() method that returns the only instance of RegElevatorController or creates it if it does not yet exist.
     * @return 
     */
    public static RegElevatorController getInstance()
    {
        if(instance == null)
        {
            synchronized(ElevatorController.class)
            {
                if(instance == null)
                {
                    instance = new RegElevatorController();
                }
            }
        }
        return instance;
    }
    
    //accessors
    /**
     * 
     * @return 
     */
    @Override
    public int getElevatorCount()
    {
        return elevatorCount;
    }
    
    /**
     * This is a simplified method designed to work with the driver main method for assignment 2. The final implementation will not use integers for parameters and will not be accessible to the main method. This is for the purposes of assignment 2 only.
     * @param floorIn
     * @param elevatorIn 
     */
    @Override
    public void request(int elevatorIn, int floorIn)
    {
        //This line looks scary, but it just adds the requested floor to the requested elevator's destination list. It basically converts integer elevator and floor values into their corresponding object references and adds the floor to the elevator's destination list.
        elevators.get(elevatorIn-1).addFloorToDestList(RegBuilding.getInstance().getFloorWithIndex(floorIn-1));
    }
    
    
    /////////////////////////////////////////////////////////
    //not sure of stuff below this line
    
    /**
     * This method receives a request from an elevator CallBox, it intelligently 
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
     * 
     * @param whichFloor
     * @param whichElevator 
     */
    private void sendElevatorUp(Floor whichFloor, Elevator whichElevator)
    {
        //if elevator is already headed in correct direction hasn't passed desired floor, simply add floor to destination list.
        
        
    }

    /**
     * 
     * @param whichFloor
     * @param whichElevator 
     */
    private void sendElevatorDown(Floor whichFloor, Elevator whichElevator)
    {
        
    }
    
}