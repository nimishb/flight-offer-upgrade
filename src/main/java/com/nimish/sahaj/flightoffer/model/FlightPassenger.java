package main.java.com.nimish.sahaj.flightoffer.model;

import java.util.Date;

public class FlightPassenger extends User {
	
	private String pnr;
	
	private String fareClass;
	
	private Date travelDate;
	
	private Integer pax;
	
	private Date ticketingDate;
	
	private String bookedCabin;

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getFareClass() {
		return fareClass;
	}

	public void setFareClass(String fareClass) {
		this.fareClass = fareClass;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Integer getPax() {
		return pax;
	}

	public void setPax(Integer pax) {
		this.pax = pax;
	}

	public Date getTicketingDate() {
		return ticketingDate;
	}

	public void setTicketingDate(Date ticketingDate) {
		this.ticketingDate = ticketingDate;
	}

	public String getBookedCabin() {
		return bookedCabin;
	}

	public void setBookedCabin(String bookedCabin) {
		this.bookedCabin = bookedCabin;
	}
	
	public FlightPassenger() {}
	
	public FlightPassenger(FlightPassenger passenger) {
		super.setFirstName(passenger.getFirstName());
		super.setLastName(passenger.getLastName());
		this.pnr = passenger.getPnr();
		this.fareClass = passenger.getFareClass();
		this.travelDate = passenger.getTravelDate();
		this.pax = passenger.getPax();
		this.ticketingDate = passenger.getTicketingDate();
		super.setEmail(passenger.getEmail());
		super.setMobileNumber(passenger.getMobileNumber());
		this.bookedCabin = passenger.getBookedCabin();
	}

	public FlightPassenger(String pnr, String fareClass, Date travelDate, Integer pax, Date ticketingDate,
			String bookedCabin, String firstName, String lastName, String email, String mobileNumber) {
		super(firstName, lastName, email, mobileNumber);
		this.pnr = pnr;
		this.fareClass = fareClass;
		this.travelDate = travelDate;
		this.pax = pax;
		this.ticketingDate = ticketingDate;
		this.bookedCabin = bookedCabin;
	}
	
}
