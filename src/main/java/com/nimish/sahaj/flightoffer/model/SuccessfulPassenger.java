package main.java.com.nimish.sahaj.flightoffer.model;

public class SuccessfulPassenger extends FlightPassenger {
	
	private String offer;

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}
	
	public SuccessfulPassenger(FlightPassenger passenger, String offer) {
		super(passenger);
		this.offer = offer;
	}
}
