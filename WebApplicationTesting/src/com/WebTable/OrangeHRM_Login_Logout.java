package com.WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class OrangeHRM_Login_Logout {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		
		driver.findElementByXPath(".//*[@id='txtUsername']").sendKeys("admin");
		driver.findElementByXPath(".//*[@id='txtPassword']").sendKeys("admin");
		driver.findElementByXPath(".//*[@id='btnLogin']").click();
		Sleeper.sleepTightInSeconds(5);
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Welcome Admin")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
