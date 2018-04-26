package com.CapturingTitle;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class ValidatingTitle_Gmail {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		
		String ExpectedTitle="Gmail";
		System.out.println(ExpectedTitle);
		
		
		String ActualTitle=driver.getTitle();
		System.out.println(ActualTitle);
		
		if(ActualTitle.equals(ExpectedTitle))
		{
			System.out.println("Title Matched -- PASS");
		}
		else
		{
			System.out.println("Title Not Matched -- FAIL");
		}
		
		Assert.assertEquals(driver.getTitle(), "Gmail");
		
		driver.close();

	}

}
