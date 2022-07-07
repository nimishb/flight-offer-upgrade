package main.java.com.nimish.sahaj.flightoffer.enums;

public enum FlightCabin {
	
	ECONOMY("Economy"),
	PREMIUM_ECONOMY("Premium Economy"),
	BUSINESS("Business"),
	FIRST("First");
			
	
	private final String label;
	
	
	public String getLabel() {
		return this.label;
	}
	
	private FlightCabin(String label) {
		this.label = label;
	}
}
