package elevator.quarter.project.population;

/**
 * An interface for a plethora of movable types that may roam the building.
 * @author ZGraceffa
 */
public interface Movable 
{
    public void callBoxRequestUp();
    public void callBoxRequestDown();
    public void waitOnFloor();
    public void floorPanelRequest();    
}
