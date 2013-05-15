package elevator.quarter.project.elevatorsystem;

/**
 *
 * @author Zach
 */
public interface Elevator1 {
 
    //public void goUp();
    //public void goDown();
    //public void stay();
    
    /* 
     * My reasoning for only having these two methods is because this is all an 
     * elevator physically does. The controller pulls it up and down based off 
     * of recieved requests.
     */
    public void doorOpen() throws ElevatorDoorException;
    public void doorClose() throws ElevatorDoorException;

}
