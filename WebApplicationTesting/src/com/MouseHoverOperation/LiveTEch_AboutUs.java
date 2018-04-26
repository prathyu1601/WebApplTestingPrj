package com.MouseHoverOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class LiveTEch_AboutUs {

	public static void main(String[] args) throws InterruptedException 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://livetech.in");
		
		Thread.sleep(5000);
		
		WebElement aboutUs = driver.findElement(By.xpath(".//*[@id='menu-item-4742']/a"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(aboutUs).perform();

	}

}
