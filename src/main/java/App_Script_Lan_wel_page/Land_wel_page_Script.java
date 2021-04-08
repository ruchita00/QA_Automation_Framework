package App_Script_Lan_wel_page;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Reusable_Functions.Generic_function;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Land_wel_page_Script {
	WebDriver driver=null;
	Generic_function obj =new  Generic_function();

	@Given("Browser is open")
	public void Browser_is_open() throws IOException {
		obj.Generic_function();
		System.setProperty("webdriver.chrome.driver",obj.getDriverPath());
		driver =new ChromeDriver();
	}

	@And("User is on Landing Welcome Page")
	public void user_is_on_landing_welcome_page() throws IOException {
		driver.navigate().to(obj.getURL());
		driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);	
		obj.takeScreenShot(driver, "HomePage");
	}

	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() throws IOException {
		obj.click("Login", driver);
	}

	@Then("User navigate to Login page")
	public void user_navigate_to_login_page() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);	
		obj.takeScreenShot(driver, "Login");
		driver.close(); 
		driver.quit(); 
	}

	@Given("User is on Welcome Page")
	public void user_is_on_welcome_page() throws IOException {
		obj.Generic_function();
		System.setProperty("webdriver.chrome.driver",obj.getDriverPath());
		driver =new ChromeDriver();
		driver.navigate().to(obj.getURL());
		driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);	
	}

	@When("User clicks on Sign up button")
	public void user_clicks_on_sign_up_button() throws IOException { 
		obj.click("SignUp", driver);
		driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);	
	}

	@Then("User navigate to Sign up page")
	public void user_navigate_to_sign_up_page() throws IOException {
		driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);	
		obj.takeScreenShot(driver, "Signup");
		driver.close(); 
		driver.quit(); 
	}
}
