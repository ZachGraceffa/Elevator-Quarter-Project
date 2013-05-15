package elevator.quarter.project.elevatorsystem;

import elevator.quarter.project.Definitions;
import elevator.quarter.project.structures.*;
import java.util.ArrayList;


/**
 * Represents one working elevator.
 * @author Zach
 */
public class RegElevator1 implements Elevator1, Definitions, Runnable{
    
    private ArrayList<Floor> destinations;
    private Floor currentFloor;
    
    //state variables
    private Door doorState;
    private ElevatorState elevatorState;
    private boolean running;
    
    /**
     * Default constructor; initializes: elevator state to idle, elevator doors 
     * to closed, current floor to default floor, and destinations ArrayList.
     */
    public RegElevator1()
    {
        elevatorState = ElevatorState.IDLE;
        doorState = Door.CLOSED;
        currentFloor = RegBuilding.getInstance().getFloorWithIndex(DEFAULT_FLOOR);
        destinations = new ArrayList<Floor>();
    }
    
    /**
     * Constantly running method to delegate elevator behavior.
     */
    @Override
    public void run()
    {
        running = true;
        while(running)
        {
            synchronized(this)
            {
                if(!destinations.isEmpty())
                {
                    if(destinations.get(0).getFloorID() > currentFloor.getFloorID())
                    {
                        this.goUp();
                    }
                    else if(destinations.get(0).getFloorID() < currentFloor.getFloorID())
                    {
                        this.goDown();
                    }
                        
                }      
            }
            
            synchronized(this)
            {
                if(!destinations.isEmpty())
                {
                    if(destinations.get(0) == currentFloor)
                    {
                        this.arrived();
                    }
                }
            }

            synchronized(this)
            {
                if(destinations.isEmpty())
                {
                    this.idle();
                }
            }

        }//end while
    }
    
    /**
     * Adds a floor to this elevators destination list as long as it passes through
     * all checks.
     * @param floorIn 
     */
    public synchronized void addDestination(Floor floorIn) //throws InvalidFloorRequestException
    {
        if(destinations.isEmpty() || elevatorState == ElevatorState.IDLE)
            destinations.add(floorIn);
        else if(!destinations.isEmpty())
        {
            if(elevatorState == ElevatorState.GOING_UP)
            {
                if(currentFloor.getFloorID() < floorIn.getFloorID())
                    destinations.add(floorIn);
            }
            else if(elevatorState == ElevatorState.GOING_DOWN)
            {
                if(currentFloor.getFloorID() > floorIn.getFloorID())
                    destinations.add(floorIn);
            }
        }   
    }
    
    private void arrived()
    {
        elevatorState = ElevatorState.STOPPED;
        try
        {
            
            doorOpen();
            Thread.sleep(TIME_BETWEEN_OPEN_CLOSE/SCALE_FACTOR);
            doorClose();
            synchronized(this)
            {
                destinations.remove(0);
            }
        }
        catch(ElevatorDoorException e)
        {
            e.printStackTrace();
        }
        catch(InterruptedException f)
        {
            f.printStackTrace();
        }
            

        
    }
    
    /**
     * Sleeps for 1 second and then increments elevator floor by 1, checks to make sure not at top floor.
     * @throws InterruptedException 
     */
    private void goUp()
    {
        if(currentFloor.getFloorID() < NUM_OF_FLOORS)
        {   
            elevatorState = ElevatorState.GOING_UP;
            try
            {
                Thread.currentThread().sleep(TIME_PER_FLOOR/SCALE_FACTOR);
                currentFloor = RegBuilding.getInstance().getNextHigherFloor(currentFloor);
            }
            catch(InterruptedException e)
            {
                System.err.println("going up exception");
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Sleeps for 1 second and then decrements elevator floor by 1, checks to make sure not at ground level.
     * @throws InterruptedException 
     */
    private void goDown()
    {
        if(currentFloor.getFloorID() > 0)
        {
            elevatorState = ElevatorState.GOING_DOWN;
            try
            {
                Thread.sleep(TIME_PER_FLOOR/SCALE_FACTOR);
                currentFloor = RegBuilding.getInstance().getNextLowerFloor(currentFloor);
            }
            catch(InterruptedException e)
            {
                System.err.println("going down exception");
                e.printStackTrace();
            }
        }
    }
    
    private void idle()
    {
        boolean waitEnded = false;
        try
        {
           Thread.currentThread().sleep(IDLE_WAIT_TIME/SCALE_FACTOR); 
           waitEnded = true;
           elevatorState = ElevatorState.IDLE;
        }
        catch (InterruptedException ex) 
        {
            System.err.println("Idle timeout interrupted :)");
        }
        
        if(waitEnded)
            destinations.add(RegBuilding.getInstance().getFloorWithIndex(DEFAULT_FLOOR));
    }
    /**
     * Sleeps for 1/4 seconds and then changes door state to open, checks to make sure that elevator is moving.
     * @throws InterruptedException
     * @throws ElevatorDoorException 
     */
    @Override
    public void doorOpen() throws InterruptedException, ElevatorDoorException
    {

        if(elevatorState == ElevatorState.STOPPED)
        {
            Thread.currentThread().sleep(DOOR_OPEN_CLOSE_TIME/SCALE_FACTOR);
            doorState = Door.OPEN;
        }  
        else
            throw new ElevatorDoorException("Cannot open door while Elevator is moving!!");
    }
    
    /**
     * Sleeps for 1/4 seconds and then changes door state to closed, checks to make sure that door is not already closed.
     * @throws InterruptedException
     * @throws ElevatorDoorException 
     */
    @Override
    public void doorClose() throws InterruptedException, ElevatorDoorException
    {
        if(doorState != Door.CLOSED)
        {
            Thread.currentThread().sleep(DOOR_OPEN_CLOSE_TIME/SCALE_FACTOR);
            doorState = Door.CLOSED;
        }  
        else
            throw new ElevatorDoorException("Door is already closed!!");
    }
}
