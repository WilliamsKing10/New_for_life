package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

public class NewExcelData {
	 
	String data [][]= null;
	@DataProvider(name = "login1")
	public String[][] Jick() throws IOException {
		
	data = NewExcel();
	
	return data;
		
	}
	
	public String[][] NewExcel () throws IOException {
		
		File ki = new File("C:\\\\Users\\\\willi\\\\eclipse-workspace\\\\High_Maven\\\\test-data\\\\Book1.xlsx");
		FileInputStream gi = new FileInputStream(ki);
		Workbook work = new XSSFWorkbook(gi);
		Sheet sheetAt = work.getSheetAt(0);
		int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();
		int physicalNumberOfCells = sheetAt.getRow(0).getPhysicalNumberOfCells();
		
		String data [][] = new String[physicalNumberOfRows-1][physicalNumberOfCells];
		for(int i=1;i<physicalNumberOfRows;i++) {
			for(int j=0;j<physicalNumberOfCells;j++) {
				data [i-1][j] = sheetAt.getRow(i).getCell(j).getStringCellValue();
				
			}	
		}
		
		return data;
	}
	@Test(dataProvider = "login1")
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
