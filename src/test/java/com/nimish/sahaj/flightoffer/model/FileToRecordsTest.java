package test.java.com.nimish.sahaj.flightoffer.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import main.java.com.nimish.sahaj.flightoffer.service.OffersService;
import main.java.com.nimish.sahaj.flightoffer.service.impl.FlightOffersService;

public class FileToRecordsTest {
	
	@Test
	public void upgradeTickets_convertFileToRecordList_success() {
		OffersService offerService = new FlightOffersService();
		assertDoesNotThrow(() -> offerService.processRecordsFromFile());
	}
}
