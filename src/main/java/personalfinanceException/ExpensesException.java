package personalfinanceException;

public class ExpensesException extends RunTimeException{
     public ExpensesException (String message) {
	super(message);
}
      public ExpensesException (String message ,Throwable cause) {
    	  super (message ,cause);
      }
}
