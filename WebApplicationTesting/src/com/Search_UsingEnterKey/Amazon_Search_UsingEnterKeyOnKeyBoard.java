package com.Search_UsingEnterKey;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon_Search_UsingEnterKeyOnKeyBoard {

	public static void main(String[] args) throws InterruptedException
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://amazon.com");
		
		Thread.sleep(10000);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("olympics");
		Actions act = new Actions(driver);
		
		act.sendKeys(Keys.RETURN).perform();;

	}

}
