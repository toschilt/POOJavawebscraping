package module_exceptions;

public class RegisterExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public RegisterExistsException() { super(); }
	public RegisterExistsException(String message) { super(message); }

}
