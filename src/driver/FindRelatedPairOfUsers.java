// **********************************************************
// Assignment0:
// UTORID:
// UT Student #:
// Author:
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences. In this semester
// we will select any three of your assignments from total of 5 and run it
// for plagiarism check.
// *********************************************************
package driver;

import exceptions.*;

/**
 * An abstract class to find and print pair of users
 * 
 * @author zhangti
 */
public abstract class FindRelatedPairOfUsers {
  /**
   * abstract method for override
   * 
   * @param numberOfUsers
   * @param Matrix
   * @throws MatrixIndexOutOfBoundsException
   */
  abstract String runCommand(int numberOfUsers, float[][] Matrix)
      throws MatrixIndexOutOfBoundsException;
}
