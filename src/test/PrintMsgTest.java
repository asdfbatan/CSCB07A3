package test;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import driver.Cfiltering;
import driver.PrintMsg;
import driver.ReadMsg;
import exceptions.FileNotFoundException;
import exceptions.MatrixIndexOutOfBoundsException;
import exceptions.NumberFormatException;

/**
 * test case for PrintMsg
 * 
 * @author zhangti
 *
 */
public class PrintMsgTest {

  @Test
  /**
   * test PrintMsg using input1.txt
   * 
   * @throws NumberFormatException
   * @throws IOException
   * @throws FileNotFoundException
   * @throws MatrixIndexOutOfBoundsException
   */
  public void test() throws NumberFormatException, IOException,
      FileNotFoundException, MatrixIndexOutOfBoundsException {

    ReadMsg reader = new ReadMsg();
    PrintMsg printer = new PrintMsg();
    System.out.println(
        "Warning: Should print in exactly \"input1.txt\"to test correctly");
    Cfiltering cfObject = reader.runCommand();
    String printerOpt = printer.runCommand(cfObject);
    String correctOpt = "\n" + "\n" + "userUserMatrix is:\n"
        + "[1.0000, 0.1380, 0.2171, 0.1285]\n"
        + "[0.1380, 1.0000, 0.1827, 0.1614]\n"
        + "[0.2171, 0.1827, 1.0000, 0.1250]\n"
        + "[0.1285, 0.1614, 0.1250, 1.0000]\n" + "\n" + "\n"
        + "The most similar pairs of users from above userUserMatrix are:\n"
        + "User1 and User3,\n" + "with similarity score of 0.2171\n" + "\n"
        + "\n"
        + "The most dissimilar pairs of users from above userUserMatrix are:\n"
        + "User3 and User4,\n" + "with similarity score of 0.1250\n" + "";
    assertEquals(correctOpt.trim(), printerOpt.trim());
  }
}
