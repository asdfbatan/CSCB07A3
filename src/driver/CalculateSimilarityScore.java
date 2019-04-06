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
 * A class to deal with the movie and user's rate
 * 
 * @author zhangti
 */
public class CalculateSimilarityScore {

  /**
   * constructor
   */
  public CalculateSimilarityScore() {}

  /**
   * Determines how similar each pair of users is based on their ratings. This
   * similarity value is represented with with a float value between 0 and 1,
   * where 1 is perfect/identical similarity. Stores these values in the
   * userUserMatrix.
   * 
   * @param user1
   * @param user2
   * @param numberOfMovies
   * @param userUserMatrix
   * @param userMovieMatrix
   * @throws MatrixIndexOutOfBoundsException
   */
  public void runCommand(int user1, int user2, int numberOfMovies,
      float[][] userUserMatrix, int[][] userMovieMatrix)
      throws MatrixIndexOutOfBoundsException {
    // check if matrix valid
    if (userUserMatrix.length == 0 | userMovieMatrix.length == 0) {
      throw new MatrixIndexOutOfBoundsException("Matrix Empty");
    }
    double distance = 0;
    for (int i = 0; i < numberOfMovies; i++) {
      // use Euclidean Distance Formula to calculate the distanc
      distance = distance + Math
          .pow(((userMovieMatrix[user1][i] - userMovieMatrix[user2][i])), 2);
    }
    // calculate the similarity score
    double similarityScore = (1 / (1 + Math.sqrt(distance)));
    // Store similarity score in both upper and lower triangle in Matrix
    userUserMatrix[user1][user2] = (float) similarityScore;
    userUserMatrix[user2][user1] = (float) similarityScore;
  }
}
