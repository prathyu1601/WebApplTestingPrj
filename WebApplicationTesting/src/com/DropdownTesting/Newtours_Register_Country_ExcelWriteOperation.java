package com.DropdownTesting;

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

public class Newtours_Register_Country_ExcelWriteOperation {

	public static void main(String[] args) throws IOException 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		
		driver.findElement(By.linkText("REGISTER")).click();
		WebElement country = driver.findElement(By.name("country"));
		List<WebElement> countryNames = country.findElements(By.tagName("option"));
		
		FileInputStream file = new FileInputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\testBook1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
	
		
		for(int i=0;i<countryNames.size();i++)
		{
			System.out.println(countryNames.get(i).getText());
			
			Row r = sheet.createRow(i);
			Cell c = r.createCell(0);
			c.setCellValue(countryNames.get(i).getText());
			
			FileOutputStream outfile = new FileOutputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\countryNames.xlsx");
			workbook.write(outfile);
		}
		
		driver.close();
		
	}

}
