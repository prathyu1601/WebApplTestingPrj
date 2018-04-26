package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class TsrtcHomePage_Header_IdentifyingLinkNames {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://tsrtconline.in/oprs-web");
		
		List<WebElement> links= driver.findElements(By.cssSelector("div[class='menu'] > a"));
		//List<WebElement> links= driver.findElements(By.xpath("//div[@class='menu']/a"));
		System.out.println(links.size());
		try 
		{
			for(int i=0;i<links.size();i++)
			{
				
				String linkName = links.get(i).getText();
				System.out.println(i+" "+linkName);
			
				links.get(i).click();
				
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				System.out.println();
				
				driver.navigate().back();
				//Sleeper.sleepTightInSeconds(5);
				Thread.sleep(5000);
				links= driver.findElements(By.cssSelector("div[class='menu'] > a"));
				//links= driver.findElements(By.xpath("//div[@class='menu']/a"));
			}
			//driver.close();	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
