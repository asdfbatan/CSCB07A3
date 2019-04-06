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

import java.io.IOException;
import driver.Cfiltering;
import exceptions.FileNotFoundException;
import exceptions.MatrixIndexOutOfBoundsException;
import exceptions.NumberFormatException;

/**
 * A driver for Cfiltering to analyze user movie related data
 * 
 * @author zhangti
 */
public class CfilteringDriver {

  /**
   * it reads users' rating from a given file calculate and show similarity
   * scores as well as score matrix
   * 
   * @param args
   * @throws MatrixIndexOutOfBoundsException
   * @throws FileNotFoundException
   * @throws IOException
   */
  public static void main(String[] args) throws MatrixIndexOutOfBoundsException,
      FileNotFoundException, IOException {
    try {
      // create needed objects
      ReadMsg reader = new ReadMsg();
      PrintMsg printer = new PrintMsg();
      // read the file to get input
      Cfiltering cfObject = reader.runCommand();
      // print the Cfiltering result of the input file
      System.out.println(printer.runCommand(cfObject));
    } catch (FileNotFoundException e) {
      System.err.println("Do you have the input file in the root folder "
          + "of your project?");
      System.err.print(e.getMessage());
    } catch (IOException e) {
      System.err.print(e.getMessage());
    } catch (NumberFormatException e) {
      System.err.println((e.getMessage()));
    }
  }
}
