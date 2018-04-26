package com.BrowserAutomation;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxBrowserAutomation {

	public static void main(String[] args) 
	{
		FirefoxDriver Hello = new FirefoxDriver();
		Hello.get("http://facebook.com");
		
		Hello.navigate().to("http://amazon.com");
		
		Hello.close();
		

	}

}
