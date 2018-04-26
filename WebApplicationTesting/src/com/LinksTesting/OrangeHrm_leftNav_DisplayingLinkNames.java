package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHrm_leftNav_DisplayingLinkNames {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.orangehrm.com/solutions");
		
		WebElement table = driver.findElement(By.cssSelector("#cssmenu ul"));
		List<WebElement> rows = table.findElements(By.xpath("//li[@class='has-sub']/a/span"));
		//System.out.println(rows.get(i).);
		for(int i=0 ;i<6;i++)
		{
			String str = rows.get(i).getText();
			System.out.println(str);
		}
		
	}

}
