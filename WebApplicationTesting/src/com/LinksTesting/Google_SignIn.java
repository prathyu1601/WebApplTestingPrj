package com.LinksTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Google_SignIn {

	public static void main(String[] args) throws InterruptedException
	{
		FirefoxDriver driver =  new FirefoxDriver();
		driver.get("http://google.com");
		
		//driver.findElement(By.id("gb_70")).click();
		
		//driver.findElement(By.linkText("Sign in")).click();
		
		//Thread.sleep(10000); java wait statement
		
		//Sleeper.sleepTightInSeconds(10); selenium wait statement
		
		
		driver.findElement(By.partialLinkText("Sign")).click();
		
		driver.close();

	}

}
