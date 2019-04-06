package test;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Test;
import driver.Cfiltering;
import driver.FindMostSimilarPairOfUsers;
import exceptions.*;
import exceptions.NumberFormatException;

public class FindMostSimilarPairOfUsersTest {

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
   * test case for basic FindMostSimilarPairOfUsers
   * 
   * @throws NumberFormatException
   * @throws IOException
   * @throws MatrixIndexOutOfBoundsException
   */
  public void test() throws NumberFormatException, IOException,
      MatrixIndexOutOfBoundsException {
    FindMostSimilarPairOfUsers fmdpou = new FindMostSimilarPairOfUsers();
    String correctOuput =
        "The most similar pairs of users from above userUserMatrix are:\n"
            + "User1 and User2,\n" + "User1 and User3,\n" + "User1 and User4,\n"
            + "User2 and User3,\n" + "User2 and User4,\n" + "User3 and User4,\n"
            + "with similarity score of 0.0000";
    String fmdpouOutput = fmdpou.runCommand(setUp().getNumberOfUsers(),
        setUp().getUserUserMatrix());
    assertEquals(correctOuput, fmdpouOutput);
  }
}
