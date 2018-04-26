package com.POM;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class WelComeMercuryTours 
{

	//WebElement register=driver.findElement(By.linkText("REGISTER"));
	
	@FindBy(linkText="REGISTER")
	WebElement register;
	
	public void Register()
	{
		register.click();
	}
	
	@FindBy(linkText = "SIGN-ON")
	WebElement SignOn;
	
	public void SignIn()
	{
		SignOn.click();
	}
	
	@FindBy(name = "userName")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(name = "login")
	WebElement login;
	
	public void FindAFlight(String UserName, String password)
	{
		userName.sendKeys(UserName);
		Password.sendKeys(password);
		login.click();
	}
	
	@FindAll({ @FindBy(tagName = "a") })
	List<WebElement> links;
	
	public void AllLinks()
	{
		int size = links.size();
		System.out.println(size);
		for(int i=0;i<size; i++)
		{
			//links.get(i).click();
			String name = links.get(i).getText();
			System.out.println(name);
		}
		
	}
	
}
