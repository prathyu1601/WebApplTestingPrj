package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class OrangeHrm_lefNav_IdentifyingLinkNames_UnderALink {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.orangehrm.com/solutions");
		
		WebElement table = driver.findElement(By.cssSelector("#cssmenu ul"));
		List<WebElement> rows = table.findElements(By.xpath("//li[@class='has-sub']/a/span"));
		System.out.println(rows.size());
		for(int i=0 ;i<rows.size();i++)
		{
			System.out.println(rows.get(i).getText());
			rows.get(i).click();
			WebElement sublink1 = driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li/ul/li[1]"));
			List<WebElement> sublinks = driver.findElements(By.xpath(".//li[@class='has-sub active']//a/span"));//.getText();
			System.out.println(sublinks.size());
			if(sublinks.size() !=0)
			{
				System.out.println("djsjndj");
				//for(int j=0; j<;j++)
			}
			
			System.out.println("***");
			//rows.get(i).click();
							
		}
		//driver.navigate().back();
		rows = table.findElements(By.xpath("//li[@class='has-sub active']/ul/li/a/span"));
		
	}

}
