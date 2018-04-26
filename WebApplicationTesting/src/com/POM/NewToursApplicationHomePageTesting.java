package com.POM;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class NewToursApplicationHomePageTesting 
{
	FirefoxDriver driver;
	
	@Test
	public void HomePageTesting() 
	{
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		WelComeMercuryTours wmt = PageFactory.initElements(driver, WelComeMercuryTours.class);
		
		wmt.Register();
		driver.navigate().back();
		
		wmt.FindAFlight("tutorial", "tutorial");
		driver.navigate().back();
		
		wmt.AllLinks();
		
		driver.close();
	}
	
}
