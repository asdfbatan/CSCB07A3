package exceptions;

/**
 * the custom exception for given the incorrect
 * 
 * @author zhangti
 */
public class FileNotFoundException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 7950403806253174707L;

  /**
   * 
   * @param errorMessage
   */
  public FileNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
