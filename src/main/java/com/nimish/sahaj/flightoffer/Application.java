package main.java.com.nimish.sahaj.flightoffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.com.nimish.sahaj.flightoffer.service.OffersService;
import main.java.com.nimish.sahaj.flightoffer.service.impl.FlightOffersService;

public class Application {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
		
	public static void main(String[] args) {
		
		try {
		
			OffersService offerService = new FlightOffersService();
		
			offerService.processRecordsFromFile();
			logger.info("Processing Successful");
		}
		catch(Exception e) {
			logger.error("Processing failed with error :" + e.getLocalizedMessage());
		}
	}
}
