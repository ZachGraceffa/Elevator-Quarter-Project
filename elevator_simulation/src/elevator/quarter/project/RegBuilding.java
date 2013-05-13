package elevator.quarter.project;

import java.util.*;

/**
 * 
 * @author Craig Brott & ZGraceffa
 */
public class RegBuilding implements Building
{
    //controller
    private ElevatorController controller;
    
    //array lists of building components
    private ArrayList<Floor> floors;
    private ArrayList<Movable> movablesInBuilding;
    
    //for use as the universal time in building across all floors
    private Timer universalTime;
    
    //flag that can only be set once to ensure that the building is only initialized once.
    private boolean hasBeenInitialized;
    
    //creates a reference to the one singleton instance.
    private static RegBuilding instance = null;
    
    /**
     * Default constructor creates a building with floors elevators and movables as defined in @class definitions.java.
     */
    private RegBuilding()
    {
        System.out.println("Creating Building...");
        
        floors = new ArrayList<Floor>();
        movablesInBuilding = new ArrayList<Movable>();
        controller = RegElevatorController.getInstance();
    }// end constructor
    
    /**
     * Initializes the newly constructed Building and ElevatorController.
     * @param elevatorCountIn
     * @param floorCountIn
     * @param movableCountIn
     */
    public void initialize(int elevatorCountIn, int floorCountIn, int movableCountIn)
    {   
        if(!hasBeenInitialized)
        {
            for(int i = 0; i < floorCountIn; i++)
            {
                floors.add(new RegFloor());
            }

            /*
            //omit movables for now
            for(int i = 0; i < movableCountIn; i++)
            {
                movablesInBuilding.add(new RegPerson());
            }
            */

            //initialize the elevator controller
           RegElevatorController.getInstance().initialize(elevatorCountIn);

            System.out.println("Building created, " + floorCountIn + " Floors, " + elevatorCountIn + " Elevators.");
        }
    }//end initialize
    
    /**
     * Singleton for RegBuilding.
     * @return instance of RegBuilding
     */
    public static RegBuilding getInstance()
    {
        if(instance == null)
        {
            synchronized(Building.class)
            {
                if(instance == null)
                {
                    //System.out.println("OK");
                    instance = new RegBuilding();
                }
            }
        }
        return instance;
    }//end getInstance
    
    //accessors
    /**
     * Accessor for total number of floors (0 = 1st floor).
     * @return number of floors in building
     */
    public int getFloorCount()
    {
        return floors.size();
    }//end getFloorCount
    
    /**
     * Accessor for total count of every movable in building
     * @return count of all movables in building.
     */
    public int getMovableCount()
    {
        return movablesInBuilding.size();
    }//end getMovableCount
    
    /**
     * Accessor for floor with index @param floorIndexIn if in range.
     * @param floorIndexIn
     * @return floor with index @param floorIdexIn.
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public Floor getFloorWithIndex(int floorIndexIn) throws IndexOutOfBoundsException
    {
        floorIndexIn -= 1; //so floor 1 = floors.get(0);
        if( floorIndexIn >= 0 && floorIndexIn < floors.size())
            return floors.get(floorIndexIn);
        else
            throw new IndexOutOfBoundsException("Cannot access floor " + floorIndexIn + ". (0-" + (floors.size() - 1) +")");
    }//end getFloorWithIndex
    
    /**
     * Accessor for floor above current floor if not on top floor.
     * @param floorIn
     * @return the floor below @param floorIn.
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public Floor getNextHigherFloor(Floor floorIn) throws IndexOutOfBoundsException
    {
        if(floorIn.getFloorID() < floors.size())
            return floors.get(floors.indexOf(floorIn) + 1);
        else
            throw new IndexOutOfBoundsException("Cannot access floor " + floorIn.getFloorID() + ". (0-" + (floors.size() - 1) +")");
    }//end getNextHigherFloor
    
    /**
     * Accessor for floor below current floor if above first floor.
     * @param floorIn
     * @return the floor below @param floorIn.
     * @throws IndexOutOfBoundsException 
     */
    @Override
    public Floor getNextLowerFloor(Floor floorIn) throws IndexOutOfBoundsException
    {
        if(floorIn.getFloorID() > 0)
            return floors.get(floors.indexOf(floorIn) -1);
        else
            throw new IndexOutOfBoundsException("Cannot access floor " + floorIn.getFloorID() + ". (0-" + (floors.size() - 1) +")");
    }//end getNextLowerFloor
    
}
