package OrangeHrmLogInTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LogInTest 
{
	FirefoxDriver driver;
	
	@Given("^Open Firefox browser$")
	public void Open_Firefox_browser() throws Throwable 
	{
	    driver = new FirefoxDriver();
	}

	@Given("^Navigate to Orange Hrm Application$")
	public void Navigate_to_Orange_Hrm_Application() throws Throwable 
	{
	    driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");
	}

	@When("^user enters valid UserName and Password$")
	public void user_enters_valid_UserName_and_Password() throws Throwable 
	{
	    driver.findElement(By.id("txtUsername")).sendKeys("admin");
	    driver.findElement(By.id("txtPassword")).sendKeys("admin");
	    
	}

	@When("^Click on SignIn button$")
	public void Click_on_SignIn_button() throws Throwable 
	{
		driver.findElement(By.id("btnLogin")).click(); 
	}

	@Then("^User should be able to succesfully login$")
	public void User_should_be_able_to_succesfully_login() throws Throwable 
	{
	    String actual_Title = driver.getTitle();
	    String expected_Title = "OrangeHRM";
	    
	    if(actual_Title.contains(expected_Title))
	    	System.out.println("Titles matched -- PASS");
	    else
	    	System.out.println("Titles not matched -- FAIL");
	    
	   Assert.assertTrue("Titles not matched - PASS", actual_Title.contains(expected_Title));
	}

	@Then("^close the application$")
	public void close_the_application() throws Throwable 
	{
	    driver.close();
	}

}
