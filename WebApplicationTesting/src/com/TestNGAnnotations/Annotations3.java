package com.TestNGAnnotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations3 
{
	@BeforeMethod
	public void BrowserLaunchAndLogIN()
	{
		System.out.println("This is used to Launch FireFox Browser and LogIN");
	}
	
		
	@Test(priority=1)
	public void Composemail()
	{
		System.out.println("Th is used to test Compose mail Functionality");
	}
	
	@Test(priority=2)
	public void SentMail()
	{
		System.out.println("This is is used to test Sent Mail Functionality");
	}
	
	@AfterMethod
	public void ApplicationCLose()
	{
		System.out.println("This is used to Close the Application");
	}
}
