/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator.quarter.project;

import java.util.*;

/**
 *
 * @author Craig
 */
public class ElevatorQuarterProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidFloorRequestException
    {
        //initialize the building with a given number of elevators, floors, and movables.
        RegBuilding.getInstance();
        RegBuilding.getInstance().initialize(2, 10, 0);
        
        //requests (elevator #, floor #)
        RegElevatorController.getInstance().request(1, 2);
        
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
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(5);
            
            RegElevatorController.getInstance().getElevatorWithIndex(1).addDestination(6);
            Thread.sleep(6000);
            RegElevatorController.getInstance().getElevatorWithIndex(0).addDestination(9);
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}
