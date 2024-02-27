package personalfinanceException;

public class UserException extends RunTimeException{
	public UserException(String message) {
		super(message);
	}
 public UserException(String message, Throwable cause) {
	 super(message , cause);
 }
}
