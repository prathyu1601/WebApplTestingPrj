package com.ValidatingTitle_And_Url_Facebook;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Facebook {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		String ExpectedURl="facebook.com";
		System.out.println(ExpectedURl);
		
		String ActualUrl=driver.getCurrentUrl();
		System.out.println(ActualUrl);
		
		if(ActualUrl.contains(ExpectedURl))
		{
			System.out.println("URL Matched -- PASS");
		}
		else
		{
			System.out.println("URL not matched -- FAIL");
		}
		
			driver.close();

	}

}
