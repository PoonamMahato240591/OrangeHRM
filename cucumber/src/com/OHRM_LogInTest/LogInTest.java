package com.OHRM_LogInTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogInTest {
	
	public WebDriver driver = null;
	public String url="http://localhost/orangehrm/symfony/web/index.php/auth/login";
	
	public String UserName="admin";
	public String Password="password";
	
	
	@Given("^Open Chrome Browser and Navigate to OrangeHRM Application$")
	public void Open_Chrome_Browser_and_Navigate_to_OrangeHRM_Application() throws Throwable 
	{
		
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	}
/*
	@When("^User eneters UserName and Password and click on logIn Button$")
	public void User_eneters_UserName_and_Password_and_click_on_logIn_Button() throws Throwable 
	{
	
		WebElement userName=driver.findElement(By.id("txtUsername"));
		userName.sendKeys(UserName);
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(Password);
		
		WebElement logIn=driver.findElement(By.id("btnLogin"));
		logIn.click();
		
	}
*/
	
	@When("^User eneters \"([^\"]*)\" and \"([^\"]*)\" and click on logIn Button$")
	public void User_eneters_and_and_click_on_logIn_Button(String UserName, String Password) 
	{
		WebElement userName=driver.findElement(By.id("txtUsername"));
		userName.sendKeys(UserName);
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(Password);
		
		WebElement logIn=driver.findElement(By.id("btnLogin"));
		logIn.click();
	
	}
	@Then("^User should be able to successfully LogIn to the Application and close the application$")
	public void User_should_be_able_to_successfully_LogIn_to_the_Application_and_close_the_application() throws Throwable 
	{
		try{
			String expected_text="Welcome Admin";
	System.out.println("The expected text is :"+expected_text);
	
	// <a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
	String actual_Text=driver.findElement(By.id("welcome")).getText();
	System.out.println("The actual text is : "+actual_Text);
	
	if(actual_Text.contains(expected_text))
	{
		System.out.println("Successfully logIn - PASS");
	}
	
	}
	catch(Exception e)
	{
		if(driver.findElement(By.id("spanMessage")).getText().equals("Invalid credentials"))
		{
			File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File("./ScreenShot/img.png"));
			
			System.out.println("LogIn Failed - FAIL");
			driver.quit();
		}
		
		
	}
	driver.quit();

	
	
}

	}


	
	


