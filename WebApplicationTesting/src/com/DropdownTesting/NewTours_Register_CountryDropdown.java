package com.DropdownTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTours_Register_CountryDropdown {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		
		driver.findElement(By.linkText("REGISTER")).click();
		WebElement country = driver.findElement(By.name("country"));
		List<WebElement> countryNames = country.findElements(By.tagName("option"));
		for(int i=0;i<countryNames.size();i++)
		{
			System.out.println(countryNames.get(i).getText());
		}
		driver.close();
		
	}

}
