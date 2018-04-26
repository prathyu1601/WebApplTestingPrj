package com.DragAndDropDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDraggableDemo {

	public static void main(String[] args) throws InterruptedException
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/droppable/");
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	
		
		WebElement drag = driver.findElement(By.id("draggable"));
		
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
		
		
		
		
	}

}
