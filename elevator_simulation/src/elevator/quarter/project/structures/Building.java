
package elevator.quarter.project.structures;

/**
 *
 * @author Craig
 */
public interface Building
{
    public Floor getFloorWithIndex(int floorIndexIn);
    public Floor getNextHigherFloor(Floor floorIn);
    public Floor getNextLowerFloor(Floor floorIn);
}
