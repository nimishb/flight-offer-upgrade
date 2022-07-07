package main.java.com.nimish.sahaj.flightoffer.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.com.nimish.sahaj.flightoffer.constant.Regex;
import main.java.com.nimish.sahaj.flightoffer.enums.FlightCabin;

public class Validator {
	
	public static Boolean isValidEmail(String email) {
		
		Pattern pattern = Pattern.compile(Regex.EMAIL_REGEX);
        if (email == null)
            return false;
        return pattern.matcher(email).matches();
	}
	
	public static Boolean isValidMobileNumber(String mobileNumber) {
		
		Pattern pattern = Pattern.compile(Regex.MOBILE_REGEX);    
		Matcher match = pattern.matcher(mobileNumber);    
		return match.find() && match.group().equals(mobileNumber); 
	}
	
	public static Boolean isValidPNR(String pnr) {
		return pnr !=null && pnr.length()==6 && pnr.matches(Regex.ALPHANUMERIC_REGEX);
	}
	
	public static Boolean isValidCabin(String cabin) {
		return Arrays.stream(FlightCabin.values()).anyMatch((e) -> e.getLabel().equals(cabin));
	}
	
}
