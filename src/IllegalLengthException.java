/**
 * Exception thrown when there is an illegal length of a variable or parameter.
 */
public class IllegalLengthException extends IllegalArgumentException {
   /**
    * Default Constructor.
    */
   public IllegalLengthException() {
      super();
   }

   /**
    * Constructor to set the message.
    * @param message message of the Exception
    */
   public IllegalLengthException(String message) {
      super(message);
   }
}