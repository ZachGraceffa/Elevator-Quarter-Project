package elevator.quarter.project;

/**
 * An interface for a plethora of movable types that may roam the building.
 * @author ZGraceffa
 */
public interface Movable 
{
    void callBoxRequestUp();
    void callBoxRequestDown();
    void waitOnFloor();
    void floorPanelRequest();
        
}
