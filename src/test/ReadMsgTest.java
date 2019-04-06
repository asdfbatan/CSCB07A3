package test;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import driver.Cfiltering;
import driver.ReadMsg;
import exceptions.FileNotFoundException;
import exceptions.NumberFormatException;

/**
 * test case for ReadMsg
 * @author zhangti
 *
 */
public class ReadMsgTest {

  @Test
  /**
   * test ReadMsg using input1.txt
   * 
   * @throws NumberFormatException
   * @throws IOException
   * @throws FileNotFoundException
   */
  public void test1()
      throws NumberFormatException, IOException, FileNotFoundException {
    ReadMsg reader = new ReadMsg();
    System.out.println(
        "Warning: Should print in exactly \"input1.txt\"to test correctly");
    Cfiltering readerObj = reader.runCommand();
    Cfiltering correctObj = new Cfiltering();
    correctObj.setNumberOfUsers(4);
    correctObj.setNumberOfMovies(5);
    assertEquals(correctObj.getNumberOfUsers(), readerObj.getNumberOfUsers());
    assertEquals(correctObj.getNumberOfMovies(), readerObj.getNumberOfMovies());
  }
}
