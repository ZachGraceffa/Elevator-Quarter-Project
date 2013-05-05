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
    private ArrayList<Elevator> elevators;
    
    //for use as the universal time in building across all floors
    private Timer universalTime;
    
    //creates a reference to the one singleton instance.
    private static RegBuilding instance = null;
    
    public int getFloorCount()
    {
        return floors.size();
    }
    
    public int getElevatorCount()
    {
        return floors.size();
    }
    
    public int getMovableCount()
    {
        return movablesInBuilding.size();
    }
    
    //default constructor creates a building with 2 floors, 1 elevator, and 1 movable.
    private RegBuilding()
    {
        int floorCount = 2;
        int elevatorCount = 1;
        int movableCount = 1;
        
        for(int i = 0; i < floorCount; i++)
        {
            floors.add(new RegFloor());
        }
        
        for(int i = 0; i < elevatorCount; i++)
        {
            elevators.add(new RegElevator());
        }
                
        for(int i = 0; i < movableCount; i++)
        {
            movablesInBuilding.add(new RegPerson());
        }
        
    }
    
    private RegBuilding(int elevatorCountIn, int floorCountIn, int movableCountIn)
    {
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
        
        
        //construct elevator controller
        
        /*
         * takes the following:
         * # of elevators
         * # of movables to start out initially
         * # of floors
         * responsible for constructing the elevator controller
         * building is a singleton
         * elevator controller is a singleton
         */
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
}
