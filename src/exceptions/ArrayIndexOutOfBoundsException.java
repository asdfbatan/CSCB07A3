package exceptions;

/**
 * the custom exception for given the incorrect
 * 
 * @author zhangti
 */
public class ArrayIndexOutOfBoundsException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 7219922024634021442L;

  /**
   * 
   * @param errorMessage
   */
  public ArrayIndexOutOfBoundsException(String errorMessage) {
    super(errorMessage);
  }
}
