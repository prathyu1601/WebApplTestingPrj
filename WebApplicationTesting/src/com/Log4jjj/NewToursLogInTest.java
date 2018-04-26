package com.Log4jjj;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewToursLogInTest
{

	public static Logger logger = Logger.getLogger("NewToursLogInTest");
	
	public static void main(String[] args) 
	{
		PropertyConfigurator.configure("Log4j.properties");
		
		
		//FirefoxDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		logger.info("FIrefox Browser successfull Launched");
		
		driver.get("http://newtours.demoaut.com");
		logger.info("Navigate to NewTours Application");
		
		
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		logger.info("Entered valid username");
		
		driver.findElement(By.name("password")).sendKeys("tutorial");
		logger.info("Entered valid password");
		
		driver.findElement(By.name("login")).click();
		logger.info("Login button is clicked");
		
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
		
		
		driver.close();
		logger.info("Closing the application");

	}

}
