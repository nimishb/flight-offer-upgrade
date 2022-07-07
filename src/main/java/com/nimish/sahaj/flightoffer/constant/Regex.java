package main.java.com.nimish.sahaj.flightoffer.constant;

public interface Regex {
	
	String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";
	
	String MOBILE_REGEX = "(0/91)?[7-9][0-9]{9}";
	
	String ALPHANUMERIC_REGEX = "^[a-zA-Z0-9]*$";
	
}
