
//////////////// P06 Treasure Hunt //////////////////////////
//
// Title: DraggableObject
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

public class DraggableObject extends VisibleObject {
  // tracks whether the mouse was pressed during the last update()
  private boolean mouseWasPressed;
  // tracks when an object is being dragged
  private boolean isDragging = false;
  // horizontal position of mouse during last update
  private int oldMouseX;
  // vertical position of mouse during last update
  private int oldMouseY;

  /**
   * Creates and initializes this new DraggableObject
   * 
   * @param name - name of new object
   * @param x    - horizontal position of object (in pixels of this object’s left side)
   * @param y    - vertical position of object (in pixels of this object’s top side)
   */
  public DraggableObject(String name, int x, int y) {
    // calls super constructor to initialize name, x, and y
    super(name, x, y);
  }

  /**
   * Calls VisibleObject update(), then moves if object is being dragged, and calls drop() method
   * when object is dropped
   * 
   * @return drop() each time isDragging changes from true to false or null otherwise
   */
  @Override
  public Action update() {
    // updates the display
    super.update();
    // checks if the object was clicked
    if (super.isOver(getProcessing().mouseX, getProcessing().mouseY)
        && getProcessing().mousePressed == true && mouseWasPressed == false) {
      // sets is dragging to true
      isDragging = true;
      // sets mouseWasPressed to true
      mouseWasPressed = true;
    }
    // moves object based on mouse position if isDragging was set to true and the mouse is being
    // pressed
    if (isDragging == true && mouseWasPressed == true) {
      // dx represents the horizontal distance traveled from the previous update
      int dx = getProcessing().mouseX - oldMouseX;
      // dy represents the vertical distance traveled from the previous update
      int dy = getProcessing().mouseY - oldMouseY;
      // moves the object accordingly
      move(dx, dy);
    }
    // tracks the current horizontal mouse position to oldMouseX for the next update
    oldMouseX = getProcessing().mouseX;
    // tracks the current vertical mouse position to oldMouseY for the next update
    oldMouseY = getProcessing().mouseY;
    // checks if the object was dropped
    if (isDragging == true && mouseWasPressed != getProcessing().mousePressed) {
      // sets isDragging to false
      isDragging = false;
      // sets mouseWasPressed to the current value of mousePressed for the next update
      mouseWasPressed = getProcessing().mousePressed;
      // calls the drop() method
      return drop();
    } else {
      // sets mouseWasPressed to the current value of mousePressed for the next update
      mouseWasPressed = getProcessing().mousePressed;
      return null;
    }
  }

  /**
   * Method that returns null and is overridden in another class
   * 
   * @return null
   */
  protected Action drop() {
    return null;
  }
}
