package com.LinksTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewToursHomePG_LinksTesting 
{
	FirefoxDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
	}
	
	@Test
	public void HomeLinks() throws IOException
	{
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
		FileInputStream file = new FileInputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\HomePG_links.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		for(int i =0; i<links.size(); i++)
		{
			//int rowCount = sheet.getLastRowNum();
			Row currentRow = sheet.getRow(i+1);	
			String expectedUrl = currentRow.getCell(1).getStringCellValue();
			//System.out.println(expectedUrl);
			
				
				links.get(i).click();
				
				Row rowNumber = sheet.getRow(i+1);
				
				String actualCurrentUrl = driver.getCurrentUrl();
				//System.out.println(actualCurrentUrl);
			
				rowNumber.createCell(2).setCellValue(actualCurrentUrl);
				
				if(actualCurrentUrl.equals(expectedUrl))
				{
					String message1 = "URLs matched -- PASS";
					rowNumber.createCell(3).setCellValue(message1);
				}
				else
				{
					String message2 = "URLs not matched -- FAIL";
					rowNumber.createCell(3).setCellValue(message2);
				}
				
				FileOutputStream outfile = new FileOutputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\src\\com\\ExcelTestResultFiles\\HomePG_links.xlsx");
				workbook.write(outfile);
				
				driver.navigate().back();
				links= driver.findElements(By.tagName("a"));
			
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.close();
	}
	
}
