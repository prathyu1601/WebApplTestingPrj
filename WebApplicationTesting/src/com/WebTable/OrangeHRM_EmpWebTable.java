package com.WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class OrangeHRM_EmpWebTable {

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		
		driver.findElementByXPath(".//*[@id='txtUsername']").sendKeys("admin");
		driver.findElementByXPath(".//*[@id='txtPassword']").sendKeys("admin");
		driver.findElementByXPath(".//*[@id='btnLogin']").click();
		Sleeper.sleepTightInSeconds(3);
		driver.findElementById("menu_pim_viewPimModule").click();
		driver.findElementById("menu_pim_viewEmployeeList").click();
		
		/*  .//*[@id='resultTable']/tbody/tr[1]/td[2]
			.//*[@id='resultTable']/tbody/tr[1]/td[8]
		String part1 = ".//*[@id='resultTable']/tbody/tr[";
		String part2 = "]/td[";
		String part3 = "]";*/
		WebElement table = driver.findElement(By.xpath(".//table[@id='resultTable']"));
		List<WebElement> rows=  table.findElements(By.tagName("tr"));
		
		for(int i=1;i<rows.size();i++) 
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for(int j=1;j<cols.size();j++)
			{
				/*String data = driver.findElement(By.xpath(part1 + i + part2 + j + part3)).getText();
				System.out.print(data+" ");*/
				String tableData = cols.get(j).getText();
				System.out.print(tableData+ " ");
			}
			System.out.println();
		}
		
		
		
	}

}
