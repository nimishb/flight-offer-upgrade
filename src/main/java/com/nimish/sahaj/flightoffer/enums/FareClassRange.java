package main.java.com.nimish.sahaj.flightoffer.enums;

public enum FareClassRange {
	
	A_E("OFFER_20"),
	F_K("OFFER_30"),
	L_R("OFFER_25"),
	S_Z("");
	
private final String label;
	
	
	public String getLabel() {
		return this.label;
	}
	
	private FareClassRange(String label) {
		this.label = label;
	}
}
