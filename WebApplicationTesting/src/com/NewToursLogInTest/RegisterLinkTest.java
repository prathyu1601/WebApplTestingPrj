package com.NewToursLogInTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegisterLinkTest 
{
	public static void main(String[] args) 
	{
		WebElement webEle;
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		webEle = driver.findElement(By.linkText("REGISTER"));//expected
		if(webEle.getText().equals("REGISTER"))//actual result
		{
			webEle.click();
			System.out.println("Register link text is matched -- PASS ");
			
			webEle = driver.findElement(By.linkText("Vacations"));
			if(webEle.getText().equals("Vacations"))
			{
				webEle.click();
				System.out.println("Vacations link text is matched -- PASS ");
				
				webEle = driver.findElement(By.xpath("//a[@href='mercurywelcome.php']/img"));
				if(webEle.isDisplayed())
				{
					webEle.click();
					System.out.println("Back to Home element is present on the page -- PASS ");
				}
				else
					System.out.println("Back to Home element is not displayed -- FAIL");
			}
			else
				System.out.println("Vacations link is not displayed -- FAIL");
		}
		else
			System.out.println("Register button is not displayed -- FAIL");
	}

}
