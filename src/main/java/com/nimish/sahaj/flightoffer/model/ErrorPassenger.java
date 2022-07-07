package main.java.com.nimish.sahaj.flightoffer.model;

public class ErrorPassenger extends FlightPassenger{
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ErrorPassenger(FlightPassenger passenger, String error) {
		super(passenger);
		this.errorMessage = error;
	}
}
