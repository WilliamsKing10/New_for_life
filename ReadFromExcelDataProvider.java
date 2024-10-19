package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadFromExcelDataProvider {
	
	
	String [][]data=null;
	
	
	@DataProvider(name="login")
	public String[][] Rick() throws IOException {		
		//	String [][] data = new String [2][2];
		
		data = Getexceldatafrom();
//		data [0][0]="dkndindi@gmail.com";
//		data [0][1]="dhidhidj";
//		data [1][0]="pojiji@gmail.com";
//		data [1][1]="jdfnff";
		return data;
		
		
	}
	
	// file location
	//file inpujt
	//get workbook
	//get physcial num of rows
	// sheet.getrow.get physical num of cells
	// array create 
	// ittreate
	
	public String[][] Getexceldatafrom() throws IOException {
		
		File fim = new File("C:\\Users\\willi\\eclipse-workspace\\High_Maven\\test-data\\Book1.xlsx");
		FileInputStream lo = new FileInputStream(fim);
		Workbook wo = new XSSFWorkbook(lo);
		Sheet sheet = wo.getSheetAt(0);
		int Rows = sheet.getPhysicalNumberOfRows();
		int physicalNumberOfCells = sheet.getRow(0).getPhysicalNumberOfCells();
		
		String [][] data = new String [Rows-1][physicalNumberOfCells];
		
		for ( int i = 1; i < Rows ; i ++) {
			for( int j = 0 ; j < physicalNumberOfCells ; j ++) {
				
			data [i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			
				
			}
			
		}
		return data;	
	}
	
	
	@Test(dataProvider = "login")
public void NewLIOn( String email , String pass) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	//launch browser
	WebDriver driver =  new ChromeDriver();	
	//launvh web appl
	driver.get("https://www.facebook.com/login/");
	//find the webelement wit locator xpath
	WebElement findElement = driver.findElement(By.id("email"));
	//sendkeys
	findElement.sendKeys(email);
	//find the webelement with id
	WebElement findElement3 = driver.findElement(By.id("pass"));
	findElement3.sendKeys(pass);
	WebElement findElement2 = driver.findElement(By.xpath("//button[@value='1']"));
	//foe wait issue thread.sleep
	Thread.sleep(1000);
	//click the button
	findElement2.click();

}

}
