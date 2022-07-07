package main.java.com.nimish.sahaj.flightoffer.exception;

public class InvalidPNRException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPNRException(String message) {
		super(message);
	}
}
