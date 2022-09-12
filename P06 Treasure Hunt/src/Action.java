
//////////////// P06 Treasure Hunt //////////////////////////
//
// Title: Action
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
import java.util.ArrayList;

public class Action {
  // message printed by this action (or null to do nothing)
  private String message;
  // object to be used in another object's action
  private InteractiveObject object;

  /**
   * Creates and initializes this new action
   * 
   * @param message - message associated with the new action
   */
  public Action(String message) {
    // initializes message to the inputed message
    this.message = message;
  }

  /**
   * Creates and initializes this new action
   * 
   * @param object - object associated with the new action
   */
  public Action(InteractiveObject object) {
    // initializes object to the inputed object
    this.object = object;
  }

  /**
   * Creates and initializes this new action
   * 
   * @param message - message associated with the new action
   * @param object  - object associated with the new action
   */
  public Action(String message, InteractiveObject object) {
    // initializes message to the inputed message
    this.message = message;
    // initializes object to the inputed object
    this.object = object;
  }

  /**
   * Prints out message if message is not null and if object is not null, object is activated, added
   * to the ArrayList inputed and sets object equal to null
   */
  public void act(ArrayList<InteractiveObject> interactiveObjects) {
    // checks if message is null and prints it if it is not
    if (message != null) {
      System.out.println(message);
    }
    // checks if object is null
    if (object != null) {
      // activates object if it is not null
      object.activate();
      // adds object to the ArrayList inputed
      interactiveObjects.add(object);
      // sets object equal to null when done
      object = null;
    }
  }
}
