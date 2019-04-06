package driver;

/**
 * An interface to print format message
 * 
 * @author zhangti
 */
interface FormatPrintMessage {
  /**
   * base method
   */
  default String formatPrinter() {
    return "\n\n";
  }
}
