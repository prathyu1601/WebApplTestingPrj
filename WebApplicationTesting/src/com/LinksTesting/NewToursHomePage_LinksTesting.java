package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class NewToursHomePage_LinksTesting {

	public static void main(String[] args) 
	{
		FirefoxDriver driver  = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		for(int a=0;a<links.size();a++)
		{
			String linkName=links.get(a).getText();		
			System.out.println(a +" "+ linkName);
			
			links.get(a).click();
			
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println();
			
			driver.navigate().back();
			Sleeper.sleepTightInSeconds(5);
			links=driver.findElements(By.tagName("a"));
		}
		
		driver.close();



	}

}
