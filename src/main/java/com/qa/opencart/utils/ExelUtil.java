package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExelUtil {

	private static String TEST_DATA_SHEET_PATH = "./src/main/resources/testdata/OpenCartTestData.xlsx";

	private static Workbook book;
	private static Sheet sheet;
	private static Object[][]  data = null;

	public static Object[][] getTestData(String sheetName) {
		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i =0; i<sheet.getLastRowNum(); i++) {
				
				for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
					
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
				
			}
			
			
			return data;
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
