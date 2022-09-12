
//////////////// P06 Treasure Hunt //////////////////////////
//
// Title: ClickableObject
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

public class ClickableObject extends VisibleObject {
  // action returned from update when this object is clicked
  private Action action;
  // tracks whether the mouse was pressed during the last update()
  private boolean mouseWasPressed;

  /**
   * Creates and initializes this new ClickableObject
   * 
   * @param name   - name of new object
   * @param x      - horizontal position of object (in pixels of this object’s left side)
   * @param y      - vertical position of object (in pixels of this object’s top side)
   * @param action - action associated with clicking on this object
   */
  public ClickableObject(String name, int x, int y, Action action) {
    // calls super constructor to initialize name, x, and y
    super(name, x, y);
    // initializes action to inputed action
    this.action = action;
  }

  /**
   * Calls VisibleObject update(), then returns action only when mouse is first clicked on this
   * object
   * 
   * @return action if object is clicked
   */
  @Override
  public Action update() {
    // updates the display
    super.update();
    // checks if mouse clicks the object
    if (super.isOver(getProcessing().mouseX, getProcessing().mouseY)
        && getProcessing().mousePressed == true && mouseWasPressed == false) {
      // sets mouseWasPressed to true
      mouseWasPressed = true;
      return action;
    } else {
      // sets mouseWasPressed to current value of mousePressed before returning
      mouseWasPressed = getProcessing().mousePressed;
      return null;
    }
  }
}
