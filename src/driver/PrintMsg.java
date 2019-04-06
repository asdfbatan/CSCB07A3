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

import exceptions.MatrixIndexOutOfBoundsException;;

/**
 * A class to print out the Cfiltering result of given cfObject including
 * similarity scores and score matrix
 * 
 * @author zhangti
 */
public class PrintMsg {

  /**
   * Constructor
   */
  public void printMsg() {}

  /**
   * This method print out the Cfiltering result of given cfObject
   * 
   * @param cfObject
   * @throws MatrixIndexOutOfBoundsException
   */
  public String runCommand(Cfiltering cfObject)
      throws MatrixIndexOutOfBoundsException {
    // construct need variables
    int numberOfUsers = cfObject.getNumberOfUsers();
    int numberOfMovies = cfObject.getNumberOfMovies();
    // construct needed objects
    CalculateSimilarityScore csc = new CalculateSimilarityScore();
    PrintUserUserMatrix puum = new PrintUserUserMatrix();
    FindMostSimilarPairOfUsers fmspou = new FindMostSimilarPairOfUsers();
    FindMostDissimilarPairOfUsers fmdpou = new FindMostDissimilarPairOfUsers();

    int j = 0;
    for (int i = 0; i < numberOfUsers; i++) {// calculate similarity score
      for (j = i; j < numberOfUsers; j++) {
        csc.runCommand(i, j, numberOfMovies, cfObject.getUserUserMatrix(),
            cfObject.getUserMovieMatrix());
      }
    }
    StringBuffer text = new StringBuffer();
    // print the user-user matrix
    text.append(puum.runCommand(numberOfUsers, cfObject.getUserUserMatrix()));
    // print the most similar pair of users
    text.append(fmspou.runCommand(numberOfUsers, cfObject.getUserUserMatrix()));
    // print the most dissimilar pair of users
    text.append(fmdpou.runCommand(numberOfUsers, cfObject.getUserUserMatrix()));
    String buffer = new String(text);
    return buffer;
  }
}
