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
        //initialize the building
        RegBuilding.getInstance();
        RegBuilding.getInstance().initialize(2, 2, 3);
        
        //requests
        RegElevatorController.getInstance().request(1, 2);
        

    }
}
