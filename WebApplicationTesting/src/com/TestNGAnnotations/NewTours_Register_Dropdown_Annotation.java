package com.TestNGAnnotations;

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

public class NewTours_Register_Dropdown_Annotation 
{
	FirefoxDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
	}
	@Test(enabled = false)
	public void DropdownTest() throws IOException
	{
		driver.findElement(By.linkText("REGISTER")).click();
		WebElement country = driver.findElement(By.name("country"));
		List<WebElement> countryList = country.findElements(By.tagName("option"));
		
		FileInputStream file = new FileInputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		
		for(int i=0;i<countryList.size();i++)
		{
			String name = countryList.get(i).getText();
			Row r = sheet.createRow(i);
			Cell c = r.createCell(0);
			c.setCellValue(name);
			
			FileOutputStream file1 = new FileOutputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\TestData.xlsx");
			workbook.write(file1);
		}
		
	}
	@Test
	public void ExcelRead() throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		
		int rowCount = sheet.getLastRowNum();
		for(int i=0;i<rowCount;i++)
		{
			Row r = sheet.getRow(i);
			Cell c = r.getCell(0);
			String cellValue = c.getStringCellValue();
			System.out.println(cellValue);
		}
			
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
