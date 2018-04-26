package com.NewToursLogInTest;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogInTest {

	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		
		String ExpectedTitle="Find";
		System.out.println(ExpectedTitle);
		
		String ActualTitle=driver.getTitle();
		System.out.println(ActualTitle);
		
		if(ActualTitle.contains(ExpectedTitle))
		{
			System.out.println("LogIn Successful -- PASS");
		}
		else
		{
			System.out.println("LogIn Failed -- FAIL");
			
		}
		
		
		driver.close();

	}

}
