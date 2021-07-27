package module_exceptions;

public class PersonNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PersonNotFoundException() { super(); }
	public PersonNotFoundException(String message) { super(message); }

}
