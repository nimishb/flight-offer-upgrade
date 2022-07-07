package main.java.com.nimish.sahaj.flightoffer.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.com.nimish.sahaj.flightoffer.constant.Constant;
import main.java.com.nimish.sahaj.flightoffer.model.ErrorPassenger;
import main.java.com.nimish.sahaj.flightoffer.service.ConversionService;
import main.java.com.nimish.sahaj.flightoffer.util.WorkbookUtil;

public class FailedPassengerService implements ConversionService<ErrorPassenger>{

	private static Logger logger = LoggerFactory.getLogger(FailedPassengerService.class);
	
	/**
	 * Converts Failed Passengers list to Excel sheet file
	 */
	@Override
	public void convertRecordsToSheet(List<ErrorPassenger> passengers) {
		
		logger.info("Conversion of Failed records start");
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(Constant.SHEET_TITLE_FAILED);
		Integer rowNum = 0;

		Row headerRow = WorkbookUtil.getCellheaders(sheet, rowNum);
		headerRow.createCell(10).setCellValue(Constant.ERROR_TITLE);

		rowNum++;
		
		for(ErrorPassenger passenger : passengers) {
			Row nextRow = sheet.createRow(rowNum);
			nextRow = WorkbookUtil.setCellRows(nextRow, passenger);
			nextRow.createCell(10).setCellValue(passenger.getErrorMessage());
			rowNum++;
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(Constant.ERROR_OUTPUT_FILE);
			workbook.write(fos);

			workbook.close();
			
			logger.info("Conversion of Failed Records complete!");
		} catch (IOException e) {
			
			logger.error("Error Occurred, Reason: "+ e.getLocalizedMessage());
		}
	}

}
