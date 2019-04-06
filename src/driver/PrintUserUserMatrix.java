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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import exceptions.*;

/**
 * A class to print out the user-user mattrix
 * 
 * @author zhangti
 */
public class PrintUserUserMatrix implements FormatPrintMessage {

  /**
   * Default Constructor.
   */
  public PrintUserUserMatrix() {}

  /**
   * Constructs an object which contains two 2d matrices, one of size
   * users*movies which will store integer movie ratings and one of size
   * users*users which will store float similarity scores between pairs of
   * users.
   * 
   * @param numberOfUsers
   * @param UserUserMatrix
   * @return output of user-user matrix
   * @throws MatrixIndexOutOfBoundsException
   */
  public String runCommand(int numberOfUsers, float[][] UserUserMatrix)
      throws MatrixIndexOutOfBoundsException {

    if (UserUserMatrix.length == 0) { // check for invalid
      throw new MatrixIndexOutOfBoundsException("userUserMatrix Empty");
    }
    List<String> userScore = new ArrayList<String>();
    DecimalFormat decimal = new DecimalFormat("0.0000");// format requirements
    StringBuffer text = new StringBuffer();

    text.append(formatPrinter());// format requirement
    text.append("userUserMatrix is:");

    for (int i = 0; i < numberOfUsers; i++) {// calculate each box of matrix
      for (int j = 0; j < numberOfUsers; j++) {
        userScore.add(decimal.format(UserUserMatrix[i][j]));
      }
      text.append("\n" + userScore);
      userScore.clear();// reset pointer
    }
    String buffer = new String(text);
    return buffer;
  }


}
