/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator.quarter.project;

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
