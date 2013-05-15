package elevator.quarter.project.elevatorsystem;

import elevator.quarter.project.Definitions;
import elevator.quarter.project.structures.RegBuilding;
import java.util.ArrayList;

/**
 *
 * @author ZGraceffa & Craig
 */
public class RegElevatorController implements ElevatorController, Definitions
{
    private ArrayList<Elevator1> elevators;
    private static RegElevatorController instance = null;
    
    private int elevatorCount;
    
    /**
     * Default constructor.
     */
    private RegElevatorController()
    {
        elevators = new ArrayList<Elevator1>();
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
            elevators.add(new RegElevator1());
        }

        elevatorCount = numOfElevatorsIn;

        //for(int i = 0; i < elevators.size(); i++)
        //{
          //  elevators.get(i).initiallySetCurrentFloor();
        //}
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
     * 
     * @param indexIn
     * @return 
     */
    @Override
    public Elevator1 getElevatorWithIndex(int indexIn) throws IndexOutOfBoundsException
    {
        if( indexIn >= 0 && indexIn < elevators.size())
            return elevators.get(indexIn);
        else
            throw new IndexOutOfBoundsException("Cannot access elevator " + indexIn + ". (0-" + (elevators.size() - 1) +")");
    }
    
    /**
     * This is a simplified method designed to work with the driver main method for assignment 2. The final implementation will not use integers for parameters and will not be accessible to the main method. This is for the purposes of assignment 2 only.
     * @param floorIn
     * @param elevatorIn 
     */
    /*@Override
    public void request(int elevatorIn, int floorIn)
    {
        try{
            //This line looks scary, but it just adds the requested floor to the requested elevator's destination list. It basically converts integer elevator and floor values into their corresponding object references and adds the floor to the elevator's destination list.
            elevators.get(elevatorIn-1).addDestination(RegBuilding.getInstance().getFloorWithIndex(floorIn-1).getFloorID());
        }
        catch(InvalidFloorRequestException ex)
        {
            ex.printStackTrace();
        }
    }*/
}