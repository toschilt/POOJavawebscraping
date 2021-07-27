package module_exceptions;

public class CannotCreateDataFileException extends Exception {

	private static final long serialVersionUID = 1L;

	public CannotCreateDataFileException() { super(); }
	public CannotCreateDataFileException(String message) { super(message); }

}
