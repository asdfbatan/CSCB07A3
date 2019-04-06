package exceptions;

/**
 * the custom exception for given the incorrect
 * 
 * @author zhangti
 */
public class NumberFormatException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 560027019652182722L;

  /**
   * 
   * @param errorMessage
   */
  public NumberFormatException(String errorMessage) {
    super(errorMessage);
  }
}
