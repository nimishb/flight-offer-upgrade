package main.java.com.nimish.sahaj.flightoffer.service;

import java.util.List;

import main.java.com.nimish.sahaj.flightoffer.model.FlightPassenger;

public interface OffersService {
	
	void processRecords();
	
	List<FlightPassenger> processRecordsFromFile();
	
	void upgradeTicketRecords(List<FlightPassenger> passengers);
}
