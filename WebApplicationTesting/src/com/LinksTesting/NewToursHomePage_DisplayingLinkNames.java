package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewToursHomePage_DisplayingLinkNames {

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
		}
		
		driver.close();

	}

}
