package main.java.com.nimish.sahaj.flightoffer.exception;

public class InvalidDataException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public InvalidDataException(String message) {
		super(message);
	}
}
