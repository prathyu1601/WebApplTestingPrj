package com.TestNGAnnotations;

import org.testng.annotations.Test;

public class Annotations1 
{
	
	@Test(priority=1)
	public void BrowserLaunch()
	{
		System.out.println("This is used to Launch FireFox Browser");
	}
	
	@Test(priority=2)
	public void LogIn()
	{
		System.out.println("THis is used to Test LogIn Functionality");
	}
	
	@Test(priority=3)
	public void Composemail()
	{
		System.out.println("Th is used to test Compose mail Functionality");
	}
	
	@Test(enabled=false)
	public void SentMail()
	{
		System.out.println("This is is used to test Sent Mail Functionality");
	}
	
}
