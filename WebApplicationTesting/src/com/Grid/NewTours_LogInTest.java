package com.Grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTours_LogInTest 
{
	
	@Parameters("Browser")
	
	@Test
	public void logIn(String b) throws MalformedURLException
	{
		System.out.println(b);
		
		DesiredCapabilities cap =null;
		
		if(b.equals("firefox"))
		{
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		}
		else 
		if(b.equals("chrome"))
		{
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.151.1.166:4444/wd/hub"),cap);
		
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		
		String ExpectedTitle="Find";
		System.out.println(ExpectedTitle);
		
		String ActualTitle=driver.getTitle();
		System.out.println(ActualTitle);
		
		/*if(ActualTitle.contains(ExpectedTitle))
		{
			System.out.println("LogIn Successful -- PASS");
		}
		else
		{
			System.out.println("LogIn Failed -- FAIL");
			
		}*/
		
		Assert.assertTrue(ActualTitle.contains(ExpectedTitle), "titles are not matched");
	
		driver.close();
		
	}
	
	
}
