package main.java.com.nimish.sahaj.flightoffer.service.impl;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.com.nimish.sahaj.flightoffer.constant.Constant;
import main.java.com.nimish.sahaj.flightoffer.exception.InvalidDataException;
import main.java.com.nimish.sahaj.flightoffer.model.ErrorPassenger;
import main.java.com.nimish.sahaj.flightoffer.model.FlightPassenger;
import main.java.com.nimish.sahaj.flightoffer.model.SuccessfulPassenger;
import main.java.com.nimish.sahaj.flightoffer.service.ConversionService;
import main.java.com.nimish.sahaj.flightoffer.service.OffersService;
import main.java.com.nimish.sahaj.flightoffer.util.FareClassUtil;
import main.java.com.nimish.sahaj.flightoffer.util.ValidationUtil;
import main.java.com.nimish.sahaj.flightoffer.util.WorkbookUtil;

public class FlightOffersService implements OffersService {
	
	private static Logger logger = LoggerFactory.getLogger(FlightOffersService.class);
	
	@Override
	public void processRecords() {
		
		List<FlightPassenger> passengers = processRecordsFromFile();
		upgradeTicketRecords(passengers);
	}

	@Override
	public List<FlightPassenger> processRecordsFromFile() {
		
		try {
			
			logger.info("Input File Processing Start");
			URL resource = this.getClass().getClassLoader().getResource(Constant.INPUT_FILE);
			if (resource == null) {
			      throw new IllegalArgumentException("File not found!");
			  } 
			final File xlsxFile = new File(resource.toURI());
			
			List<FlightPassenger> passengers = WorkbookUtil.convertToListOfObject(xlsxFile);
			
			logger.info("Input File Processing complete!");
			
			return passengers;
			
		} catch (URISyntaxException e) {
			throw new InvalidDataException(e.getLocalizedMessage());
		}
	}

	@Override
	public void upgradeTicketRecords(List<FlightPassenger> passengers) {
		
		ConversionService<SuccessfulPassenger> successfulPassengerService = new SuccessfulPassengerService();
		ConversionService<ErrorPassenger> errorPassengerService = new FailedPassengerService();
		
		List<SuccessfulPassenger> successfulPassengers = new ArrayList<>();
		List<ErrorPassenger> errorPassengers = new ArrayList<>();
		
		for(FlightPassenger passenger : passengers) {
			try {
				ValidationUtil.checkValidFields(passenger);
				successfulPassengers.add(new SuccessfulPassenger(passenger, FareClassUtil.getOfferByFareClass(passenger.getFareClass())));
			}
			catch(Exception e) {
				errorPassengers.add(new ErrorPassenger(passenger, e.getLocalizedMessage()));
			}
		}
		successfulPassengerService.convertRecordsToSheet(successfulPassengers);
		errorPassengerService.convertRecordsToSheet(errorPassengers);
	}
}