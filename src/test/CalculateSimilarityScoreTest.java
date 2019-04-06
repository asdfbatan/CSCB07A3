package test;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import org.junit.Test;
import driver.*;
import exceptions.*;
import exceptions.ArrayIndexOutOfBoundsException;
import exceptions.NumberFormatException;

/**
 * test case for CalculateSimilarityScore
 * 
 * @author zhangti
 */
public class CalculateSimilarityScoreTest {

  /**
   * a method to set up the Cfiltering
   * 
   * @return
   * @throws NumberFormatException
   * @throws IOException
   */
  public Cfiltering setUp() throws NumberFormatException, IOException {
    FileInputStream fStream = new FileInputStream("input1.txt");// read file
    BufferedReader br = new BufferedReader(new InputStreamReader(fStream));

    int numberOfUsers = Integer.parseInt(br.readLine());// read #users
    int numberOfMovies = Integer.parseInt(br.readLine());// read #movies
    br.readLine();// skip blank line

    String row;
    int rowNumber = 0;
    int columnNumber = 0;// initial Cfiltering object
    Cfiltering cfObject = new Cfiltering(numberOfUsers, numberOfMovies);

    while ((row = br.readLine()) != null) {// fill the user-movie matrix
      String allRatings[] = row.split(" "); // a list of String numbers
      for (String singleRating : allRatings) {// loop through each column
        cfObject.populateUserMovieMatrix(rowNumber, columnNumber,
            Integer.parseInt(singleRating));// fill in numbers
        columnNumber++; // move pointer
      }
      rowNumber++;// move pointer to next row
      columnNumber = 0;// reset the column pointer
    }
    fStream.close();
    return cfObject;
  }

  @Test
  /**
   * test for movie1
   * 
   * @throws MatrixIndexOutOfBoundsException
   * @throws ArrayIndexOutOfBoundsException
   */
  public void test1() throws MatrixIndexOutOfBoundsException,
      ArrayIndexOutOfBoundsException, NumberFormatException, IOException {
    DecimalFormat decimal = new DecimalFormat("0.0000");
    CalculateSimilarityScore cscObject = new CalculateSimilarityScore();
    String correctOuput = decimal.format(0);
    cscObject.runCommand(0, 0, 1, setUp().getUserUserMatrix(),
        setUp().getUserMovieMatrix());
    String cscOutput = decimal.format(setUp().getUserUserMatrix()[0][0]);
    assertEquals(correctOuput, cscOutput);
  }

  @Test
  /**
   * test for movie2
   * 
   * @throws MatrixIndexOutOfBoundsException
   * @throws ArrayIndexOutOfBoundsException
   */
  public void test2()
      throws MatrixIndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
    DecimalFormat decimal = new DecimalFormat("0.0000");
    Cfiltering cfObject = new Cfiltering();
    CalculateSimilarityScore cscObject = new CalculateSimilarityScore();
    cscObject.runCommand(0, 0, 1, cfObject.getUserUserMatrix(),
        cfObject.getUserMovieMatrix());
    String correctOuput = decimal.format(1);
    String cscOutput = decimal.format(cfObject.getUserUserMatrix()[0][0]);
    assertEquals(correctOuput, cscOutput);
  }
}
