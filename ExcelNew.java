package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelNew {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File ("C:\\Users\\willi\\eclipse-workspace\\High_Maven\\test-data\\Book1.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("Sheet1");
			Row r = s.getRow(2);
			Cell c = r.getCell(1);
				String stringCellValue = c.getStringCellValue();
				System.out.println(stringCellValue);
				
	}
}


			
		
		
//		String filelocation = "C:\\Users\\willi\\eclipse-workspace\\High_Maven\\test-data\\Book1.xlsx";
//		XSSFWorkbook w = new XSSFWorkbook(filelocation);
//		XSSFSheet s = w.getSheetAt(0);
//		XSSFRow r = s.getRow(2);
//		XSSFCell cell = r.getCell(1);
//		System.out.println(cell.getStringCellValue());
	
		
		
//		File f = new File ("C:\\Users\\willi\\eclipse-workspace\\High_Maven\\test-data\\Book1.xlsx");
//		FileInputStream fin = new FileInputStream(f);
//		Workbook w = new XSSFWorkbook(fin);
//		Sheet s = w.getSheet("Sheet1");
//		
//		for (int i = 0; i < 2; i++) {
//			Row r = s.getRow(2);
//			for (int j = 0; j < 2; i++) {
//				Cell c = r.getCell(j);
//				String stringCellValue = c.getStringCellValue();
//				System.out.println(stringCellValue);
//			
		
		
		
		
		
		
		
	
	
	
	
	


