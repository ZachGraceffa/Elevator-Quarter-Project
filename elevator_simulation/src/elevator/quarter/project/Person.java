package elevator.quarter.project;

/**
 * Upon creation wait method is called, person waits on floor until random boolean
 * chooses up or down button for them.
 * @author ZGraceffa
 */
public class Person implements Movable{
    
    //gonna need dto for person to be autonomous!
    @Override
    public void callBoxRequestUp(){}
    
    @Override
    public void callBoxRequestDown(){}
    
    @Override
    public void waitOnFloor(){}
    
    @Override
    public void floorPanelRequest(){}
    
}
