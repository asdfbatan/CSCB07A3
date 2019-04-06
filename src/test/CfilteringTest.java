package test;

import static org.junit.Assert.*;
import org.junit.Test;
import driver.*;

/**
 * test case for Cfiltering
 * @author zhangti
 *
 */
public class CfilteringTest {
  @Test
  /**
   * test Cfiltering UserMovieMatrix
   */
  public void test1() {
    Cfiltering cfObject = new Cfiltering(4, 5);
    int correctOuput = 4;
    int cfOutput = cfObject.getUserMovieMatrix().length;
    assertEquals(correctOuput, cfOutput);
  }

  @Test
  /**
   * test Cfiltering UserUserMatrix
   */
  public void test2() {
    Cfiltering cfObject = new Cfiltering(4, 5);
    int correctOuput = 5;
    int cfOutput = cfObject.getUserUserMatrix().length;
    assertEquals(correctOuput, cfOutput);
  }


  @Test
  /**
   * test populateUserMovieMatrix
   */
  public void test3() {
    Cfiltering cfObject = new Cfiltering();
    cfObject.populateUserMovieMatrix(0, 0, Integer.parseInt("2"));
    int correctOuput = 2;
    int cfOutput = cfObject.getUserMovieMatrix()[0][0];
    assertEquals(correctOuput, cfOutput);
  }


}
