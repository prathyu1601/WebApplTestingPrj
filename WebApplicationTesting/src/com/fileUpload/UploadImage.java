package com.fileUpload;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadImage 
{
	FirefoxDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://imgur.com");
	}
	
	@Test
	public void ImageUpload() throws IOException
	{
		driver.findElement(By.id("create-dropdown-button")).click();
		driver.findElement(By.linkText("Upload Images")).click();
		driver.findElement(By.className("browse-btn")).click();
		
		java.lang.Runtime.getRuntime().exec("C:\\Users\\Prathyusha P\\Desktop\\FileUpload.exe");
		
	}
	
	/*@AfterTest
	public void tearDown()
	{
		driver.close();
	}*/
}
