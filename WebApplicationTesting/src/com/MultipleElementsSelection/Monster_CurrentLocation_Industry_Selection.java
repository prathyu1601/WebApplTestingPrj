package com.MultipleElementsSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Monster_CurrentLocation_Industry_Selection {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://my.monsterindia.com/sponsered_popup.html");
		
		WebElement CurrentLocation=driver.findElement(By.name("currentloc"));
		
		Select selection = new Select(CurrentLocation);
		//selection.selectByIndex(3);
		selection.selectByVisibleText("Delhi");
		
		WebElement industry = driver.findElement(By.id("id_industry"));
		Select selectIndustry = new Select(industry);
		selectIndustry.selectByIndex(5);
		selectIndustry.selectByVisibleText("Banking/ Financial Services");
		
	}

}
