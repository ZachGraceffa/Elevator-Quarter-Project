/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator.quarter.project;

import java.util.*;

/**
 * 
 * @author Craig Brott
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
     * Default constructor creates a building with 2 floors, 1 elevator, and 1 movable.
     */
    private RegBuilding()
    {
        System.out.println("Creating Building...");
        
        floors = new ArrayList<Floor>();
        movablesInBuilding = new ArrayList<Movable>();
        controller = RegElevatorController.getInstance();
    }
    
    /**
     * Initializes the newly constructed Building and ElevatorController
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
    }
    
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
    }
    
    //accessors
    public int getFloorCount()
    {
        return floors.size();
    }
    
    public int getMovableCount()
    {
        return movablesInBuilding.size();
    }

    @Override
    public Floor getFloorWithIndex(int floorIndexIn)
    {
        return floors.get(floorIndexIn);
    }

    @Override
    public Floor getNextHigherFloor(Floor floorIn)
    {
        return floors.get(floors.indexOf(floorIn) + 1);
    }

    @Override
    public Floor getNextLowerFloor(Floor floorIn)
    {
        return floors.get(floors.indexOf(floorIn) - 1);
    }
}
