
//////////////// P06 Treasure Hunt //////////////////////////
//
// Title: DroppableObject
// Course: CS 300 Fall 2020
//
// Author: Jerry Yu
// Email: jcyu4@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

public class DroppableObject extends DraggableObject {
  // object over which this object can be dropped
  private VisibleObject target;
  // action that results from dropping this object over target
  private Action action;

  /**
   * Creates and initializes this new DroppableObject
   * 
   * @param name   - name of new object
   * @param x      - horizontal position of object (in pixels of this object’s left side)
   * @param y      - vertical position of object (in pixels of this object’s top side)
   * @param target - object over which this object can be dropped
   * @param action - action that results from dropping this object over target
   */
  public DroppableObject(String name, int x, int y, VisibleObject target, Action action) {
    // calls the super constructor to initialize name, x, and y
    super(name, x, y);
    // initializes target to inputed target
    this.target = target;
    // initializes action to inputed action
    this.action = action;
  }

  /**
   * Method that is called when an object is dropped, returns action and deactivates objects in
   * response to a successful drop
   * 
   * @return action if object was successfully dropped onto the target and null otherwise
   */
  @Override
  protected Action drop() {
    // checks if objects are active object was dropped on target
    if (isActive() == true && isOver(target) == true) {
      // deactivates this object
      deactivate();
      // deactivates the target
      target.deactivate();
      return action;
    } else {
      return null;
    }
  }
}
