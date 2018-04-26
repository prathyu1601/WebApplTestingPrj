package com.Search_UsingEnterKey;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Facebook_LogInTest {

	public static void main(String[] args) {


		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		
		driver.findElement(By.id("email")).sendKeys("Hello");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		
		act.sendKeys("Chello").perform();
		
		
		

	}

}
