package com.Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingALert_TSRTC {

	public static void main(String[] args) throws InterruptedException 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.tsrtconline.in/oprs-web/");
		
		driver.findElementById("searchBtn").click();
		
		Thread.sleep(10000);
		
		Alert alt  = driver.switchTo().alert();
		
		System.out.println(alt.getText());
		alt.accept();
		
		//alt.dismiss();
		
		//alt.sendKeys("Hello");

		driver.close();
	}

}
