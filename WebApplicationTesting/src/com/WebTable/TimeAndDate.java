package com.WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TimeAndDate {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.timeanddate.com/worldclock/");
		
		driver.manage().window().maximize();
		
		// html/body/div[1]/div[8]/section[2]/div[1]/table/tbody/tr[1]/td[1]
		//html/body/div[1]/div[8]/section[2]/div[1]/table/tbody/tr[36]/td[1]
		
		String part1="html/body/div[1]/div[8]/section[2]/div[1]/table/tbody/tr[";
		String part2="]/td[1]";
		
		for(int i=1;i<=36;i++)
		{
			String cityName = driver.findElement(By.xpath(part1+i+part2)).getText();
			System.out.println(cityName);
		}
		
		/*String data=driver.findElement(By.xpath("html/body/div[1]/div[8]/section[2]/div[1]/table/tbody/tr[1]/td[1]")).getText();
		
		System.out.println(data);*/
		
		driver.close();

	}

}
