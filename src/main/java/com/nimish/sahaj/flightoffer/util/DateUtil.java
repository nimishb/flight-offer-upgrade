package main.java.com.nimish.sahaj.flightoffer.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static Boolean isValidTicketingDate(Date ticketingDate, Date travelDate) {
	      
		if(ticketingDate.compareTo(travelDate) >= 0) {
		     return false;
		}
		
		return true;
	}
	
	public static String getDateFormat(Date date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);  
	}
	
	public static Date addDays(final Date date, final int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }
	
	private static Date add(final Date date, final int calendarField, final int amount) {
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }
}
