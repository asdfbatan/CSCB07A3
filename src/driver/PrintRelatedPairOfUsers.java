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
import java.util.Iterator;
import java.util.List;
import driver.FormatPrintMessage;

/**
 * A class to print related pair of users
 * 
 * @author zhangti
 */
public class PrintRelatedPairOfUsers implements FormatPrintMessage {

  /**
   * Default Constructor.
   */
  public PrintRelatedPairOfUsers() {}

  /**
   * This method print related pair of users
   * 
   * @param relation
   * @param relatedUser
   * @param extremeScore
   * @return output of related user message including type and score
   */
  public String runCommand(String relation, List<String> relatedUser,
      float extremeScore) {
    DecimalFormat decimal = new DecimalFormat("0.0000");
    StringBuffer text = new StringBuffer();
    text.append(formatPrinter());// format requirement
    text.append("\nThe most " + relation
        + " pairs of users from above userUserMatrix are:\n");
    Iterator<String> iter = relatedUser.iterator();// use iterator print result
    while (iter.hasNext()) {
      String str = (String) iter.next();
      text.append(str + ",\n");
    }
    text.append("with similarity score of " + decimal.format(extremeScore));
    String buffer = new String(text);
    return buffer;
  }

}
