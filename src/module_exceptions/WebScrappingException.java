package module_exceptions;

public class WebScrappingException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebScrappingException() {}
	
	public WebScrappingException(String message) {
		super(message);
	}
	
	public WebScrappingException(String message, Throwable cause) {
		super(message, cause);
	}
}
