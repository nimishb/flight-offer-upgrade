package main.java.com.nimish.sahaj.flightoffer.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.com.nimish.sahaj.flightoffer.constant.Regex;
import main.java.com.nimish.sahaj.flightoffer.enums.FlightCabin;

public class Validator {
	
	public static Boolean isValidEmail(String email) {
		
		Pattern pattern = Pattern.compile(Regex.EMAIL_REGEX);
        return isValidString(email) && pattern.matcher(email).matches();
	}
	
	public static Boolean isValidMobileNumber(String mobileNumber) {
		
		Pattern pattern = Pattern.compile(Regex.MOBILE_REGEX);    
		Matcher match = pattern.matcher(mobileNumber);    
		return isValidString(mobileNumber) && match.find() && match.group().equals(mobileNumber); 
	}
	
	public static Boolean isValidPNR(String pnr) {
		return isValidString(pnr) && pnr.length()==6 && pnr.matches(Regex.ALPHANUMERIC_REGEX);
	}
	
	public static Boolean isValidCabin(String cabin) {
		return isValidString(cabin) && Arrays.stream(FlightCabin.values()).anyMatch((e) -> e.getLabel().equals(cabin));
	}
	
	public static Boolean isValidString(String str) {
		return (str !=null && !str.isEmpty());
	}
	
}
