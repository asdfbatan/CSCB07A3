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

/**
 * A class to find and print most dissimilar pair of users
 * 
 * @author zhangti
 */
public class FindMostDissimilarPairOfUsers extends FindRelatedPairOfUsers {

  /**
   * Default Constructor.
   */
  public FindMostDissimilarPairOfUsers() {}

  /**
   * This function finds and prints the most dissimilar pair of users in the
   * userUserMatrix.
   * 
   * @param numberOfUsers
   * @return most dissimilar pair of users' message
   * @throws MatrixIndexOutOfBoundsException
   */
  @Override
  public String runCommand(int numberOfUsers, float[][] userUserMatrix)
      throws MatrixIndexOutOfBoundsException {
    if (userUserMatrix.length == 0) {// check for invalid
      throw new MatrixIndexOutOfBoundsException("Matrix Empty");
    }
    PrintRelatedPairOfUsers prpou = new PrintRelatedPairOfUsers();
    float minScore = 1;
    List<String> dissimilarUser = new ArrayList<String>();

    for (int x = 0; x < (numberOfUsers - 1); x++) {// finds most dissimilarUser
      for (int y = x + 1; y < (numberOfUsers); y++) {
        if (userUserMatrix[x][y] < minScore) {
          // if found more similar one, replace it and reset the associations
          minScore = userUserMatrix[x][y];
          dissimilarUser.clear();
          dissimilarUser.add("User" + (x + 1) + " and User" + (y + 1));
        } else if (userUserMatrix[x][y] == minScore) {
          // find anther similar one
          dissimilarUser.add("User" + (x + 1) + " and User" + (y + 1));
        }
      }
    }
    return prpou.runCommand("dissimilar", dissimilarUser, minScore);
  }
}
