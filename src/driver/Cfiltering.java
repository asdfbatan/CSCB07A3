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

/**
 * A class to conduct user and movie related matrix
 * 
 * @author zhangti
 */
public class Cfiltering {
  // this is a 2d matrix i.e. user*movie
  private int userMovieMatrix[][];
  // this is a 2d matrix i.e. user*movie
  private float userUserMatrix[][];
  // initial values
  private int numberOfUsers;
  private int numberOfMovies;


  /**
   * Default Constructor.
   */
  public Cfiltering() {
    // this is 2d matrix of size 1*1
    setUserMovieMatrix(new int[1][1]);
    // this is 2d matrix of size 1*1
    setUserUserMatrix(new float[1][1]);
  }

  /**
   * Constructs an object which contains two 2d matrices, one of size
   * users*movies which will store integer movie ratings and one of size
   * users*users which will store float similarity scores between pairs of
   * users.
   * 
   * @param numberOfUsers Determines size of matrix variables.
   * @param numberOfMovies Determines size of matrix variables.
   */
  public Cfiltering(int numberOfUsers, int numberOfMovies) {
    // set the values of users and movies
    this.setNumberOfUsers(numberOfUsers);
    this.setNumberOfMovies(numberOfMovies);
    // this is 2d matrix of size numberOfUsers*numberOfMovies
    setUserMovieMatrix(new int[numberOfUsers][numberOfMovies]);
    // this is 2d matrix of size numberOfMovies*numberOfMovies
    setUserUserMatrix(new float[numberOfMovies][numberOfMovies]);
  }

  /**
   * getter for movie numbers
   * 
   * @return
   */
  public int getNumberOfMovies() {
    return numberOfMovies;
  }

  /**
   * setter for movie numbers
   * 
   * @param numberOfMovies
   */
  public void setNumberOfMovies(int numberOfMovies) {
    this.numberOfMovies = numberOfMovies;
  }

  /**
   * getter for user numbers
   * 
   * @return
   */
  public int getNumberOfUsers() {
    return numberOfUsers;
  }

  /**
   * setter for user numbers
   * 
   * @param numberOfUsers
   */
  public void setNumberOfUsers(int numberOfUsers) {
    this.numberOfUsers = numberOfUsers;
  }

  /**
   * getter for user-movie matrix
   * 
   * @return
   */
  public int[][] getUserMovieMatrix() {
    return userMovieMatrix;
  }

  /**
   * setter for user-movie matrix
   * 
   * @param userMovieMatrix
   */
  public void setUserMovieMatrix(int userMovieMatrix[][]) {
    this.userMovieMatrix = userMovieMatrix;
  }

  /**
   * getter for user-user matrix
   * 
   * @return
   */
  public float[][] getUserUserMatrix() {
    return userUserMatrix;
  }

  /**
   * setter for user-user matrix
   * 
   * @param userUserMatrix
   */
  public void setUserUserMatrix(float userUserMatrix[][]) {
    this.userUserMatrix = userUserMatrix;
  }

  /**
   * The purpose of this method is to populate the UserMovieMatrix. As input
   * parameters it takes in a rowNumber, columnNumber and a rating value. The
   * rating value is then inserted in the UserMovieMatrix at the specified
   * rowNumber and the columnNumber.
   * 
   * @param rowNumber The row number of the userMovieMatrix.
   * @param columnNumber The column number of the userMovieMatrix.
   * @param ratingValue The ratingValue to be inserted in the userMovieMatrix
   */
  public void populateUserMovieMatrix(int rowNumber, int columnNumber,
      int ratingValue) {
    getUserMovieMatrix()[rowNumber][columnNumber] = ratingValue;
  }
}
