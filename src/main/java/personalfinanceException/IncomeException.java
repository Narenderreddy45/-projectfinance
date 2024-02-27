package personalfinanceException;

public class IncomeException extends RuntimeException{
	public IncomeException(String message) {
	super (message);
	}
	public IncomeException (String message ,Throwable cause) {
	super(message ,cause);
	}
}
