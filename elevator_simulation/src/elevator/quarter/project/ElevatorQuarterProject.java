package elevator.quarter.project;

import static elevator.quarter.project.Definitions.*;
import java.util.*;

/** Contains The driver for the elevator simulation, will change depending on current stage in project; see @main.
 *
 * @author Craig and ZGraceffa
 */
public class ElevatorQuarterProject {

    /** Driver for elevator simulation mapped to specific implementation 1 instructions.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidFloorRequestException
    {
        //initialize the building with a given number of elevators, floors, and movables.
        RegBuilding.getInstance();
        RegBuilding.getInstance().initialize(NUM_OF_ELEVATORS, NUM_OF_FLOORS, NUM_OF_MOVABLES);
        
        //requests (elevator #, floor #)
        //RegElevatorController.getInstance().request(1, 2);
        
        ArrayList<Thread> threads = new ArrayList<Thread>();
        
        //create all elevator threads
        for(int i = 0; i < RegElevatorController.getInstance().getElevatorCount(); i++)
        {
            threads.add(new Thread((Runnable) RegElevatorController.getInstance().getElevatorWithIndex(i)));
        }
        
        //start all elevator threads
        for(int i = 0; i < threads.size(); i++)
        {
            threads.get(i).start();
        }
        
        try
        {
            Thread.sleep(5000/SCALE_FACTOR);//allow elevators to initialize
            
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(11);
            RegElevatorController.getInstance().getElevatorWithIndex(1).addDestination(14);
            Thread.sleep(7000/SCALE_FACTOR);//to show can add dest while moving
            RegElevatorController.getInstance().getElevatorWithIndex(1).addDestination(13);
            RegElevatorController.getInstance().getElevatorWithIndex(1).addDestination(15);
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
       
            System.out.println("testing...");
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
            System.out.println("Interrupted exception in main.");
        }
        
        //stop all elevator threads
        for(int i = 0; i < threads.size(); i++)
        {
            RegElevatorController.getInstance().getElevatorWithIndex(i).endRun();
        }
        
    }//end main
    
}//end class
