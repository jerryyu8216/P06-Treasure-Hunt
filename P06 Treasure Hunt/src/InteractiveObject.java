
//////////////// P06 Treasure Hunt //////////////////////////
//
// Title: InteractiveObject
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

import processing.core.PApplet;

public class InteractiveObject {
  // the constant name identifying this interactive object
  private final String NAME;
  // field tracks whether or not object is active
  private boolean isActive;

  /**
   * Creates and initializes this new InteractiveObject
   * 
   * @param name - name of new object
   */
  public InteractiveObject(String name) {
    // initializes NAME to inputed name
    this.NAME = name;
    // sets isActive to true
    this.isActive = true;
  }

  /**
   * Checks if inputed name is equal to the name identifying this interactive object
   * 
   * @param name - the name being compared to NAME
   * @return true if the inputed name is equal to NAME and false otherwise
   */
  public boolean hasName(String name) {
    // checks if NAME is equal to the name inputed
    if (NAME.equals(name) == true) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Accessor method that returns the value of isActive
   * 
   * @return the value of isActive
   */
  public boolean isActive() {
    return this.isActive;
  }

  /**
   * Method that changes isActive to true
   */
  public void activate() {
    this.isActive = true;
  } // changes isActive to true

  /**
   * Method that changes isActive to false
   */
  public void deactivate() {
    this.isActive = false;
  } // changes isActive to false

  /**
   * Method that returns null and is overridden in other classes
   * 
   * @return null
   */
  public Action update() {
    return null;
  }

  // processing field
  private static PApplet processing = null;

  /**
   * Initializes processing field
   */
  public static void setProcessing(PApplet processing) {
    InteractiveObject.processing = processing;
  }

  /**
   * Accessor method that returns the static field processing
   * 
   * @return the static field processing
   */
  protected static PApplet getProcessing() {
    return processing;
  }
}
