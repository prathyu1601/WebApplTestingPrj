package com.Newtours_Registration_DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Validating_Registered_Username {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.newtours.demoaut.com/mercuryregister.php");
		driver.findElement(By.name("firstName")).sendKeys("Ram");
		driver.findElement(By.name("lastName")).sendKeys("charan");
		driver.findElement(By.name("phone")).sendKeys("1234567890");
		driver.findElementById("userName").sendKeys("abc@xyz.com");
		driver.findElementByName("address1").sendKeys("3425 oak street, apt#101");
		driver.findElementByName("city").sendKeys("hyderabad");
		driver.findElementByName("state").sendKeys("TG");
		driver.findElementByName("postalCode").sendKeys("12345");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		WebElement web_country = driver.findElement(By.name("country"));
		Select country = new Select(web_country);
		country.selectByVisibleText("INDIA");
		
		String username = "ram_charan";
		driver.findElementById("email").sendKeys(username);
		driver.findElementByName("password").sendKeys("abc.123");
		driver.findElementByName("confirmPassword").sendKeys("abc.123");
		driver.findElementByName("register").click();
		
				
		String ExpectedUserName="ram_charan";
		System.out.println(ExpectedUserName);
		
	String	ActualRegisterdUserName=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
	System.out.println(ActualRegisterdUserName);
	
	if(ActualRegisterdUserName.contains(ExpectedUserName))
	{
		System.out.println("User Registered Sccessfully -- pASS");
	}
	else
	{
		System.out.println("User Registration Failed -- FAIL");
	}
	
		
		driver.close();
	}

}
