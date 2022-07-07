package main.java.com.nimish.sahaj.flightoffer.exception;

public class InvalidTicketingDateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidTicketingDateException(String message) {
		super(message);
	}
}
