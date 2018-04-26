package com.CapturingURL;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Facebook_URL {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		String ActualUrl=driver.getCurrentUrl();
		System.out.println(ActualUrl);
		
		driver.close();

	}

}
