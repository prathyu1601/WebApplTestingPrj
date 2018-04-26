package com.TestNGAnnotations;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTours_LogInTesting 
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
	public void LogInTest()
	{
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		
		String ExpectedTitle="Find";
		System.out.println(ExpectedTitle);
		
		String ActualTitle=driver.getTitle();
		System.out.println(ActualTitle);
		
		if(ActualTitle.contains(ExpectedTitle))
		{
			System.out.println("LogIn Successful -- PASS");
		}
		else
		{
			System.out.println("LogIn Failed -- FAIL");
			
		}
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
