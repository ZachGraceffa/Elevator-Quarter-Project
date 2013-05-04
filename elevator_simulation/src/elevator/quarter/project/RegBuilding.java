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
public class RegBuilding
{
    //controller
    private ElevatorController controller;
    
    //array lists of building components
    private ArrayList<Floor> floors;
    private ArrayList<Movable> movablesInBuilding;
    private ArrayList<Elevator> elevators;
    
    //counters
    private int numOfFloors;
    private int numOfElevators;
    private int numOfMovables;
    
    //for use as the universal time in building across all floors
    private Timer universalTime;
    
    //creates a reference to the one singleton instance.
    private static RegBuilding instance = null;
    
    //default constructor creates a building with 2 floors, 1 elevator, and 1 movable.
    private RegBuilding()
    {
        numOfFloors = 2;
        numOfElevators = 1;
        numOfMovables = 2;
    }
    
    private RegBuilding(int numOfElevatorsIn, int numOfFloorsIn, int numOfMovablesIn)
    {
        numOfFloors = numOfFloorsIn;
        numOfElevators = numOfElevatorsIn;
        numOfMovables = numOfMovablesIn;
        
        for(int i = 0; i < numOfFloors; i++)
        {
            floors.add(new RegFloor());
        }
        
        for(int i = 0; i < numOfElevators; i++)
        {
            elevators.add(new RegElevator());
        }
                
        for(int i = 0; i < numOfMovables; i++)
        {
            movablesInBuilding.add(new Person());
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
