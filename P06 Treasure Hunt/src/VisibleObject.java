
//////////////// P06 Treasure Hunt //////////////////////////
//
// Title: VisibleObject
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

import java.io.File;
import processing.core.PImage;

public class VisibleObject extends InteractiveObject {
  // the graphical representation of this object
  private PImage image;
  // the horizontal position (in pixels of this object’s left side)
  private int x;
  // the vertical position (in pixels of this object’s top side)
  private int y;

  /**
   * Creates and initializes this new VisibleObject
   * 
   * @param name - name of new object
   * @param x    - horizontal position of object (in pixels of this object’s left side)
   * @param y    - vertical position of object (in pixels of this object’s top side)
   */
  public VisibleObject(String name, int x, int y) {
    // calls super constructor to initialize name
    super(name);
    // loads image associated with name
    image = getProcessing().loadImage("images" + File.separator + name + ".png");
    // initializes x to inputed value of x
    this.x = x;
    // initializes y to inputed value of y
    this.y = y;
  }

  /**
   * Draws image at its position before returning null
   */
  @Override
  public Action update() {
    getProcessing().image(image, x, y);
    return null;
  }

  /**
   * Moves object based on distances inputed
   * 
   * @param dx - horizontal distance traveled
   * @param dy - vertical distance traveled
   */
  public void move(int dx, int dy) {
    // adds horizontal distance to current horizontal position
    this.x = x + dx;
    // adds vertical distance to current vertical position
    this.y = y + dy;
  }

  /**
   * Checks if inputed coordinates are over the image of this object
   * 
   * @param x - horizontal coordinate of point
   * @param y - vertical coordinate of point
   * @return true if point is over image of object and false otherwise
   */
  public boolean isOver(int x, int y) {
    // x value of right side of image
    double x1 = this.x + image.width;
    // y value of bottom of image
    double y1 = this.y + image.height;
    // checks if inputed coordinates are within the image of the object
    if (x <= x1 && x >= this.x && y <= y1 && y >= this.y) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks whether the two objects overlap
   * 
   * @param other - other object that is being checked
   */
  public boolean isOver(VisibleObject other) {
    // checks if other is null
    if (other != null) {
      // x value of right side of image of other
      double x1 = other.x + other.image.width;
      // x value of right side of image
      double x2 = this.x + image.width;
      // y value of bottom of image of other
      double y1 = other.y + other.image.height;
      // y value of bottom of image
      double y2 = this.y + image.height;
      // checks if images overlap
      if ((this.x >= other.x && this.x <= x1) || (x2 >= other.x && x2 <= x1)) {
        if ((this.y >= other.y && this.y <= y1) || (y2 >= other.y && y2 <= y1)) {
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}
