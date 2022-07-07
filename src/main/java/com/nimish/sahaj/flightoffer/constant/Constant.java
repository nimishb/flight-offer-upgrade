package main.java.com.nimish.sahaj.flightoffer.constant;

public interface Constant {
	
	/**
	 * Input output sheet field names
	 */
	String FIRST_NAME = "First Name";
	String LAST_NAME = "Last Name";
	String PNR = "PNR";
	String EMAIL = "Email";
	String TRAVEL_DATE = "Travel Date";
	String TICKETING_DATE = "Ticketing Date";
	String MOBILE_NUMBER = "Mobile Number";
	String PAX = "PAX";
	String FARECLASS = "FareClass";
	String BOOKED_CABIN = "Booked Cabin";
	String ERROR_TITLE = "Error";
	String DISCOUNT = "Discount";
	
	/**
	 * Input Output sheet File Name
	 */
	String INPUT_FILE = "sahaj_demo_data.xlsx";
	String SUCCESSFUL_OUTPUT_FILE = "src/main/resources/successful-records";
	String ERROR_OUTPUT_FILE = "src/main/resources/error-records";
	String OUTPUT_FILE_EXT = ".xlsx";
	
	/**
	 * Output sheet title
	 */
	String SHEET_TITLE_SUCCESS = "Successful Records";
	String SHEET_TITLE_FAILED = "Error Records";
	String UNDERSCORE = "_";

}
