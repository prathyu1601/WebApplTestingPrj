package newToursLogInTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogIn
{
	FirefoxDriver driver;
	
	@Given("^Open Firefox Browser and Navigate to NewTours Application$")
	public void Open_Firefox_Browser_and_Navigate_to_NewTours_Application() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
	}

	/*@When("^User Enters Valid  UserName and Password and Click on SignIn button$")
	public void User_Enters_Valid_UserName_and_Password_and_Click_on_SignIn_button() throws Throwable 
	{
	    driver.findElement(By.name("userName")).sendKeys("tutorial");
	    driver.findElement(By.name("password")).sendKeys("tutorial");
	    driver.findElement(By.name("login")).click();
	}*/
	
	@When("^User Enters Valid  \"([^\"]*)\" and \"([^\"]*)\" and Click on SignIn button$")
	public void User_Enters_Valid_and_and_Click_on_SignIn_button(String UserName, String Password) throws Throwable 
	{
		 driver.findElement(By.name("userName")).sendKeys(UserName);
		 driver.findElement(By.name("password")).sendKeys(Password);
		 driver.findElement(By.name("login")).click();
		
	}

	@Then("^User Should be able to succesfully LogIn and close the application$")
	public void User_Should_be_able_to_succesfully_LogIn_and_close_the_application() throws Throwable 
	{
	    String actual_Title = driver.getTitle();
	      String expected_Title = "Find";
	      
	      System.out.println(actual_Title);
	      System.out.println(expected_Title);
	      
	      Assert.assertTrue("Title Not Matched", actual_Title.contains(expected_Title));
	    


		driver.close();
	}
	
}
