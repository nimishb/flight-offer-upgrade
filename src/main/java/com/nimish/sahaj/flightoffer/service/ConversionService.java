package main.java.com.nimish.sahaj.flightoffer.service;

import java.util.List;

public interface ConversionService<T> {
	
	/*
	 * Converts Records to Excel Sheet File
	 **
	 */
	void convertRecordsToSheet(List<T> users);
}
