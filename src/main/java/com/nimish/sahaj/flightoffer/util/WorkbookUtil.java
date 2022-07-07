package main.java.com.nimish.sahaj.flightoffer.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import main.java.com.nimish.sahaj.flightoffer.constant.Constant;
import main.java.com.nimish.sahaj.flightoffer.constant.DateFormat;
import main.java.com.nimish.sahaj.flightoffer.model.FlightPassenger;

public class WorkbookUtil {
	
	/**
	 * Sets Cell Headers for Sheet
	 * @param sheet
	 * @param rowNum
	 * @return
	 */
	public static Row getCellheaders(Sheet sheet, Integer rowNum) {
		Row headerRow = sheet.createRow(rowNum);
		headerRow.createCell(0).setCellValue(Constant.FIRST_NAME);
		headerRow.createCell(1).setCellValue(Constant.LAST_NAME);
		headerRow.createCell(2).setCellValue(Constant.PNR);
		headerRow.createCell(3).setCellValue(Constant.EMAIL);
		headerRow.createCell(4).setCellValue(Constant.TRAVEL_DATE);
		headerRow.createCell(5).setCellValue(Constant.TICKETING_DATE);
		headerRow.createCell(6).setCellValue(Constant.MOBILE_NUMBER);
		headerRow.createCell(7).setCellValue(Constant.PAX);
		headerRow.createCell(8).setCellValue(Constant.FARECLASS);
		headerRow.createCell(9).setCellValue(Constant.BOOKED_CABIN);
		return headerRow;
	}
	
	/**
	 * Set Individual Cell values for a Row
	 * @param nextRow
	 * @param passenger
	 * @return
	 */
	public static Row setCellRows(Row nextRow, FlightPassenger passenger) {
		nextRow.createCell(0).setCellValue(passenger.getFirstName());
	    nextRow.createCell(1).setCellValue(passenger.getLastName());
	    nextRow.createCell(2).setCellValue(passenger.getPnr());
	    nextRow.createCell(3).setCellValue(passenger.getEmail());
	    nextRow.createCell(4).setCellValue(DateUtil.getDateFormat(passenger.getTravelDate(), DateFormat.YYYY_MM_DD));
	    nextRow.createCell(5).setCellValue(DateUtil.getDateFormat(passenger.getTicketingDate(),DateFormat.YYYY_MM_DD));
	    nextRow.createCell(6).setCellValue(passenger.getMobileNumber());
	    nextRow.createCell(7).setCellValue(passenger.getPax());
	    nextRow.createCell(8).setCellValue(passenger.getFareClass());
	    nextRow.createCell(9).setCellValue(passenger.getBookedCabin());
	    return nextRow;
	}
	
	/**
	 * Converts the Excel File's Row and Columns to List of Java POJO Object
	 * @param file
	 * @return
	 */
	public static List<FlightPassenger> convertToListOfObject(File file) {
			
		try {
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);

			List<FlightPassenger> passengers = new ArrayList<>();

			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
				FlightPassenger inputPassenger = new FlightPassenger();
				Row row = sheet.getRow(i);
				for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					if (j == 0) {
						inputPassenger.setFirstName(cell.getStringCellValue());
					}
					if (j == 1) {				
						inputPassenger.setLastName(cell.getStringCellValue());
					}
					if (j == 2) {
						inputPassenger.setPnr(cell.getStringCellValue());
					}
					if (j == 3) {
						inputPassenger.setFareClass(cell.getStringCellValue());
					}
					if (j == 4) {
						inputPassenger.setTravelDate(cell.getDateCellValue());
					}
					if (j == 5) {
						inputPassenger.setPax((int)cell.getNumericCellValue());
					}
					if (j == 6) {
						inputPassenger.setTicketingDate(cell.getDateCellValue());
					}
					if (j == 7) {
						inputPassenger.setEmail(cell.getStringCellValue());
					}
					if (j == 8) {
						Long mobileNumber = (long)cell.getNumericCellValue();
						inputPassenger.setMobileNumber(mobileNumber.toString());
					}
					if (j == 9) {
						inputPassenger.setBookedCabin(cell.getStringCellValue());
					}
					
				}
				passengers.add(inputPassenger);
			}
			return passengers;
		} catch (Exception e) {
			return null;
		}
	}
	
}
