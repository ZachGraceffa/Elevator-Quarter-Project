package elevator.quarter.project;

import elevator.quarter.project.elevatorsystem.RegElevatorController;
import elevator.quarter.project.structures.*;
import elevator.quarter.project.elevatorsystem.InvalidFloorRequestException;
import java.util.*;

/** 
 * Contains The driver for the elevator simulation, will change depending on current stage in project; see @main.
 *
 * @author Craig and ZGraceffa
 */
public class ElevatorQuarterProject implements Definitions{

    /** 
     * Driver for elevator simulation mapped to specific implementation 1 instructions.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidFloorRequestException
    {
        //initialize the building with a given number of elevators, floors, and movables.
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
            System.out.println("main");
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(3);
            Thread.sleep(3000/SCALE_FACTOR);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        //stop all elevator threads
        
        for(int i = 0; i < elevatorThreads.size(); i++)
        {
            //RegElevatorController.getInstance().getElevatorWithIndex(i).endRun();
        }
        
        
    }//end main
    
}//end class
