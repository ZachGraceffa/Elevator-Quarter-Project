package elevator.quarter.project;

import static elevator.quarter.project.Definitions.*;
import java.util.*;

/** 
 * Contains The driver for the elevator simulation, will change depending on current stage in project; see @main.
 *
 * @author Craig and ZGraceffa
 */
public class ElevatorQuarterProject {

    /** 
     * Driver for elevator simulation mapped to specific implementation 1 instructions.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidFloorRequestException
    {
        //initialize the building with a given number of elevators, floors, and movables.
        RegBuilding.getInstance();
        RegBuilding.getInstance().initialize(NUM_OF_ELEVATORS, NUM_OF_FLOORS, NUM_OF_MOVABLES);
        
        ArrayList<Thread> elevatorThreads = new ArrayList<Thread>();
        
        //create all elevator threads
        for(int i = 0; i < RegElevatorController.getInstance().getElevatorCount(); i++)
        {
            elevatorThreads.add(new Thread((Runnable) RegElevatorController.getInstance().getElevatorWithIndex(i)));
        }
        
        //start all elevator threads
        for(int i = 0; i < elevatorThreads.size(); i++)
        {
            elevatorThreads.get(i).start();
        }
        
        try
        {
            Thread.sleep(5000/SCALE_FACTOR);//allow elevators to initialize
            
            //actual test
            /*
            Thread.sleep(2000/SCALE_FACTOR);//allow elevators to initialize
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(11);
            //Thread.sleep(1000);
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(12);
            Thread.sleep(100);//to show can add dest while moving
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(10);
            Thread.sleep(1000/SCALE_FACTOR);
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(15);
            */
            
            
            
            //RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(11);
            //RegElevatorController.getInstance().getElevatorWithIndex(1).addDestination(14);
            //Thread.sleep(7000/SCALE_FACTOR);//to show can add dest while moving
            //RegElevatorController.getInstance().getElevatorWithIndex(1).addDestination(13);
            //RegElevatorController.getInstance().getElevatorWithIndex(1).addDestination(15);
            //Thread.sleep(15000/SCALE_FACTOR);//to give all elevators a chance to reach destinations
           
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(5);
            Thread.sleep(1000/SCALE_FACTOR);
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(2);
            Thread.sleep(6000/SCALE_FACTOR);
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(9);
            /*
            Thread.sleep(15000/SCALE_FACTOR);//to give all elevators a chance to reach destinations
            RegElevatorController.getInstance().getElevatorWithIndex(2).addDestination(10);//for sake of using a new elevator
            Thread.sleep(1000/SCALE_FACTOR);//give elevator 2 chance to move
            RegElevatorController.getInstance().getElevatorWithIndex(2).addDestination(1);//request should be denied
            Thread.sleep(10000/SCALE_FACTOR);//allow elevator 2 to reach dest
            RegElevatorController.getInstance().getElevatorWithIndex(2).addDestination(2);//request should be accepted
            Thread.sleep(2000/SCALE_FACTOR);
            RegElevatorController.getInstance().getElevatorWithIndex(2).addDestination(5);
            RegElevatorController.getInstance().getElevatorWithIndex(2).addDestination(3);//to demonstrate destination list sorting
            Thread.sleep(30000/SCALE_FACTOR); //allow all elevators to return to default floors
            */
            
            //craig's test
            /*
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(4);
            Thread.sleep(1000/SCALE_FACTOR);
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(2);
            Thread.sleep(1000/SCALE_FACTOR);
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(9);
            */
            
            /*
            RegElevatorController.getInstance().getElevatorWithIndex(2).addDestination(14);
            Thread.currentThread().sleep(1000/SCALE_FACTOR);
            RegElevatorController.getInstance().getElevatorWithIndex(2).addDestination(8);//to demonstrate destination list sorting
            Thread.sleep(40000/SCALE_FACTOR); //allow all elevators to return to default floors
            */
            
            
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
        
        //stop all elevator threads
        
        for(int i = 0; i < elevatorThreads.size(); i++)
        {
            RegElevatorController.getInstance().getElevatorWithIndex(i).endRun();
        }
        
        
    }//end main
    
}//end class
