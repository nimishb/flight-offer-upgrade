package test.java.com.nimish.sahaj.flightoffer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import main.java.com.nimish.sahaj.flightoffer.enums.FareClassRange;
import main.java.com.nimish.sahaj.flightoffer.model.FlightPassenger;
import main.java.com.nimish.sahaj.flightoffer.model.SuccessfulPassenger;
import main.java.com.nimish.sahaj.flightoffer.util.DateUtil;
import main.java.com.nimish.sahaj.flightoffer.util.FareClassUtil;

public class PassengerOffersTest {
	
	@Test
	public void checkOffer_withinOffer20_true() {
		FlightPassenger passenger = new FlightPassenger("ABC001", "B", DateUtil.addDays(new Date(), 3), 2, new Date(), "Economy", "Test", "TestLastName", "test@gmaild.com", "9988776655");
		SuccessfulPassenger sPassenger = new SuccessfulPassenger(passenger, FareClassUtil.getOfferByFareClass(passenger.getFareClass()));
		assertEquals(FareClassRange.A_E.getLabel(), sPassenger.getOffer());
	}
	
	@Test
	public void checkOffer_withinOffer30_true() {
		FlightPassenger passenger = new FlightPassenger("ABC001", "G", DateUtil.addDays(new Date(), 3), 2, new Date(), "Economy", "Test", "TestLastName", "test@gmaild.com", "9988776655");
		SuccessfulPassenger sPassenger = new SuccessfulPassenger(passenger, FareClassUtil.getOfferByFareClass(passenger.getFareClass()));
		assertEquals(FareClassRange.F_K.getLabel(), sPassenger.getOffer());
	}
	
	@Test
	public void checkOffer_withinOffer25_true() {
		FlightPassenger passenger = new FlightPassenger("ABC001", "N", DateUtil.addDays(new Date(), 3), 2, new Date(), "Economy", "Test", "TestLastName", "test@gmaild.com", "9988776655");
		SuccessfulPassenger sPassenger = new SuccessfulPassenger(passenger, FareClassUtil.getOfferByFareClass(passenger.getFareClass()));
		assertEquals(FareClassRange.L_R.getLabel(), sPassenger.getOffer());
	}
	
	@Test
	public void checkOffer_withoutOffer_true() {
		FlightPassenger passenger = new FlightPassenger("ABC001", "Z", DateUtil.addDays(new Date(), 3), 2, new Date(), "Economy", "Test", "TestLastName", "test@gmaild.com", "9988776655");
		SuccessfulPassenger sPassenger = new SuccessfulPassenger(passenger, FareClassUtil.getOfferByFareClass(passenger.getFareClass()));
		assertEquals(FareClassRange.S_Z.getLabel(), sPassenger.getOffer());
	}
}
