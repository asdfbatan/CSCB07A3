package exceptions;

/**
 * the custom exception for given the incorrect
 * 
 * @author zhangti
 */
public class MatrixIndexOutOfBoundsException extends Exception {

  /**
   * generate serial id
   */
  private static final long serialVersionUID = 8262974942332172364L;

  /**
   * 
   * @param errorMessage
   */
  public MatrixIndexOutOfBoundsException(String errorMessage) {
    super(errorMessage);
  }
}
