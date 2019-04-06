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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import driver.Cfiltering;
import exceptions.NumberFormatException;
import exceptions.FileNotFoundException;

/**
 * A class to read the input msg from given file and return a constructed
 * Cfiltering object
 * 
 * @author zhangti
 */
public class ReadMsg {

  /**
   * Constructor
   */
  public void readMsg() {}

  /**
   * This method turns the input msg from given file into a constructed
   * Cfiltering object
   * 
   * @return a constructedCfiltering object
   * @throws NumberFormatException
   * @throws IOException
   * @throws FileNotFoundException
   */
  public Cfiltering runCommand()
      throws NumberFormatException, IOException, FileNotFoundException {
    Scanner in = new Scanner(System.in);// open file to read
    System.out.println("Enter the name of input file? ");
    FileInputStream fStream = new FileInputStream(in.nextLine());// read file
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
    in.close();
    return cfObject;
  }
}
