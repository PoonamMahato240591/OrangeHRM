package com.OperationOnWelcomeAdminAndLogout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class OrangeHRM_WelcomeAdmin_Logout_Click_Operation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driverFiles/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://localhost/orangehrm/symfony/web/index.php/auth/login";
		driver.navigate().to(url);
		String expected_LoginPageTitle="OrangeHRM";
		System.out.println("The expected LoginPage Title is:"+"expected_LoginPageTitle"+expected_LoginPageTitle);
		String actual_WebPageTitle=driver.getTitle();
		System.out.println("The actual WebPage Title is :"+actual_WebPageTitle);
		//<div id="logInPanelHeading">LOGIN Panel</div>
		WebElement login=driver.findElement(By.id("logInPanelHeading"));
		String expected_loginName="LOGIN Panel";
		System.out.println("The expected login name is: "+expected_loginName);
		String actual_loginName=login.getText();
		System.out.println("The actual login name is: "+actual_loginName);
		if(actual_loginName.equals(expected_loginName))
		{
		System.out.println("The Login Name matched-PASS");
	}
		else
		{
			System.out.println("The Login Name did not matched-FAIL");
		}
		//<input name="txtUsername" id="txtUsername" type="text">
	WebElement userName=driver.findElement(By.id("txtUsername"));
	userName.sendKeys("Admin");
	//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
	WebElement password=driver.findElement(By.id("txtPassword"));
	password.sendKeys("Admin123");
	//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	WebElement login_button=driver.findElement(By.id("btnLogin"));
	login_button.click();
	String expected_AdminName ="Admin";
	System.out.println("The expected admin name is: "+expected_AdminName);
	//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
	WebElement welcome_Admin=driver.findElement(By.id("welcome"));
	String actual_WelcomeAdminName=welcome_Admin.getText();
	System.out.println("The actual_WelcomeAdminName name is: "+actual_WelcomeAdminName);
	if(actual_WelcomeAdminName.contains(expected_AdminName))
	{
		System.out.println("It's in Welcome Admin Page-PASS");
		
	}
	else
	{
     System.out.println("It is not in Welcome Admin Page-Fail");
	}
	welcome_Admin.click();
	
	
	//<a href="#" data-dismiss="modal" id="aboutDisplayLink">About</a>
	
	//<a href="/orangehrm/symfony/web/index.php/auth/logout">Logout</a>
	
	Thread.sleep(2000);
	WebElement logout=driver.findElement(By.linkText("Logout"));

	logout.click();
	
	}
	
}
