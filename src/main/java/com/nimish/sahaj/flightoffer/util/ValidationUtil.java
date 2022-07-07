package main.java.com.nimish.sahaj.flightoffer.util;

import main.java.com.nimish.sahaj.flightoffer.constant.ErrorConstants;
import main.java.com.nimish.sahaj.flightoffer.exception.InvalidEmailException;
import main.java.com.nimish.sahaj.flightoffer.exception.InvalidFlightCabinException;
import main.java.com.nimish.sahaj.flightoffer.exception.InvalidMobileNumberException;
import main.java.com.nimish.sahaj.flightoffer.exception.InvalidPNRException;
import main.java.com.nimish.sahaj.flightoffer.exception.InvalidTicketingDateException;
import main.java.com.nimish.sahaj.flightoffer.model.FlightPassenger;

public class ValidationUtil {
	
	
	/**
	 * Checks for all validation checks before processing for discount
	 * @param passenger
	 */
	public static void checkValidFields(FlightPassenger passenger) {
		
		if(!Validator.isValidEmail(passenger.getEmail())) {
			throw new InvalidEmailException(ErrorConstants.EMAIL_INVALID);
		}
		if(!Validator.isValidMobileNumber(passenger.getMobileNumber())) {
			throw new InvalidMobileNumberException(ErrorConstants.NUMBER_INVALID);
		}
		if(!Validator.isValidPNR(passenger.getPnr())) {
			throw new InvalidPNRException(ErrorConstants.PNR_INVALID);
		}
		if(!Validator.isValidCabin(passenger.getBookedCabin())) {
			throw new InvalidFlightCabinException(ErrorConstants.CABIN_INVALID);
		}
		if(!DateUtil.isValidTicketingDate(passenger.getTicketingDate(), passenger.getTravelDate())) {
			throw new InvalidTicketingDateException(ErrorConstants.TICKETING_DATE_INVALID);
		}
	}
}
