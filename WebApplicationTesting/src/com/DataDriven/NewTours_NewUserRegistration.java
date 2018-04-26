package com.DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_NewUserRegistration 
{
	
	FirefoxDriver driver;

	@BeforeTest
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void Register()
	{
		driver.findElement(By.linkText("REGISTER")).click();
	}
	@Test(priority=2)
	public void UserRegistration() throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\NewUserRegistrationTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		for(int i =1;i<=rowCount ;i++)
		{
			Row rowNumb = sheet.getRow(i);
		
			driver.findElement(By.name("firstName")).sendKeys(rowNumb.getCell(0).getStringCellValue());
			driver.findElement(By.name("lastName")).sendKeys(rowNumb.getCell(1).getStringCellValue());
			
			//typecasting
			double d=rowNumb.getCell(2).getNumericCellValue();
			long x=(long)d;
			String PhoneNumber=Long.toString(x);
			
			driver.findElement(By.name("phone")).sendKeys(PhoneNumber);
			driver.findElementById("userName").sendKeys(rowNumb.getCell(3).getStringCellValue());
			driver.findElementByName("address1").sendKeys(rowNumb.getCell(4).getStringCellValue());
			driver.findElementByName("city").sendKeys(rowNumb.getCell(5).getStringCellValue());
			driver.findElementByName("state").sendKeys(rowNumb.getCell(6).getStringCellValue());
			
			double d2=rowNumb.getCell(7).getNumericCellValue();
			long x2 =(long)d2;
			String postalCode = Long.toString(x2);
			
			driver.findElementByName("postalCode").sendKeys(postalCode);
			
			driver.findElement(By.name("country")).sendKeys(rowNumb.getCell(8).getStringCellValue());;
			
			driver.findElementById("email").sendKeys(rowNumb.getCell(9).getStringCellValue());
			driver.findElementByName("password").sendKeys(rowNumb.getCell(10).getStringCellValue());
			driver.findElementByName("confirmPassword").sendKeys(rowNumb.getCell(11).getStringCellValue());
			
			
			driver.findElementByName("register").click();
			
			String ExpectedUserName= rowNumb.getCell(9).getStringCellValue();
			System.out.println(ExpectedUserName);
			
			String	ActualRegisterdUserName=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
			System.out.println(ActualRegisterdUserName);
			
			if(ActualRegisterdUserName.contains(ExpectedUserName))
			{
				System.out.println("User Registered Sccessfully -- pASS");
				
				rowNumb.createCell(12).setCellValue("User Registered Sccessfully -- pASS");
				
			}
			else
			{
				System.out.println("User Registration Failed -- FAIL");
				
				rowNumb.createCell(12).setCellValue("User Registration Failed -- FAIL");
			}
			
			FileOutputStream outFile = new FileOutputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\src\\com\\ExcelTestResultFiles\\NewUserRegistration.xlsx");
			workbook.write(outFile);
			
			driver.navigate().back();
		}
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
