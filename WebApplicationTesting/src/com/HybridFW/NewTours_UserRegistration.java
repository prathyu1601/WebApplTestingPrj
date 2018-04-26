package com.HybridFW;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_UserRegistration 
{
	FirefoxDriver driver;
	FileInputStream fileProp;
	Properties pr;
	
	@BeforeTest
	public void setUp() throws FileNotFoundException
	{
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void Register() throws IOException
	{
		fileProp = new FileInputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\NewTours_Register.properties");
		pr = new Properties();
		pr.load(fileProp);
	
		driver.findElement(By.linkText(pr.getProperty("RegisterLink"))).click();
	}
	@Test(priority=2)
	public void UserRegistration() throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\NewUserRegistrationTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		fileProp = new FileInputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\NewTours_Register.properties");
		pr = new Properties();
		pr.load(fileProp);
		
		int rowCount = sheet.getLastRowNum();
		for(int i =1;i<=rowCount ;i++)
		{
			Row rowNumb = sheet.getRow(i);
		
			driver.findElement(By.name(pr.getProperty("FirstName"))).sendKeys(rowNumb.getCell(0).getStringCellValue());
			driver.findElement(By.name(pr.getProperty("LastName"))).sendKeys(rowNumb.getCell(1).getStringCellValue());
			
			//typecasting
			double d=rowNumb.getCell(2).getNumericCellValue();
			long x=(long)d;
			String PhoneNumber=Long.toString(x);
			
			driver.findElement(By.name(pr.getProperty("Phone"))).sendKeys(PhoneNumber);
			driver.findElementById(pr.getProperty("Emailid")).sendKeys(rowNumb.getCell(3).getStringCellValue());
			driver.findElementByName(pr.getProperty("Address")).sendKeys(rowNumb.getCell(4).getStringCellValue());
			driver.findElementByName(pr.getProperty("City")).sendKeys(rowNumb.getCell(5).getStringCellValue());
			driver.findElementByName(pr.getProperty("State")).sendKeys(rowNumb.getCell(6).getStringCellValue());
			
			double d2=rowNumb.getCell(7).getNumericCellValue();
			long x2 =(long)d2;
			String postalCode = Long.toString(x2);
			
			driver.findElementByName(pr.getProperty("Zip")).sendKeys(postalCode);
			
			driver.findElement(By.name(pr.getProperty("Country"))).sendKeys(rowNumb.getCell(8).getStringCellValue());;
			
			driver.findElementById(pr.getProperty("UserName")).sendKeys(rowNumb.getCell(9).getStringCellValue());
			driver.findElementByName(pr.getProperty("Password")).sendKeys(rowNumb.getCell(10).getStringCellValue());
			driver.findElementByName(pr.getProperty("ConfirmPwd")).sendKeys(rowNumb.getCell(11).getStringCellValue());
			
			
			driver.findElementByName(pr.getProperty("Submit")).click();
			
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
