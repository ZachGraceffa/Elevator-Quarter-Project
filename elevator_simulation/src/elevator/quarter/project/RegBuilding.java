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
    private ArrayList<Elevator> elevators;
    private ArrayList<Movable> movablesInBuilding;
    
    //for use as the universal time in building across all floors
    private Timer universalTime;
    
    //creates a reference to the one singleton instance.
    private static RegBuilding instance = null;
    
    /**
     * Default constructor creates a building with 2 floors, 1 elevator, and 1 movable.
     */
    private RegBuilding()
    {
        System.out.println("Creating Building...");
        
        int floorCount = 15;
        int elevatorCount = 6;
        int movableCount = 1;
        
        floors = new ArrayList<Floor>();
        elevators = new ArrayList<Elevator>();
        movablesInBuilding = new ArrayList<Movable>();
        
        
        for(int i = 0; i < floorCount; i++)
        {
            floors.add(new RegFloor());
        }
        
        for(int i = 0; i < elevatorCount; i++)
        {
            elevators.add(new RegElevator());
        }
        
        //leave out the movable code for now
        /*      
        for(int i = 0; i < movableCount; i++)
        {
            movablesInBuilding.add(new RegPerson());
        }
        */
        
        controller = RegElevatorController.getInstance();
        
        System.out.println("Building created, " + floorCount + " Floors, " + elevatorCount + " Elevators.");
    }
    
    private RegBuilding(int elevatorCountIn, int floorCountIn, int movableCountIn)
    {
        System.out.println("Creating Building...");
        
        for(int i = 0; i < floorCountIn; i++)
        {
            floors.add(new RegFloor());
        }
        
        for(int i = 0; i < elevatorCountIn; i++)
        {
            elevators.add(new RegElevator());
        }
                
        for(int i = 0; i < movableCountIn; i++)
        {
            movablesInBuilding.add(new RegPerson());
        }
        
        controller = RegElevatorController.getInstance();
        
        System.out.println("Building created, " + floorCountIn + " Floors, " + elevatorCountIn + " Elevators.");
    }
    
    public static RegBuilding getInstance()
    {
        if(instance == null)
        {
            synchronized(Building.class)
            {
                if(instance == null)
                {
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
}
