package main.java.com.nimish.sahaj.flightoffer.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.com.nimish.sahaj.flightoffer.constant.Constant;
import main.java.com.nimish.sahaj.flightoffer.constant.DateFormat;
import main.java.com.nimish.sahaj.flightoffer.model.SuccessfulPassenger;
import main.java.com.nimish.sahaj.flightoffer.service.ConversionService;
import main.java.com.nimish.sahaj.flightoffer.util.DateUtil;
import main.java.com.nimish.sahaj.flightoffer.util.WorkbookUtil;

public class SuccessfulPassengerService implements ConversionService<SuccessfulPassenger>{
	
	private static Logger logger = LoggerFactory.getLogger(SuccessfulPassengerService.class);
	
	/**
	 * Converts Successful Passenger's List to Excel sheet file
	 */
	@Override
	public void convertRecordsToSheet(List<SuccessfulPassenger> passengers) {
		
		logger.info("Conversion of Successful records start");
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(Constant.SHEET_TITLE_SUCCESS);
		Integer rowNum = 0;

		Row headerRow = WorkbookUtil.getCellheaders(sheet, rowNum);
		headerRow.createCell(10).setCellValue(Constant.DISCOUNT);

		rowNum++;
		
		for(SuccessfulPassenger passenger : passengers) {
			Row nextRow = sheet.createRow(rowNum);
			nextRow = WorkbookUtil.setCellRows(nextRow, passenger);
			nextRow.createCell(10).setCellValue(passenger.getOffer());
			rowNum++;
		}
		try {
			FileOutputStream fos = new FileOutputStream(Constant.SUCCESSFUL_OUTPUT_FILE+Constant.UNDERSCORE+DateUtil.getDateFormat(new Date(), DateFormat.yyyy_MM_dd_T_HH_mm_ssZ)+Constant.OUTPUT_FILE_EXT);
			workbook.write(fos);

			workbook.close();
			logger.info("Conversion of Successful Records complete!");
		} catch (IOException e) {
			
			logger.error("Error Occurred, Reason: "+ e.getLocalizedMessage());
		}
	}

}
