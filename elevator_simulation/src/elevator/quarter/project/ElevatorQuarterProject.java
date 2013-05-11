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
    public static void main(String[] args)
    {
        //initialize the building with a given number of elevators, floors, and movables.
        RegBuilding.getInstance();
        RegBuilding.getInstance().initialize(1, 10, 0);
        
        //requests (elevator #, floor #)
        RegElevatorController.getInstance().request(1, 2);
        
        ArrayList<Thread> threads = new ArrayList<Thread>();
        
        for(int i = 0; i < RegElevatorController.getInstance().getElevatorCount(); i++)
        {
            threads.add(new Thread((Runnable) RegElevatorController.getInstance().getElevatorWithIndex(i)));
        }
        
        for(int i = 0; i < threads.size(); i++)
        {
            threads.get(i).start();
        }
        
    }
}
