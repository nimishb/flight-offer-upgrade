package test.java.com.nimish.sahaj.flightoffer.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.com.nimish.sahaj.flightoffer.model.ErrorPassenger;
import main.java.com.nimish.sahaj.flightoffer.model.FlightPassenger;
import main.java.com.nimish.sahaj.flightoffer.model.SuccessfulPassenger;
import main.java.com.nimish.sahaj.flightoffer.service.ConversionService;
import main.java.com.nimish.sahaj.flightoffer.service.impl.FailedPassengerService;
import main.java.com.nimish.sahaj.flightoffer.service.impl.SuccessfulPassengerService;
import main.java.com.nimish.sahaj.flightoffer.util.DateUtil;
import main.java.com.nimish.sahaj.flightoffer.util.FareClassUtil;
import main.java.com.nimish.sahaj.flightoffer.util.ValidationUtil;

public class RecordsToFileTest {
	
	@Test
	public void upgradeTickets_successfulRecords_true() {
		
		List<SuccessfulPassenger> passengers = new ArrayList<>();
		FlightPassenger passenger = new FlightPassenger("ABC001", "B", DateUtil.addDays(new Date(), 3), 2, new Date(), "Economy", "Test", "TestLastName", "test@gmaild.com", "9988776655");
		passengers.add(new SuccessfulPassenger(passenger, FareClassUtil.getOfferByFareClass(passenger.getFareClass())));
		passenger = new FlightPassenger("ABC002", "V", DateUtil.addDays(new Date(), 5), 2, new Date(), "Business", "TestB", "TestLastNameB", "testb@gmaild.com", "9988776654");
		passengers.add(new SuccessfulPassenger(passenger, FareClassUtil.getOfferByFareClass(passenger.getFareClass())));
		passenger = new FlightPassenger("ABC003", "K", DateUtil.addDays(new Date(), 1), 1, new Date(), "First", "TestC", "TestLastNameC", "testc@gmaild.com", "9988776653");
		passengers.add(new SuccessfulPassenger(passenger, FareClassUtil.getOfferByFareClass(passenger.getFareClass())));
		passenger = new FlightPassenger("ABC003", "M", DateUtil.addDays(new Date(), 10), 2, new Date(), "Premium Economy", "TestD", "TestLastNameD", "testd@gmaild.com", "9988776652");
		passengers.add(new SuccessfulPassenger(passenger, FareClassUtil.getOfferByFareClass(passenger.getFareClass())));
		
		assertDoesNotThrow(()-> {
			ConversionService<SuccessfulPassenger> successfulPassengerService = new SuccessfulPassengerService();
			successfulPassengerService.convertRecordsToSheet(passengers);
			});
	}
	
	@Test
	public void upgradeTickets_errorRecords_true() {
		
		List<ErrorPassenger> passengers = new ArrayList<>();
		FlightPassenger passenger = new FlightPassenger("ABC001#", "B", DateUtil.addDays(new Date(), 3), 2, new Date(), "Economy", "Test", "TestLastName", "test@gmaild.com", "9988776655");
		try {
			ValidationUtil.checkValidFields(passenger);
		}
		catch(Exception e) {
			passengers.add(new ErrorPassenger(passenger, e.getLocalizedMessage()));
		}
		passenger = new FlightPassenger("ABC002", "V", DateUtil.addDays(new Date(), 5), 2, new Date(), "Economys", "TestB", "TestLastNameB", "testb@gmaild.com", "9988776654");
		try {
			ValidationUtil.checkValidFields(passenger);
		}
		catch(Exception e) {
			passengers.add(new ErrorPassenger(passenger, e.getLocalizedMessage()));
		}
		passenger = new FlightPassenger("ABC003", "K", DateUtil.addDays(new Date(), 1), 1, new Date(), "Economy", "TestC", "TestLastNameC", "testc@gmaild.com", "998877665322");
		try {
			ValidationUtil.checkValidFields(passenger);
		}
		catch(Exception e) {
			passengers.add(new ErrorPassenger(passenger, e.getLocalizedMessage()));
		}
		passenger = new FlightPassenger("ABC003", "K", DateUtil.addDays(new Date(), 1), 1, new Date(), "Economy", "TestD", "TestLastNameD", "testd@gmaild@zxc.com", "9988776651");
		try {
			ValidationUtil.checkValidFields(passenger);
		}
		catch(Exception e) {
			passengers.add(new ErrorPassenger(passenger, e.getLocalizedMessage()));
		}
		passenger = new FlightPassenger("ABC003", "K", DateUtil.addDays(new Date(), -4), 1, new Date(), "Economy", "TestE", "TestLastNameE", "teste@gmaild.com", "9988776652");
		try {
			ValidationUtil.checkValidFields(passenger);
		}
		catch(Exception e) {
			passengers.add(new ErrorPassenger(passenger, e.getLocalizedMessage()));
		}
		assertDoesNotThrow(()-> {
			ConversionService<ErrorPassenger> errorPassengerService = new FailedPassengerService();
			errorPassengerService.convertRecordsToSheet(passengers);
			});
	}
}
