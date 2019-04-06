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

import java.util.ArrayList;
import java.util.List;
import exceptions.*;
import driver.PrintRelatedPairOfUsers;

/**
 * A class to find and print most similar pair of users
 * 
 * @author zhangti
 */
public class FindMostSimilarPairOfUsers extends FindRelatedPairOfUsers {

  /**
   * Default Constructor.
   */
  public FindMostSimilarPairOfUsers() {}

  /**
   * This function finds and prints the most similar pair of users in the
   * userUserMatrix.
   * 
   * @param numberOfUsers
   * @return most similar pair of users' message
   * @throws MatrixIndexOutOfBoundsException
   */
  @Override
  public String runCommand(int numberOfUsers, float[][] userUserMatrix)
      throws MatrixIndexOutOfBoundsException {
    if (userUserMatrix.length == 0) {// check for invalid
      throw new MatrixIndexOutOfBoundsException("Matrix Empty");
    }
    PrintRelatedPairOfUsers prpou = new PrintRelatedPairOfUsers();
    float maxScore = 0;
    List<String> similarUser = new ArrayList<String>();

    for (int i = 0; i < (numberOfUsers - 1); i++) {// finds most similarUser
      for (int j = i + 1; j < (numberOfUsers); j++) {
        if (userUserMatrix[i][j] > maxScore) {
          // if found more similar one, replace it and reset the associations
          maxScore = userUserMatrix[i][j];
          similarUser.clear();
          similarUser.add("User" + (i + 1) + " and User" + (j + 1));
        } else if (userUserMatrix[i][j] == maxScore) {
          // find anther similar one
          similarUser.add("User" + (i + 1) + " and User" + (j + 1));
        }
      }
    }
    return prpou.runCommand("similar", similarUser, maxScore);
  }
}
